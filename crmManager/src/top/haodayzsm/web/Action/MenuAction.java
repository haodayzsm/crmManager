package top.haodayzsm.web.Action;

import java.io.IOException;
import java.util.List;
import java.util.Set;

import javax.annotation.Resource;

import org.apache.struts2.ServletActionContext;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import net.sf.json.JSONArray;
import net.sf.json.JsonConfig;
import top.haodayzsm.pojo.Permission;
import top.haodayzsm.pojo.User;
import top.haodayzsm.service.IMenuService;
import top.haodayzsm.utils.Utils;
import top.haodayzsm.web.impl.BaseAction;

@Controller(value="menuAction")
@Scope(value="prototype")
public class MenuAction extends BaseAction<Permission>{
	@Resource(name="menuService")
	IMenuService menuService;
	@SuppressWarnings("unchecked")
	public String tree() throws IOException{
		User user = Utils.getUser();
		List<Permission> permission = menuService.findAll();
		JsonConfig jsonConfig=new JsonConfig();
		jsonConfig.setExcludes(new String[]{"user","permission_id"});
		String json = JSONArray.fromObject(permission,jsonConfig).toString();
		System.out.println(json);
		Utils.printJson(json);
		return NONE;
	}
}
