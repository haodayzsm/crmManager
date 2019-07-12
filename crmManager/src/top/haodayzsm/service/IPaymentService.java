package top.haodayzsm.service;

import java.util.Date;

import top.haodayzsm.pojo.Customer;
import top.haodayzsm.pojo.Payment;
import top.haodayzsm.pojo.Supplier;
import top.haodayzsm.pojo.SupplierPayment;

public interface IPaymentService {
	public boolean supplierSettlement (Supplier supplier,Integer payment);
	public boolean customerSettlement (Customer customer,Integer payment);
	public boolean save(Customer customer,Integer money,Date date);
	public boolean save(Supplier supplier,Integer money,Date date);
}
