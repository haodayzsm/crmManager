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
import top.haodayzsm.web.impl.BaseAction;

@Controller(value="classificationAction")
@Scope(value="prototype")
public class ClassificationAction extends BaseAction<Classification> {
	@Resource(name="classificationService")
	IClassificationService classificationService;
	Long id;
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
			this.printJson(json);
		} catch (IOException e) {
			e.printStackTrace();
		}
		return NONE;
	}
	public String save() throws IOException{
		this.print(classificationService.save(model));
		return NONE;
	}
	public String updata() throws IOException{
		this.print(classificationService.updata(model));
		return NONE;
	}
	public String delete() throws IOException{
		System.out.println(model.getClassification_id());
		this.print(classificationService.delete(id));
		return NONE;
	}
	public String tree() throws IOException{
		this.printJson(classificationService.tree());
		return NONE;
	}
	public String combobox() throws IOException{
		this.printJson(classificationService.combobox());
		return NONE;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
}
