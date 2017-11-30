package ${package}.util;

import tk.mybatis.mapper.common.ExampleMapper;
import tk.mybatis.mapper.common.IdsMapper;
import tk.mybatis.mapper.common.MySqlMapper;
import tk.mybatis.mapper.common.RowBoundsMapper;

/**
 * 自定义通用 Mapper
 *
 * @param <T>
 * @author trang
 */
public interface BaseMapper<T> extends
        tk.mybatis.mapper.common.BaseMapper<T>,
        MySqlMapper<T>,
        IdsMapper<T>,
        ExampleMapper<T>,
        RowBoundsMapper<T> {
}