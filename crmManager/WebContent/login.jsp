<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="/struts-tags" prefix="s" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="${pageContext.request.contextPath }/text/html; charset=UTF-8">
        <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath }/js/easyui/themes/default/easyui.css">
		<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath }/js/easyui/themes/icon.css">
		<script type="text/javascript" src="${pageContext.request.contextPath }/js/easyui/jquery-1.8.0.min.js"></script>
		<script type="text/javascript" src="${pageContext.request.contextPath }/js/easyui/jquery.easyui.min.js"></script>
        <script type="text/javascript"></script>
    	<style>
/*     		body{ 	background:#0462A5;color:#004C7E;}
    		* { margin:0 auto; padding:0; border:0;font-size:12px;} */
    		#main{
    			position:absolute;
				left:50%;
				top:50%;
				transform:translate(-50%,-50%);
    		}
    		.login{
    			/* column-cunt:2; */
    			position:absolute;
    			left:50%;
    			transform:translate(-50%,-50%);
    		}
    	</style>
    	<title>后台管理</title>
    </head>
    <body>
       	<form action="${pageContext.request.contextPath }/userAction_login" type="post">

			<div id="main" style="width: 400px;height: 240px; background-color: #088AA4;">		
				<table id="main" style="width: 350px;height: 160px;">
					<thead><tr>
						<th class="login">用户登录</br>
							<font  color="red" size="1">
								<s:actionerror/>
							</font>
						</th>
					</tr></thead>
					<tbody>
						<tr>
							<th>用户名：</th>
							<td><input type="test" name="username"/></td>
						</tr>
						<tr>
						<th>密码：</th>
						<td><input type="password" name="password"/></td>
					</tr>
					</tbody>
					<table id="main" style="width: 350;height: 30px;top:220px">
						<tr class="login">
						<td><a><button type="submit" style="height:30px;width:90px;">登录</button></a></td>
						<td><a href="#" ><button style="height:30px;width:90px;">注册</button></a></td>
					</tr>
					</table>
				</table>
			</div>
       	</form>

 	</body>
</html>
