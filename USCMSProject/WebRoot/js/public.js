var LOADSUCCESS="文件上传成功，但是进行角色批量保存失败，原因可能是您的Excel表格数据出现问题，请核实！";
var SAVESUCCESS="批量操作成功！";
var LOADFAIL="文件上传失败！";

$.fn.getFormObj = function(){ 
	var serializedParams = this.serialize();

	function paramString2obj(serializedParams) {
		var obj = {}; 
		function evalThem(str) {
			var attributeName = str.split("=")[0];
			var attributeValue = str.split("=")[1];

			if (!attributeValue) {
				attributeValue ="";

			}
			var array = attributeName.split(".");
			for (var i = 1; i < array.length; i++) {
				var tmpArray = Array();
				tmpArray.push("obj");
				for (var j = 0; j < i; j++) {
					tmpArray.push(array[j]);
				};
				var evalString = tmpArray.join(".");
				// alert(evalString); 
				if (!eval(evalString)) {
					eval(evalString + "={};");
				}
			}; 
			eval("obj." + attributeName + "='" + attributeValue + "';");
		}
		var properties = serializedParams.split("&");
		for (var i = 0; i < properties.length; i++) {
			evalThem(properties[i]);
		};
		return obj;
	}
	return paramString2obj(serializedParams); 
} 
/**********************************************
 * datagrid的Ajax的数据分页查找
 * page:页码，从1开始
 * rows:每页行数
 * datagridId:datagrid的ID
 * params:参数对象
 * type:操作类别
 *********************************************/
function findData(url,page, rows,datagridId,params) { 
	$('#'+datagridId).datagrid("loading"); 
	params.pageNumber=page;
	params.rowsCount=rows; 
	$.ajax({
		type : 'post',
		url : url, 
		dataType : 'json',
		data : params,
		success : function(obj) { 
			 
			$('#'+datagridId).datagrid("options").pageNumber=page;
			$('#'+datagridId).datagrid("options").pageSize=rows;
			$('#'+datagridId).datagrid('loadData', $.parseJSON(obj));
			
			$('#'+datagridId).datagrid("loaded");
			

		},
		error : function(arg0,arg1,arg2) {
			$('#'+datagridId).datagrid("loaded"); 
			switch(arg0.status)
			{
			  case 200:
				  alert("怀疑非法侵入或无操作权限，重新验证身份！");
				  top.location.href = "login.jsp"; 
				  break;
			  case 404:
				  alert("当前操作未授权！");
				  break;
			  case 500:
				  alert("程序内容处理错误：500");
				  break;
			  default:
				  alert("数据处理错误,错误代码："+arg0.status);
			      break; 
			} 
		}
	}); 
}
function findByPage(url,id,con)
{   
	setPager(url,id,con);
	findData(url, 1, 10, id, con);
}
/**********************************************
 * datagrid的Ajax无分页数据查找
 * datagridId:datagrid的ID
 * params:参数对象
 * type:数据类型
 *********************************************/
function findDataNoPage(url,datagridId,params) { 
	$('#'+datagridId).datagrid("loading");
	$.ajax({
		type : 'post',
		url : url,
		dataType : 'json',
		data : params,
		success : function(obj) { 
			$('#'+datagridId).datagrid('loadData', $.parseJSON(obj.data));
			$('#'+datagridId).datagrid("loaded");
		},
		error : function(arg0,arg1,arg2) {
			$('#'+datagridId).datagrid("loaded");
			switch(arg0.status)
			{
			  case 200:
				  alert("怀疑非法侵入或无操作权限，重新验证身份！");
				  top.location.href = "login.jsp"; 
				  break;
			  case 404:
				  alert("当前操作未授权！");
				  break;
			  case 500:
				  alert("程序内容处理错误：500");
				  break;
			  default:
				  alert("数据处理错误,错误代码："+arg0.status);
			      break; 
			} 
		}
	});
}

/**********************************************
 * datagrid的Ajax树形结构数据查找
 * datagridId:datagrid的ID
 * params:参数对象
 * type:数据处理类型
 *********************************************/
function findTreeGridData(url,datagridId,params) {

	$('#'+datagridId).treegrid("loading");
	$.ajax({
		type : 'post',
		url : url,
		dataType : 'json',
		data : params,
		success : function(obj) { 
			$('#'+datagridId).treegrid('loadData', $.parseJSON(obj.data));
			$('#'+datagridId).treegrid("loaded");
		},
		error : function(arg0,arg1,arg2) {
			$('#'+datagridId).datagrid("loaded");
			switch(arg0.status)
			{
			  case 200:
				  alert("怀疑非法侵入或无操作权限，重新验证身份！");
				  top.location.href = "login.jsp"; 
				  break;
			  case 404:
				  alert("当前操作未授权！");
				  break;
			  case 500:
				  alert("程序内容处理错误：500");
				  break;
			  default:
				  alert("数据处理错误,错误代码："+arg0.status);
			      break; 
			} 
		}
	});
}

