package top.haodayzsm.dao;

import java.util.List;

import top.haodayzsm.pojo.Customer;
import top.haodayzsm.pojo.Product;

public interface ICustomerDao extends IBaseDao<Customer>{

	List<Customer> findAllActivation();

}
