package top.haodayzsm.dao.impl;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import top.haodayzsm.dao.IOrderDao;
import top.haodayzsm.pojo.Order;
@Controller(value="orderDao")
@Scope(value="prototype")
public class OrderDaoImpl extends BaseDaoImpl<Order> implements IOrderDao{

}
