package ${package}.util;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.TypeReference;
import com.alibaba.fastjson.parser.Feature;
import com.alibaba.fastjson.serializer.SerializerFeature;

import java.util.List;
import java.util.Map;

/**
 * FastJson 封装工具类
 *
 * @author trang
 */
public final class JsonUtils {

    private JsonUtils() {
        throw new UnsupportedOperationException();
    }

    // 序列化特性
    private static final SerializerFeature[] SERIALIZER_FEATURES = {
            SerializerFeature.NotWriteRootClassName,
            // 将 key 输出为字符串
            SerializerFeature.WriteNonStringKeyAsString,
            // 禁止循环引用检测
            SerializerFeature.DisableCircularReferenceDetect
    };

    // 反序列化特性
    private static final Feature[] PARSE_FEATURES = {
            Feature.DisableCircularReferenceDetect
    };

    public static String toJson(Object object) {
        return JSON.toJSONString(object, SERIALIZER_FEATURES);
    }

    public static String toDefaultJson(Object object) {
        return JSON.toJSONString(object);
    }

    public static <T> T parse(String json, Class<T> clazz) {
        return JSON.parseObject(json, clazz, PARSE_FEATURES);
    }

    /**
     * 转换为 List
     */
    public static <T> List<T> parseList(String json, Class<T> clazz) {
        return JSON.parseArray(json, clazz);
    }

    /**
     * 转换为 Map
     */
    public static List<Map<String, Object>> parseMap(String json) {
        return JSON.parseObject(json, new TypeReference<List<Map<String, Object>>>() {
        }, PARSE_FEATURES);
    }

}