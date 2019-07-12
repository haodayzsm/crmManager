package top.haodayzsm.service.impl;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.annotation.Resource;

import org.hibernate.criterion.DetachedCriteria;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
import top.haodayzsm.dao.IColorDao;
import top.haodayzsm.dao.IStorageDao;
import top.haodayzsm.pojo.Color;
import top.haodayzsm.pojo.Storage;
import top.haodayzsm.pojo.StorageProduct;
import top.haodayzsm.pojo.Supplier;
import top.haodayzsm.pojo.User;
import top.haodayzsm.service.IPaymentService;
import top.haodayzsm.service.IProductService;
import top.haodayzsm.service.IStorageService;
import top.haodayzsm.utils.Utils;
@Controller(value="storageService")
@Scope(value="prototype")
public class StorageServiceImpl implements IStorageService {
	@Resource(name="storageDao")
	IStorageDao storageDao;
	
	@Resource(name="colorDao")
	IColorDao colorDao;
	
	@Resource(name="paymentService")
	IPaymentService paymentService;
	
	@Resource(name="productService")
	IProductService productService;
	
	@Override
	public boolean order(Storage storage,String orderProduct) {
		System.out.println(orderProduct+storage.toString());
		User user = Utils.getUser();
		storage.setUser_id(user.getUser_id());
		JSONArray jsonArray = JSONArray.fromObject(orderProduct);
		Set jsonSet = this.jsonToSet(jsonArray,storage.getType());
		storage.setOrderProduct(jsonSet);
		
		//按id获取supplier对象
		String hql="from Supplier s where s.supplier_id=?";
		List<Supplier> suppliers = storageDao.findById(hql,new Long[]{storage.getSupplier_id()});
		
		if(storage.getType().equals("return")){	
			if(suppliers!=null){
				Supplier supplier = suppliers.get(0);
				paymentService.save(supplier,(storage.getMoney()-storage.getTotal())*-1,storage.getDate());
				storage.setSupplier(supplier.getName());
			}
		}else if(storage.getType().equals("jhd")){
			if(suppliers!=null){
				Supplier supplier = suppliers.get(0);
				paymentService.save(supplier,storage.getMoney()-storage.getTotal(),storage.getDate());
				storage.setSupplier(supplier.getName());
			}
		}
		else{
			try {
				throw new Exception("单据类型错误");
			} catch (Exception e) { 
				e.printStackTrace();
			}
		}
		
		storage.setUser(user.getName());
		
		
		return storageDao.save(storage);
	}

	@Override
	public boolean orderReturn(Storage storage,String orderProduct) {
		// TODO Auto-generated method stub
		return false;
	}
	Set jsonToSet(JSONArray jsonArray,String type){
		JSONObject obj=new JSONObject();
		Set	storageProduct=new HashSet();
		Color color;
		for(int i=0;i<jsonArray.size();i++){
			obj = jsonArray.getJSONObject(i);
			StorageProduct product = (StorageProduct) obj.toBean(obj, StorageProduct.class);
			
			String colorName = (String) obj.get("color");
			Integer costPrice = Integer.parseInt((String) obj.get("unitPrice"));
			Long product_id =Long.parseLong((String) obj.get("product_id"));
			String productName = (String) obj.get("number");
			Integer productPacking = Integer.parseInt((String) obj.get("packing"));
			Integer quantity = quantity = Integer.parseInt((String) obj.get("quantity"));
			
			Color color2=null;
			color=new Color(colorName,productPacking,costPrice,productName,product_id);
			if(type.equals("jhd")){	
				color2=saveColor(color,quantity);
			}else if(type.equals("return")){	
				color2=saveColor(color,quantity*-1);				
			}else{
				try {
					throw new Exception("单据类型错误");
				} catch (Exception e) { 
					e.printStackTrace();
				}
			}
			
			product.setColor_id(color2.getColor_id());
			storageProduct.add(product);
			
			productService.updataQuantity(product.getProduct_id());
		}
		return storageProduct;
	}
	//保存Color对象，先查询该Color对象是否存在，如果存在就增加库存，
	Color saveColor(Color color,Integer quantity){
		Color color2=new Color();
		color2 = colorDao.findById(color);
		if(color2==null){
			color.setQuantity(quantity);
			colorDao.save(color);
			return color2 = colorDao.findById(color);
		}else{
			color2.setQuantity(color2.getQuantity()+quantity);
			return color2;
		}
	}

	@Override
	public List<Storage> findByCondition(DetachedCriteria criteria) {
		return storageDao.findByCondition(criteria);
	}

	@Override
	public String findById(Long storage_id) {
		String hql="from Storage s where s.storage_id=?";
		List<Storage> storages = storageDao.findById(hql,new Long[]{storage_id});
		if(storages!=null){
			Set<StorageProduct> orderProduct = storages.get(0).getOrderProduct();
			JSONArray json=JSONArray.fromObject(orderProduct);
			return json.toString();
		}
		return null;
	}
}
