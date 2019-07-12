package top.haodayzsm.web.Action;

import java.io.IOException;

import javax.annotation.Resource;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import top.haodayzsm.pojo.Supplier;
import top.haodayzsm.service.ISupplierService;
import top.haodayzsm.utils.Utils;
import top.haodayzsm.web.impl.BaseAction;
@Controller(value="supplierAction")
@Scope(value="prototype")
public class SupplierAction extends BaseAction<Supplier> {
	@Resource(name="supplierService")
	ISupplierService supplierService;
	public String list() throws IOException{
		String json=supplierService.findByAll();
		Utils.printJson(json);
		return NONE;
	}
	public String save() throws IOException{
		Utils.print(supplierService.save(model));
		return NONE;
	}
	public String updata() throws IOException{
		Utils.print(supplierService.updata(model));
		return NONE;
	}
	public String delete() throws IOException{
		Utils.print(supplierService.delete(model));
		return NONE;
	}
	public String tree() throws IOException{
		Utils.printJson(supplierService.tree());
		return NONE;
	}
	public String combobox() throws IOException{
		Utils.printJson(supplierService.combobox());
		return NONE;
	}
}
