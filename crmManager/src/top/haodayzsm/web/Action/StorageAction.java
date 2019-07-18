package top.haodayzsm.web.Action;

import java.io.IOException;
import java.util.Date;
import java.util.List;

import javax.annotation.Resource;

import org.hibernate.Criteria;
import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Restrictions;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import net.sf.json.JSONArray;
import net.sf.json.JsonConfig;
import top.haodayzsm.pojo.Product;
import top.haodayzsm.pojo.Storage;
import top.haodayzsm.service.IStorageService;
import top.haodayzsm.web.impl.BaseAction;
@Controller(value="storageAction")
@Scope(value="prototype")
public class StorageAction extends BaseAction<Storage> {
	@Resource(name="storageService")
	IStorageService storageService;
	private Long product_id;
	private String products;
	private Date start;
	private Date end;
	private Long supplier_id;
	
	//添加进货单
	public String orderSubmit() throws IOException{
		storageService.order(model,products);
		return NONE;
	}
	public String findStorage() throws IOException{
		this.findAll("jhd");
		return null;
	}
	public String findStorageReturn() throws IOException{
		this.findAll("return");
		return null;
	}
	//按条件查询进货的
	public void findAll(String type) throws IOException{
		DetachedCriteria criteria = DetachedCriteria.forClass(Storage.class);
		if(type!=null){
			criteria.add(Restrictions.eq("type",type));
		}
		if(start!=null&&end!=null){			
			criteria.add(Restrictions.between("date",start,end));
		}
		if(model.getSupplier_id()!=null){
			criteria.add(Restrictions.eq("supplier_id",model.getSupplier_id()));
		}
		List<Storage> storages = storageService.findByCondition(criteria);
		JsonConfig jsonConfig=new JsonConfig();
		jsonConfig.setExcludes(new String[]{"orderProuct"});
		JSONArray json=JSONArray.fromObject(storages,jsonConfig);
		this.printJson(json.toString());
	}
	public String getOrderProduct() throws IOException{
		this.printJson(storageService.findById(model.getStorage_id()));
		return null;
	}
	
	public String getProducts() {
		return products;
	}
	public void setProducts(String products) {
		this.products = products;
	}
	public void setStorageService(IStorageService storageService) {
		this.storageService = storageService;
	}
	public void setProduct_id(Long product_id) {
		this.product_id = product_id;
	}
	public void setSupplier_id(Long supplier_id) {
		this.supplier_id = supplier_id;
	}
	public IStorageService getStorageService() {
		return storageService;
	}
	public Long getProduct_id() {
		return product_id;
	}
	public Long getSupplier_id() {
		return supplier_id;
	}
	public Date getStart() {
		return start;
	}
	public void setStart(Date start) {
		this.start = start;
	}
	public Date getEnd() {
		return end;
	}
	public void setEnd(Date end) {
		this.end = end;
	}
}	
