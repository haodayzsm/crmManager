package top.haodayzsm.service.impl;

import java.io.IOException;
import java.io.Serializable;
import java.util.List;
import java.util.Set;

import javax.annotation.Resource;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
import top.haodayzsm.dao.IClassificationDao;
import top.haodayzsm.dao.IProductDao;
import top.haodayzsm.pojo.Classification;
import top.haodayzsm.pojo.Product;
import top.haodayzsm.pojo.Supplier;
import top.haodayzsm.service.IClassificationService;
import top.haodayzsm.service.IProductService;

@Service(value="classificationService")
@Scope(value="prototype")
//@Transactional(value="hibernateManager")
public class ClassificationServiceImpl implements IClassificationService {
	@Resource(name="classificationDao")
	IClassificationDao classificationDao;
	@Resource(name="productService")
	IProductService productService;
	@Override
	public boolean save(Classification classification) {
		return classificationDao.save(classification);
	}

	@Override
	public boolean updata(Classification classification) {
		return classificationDao.updata(classification);
	}
	/**
	 * 删除分类信息，级联删除该分类的商品与色号
	 */
	@Override
	public boolean delete(Long id) {
		return classificationDao.deleteById(id);
	}

	@Override
	public Classification findById(Serializable id) {
		return classificationDao.findById(id);
	}

	@Override
	public List findAll() {
		return classificationDao.findAll();
	}
//	@Override
//	public String tree(){
//		List<Classification> list = classificationDao.findAll();
//		StringBuffer json=new StringBuffer("[");
//		int a=0;
//		for(Classification cla:list){
//			json.append("{");
//			json.append("\"text\":");
//			json.append(" \""+cla.getName()+"\",");
//			int b=0;
//			a++;
//			json.append("\"children\":[");
//			for(Product product:cla.getProduct()){
//				json.append("{");
//				json.append("\"id\":");
//				json.append("\""+product.getProduct_id().toString()+"\",");
//				json.append("\"text\":");
//				json.append(" \""+product.getNumber()+"\"");
//				b++;
//				if(b<cla.getProduct().size()){
//					json.append("},");
//				}else{
//					json.append("}");
//				}
//			}
//			json.append("]");
//			if(a<list.size()){
//				json.append("},");
//			}else{
//				json.append("}");
//			}
//		}
//		json.append("]");
//		return json.toString();
//	}
//	
	/*
	 * 返回以适合tree格式的json字符串
	 */
	@Override
	public String tree() {
		List<Classification> list = classificationDao.findAll();
		JSONArray json=new JSONArray();
		for(int i=0;list.size()>i;i++){
			JSONObject obj=new JSONObject();
			JSONArray arr=new JSONArray();
			Classification classification = list.get(i);
			Set<Product> products = classification.getProduct();
			if(products.size()>0){			
				obj.accumulate("id", classification.getClassification_id());
				obj.accumulate("text", classification.getName());
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

	@Override
	public String combobox() {
		StringBuffer json=new StringBuffer("[");
		List<Classification> list = classificationDao.findAll();
		int a=0;
		for(Classification classification:list){
			json.append("{");
			json.append("\"id\":");
			json.append(" \""+classification.getClassification_id()+"\",");
			json.append("\"text\":");
			json.append(" \""+classification.getName()+"\"");
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

	@Override//暂时不用
	public Classification findById(String id) {
//		String hql="from Classification c where c.classification_id=?";
//		List list = classificationDao.findById(hql, new String[]{"id"});
//		if(list.size()>0){
//			return (Classification) list.get(0);
//		}else{
//			return null;
//		}
		return null;
	}
}
