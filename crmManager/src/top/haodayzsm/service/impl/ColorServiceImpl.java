package top.haodayzsm.service.impl;

import javax.annotation.Resource;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import top.haodayzsm.dao.IColorDao;
import top.haodayzsm.pojo.Color;
import top.haodayzsm.service.IColorService;
@Controller(value="colorService")
@Scope(value="prototype")
public class ColorServiceImpl implements IColorService {
	@Resource(name="colorDao")
	IColorDao colorDao;
	public boolean delete(Color color){
		return colorDao.delete(color);
	}
	@Override
	public Color findByProductId(Long id) {
		return colorDao.findByProductId(id);
	}
	
}
