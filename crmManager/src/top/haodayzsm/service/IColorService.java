package top.haodayzsm.service;

import top.haodayzsm.pojo.Color;

public interface IColorService {
	public boolean delete(Color color);
	public Color findByProductId(Long id);
}
