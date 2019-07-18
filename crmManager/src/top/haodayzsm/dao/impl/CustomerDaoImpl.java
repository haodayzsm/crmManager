package top.haodayzsm.dao.impl;

import java.util.List;

import org.springframework.stereotype.Component;

import top.haodayzsm.dao.ICustomerDao;
import top.haodayzsm.pojo.Customer;
@Component(value="customerDao")
public class CustomerDaoImpl extends BaseDaoImpl<Customer> implements ICustomerDao {
	@Override
	public List<Customer> findAllActivation() {
		String hql = "from Customer c where c.status=?";
		return (List<Customer>) this.getHibernateTemplate().find(hql, "activation");
	}
}
