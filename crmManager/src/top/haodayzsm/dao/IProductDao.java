package top.haodayzsm.dao;

import java.util.List;

import top.haodayzsm.pojo.Product;

public interface IProductDao extends IBaseDao<Product>{
	public Product findById(Product product);
	public List<Product> findByClassId(Long id);
}
