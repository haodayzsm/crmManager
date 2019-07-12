package top.haodayzsm.web.Action;

import java.io.IOException;

import javax.annotation.Resource;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import top.haodayzsm.pojo.Color;
import top.haodayzsm.service.IColorService;
import top.haodayzsm.utils.Utils;
import top.haodayzsm.web.impl.BaseAction;
@Component(value="colorAction")
@Scope(value="prototype")
public class ColorAction extends BaseAction<Color> {
	@Resource(name="colorService")
	IColorService colorService;
	public String delete() throws IOException{
		Utils.print(colorService.delete(model));
		return null;
	}
}
