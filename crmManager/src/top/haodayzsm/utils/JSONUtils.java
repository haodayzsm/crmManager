package top.haodayzsm.utils;

import net.sf.json.JSONObject;
import net.sf.json.JsonConfig;

public class JSONUtils {
	public static String getJSON(){
		String json=null;
		return json;
	}
	//将对象转换为JSON
	public static String objToJson(Object object,String[] str){
		JsonConfig jsonConfig=new JsonConfig();
		jsonConfig.setExcludes(str);
		return JSONObject.fromObject(object, jsonConfig).toString();
	}
}
