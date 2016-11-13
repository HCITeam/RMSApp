function myPost(sendUrl,sendData,waiter)
{
    var res=null;
    $.ajax({
        url: "/RMSApp/"+sendUrl,    //请求的url地址
        //url: "http://localhost:8080/"+sendUrl,    //请求的url地址
        dataType: "json",   //返回格式为json
        async: false, //请求是否异步，默认为异步，这也是ajax重要特性
        data: sendData,    //参数值
        type: "POST",   //请求方式
        beforeSend: function() {
            //请求前的处理
        },
        success: function(req) {
            res=req;
        },
        complete: function() {
        },
        error: function(XMLHttpRequest, textStatus, errorThrown) {
            //alert(errorThrown);
            res=null;
        }
    });
    return res;
}


var userName="正在测试",userID=-1,userStatus=1,userPass;
userID=3;

Date.prototype.format = function(format) {
    var o = {
        "M+": this.getMonth() + 1,
    // month
        "d+": this.getDate(),
    // day
        "h+": this.getHours(),
    // hour
        "m+": this.getMinutes(),
    // minute
        "s+": this.getSeconds(),
    // second
        "q+": Math.floor((this.getMonth() + 3) / 3),
    // quarter
    "S": this.getMilliseconds()
    // millisecond
};
    if (/(y+)/.test(format) || /(Y+)/.test(format)) {
        format = format.replace(RegExp.$1, (this.getFullYear() + "").substr(4 - RegExp.$1.length));
    }
    for (var k in o) {
        if (new RegExp("(" + k + ")").test(format)) {
            format = format.replace(RegExp.$1, RegExp.$1.length == 1 ? o[k] : ("00" + o[k]).substr(("" + o[k]).length));
        }
    }
    return format;
};
function timestampformat(timestamp) {
    return (new Date(timestamp )).format("yyyy-MM-dd hh:mm:ss");
}
