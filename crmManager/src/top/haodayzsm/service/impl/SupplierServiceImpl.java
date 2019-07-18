package top.haodayzsm.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
import net.sf.json.JsonConfig;
import top.haodayzsm.dao.ISupplierDao;
import top.haodayzsm.pojo.Product;
import top.haodayzsm.pojo.Supplier;
import top.haodayzsm.service.IProductService;
import top.haodayzsm.service.ISupplierService;
@Service(value="supplierService")
@Scope(value="prototype")
public class SupplierServiceImpl implements ISupplierService {
	@Resource(name="supplierDao")
	ISupplierDao supplierDao;
	@Resource(name="productService")
	IProductService productService;
/*	@Override
	public String tree(){
		StringBuffer json=new StringBuffer("[");
		List<Supplier> list = supplierDao.findAllActivation("activation");
		int a=0;
		for(Supplier supplier:list){
			List<Product> products=productService.findByCondition(supplier.getSupplier_id(),"supplier_id");
			if(products.size()<=0){
				continue;
			}
			json.append("{");
			json.append("\"text\":");
			json.append(" \""+supplier.getName()+"\",");
			json.append("\"children\":[");
			int b=0;
			a++;
			for(Product product:products){
				json.append("{");
				json.append("\"id\":");
				json.append("\""+product.getProduct_id().toString()+"\"");
				json.append(",\"text\":");
				json.append(" \""+product.getNumber()+"\"");
				b++;
				if(b<products.size()){
					json.append("},");
				}else{
					json.append("}");
				}
			}
			json.append("]");
			if(a<list.size()){
				json.append("},");
			}else{
				json.append("}");
			}
		}
		json.append("]");
		return json.toString();
	}*/
	/*
	 * 返回以适合tree格式的json字符串
	 */
	@Override
	public String tree() {
		List<Supplier> suppliers = supplierDao.findAllActivation("activation");
		JSONArray json=new JSONArray();
		for(int i=0;suppliers.size()>i;i++){
			JSONObject obj=new JSONObject();
			JSONArray arr=new JSONArray();
			Supplier supplier = suppliers.get(i);
			List<Product> products = productService.findByCondition(supplier.getSupplier_id(), "supplier_id");
			if(products.size()>0){			
				obj.accumulate("id", supplier.getSupplier_id());
				obj.accumulate("text", supplier.getName());
				for(Product product:products){
					JSONObject obj2=new JSONObject();
					obj2.accumulate("id",product.getProduct_id());
					obj2.accumulate("text",product.getName());
					arr.add(obj2);
				}
				obj.accumulate("children",arr);
				json.add(obj);
			}
		}
		
		return json.toString();
	}
	
	public String combobox(){
		StringBuffer json=new StringBuffer("[");
		List<Supplier> list = supplierDao.findAllActivation("activation");
		int a=0;
		for(Supplier supplier:list){
			json.append("{");
			json.append("\"id\":");
			json.append(" \""+supplier.getSupplier_id()+"\",");
			json.append("\"text\":");
			json.append(" \""+supplier.getName()+"\"");
			a++;
			if(a<list.size()){
				json.append("},");
			}else{
				json.append("}");
			}
		}
		json.append("]");
		return json.toString();
	}
	@Override
	public boolean updata(Supplier supplier) {
		return supplierDao.updata(supplier);
		
	}
	@Override
	public boolean inactivated (Supplier supplier){
		List<Supplier> list = supplierDao.findById(supplier.getSupplier_id());
		if(list.size()>0){
			Supplier supplier1=list.get(0);
			supplier1.setStatus("inActivated");
			return supplierDao.save(supplier1);
		}
		return false;
	}
	@Override
	public boolean activation (Supplier supplier){
		List<Supplier> list = supplierDao.findById(supplier.getSupplier_id());
		if(list.size()>0){
			Supplier supplier1=list.get(0);
			supplier1.setStatus("activation");
			return supplierDao.save(supplier1);
		}
		return false;
	}
	@Override
	public boolean delete(Long id) {
		return supplierDao.deleteById(id);
	}
	@Override
	public String findByAll() {
		List<Supplier> list = supplierDao.findAll();
		return this.ListToString(list);
	}
	@Override
	public boolean save(Supplier supplier) {
		return supplierDao.save(supplier);
	}
	private String ListToString(List list){
		JsonConfig jsonConfig=new JsonConfig();
		jsonConfig.setExcludes(new String[]{"product","supplierReturn","storage"});
		return JSONArray.fromObject(list,jsonConfig).toString();
	}
	@Override
	public String findByActivation() {
		List<Supplier> list = supplierDao.findAllActivation("activation");
		return this.ListToString(list);
	}
	@Override
	public String findByInactivated() {
		List<Supplier> list = supplierDao.findAllActivation("inActivated");
		return this.ListToString(list);
	}
}
