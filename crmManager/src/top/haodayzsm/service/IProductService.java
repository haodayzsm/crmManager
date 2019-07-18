package top.haodayzsm.service;

import java.util.List;

import top.haodayzsm.pojo.Product;
import top.haodayzsm.utils.PageBean;

public interface IProductService {
	public void pageProduct(PageBean pageBean);

	public List findByAll();
	public String findById(Product product);
	public boolean delete(Long id);
	public boolean updata(Product model);
	public boolean saveOrUpdata(Product model);
	public boolean updataQuantity(Long product_id);
	public List<Product> findByClassId(Long id);
	public List findByCondition(Long id,String key);
}
