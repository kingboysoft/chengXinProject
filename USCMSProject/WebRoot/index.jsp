<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML>
<html>
<head>
<base href="<%=basePath%>">

<title>My JSP 'index.jsp' starting page</title>
<meta http-equiv="pragma" content="no-cache">
<meta http-equiv="cache-control" content="no-cache">
<meta http-equiv="expires" content="0">
<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
<meta http-equiv="description" content="This is my page">
<link rel="stylesheet" type="text/css"
	href="css/bootstrap/easyui.css">
<link rel="stylesheet" type="text/css" href="themes/icon.css">
<script type="text/javascript" src="js/jquery.min.js"></script>
<script type="text/javascript" src="js/jquery.easyui.min.js"></script>
<script type="text/javascript" src="locale/easyui-lang-zh_CN.js"></script>
<script type="text/javascript" src="js/public.js"></script>
<script type="text/javascript" src="js/inwindow.js"></script>
<script type="text/javascript" src="js/jquery.form.js"></script>
<script>
function find(conValue) {
		var con = new Object();
		con.condition = conValue; 
		findByPage("actor_find", "datagrid", con); 
	}
 $(function(){
    find("1=1");   

 });

</script>
</head>

<body>
	<table id="datagrid" title="教室信息管理操作平台" class="easyui-datagrid"
			style="width:100%;height:450px"
			data-options="rownumbers:true,singleSelect:false,pagination:true">
	  <thead>
	    <tr>
        <th data-options="field:'id',checkbox:true"></th>
		<th data-options="field:'name'" width="200" align="left">名称</th>
      </tr>
      </thead>
	</table>
</body>
</html>
