package top.haodayzsm.service;


import java.util.List;

import org.hibernate.criterion.DetachedCriteria;

import top.haodayzsm.pojo.Storage;

public interface IStorageService {
	public boolean order(Storage storage,String orderProduct);
	public boolean orderReturn(Storage storage,String orderProduct);
	public List<Storage> findByCondition(DetachedCriteria criteria);
	public String findById(Long storage_id);
}
