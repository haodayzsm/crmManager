package top.haodayzsm.service;

import java.util.List;

import org.hibernate.criterion.DetachedCriteria;

import top.haodayzsm.pojo.Order;

public interface IOrderService {
	public boolean order(Order storage,String orderProduct);
	public boolean orderReturn(Order storage,String orderProduct);
	public List<Order> findByCondition(DetachedCriteria criteria);
	public String findById(Long customer_id);
}
