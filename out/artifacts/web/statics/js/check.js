function Trim(str)
{
    return str.replace(/(^\s*)|(\s*$)/g, "");
}
//获取表单中所有data-id属性
function check_Form(formId){
    var checkflag=false;
    $(formId).find("input,textarea").each(function(){
        var id=this.id;
        if(id!=null&&id!=""){
            var dataid=$("#"+id).attr("data-id");
            if(dataid!=null){
                checkflag=checkProperty(dataid,id);
                if(checkflag==false){
                    return false;
                }
            }else{
                checkflag=true;
                return true;
            }
        }
        //非空验证
    })
    return checkflag;
}

//验证
function checkProperty(articleId,id){
    var reg;
    message="";
    var value=Trim($("#"+id).val());
    if(articleId=='phone'){
        reg=/^[1][3,4,5,7,8][0-9]{9}$/;
        message="输入有误，请重新输入";
    }
    if(articleId=='idcode'){
        reg = /(^\d{15}$)|(^\d{18}$)|(^\d{17}(\d|X|x)$)/;
        message="输入有误，请重新输入";
    }
    if(articleId=='money'){
        reg = /^[0-9]*(\.[0-9]{1,2})?$/;
        message="输入有误（最多两位小数），请重新输入";
    }
    /**          验证*/
    if(articleId==""||articleId==null){
        var name=$("#"+id).parent().siblings().text();
        if(value==""){
            message=name+"不能为空";
            checkMessage(message);
            return false;
        }else{
            if(!reg.test(value)){
                $("#"+id).val("");
                checkMessage(name+message);
                return false;
            }else{
                return true;
            }
        }
    }
    if(articleId=='notnull'){
        if(value==""){
            var name=$("#"+id).parent().siblings().text();
            message=name+"不能为空";
            checkMessage(message);
            return false;
        }else{
            return true;
        }
    }else{
        var name=$("#"+id).parent().siblings().text();
        if(value==""){
            message=name+"不能为空";
            checkMessage(message);
            return false;
        }else{
            if(!reg.test(value)){
                $("#"+id).val("");
                checkMessage(name+message);
                return false;
            }else{
                return true;
            }
        }

    }

}

function checkMessage(message){
    var width = document.documentElement.clientWidth || document.body.clientWidth;
    var Fontsize = 18;
    if(width<415){
        width=width/2;
        var widths = width*2;
        var left=(widths-widths/2)/2;
        Fontsize = 14;
    }else if(width<980){
        width=width/3;
        var widths = width*3;
        var left=(widths-widths/3)/2;
        Fontsize = 18;
    }else{
        width=width/4;
        var widths = width*4;
        var left=(widths-widths/4)/2;
        Fontsize = 18;
    }

    $(".overlay").remove();
    $(".checkmessage").remove();
    //遮罩层样式
    var overlayStyle="position: fixed;top: 0px;left: 0px;right: 0px;bottom: 0px;text-align: center; z-index: 8888;" +
        "width:100%;height:100%;filter:alpha(opacity=60);background-color: #ABABAB;opacity:0.7;"
    var overlay='<div class="overlay"  style="'+overlayStyle+'" oncilck="closeOverlay()"></div>';
    //消息提示框样式
    var messageStyle="filter:alpha(opacity=1);opacity:1;border:1px solid red;width:"+width+"px; position: fixed;top: "+width+"px;left: "+left+"px; padding-bottom: 8px; background-color: #F8F8FF;margin:0 auto;z-index:10000;border-radius:4px;"
    var messageDiv='<div class="checkmessage" style="'+messageStyle+'">' +
        '<div style="height:40px;line-height: 40px; background-color: #FF4040;">' +
        '<span style="color:#FFFFFF;font-size: '+Fontsize+'px;margin-top: 5px;margin-left:10px; ">消息提醒</span>'+
        '</div>' +
        '<div style="padding: 40px 18px; text-align: center;">' +
        '<p style="font-size: '+Fontsize+'px;" class="check-message">'+message+'</p>'+
        '</div>' +
        '<div style="height:30px;"><button class="messagebtn" style="float: right;padding: 3px 8px; background-color: #ffffff; border: 1px solid #FF4040; border-radius: 3px; margin-right: 30px;" onclick="closeOverlay()">确 定</button></div>' +
        '</div>';
    $('body').append(messageDiv);
    $('body').append(overlay);
}
function closeOverlay(){
    $(".overlay").hide();
    $(".checkmessage").hide();
    $(".overlay").remove();
    $(".checkmessage").remove();
}

//日期比较
function CompareDate(d1,d2){
    return (new Date(d1.replace(/-/g,"\/"))) > (new Date(d2.replace(/-/g,"\/")));
}

//日期格式化（虽然写这里不合适）
Date.prototype.Format = function(fmt)
{ //author: meizz
    var o = {
        "M+" : this.getMonth()+1,         //月份
        "d+" : this.getDate(),          //日
        "h+" : this.getHours(),          //小时
        "m+" : this.getMinutes(),         //分
        "s+" : this.getSeconds(),         //秒
        "q+" : Math.floor((this.getMonth()+3)/3), //季度
        "S" : this.getMilliseconds()       //毫秒
    };
    if(/(y+)/.test(fmt))
        fmt=fmt.replace(RegExp.$1, (this.getFullYear()+"").substr(4 - RegExp.$1.length));
    for(var k in o)
        if(new RegExp("("+ k +")").test(fmt))
            fmt = fmt.replace(RegExp.$1, (RegExp.$1.length==1) ? (o[k]) : (("00"+ o[k]).substr((""+ o[k]).length)));
    return fmt;
}