package ${package}.util;

import com.github.trang.copiers.Copiers;
import com.github.trang.copiers.inter.Copier;
import com.univocity.parsers.common.processor.BeanListProcessor;
import com.univocity.parsers.common.processor.BeanWriterProcessor;
import com.univocity.parsers.csv.*;
import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;
import java.util.stream.Collectors;

import static java.nio.file.StandardOpenOption.*;

/**
 * CSV 工具类
 *
 * @author trang
 */
@Slf4j
public class CsvUtils {

    @SneakyThrows(IOException.class)
    public static List<String[]> toList(Path file) {
        try (InputStream is = Files.newInputStream(file, READ)) {
            CsvParserSettings settings = Csv.parseExcel();
            settings.setHeaderExtractionEnabled(true);
            CsvParser parser = new CsvParser(settings);
            return parser.parseAll(is);
        }
    }

    @SneakyThrows(IOException.class)
    public static <T> List<T> toList(Path file, Class<T> beanClass) {
        try (InputStream is = Files.newInputStream(file, READ)) {
            //CSV转换List处理器
            BeanListProcessor<T> beanProcessor = new BeanListProcessor<>(beanClass);
            //CSV转换设置
            CsvParserSettings settings = Csv.parseExcel();
            //设置处理器
            settings.setProcessor(beanProcessor);
            //设置文件标题
            settings.setHeaderExtractionEnabled(true);
            settings.setProcessorErrorHandler((error, inputRow, context) -> {
                log.warn("parse error, value: {}, lineIndex: {}, columnName: {}, columnIndex: {}",
                        error.getValue(), error.getLineIndex(), error.getColumnName(), error.getColumnIndex());
            });
            CsvParser parser = new CsvParser(settings);
            //读取CSV文件，Excel默认使用ANSI保存，Windows下为GBK
            //http://blog.sina.com.cn/s/blog_888269b20100wvos.html
            //开始转换
            parser.parse(is);
            return beanProcessor.getBeans();
        }
    }

    /**
     * 将 CSV 文件写入到数据库
     *
     * @param file        读取的文件
     * @param sourceClass 文件读取时对应的Bean
     * @param targetClass 写入数据库时对应的Bean
     * @return beanList
     */
    @SneakyThrows(IOException.class)
    public static <F, T> List<T> toList(Path file, Class<F> sourceClass, Class<T> targetClass) {
        try (InputStream is = Files.newInputStream(file, READ)) {
            //CSV转换List处理器
            BeanListProcessor<F> beanProcessor = new BeanListProcessor<>(sourceClass);
            //CSV转换设置
            CsvParserSettings settings = Csv.parseExcel();
            //设置处理器
            settings.setProcessor(beanProcessor);
            //设置文件标题
            settings.setHeaderExtractionEnabled(true);
            CsvParser parser = new CsvParser(settings);
            //读取CSV文件，Excel默认使用ANSI保存，Windows下为GBK
            //http://blog.sina.com.cn/s/blog_888269b20100wvos.html
            try (InputStreamReader reader = new InputStreamReader(is)) {
                //开始转换
                parser.parse(reader);
            }
            Copier<F, T> copier = Copiers.create(sourceClass, targetClass);
            return beanProcessor.getBeans().parallelStream().map(copier::copy).collect(Collectors.toList());
        }
    }

    /**
     * 将数据库的数据导出为CSV
     *
     * @param file        导出的文件
     * @param sourceClass 读取数据库数据时对应的Bean
     * @param targetClass 写入文件时对应的Bean
     * @param sourceList  数据库查到的数据
     */
    @SneakyThrows(IOException.class)
    public static <F, T> void toFile(Path file, Class<F> sourceClass, Class<T> targetClass, List<F> sourceList) {
        if (Files.notExists(file)) {
            Files.createFile(file);
        }
        Copier<F, T> copier = Copiers.create(sourceClass, targetClass);
        List<T> data = sourceList.parallelStream().map(copier::copy).collect(Collectors.toList());
        //List转换CSV处理器
        BeanWriterProcessor<T> writerProcessor = new BeanWriterProcessor<>(targetClass);
        writerProcessor.setStrictHeaderValidationEnabled(true);
        //CSV写入设置
        CsvWriterSettings settings = Csv.writeExcel();
        //设置处理器
        settings.setRowWriterProcessor(writerProcessor);
        try (OutputStream os = Files.newOutputStream(file, CREATE, TRUNCATE_EXISTING, WRITE);
             OutputStreamWriter osw = new OutputStreamWriter(os)) {
            CsvWriter writer = new CsvWriter(osw, settings);
            writer.processRecordsAndClose(data);
        }
    }

}