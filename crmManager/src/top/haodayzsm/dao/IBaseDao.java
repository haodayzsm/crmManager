package top.haodayzsm.dao;

import java.io.Serializable;
import java.util.List;

import org.hibernate.criterion.DetachedCriteria;

import top.haodayzsm.utils.PageBean;

public interface IBaseDao<T> {
	public boolean save(T entity);
	public boolean updata(T entity);
	public boolean saveOrUpdata(T entity);
	public boolean delete(T entity);
	public List<T> findAll();
	public T findById(Serializable id);
	public List findById(String hql,Long[] value);
	public boolean pageQuery(PageBean pageBean);
	public Object findByCondition(String hql);
	public List findByCondition(DetachedCriteria criteria);
	public List findByCondition(Long id,String key);
	public List findById(Long id);
	public boolean deleteById(Long id);
	List findAllActivation(String status);
}
