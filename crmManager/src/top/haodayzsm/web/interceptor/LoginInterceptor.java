package top.haodayzsm.web.interceptor;

import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.interceptor.MethodFilterInterceptor;
import top.haodayzsm.pojo.User;
import top.haodayzsm.utils.Utils;

public class LoginInterceptor extends MethodFilterInterceptor{

	@Override
	protected String doIntercept(ActionInvocation invocation) throws Exception {
		//从Session获取用户对象
		User user = (User) Utils.getUser();
		if(user==null){
			System.out.println("请登录");
			//用户不存在跳会登录页面
			return "login";
		}
		//用户存在，放行
		return invocation.invoke();
	}
}
