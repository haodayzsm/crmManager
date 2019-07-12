package top.haodayzsm.dao.impl;

import org.springframework.stereotype.Component;

import top.haodayzsm.dao.ICustomerDao;
import top.haodayzsm.pojo.Customer;
@Component(value="customerDao")
public class CustomerDaoImpl extends BaseDaoImpl<Customer> implements ICustomerDao {
	
}
