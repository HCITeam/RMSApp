function myPost(sendUrl,sendData,waiter)
{
    var res=null;
    $.ajax({
        url: "http://182.254.209.247:8080/RMSApp/"+sendUrl,    //请求的url地址
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


var userName="正在测试",userID=-1;
userID=2;