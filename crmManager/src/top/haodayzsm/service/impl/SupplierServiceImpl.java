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
import top.haodayzsm.service.ISupplierService;
@Service(value="supplierService")
@Scope(value="prototype")
public class SupplierServiceImpl implements ISupplierService {
	@Resource(name="supplierDao")
	ISupplierDao supplierDao;
	@Override
	public String tree(){
		StringBuffer json=new StringBuffer("[");
		List<Supplier> list = supplierDao.findAll();
		int a=0;
		for(Supplier supplier:list){
			json.append("{");
			json.append("\"text\":");
			json.append(" \""+supplier.getName()+"\",");
			json.append("\"children\":[");
			int b=0;
			a++;
			for(Product product:supplier.getProduct()){
				json.append("{");
				json.append("\"id\":");
				json.append("\""+product.getProduct_id().toString()+"\"");
				json.append(",\"text\":");
				json.append(" \""+product.getNumber()+"\"");
				b++;
				if(b<supplier.getProduct().size()){
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
	}
	public String combobox(){
		StringBuffer json=new StringBuffer("[");
		List<Supplier> list = supplierDao.findAll();
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
	public boolean delete(Supplier supplier) {
		return supplierDao.delete(supplier);
		
	}
	@Override
	public String findByAll() {
		List<Supplier> list = supplierDao.findAll();
		JsonConfig jsonConfig=new JsonConfig();
		jsonConfig.setExcludes(new String[]{"product","supplierReturn","storage"});
		return JSONArray.fromObject(list,jsonConfig).toString();
	}
	@Override
	public boolean save(Supplier supplier) {
		return supplierDao.save(supplier);
	}
}