function findTreeData(url,datagridId,params) { 
	$.ajax({
		type : 'post',
		url : url,
		dataType : 'json',
		data : params,
		success : function(obj) { 
			$('#'+datagridId).tree('loadData', $.parseJSON(obj.data));
		},
		error : function(arg0,arg1,arg2) {
			$('#'+datagridId).datagrid("loaded");
			switch(arg0.status)
			{
			  case 200:
				  alert("怀疑非法侵入或无操作权限，重新验证身份！1111");
				  top.location.href= "login.jsp";
				  break;
			  case 404:
				  alert("当前操作未授权！");
				  break;
			  case 500:
				  alert("程序内容处理错误：500");
				  break;
			  default:
				  alert("数据处理错误,错误代码："+arg0.status);
			      break; 
			} 
		}
	});
}
/**********************************************
 * ajax数据处理  
 * params:参数对象
 * type:数据处理类别
 * callback:回调函数
 *********************************************/
function doData(url,params,callback) {

	$.ajax({
		type : 'post',
		url : url,
		dataType : 'json',
		data : params, 
		success : function(data) { 
			callback(data);
		},
		error : function(arg0,arg1,arg2) {  
			switch(arg0.status)
			{
			  case 200:
				  alert("怀疑非法侵入或无操作权限，重新验证身份！");
				  top.location.href= "login.jsp"; 
				  break;
			  case 404:
				  alert("当前操作未授权！");
				  break;
			  case 500:
				  alert("程序内容处理错误：500");
				  break;
			  default:
				  alert("数据处理错误,错误代码："+arg0.status);
			      break; 
			} 
		}
	});
} 

/*导出Excel*/
function loadoutExcel(formId,params,url) { 
	$('#'+formId).attr("action", url+"?" + $.param(params));
	$('#'+formId).submit(); 
} 

function setPager(url,id,con)
{
	var pager = $('#'+id).datagrid().datagrid('getPager'); // get the pager of datagrid
	
	pager.pagination({
		pageSize : 10,//每页显示的记录条数，默认为10 
		pageList : [ 10, 20, 30,40,50 ],//可以设置每页记录条数的列表 
		onSelectPage : function(pageNumber, pageSize) {

			findData(url,pageNumber, pageSize,id,con);
		},
		onBeforeRefresh : function(pageNumber, pageSize) {
			findData(url,pageNumber, pageSize,id,con);
		}
	});
 }


function openModalWin(url,width,height)
{
	var value=window.showModalDialog(url, "", "dialogWidth=" + width + "px;dialogHeight=" + height + "px");
	return value;
}
function openWin(url,width,height)
{ 
	var win=window.open(url,null,"height="+height+",width="+width+",status=no,toolbar=no,resizable=no,left=400,top=300");
	return win;
}

function openWinNoUrl(url) {
	window.open(url, null, "location=no,status=no,toolbar=no");

}
/*
关闭当前页面
 */
function closeWin()
{
	var result=confirm("您确定退出系统吗？");
	if (result==true)
	{
		window.opener=null;
		window.parent.close();
	}
}

/*
获取地址栏中参数的值
 */
function getURLParamValue(pName)
{
	var url=window.location.search;
	if(url.indexOf("?")!=-1)   
	{   
		var start=url.indexOf("?");
		var str=url.substr(start+1);   
		var strs = str.split("&");   
		for(var i=0;i<strs.length;i++)   
		{   
			if([strs[i].split("=")[0]]==pName) 
				return unescape(strs[i].split("=")[1]);
		}   
	}
	else
		return ""; 
}

