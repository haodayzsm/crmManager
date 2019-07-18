/*
 * Pojo工具类，统一对POJO进行增删改
 */

function deletePojo(id,url,element){
	var data={"id":id};
	if(id==null){
		$.messager.alert('警告','请选择要删除单位','info');
		return;
	}
	$.ajax({
		type:"post",
		url:url,
		data:data,
		async : false,
		success:function(data){
			if(data=='true'){
				$.messager.alert('信息提示','删除成功！','info');
			}else{
				$.messager.alert('信息提示','删除失败！','info');
			}
			reloadDatagrid(element);
		}
	});
}
function addPojo(data,url){
	
}
function updataPojo(data,url,element){
	
}
function reloadDatagrid(element){
	element.datagrid('reload');
}
