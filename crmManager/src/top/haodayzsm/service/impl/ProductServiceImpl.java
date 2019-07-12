package top.haodayzsm.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import net.sf.json.JSONObject;
import net.sf.json.JsonConfig;
import top.haodayzsm.dao.IProductDao;
import top.haodayzsm.pojo.Classification;
import top.haodayzsm.pojo.Color;
import top.haodayzsm.pojo.Product;
import top.haodayzsm.pojo.Supplier;
import top.haodayzsm.service.IProductService;
import top.haodayzsm.utils.PageBean;
@Service(value="productService")
public class ProductServiceImpl implements IProductService {
	@Resource(name="productDao")
	IProductDao productDao;
	Classification classification;
	Supplier supplier;
	@Override
	public void pageProduct(PageBean pageBean) {
		productDao.pageQuery(pageBean);
	}
	@Override
	public List findByAll() {
		return productDao.findAll();
		
	}
	@Override
	public String findById(Product product) {
		JsonConfig jsonConfig = new JsonConfig();
		String[] srts={"classification_id","supplier_id","retailPrice","wholesalePrice"};
		jsonConfig.setExcludes(srts);		
		JSONObject jsonProduct = JSONObject.fromObject(productDao.findById(product),jsonConfig);
		String json=jsonProduct.toString();
		return json;
	}
	@Override
	public boolean delete(Product model) {
		return productDao.delete(model);
	}
	@Override
	public boolean updata(Product model) {
		if(model.getProduct_id()!=null){
			return productDao.updata(model);
		}else{
			return false;
		}	
	}
	//保存一条商品信息，用分类与供应商的ID查询分类与供应商的name
	@Override
	public boolean saveOrUpdata(Product model) {
		List cs=null;
		List ss=null;
		String c_hql="from Classification c where c.classification_id=?";
		if(model.getClassification_id()==null){
			return false;
		}else{
			cs = productDao.findById(c_hql, new Long[]{model.getClassification_id()}); 
		}
		String s_hql="from Supplier s where s.supplier_id=?";
		if(model.getSupplier_id()==null){
			return false;
		}else{
			ss = productDao.findById(s_hql, new Long[]{model.getSupplier_id()}); 
		}
		if(cs.size()>0){
			classification = (Classification) cs.get(0);
			model.setClassification(classification.getName());
			if(ss.size()>0){
				supplier = (Supplier) ss.get(0);
				model.setSupplier(supplier.getName());
				productDao.saveOrUpdata(model);
				return true;
			}else{
				return false;
			}
		}else{
			return false;
		}
	}
	
	/*
	 * 更新商品库存
	 */
	@Override
	public boolean updataQuantity(Long product_id) {
		String hql="from Product p where p.product_id=?";
		List<Product> list = productDao.findById(hql,new Long[]{product_id});
		if(list!=null){
			Product product = list.get(0);
			if (product!=null) {
				for(Color color:product.getColor()){
					if(color!=null){					
						product.setQuantity(color.getQuantity()+product.getQuantity());
					}
				}				
			}
			productDao.updata(product);
			return true;
		}
		return false;
	}
}
