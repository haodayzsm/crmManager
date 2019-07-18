package top.haodayzsm.dao.impl;

import java.io.Serializable;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.List;
import javax.annotation.Resource;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Projections;
import org.springframework.context.annotation.Scope;
import org.springframework.orm.hibernate5.support.HibernateDaoSupport;
import org.springframework.stereotype.Controller;

import top.haodayzsm.dao.IBaseDao;
import top.haodayzsm.pojo.Storage;
import top.haodayzsm.utils.PageBean;

@Controller(value="baseDao")
@Scope(value="prototype")
public class BaseDaoImpl<T> extends HibernateDaoSupport implements IBaseDao<T> {
	Class<T> entityClass;
	String className;
	String columnName;
	char c;
	
	/**
	 * ͨ�����췽�����entityClass��ʵ����
	 */
	public BaseDaoImpl(){
		//��ø�������
		ParameterizedType Superclass = (ParameterizedType) this.getClass().getGenericSuperclass();
		//�Ӹ������ͻ�÷��͵�����
		Type[] Arguments = Superclass.getActualTypeArguments();
		//��Arguments��������
		entityClass = (Class<T>) Arguments[0];
		className = entityClass.getSimpleName()+" ";
		char[] chars=className.toCharArray();
		c=(char) (chars[0]+32);
		chars[0]=c;
		columnName=String.valueOf(chars);
		
	}
	@Override
	public boolean save(T entity) {
		try{
			this.getHibernateTemplate().save(entity);
			return true;
		}catch(Exception e){
			e.printStackTrace();
			return false;
		}
	}
	@Override
	public List findAllActivation(String status){
		String hql="from "+className+c+" where "+c+"."+"status=?";
		return this.getHibernateTemplate().find(hql,status);
	}
	@Override
	public boolean updata(T entity) {
		try {
			this.getHibernateTemplate().update(entity);
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

	@Override
	public boolean delete(T entity) {
		if(entity!=null){
			this.getHibernateTemplate().delete(entity);
			return true;
		}else{
			return false;
		}
	}

	@Override
	public List<T> findAll() {
		String hql="from "+entityClass.getSimpleName();
		List<T> list = (List<T>) this.getHibernateTemplate().find(hql);
		try{
			if(list.size()>0){
				return list;
			}else{
				return null;
			}
		}catch (Exception e){
			e.printStackTrace();
			return null;
		}
	}

	@Override
	public T findById(Serializable id) {
		try{			
			return this.getHibernateTemplate().get(entityClass, id);	
		}catch(Exception e){
			e.printStackTrace();
			return null;
		}
	}
	public List findById(String hql,Long[] value){
		try{
			List list = this.getHibernateTemplate().find(hql,value);
			if(list.size()!=0){
				return list;
			}else{
				return null;
			}
		}catch(Exception e){
			return null;
		}
	}
	/**
	 * ͨ��ע���滻���úõ�sessionFactory
	 */
	@Resource(name="sessionFactory")
	public void setMySessionFactory(SessionFactory sessionFactory){
		setSessionFactory(sessionFactory);
	}
	//��ҳ��ѯ
	@Override
	public boolean pageQuery(PageBean pageBean) {
		
		DetachedCriteria detachedCriteria = pageBean.getDetachedCriteria();
		detachedCriteria.setProjection(Projections.rowCount());
		//��ȡ�ܼ�¼��
		List<Long> rows = (List<Long>) this.getHibernateTemplate().findByCriteria(detachedCriteria);	
		pageBean.setTotal(rows.get(0).intValue());
		
		//��ҳ��ѯ
		int max=pageBean.getPageSize();
		int str=(pageBean.getCurrentPage()-1)*max;
		List list = this.getHibernateTemplate().findByCriteria(pageBean.getDetachedCriteria(),str,max);
		pageBean.setRow(list);
		return true;
	}
	@Override
	public Object findByCondition(String hql) {
		try{			
			return this.getHibernateTemplate().find(hql);
		}catch(Exception e){
			e.printStackTrace();
			return null;
		}
	}
	@Override
	public boolean saveOrUpdata(T entity) {
		try{
			this.getHibernateTemplate().saveOrUpdate(entity);
			return true;
		}catch(Exception e){
			e.printStackTrace();
			return false;
		}
	}
	public List findByCondition(DetachedCriteria criteria) {
		return this.getHibernateTemplate().findByCriteria(criteria);
	}
	public List findById(Long id){
		String className=entityClass.getSimpleName();
		char[] c=className.toCharArray();
		c[0]=(char) (c[0]+32);
		String columnName=String.valueOf(c);
		String hql = "from "+className+" entity where entity."+columnName+"_id=?";
		return this.getHibernateTemplate().find(hql, id);
	}
	@Override
	public boolean deleteById(Long id) {
		List list = this.findById(id);
		if(list.size()>0){
			return this.delete((T) list.get(0));
		}
		return false;
	}
	@Override
	public List findByCondition(Long id, String key) {
		String hql="from "+className+c+" where "+c+"."+key+"=?";
		return this.getHibernateTemplate().find(hql, id);
	}
}
