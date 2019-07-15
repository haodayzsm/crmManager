package top.haodayzsm.dao.impl;

import java.util.List;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import top.haodayzsm.dao.IColorDao;
import top.haodayzsm.pojo.Color;
import top.haodayzsm.pojo.Product;

@Controller(value="colorDao")
@Scope(value="prototype")
public class ColorDaoImpl extends BaseDaoImpl<Color> implements IColorDao{
	public Color findById(Color color){
		String hql="from Color c where c.name=? and c.product_id=?";
		List<Color> color2 = (List<Color>) this.getHibernateTemplate().find(hql,color.getName(),color.getProduct_id());
		if(color2.size()<1){
			return null;
		}else{
			return color2.get(0);
		}
		
	}

	@Override
	public Color findByProductId(Long id) {
		String hql = "from Color c where c.Product_id=?";
		
		return (Color) this.getHibernateTemplate().find(hql, id);
	}
}
