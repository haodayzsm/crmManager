package top.haodayzsm.service;

import java.io.Serializable;
import java.util.List;

import org.hibernate.criterion.DetachedCriteria;

public interface IBaseService {
	public void save(Object object);
	public void saveBatch(List list);
	public void updata(Object object);
	//public void saveOrUpdata(Object object);
	public void delete(Object object);
	public Object findById(Serializable id);
	public Object fingByCondition(DetachedCriteria detachedCriteria);
}
