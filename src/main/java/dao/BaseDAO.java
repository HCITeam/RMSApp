package dao;

import java.util.List;

/**
 * Created by chenm on 2016/5/8.
 */
public interface BaseDAO<T> {

    /**
     * 执行sql语句
     * @param sql
     * @return
     */
    public List<?> doSqlQuery(String sql);

    /**
     * 执行hql语句
     * @param hql
     * @return
     */
    public List<?> doHqlQuery(String hql);

    /**
     * 数据库添加
     * @param t
     */
    public void add(T t);

    /**
     * 数据库删除操作
     * @param t
     */
    public void delete(T t);

    /**
     * 数据库更新操作
     * @param t
     */
    public void update(T t);

    /**
     * id查询数据库
     * @param id
     * @return
     */
    @SuppressWarnings({ "rawtypes" })
    public T getById(String id);

    /**
     * 列名单一查询数据库
     * @param column
     * @param value
     * @return
     */
    @SuppressWarnings({"rawtypes" })
    public T getByColumn(String column, Object value);

    /**
     * 列名多项查询
     * @param column
     * @param value
     * @return
     */
    @SuppressWarnings({"rawtypes" })
    public List<T> getListByColumn(String column, Object value);

    /**
     * 控制页数
     * @param column
     * @param value
     * @param page
     * @param size
     * @return
     */
    @SuppressWarnings({"rawtypes" })
    public List<T> getListByColumn(String column, Object value, int page, int size);

    /**
     * 控制排序
     * @param column
     * @param value
     * @param page
     * @param size
     * @param ordercolumn
     * @param asc
     * @return
     */
    @SuppressWarnings({"rawtypes" })
    public List<T> getListByColumn(String column, Object value, int page, int size, String ordercolumn, boolean asc);

    /**
     * 相似查询
     * @param column
     * @param value
     * @param page
     * @param size
     * @param ordercolumn
     * @param asc
     * @return
     */
    @SuppressWarnings({"rawtypes" })
    public List<T> getListByLikeColumn(String column, Object value, int page, int size, String ordercolumn, boolean asc);

    /**
     *
     * @param column
     * @param asc
     * @return
     */
    @SuppressWarnings({"rawtypes"})
    public List<Object> getPropertyList(String column, boolean asc);

    /**
     *
     * @param column
     * @param paramColumn
     * @param value
     * @param asc
     * @return
     */
    @SuppressWarnings({"rawtypes"})
    public List<Object> getPropertyListByColumn(String column, String paramColumn, String value, boolean asc);

    /**
     * 获得全部数据
     * @return
     */
    @SuppressWarnings({ "rawtypes" })
    public List<T> getAll();

    /**
     * 分页
     * @param page
     * @param size
     * @return
     */
    @SuppressWarnings({ "rawtypes" })
    public List<T> getAllByPage(int page,int size);

    /**
     * 统计数目
     * @return
     */
    @SuppressWarnings("rawtypes")
    public int getCounts();

    /**
     * 分类统计数目
     * @param columnName
     * @param keyword
     * @return
     */
    @SuppressWarnings("rawtypes")
    public int getCounts(String columnName, String keyword);

    /**
     * 获得最新添加的数据
     * @return
     */
    public Object getNewAddedEntity();
}
