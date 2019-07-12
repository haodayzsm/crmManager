package top.haodayzsm.service;

import top.haodayzsm.pojo.Customer;
import top.haodayzsm.pojo.Supplier;

public interface ISupplierService {
	public String tree();
	public String findByAll();
	public boolean updata(Supplier supplier);
	public boolean delete(Supplier supplier);
	public boolean save(Supplier supplier);
	public String combobox();
}