/*********************人民币数字转大写开始******************/
function convertCurrency(currencyDigits) {
	// Constants:
	var MAXIMUM_NUMBER = 99999999999.99;
	// Predefine the radix characters and currency symbols for output:
	var CN_ZERO = "零";
	var CN_ONE = "壹";
	var CN_TWO = "贰";
	var CN_THREE = "叁";
	var CN_FOUR = "肆";
	var CN_FIVE = "伍";
	var CN_SIX = "陆";
	var CN_SEVEN = "柒";
	var CN_EIGHT = "捌";
	var CN_NINE = "玖";
	var CN_TEN = "拾";
	var CN_HUNDRED = "佰";
	var CN_THOUSAND = "仟";
	var CN_TEN_THOUSAND = "万";
	var CN_HUNDRED_MILLION = "亿";
	var CN_SYMBOL = "人民币";
	var CN_DOLLAR = "元";
	var CN_TEN_CENT = "角";
	var CN_CENT = "分";
	var CN_INTEGER = "整";
	// Variables:
	var integral; // Represent integral part of digit number.
	var decimal; // Represent decimal part of digit number.
	var outputCharacters; // The output result.
	var parts;
	var digits, radices, bigRadices, decimals;
	var zeroCount;
	var i, p, d;
	var quotient, modulus;
	// Validate input string:
	currencyDigits = currencyDigits.toString();
	if (currencyDigits == "") {
		alert("没有数据!");
		return "";
	}

	var moneySingal = ""; //货币符号

	if (Number(currencyDigits) < 0) {
		currencyDigits = currencyDigits.substring(1);
		moneySingal = "负";
	}
	if (currencyDigits.match(/[^,.\d]/) != null) {
		alert("提供的数据无效!");
		return "";
	}
	if ((currencyDigits).match(/^((\d{1,3}(,\d{3})*(.((\d{3},)*\d{1,3}))?)|(\d+(.\d+)?))$/) == null) {
		alert("数据格式不合法!");
		return "";
	}
	// Normalize the format of input digits:
	currencyDigits = currencyDigits.replace(/,/g, ""); // Remove comma delimiters.
	currencyDigits = currencyDigits.replace(/^0+/, ""); // Trim zeros at the beginning.
	// Assert the number is not greater than the maximum number.
	if (Number(currencyDigits) > MAXIMUM_NUMBER) {
		alert("太大数据无法转换!");
		return "";
	}
	// Process the coversion from currency digits to characters:
	// Separate integral and decimal parts before processing coversion:
	parts = currencyDigits.split(".");
	if (parts.length > 1) {
		integral = parts[0];
		decimal = parts[1];
		// Cut down redundant decimal digits that are after the second.
		decimal = decimal.substr(0, 2);
	}
	else {
		integral = parts[0];
		decimal = "";
	}
	// Prepare the characters corresponding to the digits:
	digits = new Array(CN_ZERO, CN_ONE, CN_TWO, CN_THREE, CN_FOUR, CN_FIVE, CN_SIX, CN_SEVEN, CN_EIGHT, CN_NINE);
	radices = new Array("", CN_TEN, CN_HUNDRED, CN_THOUSAND);
	bigRadices = new Array("", CN_TEN_THOUSAND, CN_HUNDRED_MILLION);
	decimals = new Array(CN_TEN_CENT, CN_CENT);
	// Start processing:
	outputCharacters = "";
	// Process integral part if it is larger than 0:
	if (Number(integral) > 0) {
		zeroCount = 0;
		for (i = 0; i < integral.length; i++) {
			p = integral.length - i - 1;
			d = integral.substr(i, 1);
			quotient = p / 4;
			modulus = p % 4;
			if (d == "0") {
				zeroCount++;
			}
			else {
				if (zeroCount > 0) {
					outputCharacters += digits[0];
				}
				zeroCount = 0;
				outputCharacters += digits[Number(d)] + radices[modulus];
			}
			if (modulus == 0 && zeroCount < 4) {
				outputCharacters += bigRadices[quotient];
			}
		}
		outputCharacters += CN_DOLLAR;
	}
	// Process decimal part if there is:
	if (decimal != "") {
		for (i = 0; i < decimal.length; i++) {
			d = decimal.substr(i, 1);
			if (d != "0") {
				outputCharacters += digits[Number(d)] + decimals[i];
			}
		}
	}
	// Confirm and return the final output string:
	if (outputCharacters == "") {
		outputCharacters = CN_ZERO + CN_DOLLAR;
	}
	if (decimal == "") {
		outputCharacters += CN_INTEGER;
	}
	outputCharacters = outputCharacters;
	return moneySingal+outputCharacters;
}
/*********************人民币转大写结束***********************/

/***********************判读字符串是否日期开始*********************************/
function IsDate(str) {
	try {
		if (str.indexOf('/') >= 0) {
			str = str.split(' ')[0];
			var strDate = str.split('/');
			if (strDate[2].length != 4 || strDate[0] * 1 > 12 || strDate[0] * 1 <= 0 || strDate[1] * 1 > 31 || strDate[1] * 1 <= 0) return false;
			var d = new Date(strDate[2], strDate[0] * 1 - 1, strDate[1]);

			return true;
		}
		if (str.indexOf('-') >= 0) {
			str = str.split(' ')[0];
			var strDate = str.split('-');
			if (strDate[0].length != 4 || strDate[1] * 1 > 12 || strDate[1] * 1 <= 0 || strDate[2] * 1 > 31 || strDate[2] * 1 <= 0) return false;

			var d = new Date(strDate[0], strDate[1] * 1 - 1, strDate[2]);
			return true;
		}
		return false;
	} catch (exception) {
		return false;
	}
}
/***********************判读字符串是否日期结束*********************************/

 