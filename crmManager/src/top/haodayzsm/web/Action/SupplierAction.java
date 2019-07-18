package top.haodayzsm.web.Action;

import java.io.IOException;
import javax.annotation.Resource;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import top.haodayzsm.pojo.Supplier;
import top.haodayzsm.service.ISupplierService;
import top.haodayzsm.web.impl.BaseAction;
@Controller(value="supplierAction")
@Scope(value="prototype")
public class SupplierAction extends BaseAction<Supplier> {
	@Resource(name="supplierService")
	ISupplierService supplierService;
	Long id;
	public String list() throws IOException{
		String json=supplierService.findByAll();
		this.printJson(json);
		return NONE;
	}
	public String save() throws IOException{
		this.print(supplierService.save(model));
		return NONE;
	}
	public String updata() throws IOException{
		this.print(supplierService.updata(model));
		return NONE;
	}
	public String activationAll() throws IOException{
		this.printJson(supplierService.findByActivation());
		return NONE;
	}
	public String inActivatedAll() throws IOException{
		this.printJson(supplierService.findByInactivated());
		return NONE;
	}
	public String inActivated() throws IOException{
		this.print(supplierService.inactivated(model));
		return NONE;
	}
	public String delete() throws IOException{
		this.print(supplierService.delete(id));
		return NONE;
	}
	public String activation() throws IOException{
		this.print(supplierService.activation(model));
		return NONE;
	}
	public String tree() throws IOException{
		this.printJson(supplierService.tree());
		return NONE;
	}
	public String combobox() throws IOException{
		this.printJson(supplierService.combobox());
		return NONE;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
}
