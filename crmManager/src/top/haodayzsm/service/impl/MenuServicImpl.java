package top.haodayzsm.service.impl;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.opensymphony.xwork2.ActionContext;

import top.haodayzsm.dao.IMenuDao;
import top.haodayzsm.service.IMenuService;

@Service(value="menuService")
public class MenuServicImpl implements IMenuService {
	@Resource(name="menuDao")
	IMenuDao menuDaoImpl;
	@Override
	public List findBypermission() {
		Map<String, Object> session = ActionContext.getContext().getSession();
		
		return null;
	}

	@Override
	public List findAll() {
		// TODO Auto-generated method stub
		return menuDaoImpl.findAll();
	}

}
