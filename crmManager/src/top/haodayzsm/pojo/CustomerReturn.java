package top.haodayzsm.pojo;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

public class CustomerReturn implements java.io.Serializable{
	private Long customerReturn_id;
	private String number;			//单号
	private String Remarks;
	private Date date;				//时间
	private Double total;			//总计金额
	private Double payment;			//付款情况
	private String user;
	private Long user_id;
	private String customer;
	private Long customer_id;	
	private Set<OrderProduct> orderproduct=new HashSet<OrderProduct>();
	public Long getCustomerReturn_id() {
		return customerReturn_id;
	}
	public void setCustomerReturn_id(Long customerReturn_id) {
		this.customerReturn_id = customerReturn_id;
	}
	public String getNumber() {
		return number;
	}
	public void setNumber(String number) {
		this.number = number;
	}
	public String getRemarks() {
		return Remarks;
	}
	public void setRemarks(String remarks) {
		Remarks = remarks;
	}
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	public Double getTotal() {
		return total;
	}
	public void setTotal(Double total) {
		this.total = total;
	}
	public Double getPayment() {
		return payment;
	}
	public void setPayment(Double payment) {
		this.payment = payment;
	}
	public String getUser() {
		return user;
	}
	public void setUser(String user) {
		this.user = user;
	}
	public Long getUser_id() {
		return user_id;
	}
	public void setUser_id(Long user_id) {
		this.user_id = user_id;
	}
	public String getCustomer() {
		return customer;
	}
	public void setCustomer(String customer) {
		this.customer = customer;
	}
	public Long getCustomer_id() {
		return customer_id;
	}
	public void setCustomer_id(Long customer_id) {
		this.customer_id = customer_id;
	}
	public Set<OrderProduct> getOrderproduct() {
		return orderproduct;
	}
	public void setOrderproduct(Set<OrderProduct> orderproduct) {
		this.orderproduct = orderproduct;
	}
	
	
}
