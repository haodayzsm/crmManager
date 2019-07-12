package top.haodayzsm.dao.impl;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Repository;

import top.haodayzsm.dao.ISupplierPaymentDao;
import top.haodayzsm.pojo.SupplierPayment;
@Repository(value="supplierPaymentDao")
@Scope(value="prototype")
public class SupplierPaymentDaoImpl extends BaseDaoImpl<SupplierPayment> implements ISupplierPaymentDao {


}
