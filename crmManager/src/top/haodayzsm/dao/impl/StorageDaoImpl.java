package top.haodayzsm.dao.impl;

import java.util.List;

import org.hibernate.criterion.DetachedCriteria;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import top.haodayzsm.dao.IStorageDao;
import top.haodayzsm.pojo.Storage;
@Controller(value="storageDao")
@Scope(value="prototype")
public class StorageDaoImpl extends BaseDaoImpl<Storage> implements IStorageDao {

	@Override
	public List<Storage> findByCondition(DetachedCriteria criteria) {
		return  (List<Storage>) this.getHibernateTemplate().findByCriteria(criteria);
	}

}
 