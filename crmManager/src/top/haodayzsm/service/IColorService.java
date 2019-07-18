package top.haodayzsm.service;

import java.util.List;

import top.haodayzsm.pojo.Color;

public interface IColorService {
	public boolean delete(Color color);
	public List<Color> findByProductId(Long id);
}
