package top.haodayzsm.dao.impl;

import java.io.Serializable;
import java.util.List;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Repository;

import top.haodayzsm.dao.IPaymentDao;
import top.haodayzsm.pojo.Payment;
import top.haodayzsm.pojo.Supplier;
import top.haodayzsm.utils.PageBean;
@Repository(value="paymentDao")
@Scope(value="prototype")
public class PaymentDaoImpl extends BaseDaoImpl<Payment> implements IPaymentDao {

	
}
