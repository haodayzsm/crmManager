function removeClass(id){
	$.ajax({
		type:"post",
		//url:'json_productAction_delete',
		url:'json_productAction_tree',
		data:id,
		//async:true,
		success:function(data){
			if(data=='true'){
				$.messager.alert('信息提示','删除成功！','info');
			}else if(data==""){
				
			}
			product_reload();
		}
	});
}
