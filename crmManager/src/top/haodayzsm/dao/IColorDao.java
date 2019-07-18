package top.haodayzsm.dao;

import java.util.List;

import top.haodayzsm.pojo.Color;

public interface IColorDao extends IBaseDao<Color>{
	public Color findById(Color color);
	public List<Color> findByProductId(Long id);
}
