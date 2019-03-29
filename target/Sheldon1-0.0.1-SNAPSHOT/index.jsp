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
</head>
<body>
	<h2>Custom DataGrid Pager</h2>
	<p>You can append some buttons to the standard datagrid pager bar.</p>
	<div style="margin:20px 0;"></div>
	<input id="search" class="easyui-searchbox" data-options="prompt:'请输入要查询的人的姓名',searcher:doSearch" style="width:300px"></input>
	<table id="dg" title="Custom DataGrid Pager" style="width:480px;height:250px"
			data-options="rownumbers:true,singleSelect:true,pagination:true,method:'post'">
		<thead>
			<tr>
				<th data-options="field:'id',width:80,align:'center,display:'none'">ID</th>
				<th data-options="field:'name',width:80,align:'center'">姓名</th>
				<th data-options="field:'grade',width:80,align:'center'">年级</th>
				<th data-options="field:'num',width:80,align:'center'">学号</th>
				<th data-options="field:'createtime',width:240,align:'center'">时间</th>
			</tr>
		</thead>
	</table>
	<a href="userAction_findAll">test</a>
	 <script type="text/javascript">
		$(function(){
			var pager = $('#dg').datagrid({
				url:'userAction_findAll',
				toolbar:'#search'
			}).datagrid('getPager');	// get the pager of datagrid
			pager.pagination({
				buttons:[{
					iconCls:'icon-search',
					handler:function(){
						alert('search');
					}
				},{
					iconCls:'icon-add',
					handler:function(){
						alert('add');
					}
				},{
					iconCls:'icon-edit',
					handler:function(){
						alert('edit');
					}
				},{
					iconCls:'icon-chakan',
					handler:function(){
						var user = $.datagrid("getSelected");
						if(user == null){
							$.message.alert({
								title: '提示',
								msg: '请选中需要删除的行',
								icon:'info',
							});
						}else{
							$.message.confirm('删除确认','确认删除选中的信息？',function(r){
								if(r){
									$.post('userAction_delete',user,function(data){
										alert(data.flag);
									})
								}
							});
						}
					}
				}]
			});			
		}) 
	</script>
</body>
</html>