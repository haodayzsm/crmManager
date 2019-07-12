package top.haodayzsm.web.Action;

import java.io.IOException;
import java.util.List;

import javax.annotation.Resource;

import org.apache.struts2.ServletActionContext;
import org.hibernate.criterion.DetachedCriteria;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
import net.sf.json.JsonConfig;
import top.haodayzsm.pojo.Product;
import top.haodayzsm.service.IProductService;
import top.haodayzsm.utils.PageBean;
import top.haodayzsm.utils.Utils;
import top.haodayzsm.web.impl.BaseAction;

@Controller(value="productAction")
@Scope(value="prototype")
public class ProductAction extends BaseAction<Product>{
	@Resource(name="productService")
	private IProductService productService;
	private Integer rows;
	private Integer page;
	public String pageQuery() throws IOException{
		PageBean pageBean=new PageBean();
		pageBean.setCurrentPage(page);
		pageBean.setPageSize(rows);
		DetachedCriteria detachedCriteria = DetachedCriteria.forClass(Product.class);
		//detachedCriteria.forClass(Product.class);
		pageBean.setDetachedCriteria(detachedCriteria);
		productService.pageProduct(pageBean);
		
		//将pageBean对象转换为json格式
		JsonConfig jsonConfig = new JsonConfig();
		String json=JSONObject.fromObject(pageBean, jsonConfig).toString();
		
		//响应，IO流响应
		Utils.printJson(json);
		return NONE;
	}
	public String list() throws IOException{
		List list = productService.findByAll();
		JsonConfig jsonConfig = new JsonConfig();
		Utils.printJson(JSONArray.fromObject(list).toString());
		return NONE;
	}
	public String findById() throws IOException{
		Utils.printJson(productService.findById(model));
		return NONE;
	}
	public String saveOrUpdata() throws IOException{
		Utils.print(productService.saveOrUpdata(model));
		return NONE;
	}
	public String delete() throws IOException{
		Utils.print(productService.delete(model));
		return NONE;
	}
	
	
	public Integer getRows() {
		return rows;
	}
	public void setRows(Integer rows) {
		this.rows = rows;
	}
	public Integer getPage() {
		return page;
	}
	public void setPage(Integer page) {
		this.page = page;
	}
	
}
