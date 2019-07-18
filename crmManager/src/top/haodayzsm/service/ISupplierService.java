package top.haodayzsm.service;

import top.haodayzsm.pojo.Customer;
import top.haodayzsm.pojo.Supplier;

public interface ISupplierService {
	public String tree();
	public String findByAll();
	public String findByActivation();
	public String findByInactivated();
	public boolean updata(Supplier supplier);
	public boolean delete(Long id);
	public boolean save(Supplier supplier);
	public String combobox();
	boolean inactivated(Supplier supplier);
	boolean activation(Supplier supplier);
}
