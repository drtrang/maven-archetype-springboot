package ${package}.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.google.common.base.Joiner;
import com.google.common.base.Preconditions;
import ${package}.service.BaseService;
import ${package}.util.BaseMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import tk.mybatis.mapper.entity.Example;

import java.io.Serializable;
import java.util.List;

/**
 * BaseService 实现类
 *
 * @author trang
 */
public abstract class BaseServiceImpl<T, PK extends Serializable> implements BaseService<T, PK> {

    @Autowired
    private BaseMapper<T> mapper;

    @Override
    @Transactional
    public int insert(T record) {
        Preconditions.checkNotNull(record);
        return mapper.insertSelective(record);
    }

    @Override
    @Transactional
    public int insertUnchecked(T record) {
        Preconditions.checkNotNull(record);
        return mapper.insert(record);
    }

    @Override
    @Transactional
    public int insertBatch(List<T> records) {
        return mapper.insertList(records);
    }

    @Override
    @Transactional
    public int update(T record) {
        Preconditions.checkNotNull(record);
        return mapper.updateByPrimaryKeySelective(record);
    }

    @Override
    @Transactional
    public int updateUnchecked(T record) {
        Preconditions.checkNotNull(record);
        return mapper.updateByPrimaryKey(record);
    }

    @Override
    @Transactional
    public int updateByExample(T record, Example example) {
        Preconditions.checkNotNull(record);
        Preconditions.checkNotNull(example);
        return mapper.updateByExampleSelective(record, example);
    }

    @Override
    @Transactional
    public int updateUncheckedByExample(T record, Example example) {
        Preconditions.checkNotNull(record);
        Preconditions.checkNotNull(example);
        return mapper.updateByExample(record, example);
    }

    @Override
    @Transactional
    public int deleteByPk(PK pk) {
        Preconditions.checkNotNull(pk);
        return mapper.deleteByPrimaryKey(pk);
    }

    @Override
    @Transactional
    public int deleteByPks(Iterable<? extends PK> pks) {
        Preconditions.checkNotNull(pks);
        String pksStr = Joiner.on(',').skipNulls().join(pks);
        return mapper.deleteByIds(pksStr);
    }

    @Override
    @Transactional
    public int delete(T param) {
        Preconditions.checkNotNull(param);
        return mapper.delete(param);
    }

    @Override
    @Transactional
    public int deleteAll() {
        return mapper.delete(null);
    }

    @Override
    @Transactional
    public int deleteByExample(Example example) {
        Preconditions.checkNotNull(example);
        return mapper.deleteByExample(example);
    }

    @Override
    public T selectByPk(PK pk) {
        Preconditions.checkNotNull(pk);
        return mapper.selectByPrimaryKey(pk);
    }

    @Override
    public List<T> selectByPks(Iterable<? extends PK> pks) {
        Preconditions.checkNotNull(pks);
        String pksStr = Joiner.on(',').skipNulls().join(pks);
        return mapper.selectByIds(pksStr);
    }

    @Override
    public List<T> select(T param) {
        Preconditions.checkNotNull(param);
        return mapper.select(param);
    }

    @Override
    public T selectOne(T param) {
        Preconditions.checkNotNull(param);
        PageHelper.offsetPage(0, 1, false);
        return mapper.selectOne(param);
    }

    @Override
    public List<T> selectAll() {
        return mapper.select(null);
    }

    @Override
    public int selectCount(T param) {
        Preconditions.checkNotNull(param);
        return mapper.selectCount(param);
    }

    @Override
    public PageInfo<T> selectPage(T param, int pageNum, int pageSize) {
        Preconditions.checkNotNull(param);
        return PageHelper.startPage(pageNum, pageSize, false).doSelectPageInfo(() -> mapper.select(param));
    }

    @Override
    public PageInfo<T> selectPageAndCount(T param, int pageNum, int pageSize) {
        Preconditions.checkNotNull(param);
        return PageHelper.startPage(pageNum, pageSize).doSelectPageInfo(() -> mapper.select(param));
    }

    @Override
    public List<T> selectByExample(Example example) {
        Preconditions.checkNotNull(example);
        return mapper.selectByExample(example);
    }

    @Override
    public int selectCountByExample(Example example) {
        Preconditions.checkNotNull(example);
        return mapper.selectCountByExample(example);
    }

    @Override
    public PageInfo<T> selectPageByExample(Example example, int pageNum, int pageSize) {
        Preconditions.checkNotNull(example);
        return PageHelper.startPage(pageNum, pageSize, false)
                .doSelectPageInfo(() -> mapper.selectByExample(example));
    }

    @Override
    public PageInfo<T> selectPageAndCountByExample(Example example, int pageNum, int pageSize) {
        Preconditions.checkNotNull(example);
        return PageHelper.startPage(pageNum, pageSize)
                .doSelectPageInfo(() -> mapper.selectByExample(example));
    }

}