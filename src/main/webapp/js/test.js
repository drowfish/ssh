var url;
		$(function(){
			show('userAction_findAll');
		}) ;
		function submitForm(){
				$('#ff').form('submit', {
	    			url:url,
				   	success:function(data){
				   	console.log()
						if(data){
							alert("成功");
							$('#dg').datagrid('reload');
							$('#dlg').dialog('close');
							clearForm();
						}else{
							alert("失败");
						}
	    			}
				});
			}
			function clearForm(){
				$('#ff').form('clear');
			}
			function doSearch(value){
				if(value == ""){
					show('userAction_findAll');
				}else{
					show('userAction_findAll?name='+value);
				}
			}
			function show(src){
				var pager = $('#dg').datagrid({
					url:src,
				}).datagrid('getPager');	// get the pager of datagrid
				pager.pagination({
					buttons:[{
						iconCls:'icon-add',
						handler:function(){
							clearForm();
							$('#dlg').dialog('open');
							url="userAction_add";
						}
					},{
						iconCls:'icon-edit',
						handler:function(){
							var user = $('#dg').datagrid("getSelected");
							if(user == null){
								$.messager.alert('修改提示ʾ','请选中需要修改的行','error');
							}else{
								$('#dlg').dialog('open');
								$('#ff').form('load',user);
								url="userAction_update";
							}
						}
					},{
						iconCls:'icon-clear',
						handler:function(){
							 var user = $('#dg').datagrid("getSelected");
							if(user == null){
								$.messager.alert('删除提示','请选中需要删除的行','error');
							}else{
								$.messager.confirm('删除确认','确认删除此行数据？',function(r){
									if(r){
										$.post('userAction_delete',{id:user.id},function(data){
											if(data){
												alert("删除成功");
												$('#dg').datagrid('reload');
											}else{
												alert("删除失败");
											}
										})
									}
								});
							} 
						}
					}]
				});
			}