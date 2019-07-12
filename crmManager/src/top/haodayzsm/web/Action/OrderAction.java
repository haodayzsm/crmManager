package top.haodayzsm.web.Action;

import java.io.IOException;
import java.util.Date;
import java.util.List;

import javax.annotation.Resource;

import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Restrictions;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import net.sf.json.JSONArray;
import net.sf.json.JsonConfig;
import top.haodayzsm.pojo.Customer;
import top.haodayzsm.pojo.Order;
import top.haodayzsm.pojo.Storage;
import top.haodayzsm.service.ICustomerService;
import top.haodayzsm.service.IOrderService;
import top.haodayzsm.utils.Utils;
import top.haodayzsm.web.impl.BaseAction;
@Component(value="orderAction")
@Scope(value="prototype")
public class OrderAction extends BaseAction<Order> {
	private String type;
	private String products;
	private Date start;
	private Date end;
	
	@Resource(name="orderService")
	IOrderService orderService;
	public String orderSubmit() throws IOException{
		
		Utils.print(orderService.order(model, products));
		return NONE;
	}
	public String findSales() throws IOException{
		this.findAll("sales");
		return null;
	}
	public String findSalesReturn() throws IOException{
		this.findAll("return");
		return null;
	}
	//按条件查询销售订单
	public String findAll(String type) throws IOException{
		DetachedCriteria criteria = DetachedCriteria.forClass(Order.class);
		if(start!=null&&end!=null){			
			criteria.add(Restrictions.between("date",start,end));
		}
		if(model.getCustomer_id()!=null){
			criteria.add(Restrictions.eq("customer_id",model.getCustomer_id()));
		}
		if(type!=null){
			criteria.add(Restrictions.eq("type",type));
		}
		List<Order> orders = orderService.findByCondition(criteria);
		JsonConfig jsonConfig=new JsonConfig();
		jsonConfig.setExcludes(new String[]{"orderProuct"});
		JSONArray json=JSONArray.fromObject(orders,jsonConfig);
		Utils.printJson(json.toString());
		return null;
	}
	public String getOrderProduct() throws IOException{
		Utils.printJson(orderService.findById(model.getAorder_id()));
		return null;
	}
	
	
	
	

	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}

	public String getProducts() {
		return products;
	}

	public void setProducts(String products) {
		this.products = products;
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