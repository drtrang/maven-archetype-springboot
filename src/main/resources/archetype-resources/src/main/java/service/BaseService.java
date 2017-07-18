package ${package}.service;

import com.github.pagehelper.PageInfo;

import java.io.Serializable;
import java.util.List;

/**
 * BaseService
 *
 * @author trang
 */
public interface BaseService<T, PK extends Serializable> {

    // ------ C ------ //
    /*
     * 新增数据，值为null的field不会写入
     */
    int insert(T entity);

    int insertBatch(List<T> entityList);

    /*
     * 新增数据，值为null的field也会写入
     */
    int insertUnchecked(T entity);

    // ------ U ------ //
    /*
     * 更新数据，值为null的field不会写入
     */
    int update(T record);

    /*
     * 更新数据，值为null的field也会写入
     */
    int updateUnchecked(T record);

    // ------ D ------ //
    int delete(T record);

    int deleteByPk(PK pk);

    int deleteByIds(Iterable<? extends PK> ids);

    // ------ R ------ //
    List<T> select(T entity);

    T selectByPk(PK pk);

    T selectOne(T entity);

    List<T> selectByIds(Iterable<? extends PK> ids);

    int selectCount(T entity);

    /*
     * 分页查询，使用RowBounds方式，不会查询count
     */
    PageInfo<T> selectPage(T entity, int pageNum, int pageSize);

    /*
     * 分页查询，使用PageHelper.startPage()，查询count
     * 若同时需要排序，可手动指定PageHelper.orderBy()
     * {@link PageHelper}
     */
    PageInfo<T> selectPageAndCount(T entity, int pageNum, int pageSize);

}