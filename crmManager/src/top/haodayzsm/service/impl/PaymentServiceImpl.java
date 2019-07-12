package top.haodayzsm.service.impl;

import java.util.Date;
import java.util.List;
import javax.annotation.Resource;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import top.haodayzsm.dao.IPaymentDao;
import top.haodayzsm.dao.ISupplierPaymentDao;
import top.haodayzsm.pojo.Customer;
import top.haodayzsm.pojo.Payment;
import top.haodayzsm.pojo.Supplier;
import top.haodayzsm.pojo.SupplierPayment;
import top.haodayzsm.service.ICustomerService;
import top.haodayzsm.service.IPaymentService;
import top.haodayzsm.service.ISupplierService;

@Controller(value="paymentService")
@Scope(value="prototype")
public class PaymentServiceImpl implements IPaymentService{
	@Resource(name="paymentDao")
	IPaymentDao paymentDao;
	
	@Resource(name="supplierPaymentDao")
	ISupplierPaymentDao supplierPaymentDao;
	
	@Resource(name="supplierService")
	ISupplierService supplierService;
	
	@Resource(name="customerService")
	ICustomerService customerService;

	@Override
	//更新客户账户信息
	public boolean save(Customer customer, Integer money,Date date) {
		Payment custoemrPayment=new Payment(date,money,customer.getName(),customer.getCustomer_id());
		if(customerSettlement(customer,money)){
			return paymentDao.save(custoemrPayment);
		}
		return false;
	}
	@Override
	public boolean customerSettlement(Customer customer, Integer money) {
		if(customer!=null){
			customer.setMoney(money+customer.getMoney());
			customerService.updata(customer);
			return true;
		}
		return false;
	}

	@Override
	public boolean save(Supplier supplier, Integer money ,Date date) {
		SupplierPayment supplierPayment=new SupplierPayment(date,money,supplier.getName(),supplier.getSupplier_id());
		if(supplierSettlement(supplier,money)){
			return supplierPaymentDao.save(supplierPayment);
		}
		return false;
	}

	@Override
	public boolean supplierSettlement(Supplier supplier, Integer money) {
		if(supplier!=null){
			supplier.setMoney(money+supplier.getMoney());
			return supplierService.updata(supplier);
		}
		return false;
	}

/*	public boolean supplierSettlement(Long supplier_id, Integer money) {
		String hql="from Supplier s where s.supplier_id=?";
		List<Supplier> suppliers = paymentDao.findById(hql,new Long[]{supplier_id});
		Supplier supplier=suppliers.get(0);
		if(supplier!=null){
			supplier.setMoney(money+supplier.getMoney());
			supplierService.save(supplier);
			return true;
		}
		return false;
	}
	
	
	public boolean customerSettlement(Long customer_id, Integer money) {
		String hql="from Customer c where c.customer_id=?";
		List<Customer> customers = paymentDao.findById(hql,new Long[]{customer_id});
		Customer customer=customers.get(0);
		if(customer!=null){
			customer.setMoney(money+customer.getMoney());
			customerService.save(customer);
			return true;
		}
		return false;
	}*/
}
