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
	public boolean delete(Customer customer){
		return customerDao.delete(customer);
	}

	//�����е�customer����ת��Ϊ����ǰ��combobox��json�ַ���
	@Override
	public String combobox() {
		List list = findByAll();
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
}
