package dao.impl;

import dao.BaseDAO;
import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.List;

/**
 * Created by chenm on 2016/5/8.
 */
public abstract class BaseDAOImpl<T> implements BaseDAO<T> {
    @Autowired
    protected SessionFactory sessionFactory;

    protected Class<T> entityClass;

    public BaseDAOImpl() {
        Type genType = getClass().getGenericSuperclass();
        Type[] params = ((ParameterizedType) genType).getActualTypeArguments();
        entityClass = (Class) params[0];
    }

    /**
     * 数据库添加
     * @param t
     */
    public void add(T t){
        Session session = sessionFactory.getCurrentSession();
        session.saveOrUpdate(t);
    }
    /**
     * 数据库删除操作
     * @param t
     */
    public void delete(T t){
        Session session = sessionFactory.getCurrentSession();
        session.delete(t);
    }
    /**
     * 数据库更新操作
     * @param t
     */
    public void update(T t){
        Session session = sessionFactory.getCurrentSession();
        session.update(t);
    }

    /**
     * 执行sql语句
     * @param sql
     * @return
     */
    public List<?> doSqlQuery(String sql){
        Session session = sessionFactory.getCurrentSession();
        return session.createSQLQuery(sql).list();
    }

    /**
     * 执行hql语句
     * @param hql
     * @return
     */
    public List<?> doHqlQuery(String hql) {
        Session session = sessionFactory.getCurrentSession();
        return session.createQuery(hql).list();
    }

    /**
     * id查询数据库
     * @param id
     * @return
     */
    @SuppressWarnings({ "unchecked", "rawtypes" })
    public T getById(String id){
        Session session = sessionFactory.getCurrentSession();
        return (T)session.get(entityClass, id);
    }

    /**
     * 列名单一查询数据库
     * @param column
     * @param value
     * @return
     */
    @SuppressWarnings({"rawtypes", "unchecked" })
    public T getByColumn(String column, Object value) {
        Session session = sessionFactory.getCurrentSession();
        Criteria criteria = session.createCriteria(entityClass);
        criteria.add(Restrictions.eq(column, value));
        List<?> list = criteria.list();
        if ((list.size()) == 0){
            return null;
        }else{
            return (T)list.get(0);
        }
    }

    /**
     * 列名多项查询
     * @param column
     * @param value
     * @return
     */
    @SuppressWarnings({"rawtypes", "unchecked" })
    public List<T> getListByColumn(String column, Object value) {
        Session session = sessionFactory.getCurrentSession();
        Criteria criteria = session.createCriteria(entityClass);
        criteria.add(Restrictions.eq(column, value));
        return criteria.list();
    }

    /**
     * 控制页数
     * @param column
     * @param value
     * @param page
     * @param size
     * @return
     */
    @SuppressWarnings({"rawtypes", "unchecked" })
    public List<T> getListByColumn(String column, Object value, int page, int size) {
        Session session = sessionFactory.getCurrentSession();
        Criteria criteria = session.createCriteria(entityClass);
        criteria.add(Restrictions.eq(column, value));
        criteria.setFirstResult((page-1)*size);
        criteria.setMaxResults(size);
        return criteria.list();
    }

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
    @SuppressWarnings({"rawtypes", "unchecked" })
    public List<T> getListByColumn(String column, Object value, int page, int size, String ordercolumn, boolean asc) {
        Session session = sessionFactory.getCurrentSession();
        Criteria criteria = session.createCriteria(entityClass);
        criteria.add(Restrictions.eq(column, value));
        if(ordercolumn!=null){
            if(asc){
                criteria.addOrder(Order.asc(ordercolumn));
            }else{
                criteria.addOrder(Order.desc(ordercolumn));
            }
        }
        criteria.setFirstResult((page-1)*size);
        criteria.setMaxResults(size);
        return criteria.list();
    }

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
    @SuppressWarnings({"rawtypes", "unchecked" })
    public List<T> getListByLikeColumn(String column, Object value, int page, int size, String ordercolumn, boolean asc) {
        Session session = sessionFactory.getCurrentSession();
        Criteria criteria = session.createCriteria(entityClass)
                .add(Restrictions.like(column, "%"+value+"%"));
        if(ordercolumn!=null){
            if(asc){
                criteria.addOrder(Order.asc(ordercolumn));
            }else{
                criteria.addOrder(Order.desc(ordercolumn));
            }
        }
        criteria.setFirstResult((page-1)*size);
        criteria.setMaxResults(size);
        return criteria.list();
    }

    /**
     * 获取全部
     * @return
     */
    @SuppressWarnings({ "unchecked", "rawtypes" })
    public List<T> getAll(){
        Session session = sessionFactory.getCurrentSession();
        List<T> list=session.createQuery("From "+entityClass.getName()).list();
        return list;
    }

    /**
     * 分页获取
     * @param page
     * @param size
     * @return
     */
    @SuppressWarnings({ "unchecked", "rawtypes" })
    public List<T> getAllByPage(int page,int size){
        Session session = sessionFactory.getCurrentSession();
        Criteria criteria = session.createCriteria(entityClass)
                .setFirstResult((page-1)*size)
                .setMaxResults(size);

        return criteria.list();
    }

    /**
     * 我也不知道欸
     * @param column
     * @param asc
     * @return
     */
    @Override
    @SuppressWarnings({ "unchecked", "rawtypes" })
    public List<Object> getPropertyList(String column, boolean asc) {
        Session session = sessionFactory.getCurrentSession();
        Query query;
        if(asc) {
            query= session.createQuery("select " + column + " from " + entityClass.getName() + " order by " + column + " asc");
        }else {
            query= session.createQuery("select " + column + " from " + entityClass.getName() + " order by " + column + " desc");
        }

        return query.list();
    }

    /**
     * 同不知道欸
     * @param column
     * @param paramColumn
     * @param value
     * @param asc
     * @return
     */
    @Override
    @SuppressWarnings({ "unchecked", "rawtypes" })
    public List<Object> getPropertyListByColumn(String column, String paramColumn, String value, boolean asc) {
        Session session = sessionFactory.getCurrentSession();
        Query query;
        if(asc) {
            query= session.createQuery("select " + column + " from " + entityClass.getName() + " where " + paramColumn + " = '" + value + "' order by " + column + " asc");
        }else {
            query= session.createQuery("select " + column + " from " + entityClass.getName() + " where " + paramColumn + " = '" + value + "' order by " + column + " desc");
        }

        return query.list();
    }

    /**
     * 统计数目
     * @return
     */
    @SuppressWarnings("rawtypes")
    public int getCounts(){
        Session session = sessionFactory.getCurrentSession();
        Criteria criteria = session.createCriteria(entityClass);
        int count = Integer.parseInt(criteria.setProjection(Projections.rowCount()).uniqueResult().toString());
        return count;
    }

    /**
     * 分类统计数目
     * @param columnName
     * @param keyword
     * @return
     */
    public int getCounts(String columnName, String keyword){
        Session session = sessionFactory.getCurrentSession();
        Criteria criteria = session.createCriteria(entityClass)
                .add(Restrictions.like(columnName, "%"+keyword+"%"));
        int count = Integer.parseInt(criteria.setProjection(Projections.rowCount()).uniqueResult().toString());
        return count;
    }

    /**
     * 获得最新添加的数据
     * @return
     */
    public Object getNewAddedEntity(){
        Session session = sessionFactory.getCurrentSession();
        List<Object> list=session.createQuery("From "+entityClass.getName()).list();
        return list.get(list.size()-1);
    }
}
