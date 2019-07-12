package top.haodayzsm.dao.impl;

import org.springframework.stereotype.Repository;

import top.haodayzsm.dao.IMenuDao;
import top.haodayzsm.pojo.Permission;
@Repository(value="menuDao")
public class MenuDaoImpl extends BaseDaoImpl<Permission> implements IMenuDao {

}
