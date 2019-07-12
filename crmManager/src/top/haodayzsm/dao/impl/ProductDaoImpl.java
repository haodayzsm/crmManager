package top.haodayzsm.dao.impl;

import java.util.List;

import org.springframework.stereotype.Repository;

import top.haodayzsm.dao.IProductDao;
import top.haodayzsm.pojo.Product;
import top.haodayzsm.pojo.User;
@Repository(value="productDao")
public class ProductDaoImpl extends BaseDaoImpl<Product> implements IProductDao {
	public Product findById(Product product){
		String hql="from Product p where p.product_id=?";
		List<Product> product2 = (List<Product>) this.getHibernateTemplate().find(hql,product.getProduct_id());
		if(product2.size()<1){
			return null;
		}else{
			return product2.get(0);
		}
		
	}
}
