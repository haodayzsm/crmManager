package top.haodayzsm.dao;

import top.haodayzsm.pojo.Product;

public interface IProductDao extends IBaseDao<Product>{
	public Product findById(Product product);
	public Product findByClassId(Long id);
}
