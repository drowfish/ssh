<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
	<meta charset="UTF-8">
	<title>Custom DataGrid Pager - jQuery EasyUI Demo</title>
	<link rel="stylesheet" type="text/css" href="themes/default/easyui.css">
	<link rel="stylesheet" type="text/css" href="themes/icon.css">
	<link rel="stylesheet" type="text/css" href="demo/demo.css">
	<script type="text/javascript" src="js/jquery.min.js"></script>
	<script type="text/javascript" src="js/jquery.easyui.min.js"></script>
	<script type="text/javascript" src="js/test.js"  charset="utf-8"></script>
</head>
<body>
<center>
	<h2>数据表格</h2>
	<div style="margin:20px 0;"></div>
	<div id="tb">
		<input class="easyui-searchbox" data-options="prompt:'请输入姓名',searcher:doSearch" style="width:300px"></input>
	</div>
	<div id="dlg" class="easyui-dialog" title="用户信息" data-options="iconCls:'icon-save',closed:'true'" style="padding:10px">
		<div style="padding:10px 60px 20px 60px">
		    <form id="ff" method="post">
		    	<table cellpadding="5">
		    		<tr style="display:none">
		    			<td><input class="easyui-textbox" type="text" name="id" ></input></td>
		    		</tr>
		    		<tr style="display:none">
		    			<td><input class="easyui-textbox" type="text" name="createtime" ></input></td>
		    		</tr>
		    		<tr>
		    			<td>姓名:</td>
		    			<td><input class="easyui-textbox" type="text" name="name" data-options="required:true"></input></td>
		    		</tr>
		    		<tr>
		    			<td>年级:</td>
		    			<td><input class="easyui-textbox" type="text" name="grade" data-options="required:true"></input></td>
		    		</tr>
		    		<tr>
		    			<td>学号:</td>
		    			<td><input class="easyui-textbox" type="text" name="num" data-options="required:true"></input></td>
		    		</tr>
		    	</table>
		    </form>
		    <div style="text-align:center;padding:5px">
		    	<a class="easyui-linkbutton" onclick="submitForm()">提交</a>
		    	<a class="easyui-linkbutton" onclick="clearForm()">重置</a>
		    </div>
	    </div>
	</div>
	<table id="dg" title="Custom DataGrid Pager" style="width:600px;height:450px"
			data-options="rownumbers:true,singleSelect:true,pagination:true,method:'post'">
		<thead>
			<tr>
				<th data-options="field:'id',width:80,align:'center',hidden:'true'">ID</th>
				<th data-options="field:'name',width:80,align:'center'">姓名</th>
				<th data-options="field:'grade',width:80,align:'center'">年级</th>
				<th data-options="field:'num',width:80,align:'center'">学号</th>
				<th data-options="field:'createtime',width:240,align:'center'">时间</th>
			</tr>
		</thead>
	</table>
<!-- 	<a href="userAction_findAll?page=1&rows=10&name=nn">test</a>
	 <script type="text/javascript">
	</script> -->
	</center>
</body>
</html>