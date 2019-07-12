package top.haodayzsm.web.Action;

import java.io.IOException;
import java.util.List;
import javax.annotation.Resource;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import net.sf.json.JSONArray;
import net.sf.json.JsonConfig;
import top.haodayzsm.pojo.Classification;
import top.haodayzsm.service.IClassificationService;
import top.haodayzsm.utils.Utils;
import top.haodayzsm.web.impl.BaseAction;

@Controller(value="classificationAction")
@Scope(value="prototype")
public class ClassificationAction extends BaseAction<Classification> {
	@Resource(name="classificationService")
	IClassificationService classificationService;
	/*
	 * 商品分类信息
	 */
	public String list(){
		try {
			List list = classificationService.findAll();
			JsonConfig jsonConfig = new JsonConfig();
			jsonConfig.setExcludes(new String[]{"product"});
			String json = JSONArray.fromObject(list,jsonConfig).toString();
			System.out.println("json:"+json);
			Utils.printJson(json);
		} catch (IOException e) {
			e.printStackTrace();
			
		}
		return NONE;
	}
	public String save() throws IOException{
		Utils.print(classificationService.save(model));
		return NONE;
	}
	public String updata() throws IOException{
		Utils.print(classificationService.updata(model));
		return NONE;
	}
	public String delete() throws IOException{
		Utils.print(classificationService.delete(model));
		return NONE;
	}
	public String tree() throws IOException{
		Utils.printJson(classificationService.tree());
		return NONE;
	}
	public String combobox() throws IOException{
		Utils.printJson(classificationService.combobox());
		return NONE;
	}
}
