package top.haodayzsm.dao;

import java.util.List;

import org.hibernate.criterion.DetachedCriteria;

import top.haodayzsm.pojo.Storage;

public interface IStorageDao extends IBaseDao<Storage>{

	List<Storage> findByCondition(DetachedCriteria criteria);

}
