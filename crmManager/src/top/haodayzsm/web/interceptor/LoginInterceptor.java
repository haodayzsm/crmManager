package top.haodayzsm.web.interceptor;

import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.interceptor.MethodFilterInterceptor;
import top.haodayzsm.pojo.User;
import top.haodayzsm.utils.Utils;

public class LoginInterceptor extends MethodFilterInterceptor{

	@Override
	protected String doIntercept(ActionInvocation invocation) throws Exception {
		//��Session��ȡ�û�����
		User user = (User) Utils.getUser();
		if(user==null){
			System.out.println("���¼");
			//�û������������¼ҳ��
			return "login";
		}
		//�û����ڣ�����
		return invocation.invoke();
	}
}
