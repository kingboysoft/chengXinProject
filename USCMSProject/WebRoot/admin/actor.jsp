<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML>
<html>
<head>
<base href="<%=basePath%>">

<title>角色信息管理</title>

<meta http-equiv="pragma" content="no-cache">
<meta http-equiv="cache-control" content="no-cache">
<meta http-equiv="expires" content="0">
<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
<meta http-equiv="description" content="This is my page">
<link rel="stylesheet" type="text/css" href="css/css.css">
<link rel="stylesheet" type="text/css" href="css/default/easyui.css">
<link rel="stylesheet" type="text/css" href="css/icon.css">
<script type="text/javascript" src="js/jquery.min.js"></script>
<script type="text/javascript" src="js/jquery.easyui.min.js"></script>
<script type="text/javascript" src="js/locale/easyui-lang-zh_CN.js"></script>
<script type="text/javascript" src="js/public.js"></script>
<script type="text/javascript" src="js/inwindow.js"></script>
<script type="text/javascript" src="js/jquery.form.js"></script>
<script>
function find(conValue) { 
		var con = new Object();
		con.condition = conValue; 
		findByPage("actor_find","datagrid",con);
		 
	}
	function format(value, rowData, rowIndex) {
		return "<a class='edit_button' valueId='"
				+ rowData.id
				+ "' valueName='"
				+ rowData.name
				+ "' href='javascript:void(0);'>修改</a>&nbsp;<a class='del_button' valueId='"
				+ rowData.id + "' href='javascript:void(0);'>删除</a>";
	}
	function doSearch(value)
	{
	  find(value);
	}
 $(function(){  
    $("#datagrid").datagrid(
				{
					onLoadSuccess : function() {
						$(".edit_button").linkbutton(
								{
									plain : true,
									iconCls : 'icon-edit',
									onClick : function() {
									alert($(this).attr("valueId")+"->"+$(this).attr("valueName"));
										 
									}
								});
						$(".del_button").linkbutton({
							text : '删除',
							plain : true,
							iconCls : 'icon-remove',
							onClick : function() {
							    alert($(this).attr("valueId"));
							   
							}
						});
					}
				});
    $("#btnAdd").click(function(){
       doData("actor_comb", "", function(data) {
				$("#cmbActor").combobox({
					valueField : 'id',
					textField : 'name'
				});
				var d = $.parseJSON(data);
				$('#cmbActor').combobox('loadData', d);
			});
       $("#frmAdd").window("open");
    });  

 });

</script>

</head>

<body>
	<table id="datagrid" title="角色信息管理操作平台" class="easyui-datagrid"
		style="width:100%;height:450px"
		data-options="rownumbers:true,singleSelect:false,striped:true,pagination:true,toolbar:'#tb'">
		<thead>
			<tr>
				<th data-options="field:'id',checkbox:true"></th>
				<th data-options="field:'code'" width="80" align="center">代号</th>
				<th data-options="field:'name'" width="150" align="center">名称</th>
				<th data-options="field:'description'" width="250" align="center">描述</th>
				<th data-options="field:'parent'" width="150" align="center">上级角色</th>
				<th data-options="field:'status'" width="60" align="center">状态</th>
				<th data-options="field:'ids',formatter:format" width="120"
					align="center">操作</th>
			</tr>
		</thead>
	</table>

	<div id="tb" style="padding:2px 5px;">
		<form method="post" id="frmloadout">
			<a href="javascript:void(0)" class="easyui-linkbutton easyui-tooltip"
				id="btnAdd" iconCls="icon-add" data-options="plain:true"
				title="点击弹出新增教室信息操作界面">新增</a> <input class="easyui-searchbox"
				data-options="prompt:'请输入角色代号或名称',searcher:doSearch"
				style="width:300px"></input> <a href="javascript:void(0)"
				id="btnDels" class="easyui-linkbutton easyui-tooltip"
				iconCls="icon-remove" data-options="plain:true"
				title="勾选需要删除的功能，点击删除【批量删除】按钮！">批量删除</a> <a
				href="javascript:void(0)" id="btnUpload" class="easyui-linkbutton"
				iconCls="icon-up" data-options="plain:true">批量导入</a> <a
				href="javascript:void(0)" id="btnPrint" class="easyui-linkbutton"
				iconCls="icon-print" data-options="plain:true">打印</a> <a
				href="javascript:void(0)" id="btnLoadout" class="easyui-linkbutton"
				iconCls="icon-download" data-options="plain:true">导出</a>
		</form>
	</div>
	<!--new actor -->
	<div id="frmAdd" class="easyui-window" title="新增角色"
		data-options="modal:true,closed:true,iconCls:'icon-save',maximizable:false,minimizable:false,collapsible:false,footer:'#footer'"
		style="width:500px;height:370px;padding:10px 60px 20px 60px;">
		<form id="ff" class="easyui-form" method="post"
			data-options="novalidate:true">
			<input type="hidden" name="id" />
			<table cellpadding="5">
				<tr>
					<td>编号:</td>
					<td><input class="easyui-textbox" type="text" name="code"
						data-options="required:true"></input></td>
				</tr>
				<tr>
					<td>名称:</td>
					<td><input class="easyui-textbox" type="text" name="name"
						data-options="required:true"></input></td>
				</tr>
				<tr>
					<td>审批权:</td>
					<td><input type="radio" name="isApprovable" value="false"
						checked="checked" />无 &nbsp;&nbsp; <input type="radio"
						name="isApprovable" value="true" />有</td>
				</tr>
				<tr>
					<td>审批金额:</td>
					<td><input type="text" class="easyui-numberbox"
						data-options="precision:2" name="money" value="0" /></td>
				</tr>
				<tr>
					<td>角色描述:</td>
					<td><input class="easyui-textbox" name="description"
						data-options="multiline:true" style="height:60px;width:200px;"></input>
					</td>
				</tr>
				<tr>
					<td>上级角色:</td>
					<td><select id="cmbActor" style="width:200px;" name="parentID"></select>
					</td>
				</tr>
				<tr>
					<td>状态:</td>
					<td><input type="radio" name="state" value="正常"
						checked="checked" />正常 &nbsp;&nbsp; <input type="radio"
						name="state" value="关闭" />关闭</td>
				</tr>
			</table>
		</form>
	</div>
	<div id="footer" style="padding:5px;text-align:center;">
		<a href="javascript:void(0)" class="easyui-linkbutton" id="btnSave">保存</a>
		<a href="javascript:void(0)" class="easyui-linkbutton"
			onClick="clearForm()">清空</a>
	</div>


</body>
</html>
