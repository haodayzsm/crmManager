<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<script type="text/javascript" src="js/jquery-1.8.3.js"></script>
	<script type="text/javascript" src="js/easyui/jquery-1.8.0.min.js"></script>
	<script type="text/javascript" src="js/easyui/jquery.easyui.min.js"></script>
	<script type="text/javascript" src="js/utils/pojoUtils.js"></script>
	<script type="text/javascript" src="js/easyui/locale/easyui-lang-zh_CN.js"></script>
	<link rel="stylesheet" type="text/css" href="js/easyui/themes/default/easyui.css" rel="stylesheet"> 	
	<link rel="stylesheet" type="text/css" href="js/easyui/themes/icon.css" rel="stylesheet">
	<meta charset="UTF-8" content="zh-cn">
	
 	<title>home</title>
</head>
<body>
	<div class="easyui-layout"  fit="true">
		<div region="north" style="height: 120px;"> 
			<table height="95%" width="100%">
				<tr height="80%">
					<th width="85%">
						<p style="position: absolute; left:50px;top:0px;">
							<font size="50" face="Verdana">
								欢迎使用后台管理系统
							</font>
						</p>
					</th>
					<th widths="15%"></th>
				</tr>
				<tr height="20%">
					<td></td>
					<td>
						<a>欢迎:--${user.name}--</a><a href="#" onclick="logout()">注销</a>
					</td>
				</tr>
			</table>
		</div>
		
		
		<div region="west" style="width:230px">
			<div class="easyui-accordion" style="overflow:auto;" fit="true">
				<div class="t" style=" padding: 10px;" title="库存管理">
					<ul id="kc" class="easyui-tree my-ul"></ul>
				</div>
				<div class="t" style="padding: 10px;" title="销售管理">
					<ul id="xs" class="easyui-tree my-ul"></ul>
				</div>
				<div class="t" style="padding: 10px;" title="基础资料">
					<ul id="jczl" class="easyui-tree my-ul"></ul>
				</div>
				<div class="t" style="padding: 10px;" title="设置">
					<ul id="sz" class="easyui-tree my-ul"></ul>
				</div>
			</div>

		</div>
		
		
		<div id="context" region="center" >
			<div  id="mytabs" class="easyui-tabs" fit="true"  ></div>
		</div>
	</div>


	<div id="dialog1"></div>
	<script type="text/javascript">
		$(function(){
			/* $('#kc').tree('append',{
				data:[
					{"text":"测试1","attributes":"WEB-INF/page/instock/add.html"},
					{"text":"测试2","attributes":"WEB-INF/page/classification/list.html"},
					{"text":"测试3","attributes":"WEB-INF/page/customer/list.html"},
					{"text":"测试4","attributes":"WEB-INF/page/instock/add.html"},
					{"text":"服务器测试1","attributes":"page_instock_add"},
					{"text":"服务器测试2","attributes":"page_classification_list"},
					{"text":"服务器测试4","attributes":"page_instock_add"},
				]
			}); */
			//通过ajax加载Tree的json数据
			$.ajax({
				type:"post",
				url:"json_menuAction_tree",
				async:true,
				success:function(data){
					var num=0;
					while(data[num]!=null){
						var var1=data[num];
						switch(var1["name"]){
						case "库存管理":
							$('#kc').tree('append',{
								data:[var1]
							});
							break;
						case "销售管理":
							$('#xs').tree('append',{
								data:[var1]
							});
							break;
						case "基础资料":
							$('#jczl').tree('append',{
								data:[var1]
							});
							break;
						case "设置":
							$('#sz').tree('append',{
								data:[var1]
							});
							break;
						}
						num++; 
					}
				}
			});
			
			
			//点击事件
			var urls;
			$('.my-ul').tree({
				onClick: function(node){
					var mytitle=node.text;
					var a=$('#mytabs').tabs('exists',mytitle);
					urls=node.attributes;
					if(!a){
						$('#mytabs').tabs('add',{
							title:mytitle,
							fit:true,
							closable:true,
							href:urls
						});
					}else{
						$('#mytabs').tabs('select',mytitle);
					}
				}
			});
		}); 
		
		//重新加载选项卡
		function updataTree(tabName){
			tab=$('#mytabs').tabs('getTab',tabName)
			tab.panel('refresh');
		}

		function logout(){
			$.ajax({
				type:'get',
				url:'userAction_logout',
				success:function(){
					location.href='login.jsp';
				}
			})
			
		}
	</script>
</body>
	
	
</html>