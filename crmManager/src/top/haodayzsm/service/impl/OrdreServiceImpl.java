package top.haodayzsm.service.impl;

import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.annotation.Resource;

import org.hibernate.criterion.DetachedCriteria;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
import top.haodayzsm.dao.IColorDao;
import top.haodayzsm.dao.IOrderDao;
import top.haodayzsm.dao.IStorageDao;
import top.haodayzsm.pojo.Color;
import top.haodayzsm.pojo.Customer;
import top.haodayzsm.pojo.Order;
import top.haodayzsm.pojo.OrderProduct;
import top.haodayzsm.pojo.Product;
import top.haodayzsm.pojo.Storage;
import top.haodayzsm.pojo.StorageProduct;
import top.haodayzsm.pojo.Supplier;
import top.haodayzsm.pojo.User;
import top.haodayzsm.service.IOrderService;
import top.haodayzsm.service.IPaymentService;
import top.haodayzsm.service.IProductService;
import top.haodayzsm.service.IStorageService;
import top.haodayzsm.utils.Utils;
@Controller(value="orderService")
@Scope(value="prototype")
public class OrdreServiceImpl implements IOrderService {

	@Resource(name="orderDao")
	IOrderDao orderDao;
	
	@Resource(name="colorDao")
	IColorDao colorDao;
	
	@Resource(name="paymentService")
	IPaymentService paymentService;
	
	@Resource(name="productService")
	IProductService productService;
	
	@Override
	public boolean order(Order order, String orderProduct) {
		//Customer customer;
		User user = Utils.getUser();
		order.setUser(user.getName());
		order.setUser_id(user.getUser_id());		//用户信息
		
		JSONArray orderJson=JSONArray.fromObject(orderProduct);
		Set productSet=new HashSet();
		for(int i=0;i<orderJson.size();i++){
			JSONObject productJson = orderJson.getJSONObject(i);

			OrderProduct product = (OrderProduct) JSONObject.toBean(productJson,OrderProduct.class);
			Color color=new Color(product.getColor(),product.getPacking(),product.getPiece(),product.getProduct(),product.getProduct_id());
			color=updataColor(color,product.getQuantity(),order.getType());
			if(color!=null){				
				colorDao.save(color);
			}else{
				colorDao.updata(color);
			}
			product.setColor_id(color.getColor_id());
			productSet.add(product);						//将订单商品详情添加到集合
			productService.updataQuantity(product.getProduct_id());
		}
		order.setOrderProduct(productSet);		//添加订单详情集合
		
		
		String hql="from Customer c where c.customer_id=?";
		List<Customer> customers = orderDao.findById(hql, new Long[]{order.getCustomer_id()});
		
		Customer customer = customers.get(0);
		if(order.getType().equals("sales")){
			paymentService.save(customer, order.getMoney()-order.getTotal(), order.getDate());
		}else if(order.getType().equals("return")){
			paymentService.save(customer, (order.getMoney()-order.getTotal())*-1, order.getDate());
		}
		order.setCustomer(customer.getName());
		
		System.out.println(order.getAorder_id());
		orderDao.save(order);
		return true; 
	}
	
	@Override
	public boolean orderReturn(Order storage, String orderProduct) {
		// TODO Auto-generated method stub
		return false;
	}
	
	//查询color
	Color updataColor(Color color,Integer quantity,String type){
		Color color2=new Color();
		color2 = colorDao.findById(color);
		if(color2!=null){
			if(color2.getQuantity()>=quantity){
				if(type.equals("sales")){					
					color2.setQuantity(color2.getQuantity()-quantity);
					System.out.println("库存足够，库存已减");
				}else if(type.equals("return")){
					color2.setQuantity(color2.getQuantity()+quantity);					
				}
				return color2;
			}
			System.out.println("库存不足");
			return null;
		}
		System.out.println("没有这个色号");
		return null;
	}
	
	boolean updataPayment(){
		return true;
	}

	@Override
	public List<Order> findByCondition(DetachedCriteria criteria) {
		
		return orderDao.findByCondition(criteria);
	}

	@Override
	public String findById(Long aorder_id) {
		String hql="from Order o where o.aorder_id=?";
		List<Order> orders = orderDao.findById(hql,new Long[]{aorder_id});
		if(orders!=null){
			Set<OrderProduct> orderProduct = orders.get(0).getOrderProduct();
			JSONArray json=JSONArray.fromObject(orderProduct);
			return json.toString();
		}
		return null;
	}
}
