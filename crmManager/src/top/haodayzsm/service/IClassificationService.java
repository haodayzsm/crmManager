package top.haodayzsm.service;

import java.io.Serializable;
import java.util.List;

import org.hibernate.criterion.DetachedCriteria;

import top.haodayzsm.pojo.Classification;

public interface IClassificationService {
	public boolean save(Classification classification);
	public boolean updata(Classification classification);
	public boolean delete(Classification classification);
	public Classification findById(Serializable id);
	public Classification findById(String id);
	public String tree();
	public List findAll();
	public String combobox();
}
