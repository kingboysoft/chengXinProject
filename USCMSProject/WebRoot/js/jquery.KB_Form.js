
function convertToDate(data) {//将json的日期格式转换成dd/MM/yyyy的格式
    var da = eval('new ' + data.replace('/', '', 'g').replace('/', '', 'g'));
    return da.getFullYear() + "-" + (da.getMonth() + 1) + "-" + da.getDate();
    //return da.getFullYear() + "-" + da.getMonth() + "-" + da.getDate() + " " + da.getHours() + ":" + da.getSeconds() + ":" + da.getMinutes();
}
/** @serializedParams looks like "prop1=value1&prop2=value2". 
Nested property like 'prop.subprop=value' is also supported **/


$.fn.KB_GetFormJson = function() {
    function paramString2obj(serializedParams) {
        var obj = {};
        function evalThem(str) {
            var attributeName = str.split("=")[0];
            var attributeValue = str.split("=")[1];
            if (!attributeValue) {
                return;
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
        };
        var properties = serializedParams.split("&");
        for (var i = 0; i < properties.length; i++) {
            evalThem(properties[i]);
        };
        return obj;
    }
    var serializedParams = this.serialize();
    var obj = paramString2obj(serializedParams);
    return decodeURIComponent(JSON.stringify(obj));
}
/**
* 重置表单
*/
$.fn.KB_SetFormJson = function (o) {
     
    if (o == null) {
        var form = document.forms[$(this).attr('name')];
        if (form !== undefined) {
            form.reset();
            return true;
        } else {
            alert("重置表单名为" + $(this).attr('name') + "失败.");
            return false;
        }
    }
    function setValue(contls, s, name) {                          //闭包setValue
        var re = /\/Date\((-|\d){10,}\)\//
        if (re.test(s)) {
            var strTime = convertToDate(re.exec(s).input);
            $("input[comboname='" + name + "']+span input ").val(strTime);
        }
        else contls.val(s);
    }
    var $this = this;
    var serializ = this.serializeArray();
    $.each(serializ, function (i, n) {
        var $t = $('(input|textarea|select)[name=\'' + this.name + '\']', $this);
        if ($.trim($.trim($t.attr("type"))) == 'radio') {
            $.each($t, function (i, n) {
                var str1 = $.trim($(this).val());
                var str2 = $.trim(eval("[o." + this.name + "]").toString());
                var bol = str2 > 0 ? true : false;
                if (str1 == str2 || $.trim(str1) == $.trim(bol)) $(this).attr("checked", true);
                else $(this).attr("checked", false);
            });
        } else if ($.trim($t.attr("type")) == "hidden") {
            $("select[comboname='" + this.name + "']").combobox('setValue', eval("[o." + this.name + "]").toString()); //ID
            setValue($t, eval("[o." + this.name + "]").toString(), this.name);
        } else if (eval("[o." + this.name + "]")) {
            $t.val(eval("[o." + this.name + "]").toString());
        }
    });
};