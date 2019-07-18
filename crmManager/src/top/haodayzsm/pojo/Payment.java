package top.haodayzsm.pojo;

import java.util.Date;

public class Payment implements java.io.Serializable{
	private Long payment_id;
	private Date date;
	private Integer money;
	private String customer;
	private Long customer_id;
	public Payment(Date date,Integer money,String customer,Long customer_id){
		this.date = date;
		this.money = money;
		this.customer = customer;
		this.customer_id=customer_id;
	}
	public Payment(){}
	public Long getPayment_id() {
		return payment_id;
	}
	public void setPayment_id(Long payment_id) {
		this.payment_id = payment_id;
	}
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
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
	public Integer getMoney() {
		return money;
	}
	public void setMoney(Integer money) {
		this.money = money;
	}

}
