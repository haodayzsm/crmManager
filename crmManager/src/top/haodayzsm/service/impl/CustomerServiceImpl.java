package top.haodayzsm.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Component;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
import net.sf.json.JsonConfig;
import top.haodayzsm.dao.ICustomerDao;
import top.haodayzsm.pojo.Customer;
import top.haodayzsm.service.ICustomerService;
@Component(value="customerService")
public class CustomerServiceImpl implements ICustomerService {
	@Resource(name="customerDao")
	ICustomerDao customerDao;
	@Override
	public boolean save(Customer customer) {
		return customerDao.save(customer);
	}

	@Override
	public boolean updata(Customer customer) {
		return customerDao.updata(customer);
	}

	@Override
	public List findByAll() {
		return customerDao.findAll();
	}
	/*
	 * 删除客户
	 */
	public boolean delete(Long id){
		return customerDao.deleteById(id);
	}

	//将所有的customer对象转换为符合前端combobox的json字符串
	@Override
	public String combobox() {
		List list = customerDao.findAllActivation();
		JsonConfig jsonConfig=new JsonConfig();
		jsonConfig.setExcludes(new String[]{"wechat","tel","payment","orderReturn","order","orderReturn","location","money"});
		JSONArray customers=JSONArray.fromObject(list,jsonConfig);
		JSONArray customers2=new JSONArray();
		JSONObject customer;
		JSONObject customer2 = new JSONObject();
		for(int i=0;i<customers.size();i++){
			customer = customers.getJSONObject(i);
			customer2.put("text",customer.get("name"));
			customer2.put("id",customer.get("customer_id"));
			customers2.add(i, customer2);
		}
		return customers2.toString();
	}
	/*
	 * 将customer变为未激活状态
	 */
	@Override
	public boolean inActivated(Long id) {
		List<Customer> list = customerDao.findById(id);
		if(list.size()>0){
			Customer customer=list.get(0);
			customer.setStatus("inActivated");
			return customerDao.save(customer);
		}
		return false;
	}
	/*
	 * 将customer变为未激活状态
	 */
	@Override
	public boolean activation(Long id) {
		List<Customer> list = customerDao.findById(id);
		if(list.size()>0){
			Customer customer=list.get(0);
			customer.setStatus("activation");
			return customerDao.save(customer);
		}
		return false;
	}
	/*
	 * 将list转为JSON字符串
	 */
	private String listToJson(List list){
		JsonConfig jsonConfig=new JsonConfig();
		jsonConfig.setExcludes(new String[]{"storage","payment","orderReturn"});
		JSONArray json=JSONArray.fromObject(list,jsonConfig);
		return json.toString();
	}
	@Override
	public String findAllactivation() {
		List<Customer> customers = customerDao.findAllActivation("activation");
		return listToJson(customers);
	}

	@Override
	public String findAllinActivated() {
		List<Customer> customers = customerDao.findAllActivation("inactivated");
		return listToJson(customers);
	}
}
