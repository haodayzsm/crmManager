package top.haodayzsm.service.impl;

import java.io.Serializable;
import java.util.List;

import javax.annotation.Resource;

import org.hibernate.criterion.DetachedCriteria;

import top.haodayzsm.dao.IBaseDao;
import top.haodayzsm.service.IBaseService;

public class BaseServiceImpl implements IBaseService {
	@Resource(name="baseDao")
	IBaseDao baseDao;
	@Override
	public void save(Object object) {
	}

	@Override
	public void saveBatch(List list) {

	}

	@Override
	public void updata(Object object) {

	}

	@Override
	public void delete(Object object) {

	}

	@Override
	public Object findById(Serializable id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Object fingByCondition(DetachedCriteria detachedCriteria) {
		// TODO Auto-generated method stub
		return null;
	}

}
