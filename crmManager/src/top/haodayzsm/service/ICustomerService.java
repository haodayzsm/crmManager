package top.haodayzsm.service;

import java.util.List;

import top.haodayzsm.pojo.Customer;

public interface ICustomerService {
	public boolean save(Customer customer);
	public boolean updata(Customer customer);
	public List findByAll();
	public boolean delete(Long id);
	public String combobox();
	public boolean inActivated(Long id);
	public boolean activation(Long id);
	public String findAllactivation();
	public String findAllinActivated();
}
