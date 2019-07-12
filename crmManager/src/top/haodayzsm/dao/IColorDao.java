package top.haodayzsm.dao;

import top.haodayzsm.pojo.Color;

public interface IColorDao extends IBaseDao<Color>{
	public Color findById(Color color);
}
