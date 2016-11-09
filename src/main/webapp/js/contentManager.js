var rl=0;
var rl2=0;
$(document).ready(function () {
    $(document).scroll(function (event) {
        if($(document).scrollTop()>300)
        {
            $(".toTopImg").show();
        }
        else
        {
            $(".toTopImg").hide();
        }
    });
    $("#projectShowBar").on("mousewheel DOMMouseScroll", function (e) {

        var delta = e.originalEvent.wheelDelta ||  // chrome & ie
            e.originalEvent.detail;              // firefox
        //var rl=parseInt($(".projectShowBar").css("margin-left"));
        var barWidth=parseInt($("#projectShowBar").css("width"));
        var hiderW=parseInt($("#projectShowBarHider").css("width"));
        var minl=-barWidth+hiderW;
        if((rl>=0&&delta<0)||(rl<0&&rl>minl)||(rl<=minl&&delta>0))
        {
            rl=rl+delta;
            if(rl>0) rl=0;
            if(rl<minl) rl=minl;
            $("#projectShowBar").css("margin-left", rl+"px");
            e.preventDefault();
        }
        var nowL=parseInt($("#projectShowBar").css("margin-left"));
        if(nowL<0&&nowL>minl)e.preventDefault();
    });
    $("#projectManageBar").on("mousewheel DOMMouseScroll", function (e) {

        var delta = e.originalEvent.wheelDelta ||  // chrome & ie
            e.originalEvent.detail;              // firefox
        //var rl=parseInt($(".projectShowBar").css("margin-left"));
        var barWidth=parseInt($("#projectManageBar").css("width"));
        var hiderW=parseInt($("#projectShowBarHider").css("width"));
        var minl=-barWidth+hiderW;
        if((rl2>=0&&delta<0)||(rl2<0&&rl2>minl)||(rl2<=minl&&delta>0))
        {
            rl2=rl2+delta;
            if(rl2>0) rl2=0;
            if(rl2<minl) rl2=minl;
            $("#projectManageBar").css("margin-left", rl2+"px");
        }
        var nowL=parseInt($("#projectManageBar").css("margin-left"));
        if(nowL<0&&nowL>minl)e.preventDefault();
    });
});
var newTitle;

function login()
{
    var res=myPost("login",{"name":$("#loginName").val(),"password":$("#loginPassword").val()});
    if(res!=null && res.name)
    {
        loginOK();
    }
    else
    {
        alert("登陆失败");
    }
}

function loginOK()
{

    $(".loginDiv").css("height","0%");
    $(".loginBox").css("border-bottom-width","0px");
    $(".passInputer").css("display","none");
    newTitle="风险系统";
    setTimeout(hideTitle, 500);
    setTimeout(showTitle, 1000);
    setTimeout(showBox, 1500);
}
function hideTitle()
{
    $(".contantTitle").css("overflow","hidden");
    $(".contantTitle").css("width","0px");
}
var boxNow=1;
function showTitle()
{
    $(".contantTitle").html(newTitle);
    $(".contantTitle").css("width","600px");
}
function showBox()
{
    if(boxNow>3) return;
    $(".box"+boxNow).css("display","inline");
    if(boxNow==1)
        setTimeout(function(){ $(".box1").css("margin-top", "40px");}, 10);
    else  if(boxNow==2)
        setTimeout(function(){ $(".box2").css("margin-top", "40px");}, 10);
    else if(boxNow==3)
        setTimeout(function(){ $(".box3").css("margin-top", "40px");}, 10);
    boxNow++;
    setTimeout(showBox, 200);
}
var isSmall=0;
var nowBoxNum=0;
function smallBox(boxNum)
{
    nowBoxNum=boxNum
    if (isSmall == 0)
    {
        isSmall = 1;
        $(".mainBox").css("width", "0px");
        $(".boxTitle").hide();
        $(".boxText").hide();
        if (boxNum == 1)
        {
            newTitle = "项目管理";
        }
        else  if (boxNum == 2)
        {
            newTitle = "账号管理";
        }
        else  if (boxNum == 3)
        {
            newTitle = "系统管理";
        }

        setTimeout(hideTitle, 0);
        setTimeout(showTitle, 500);
        setTimeout(moveBoxSon, 500);
    }
    else
    {
        moveBoxSon();
        isSmall=0;
        newTitle="风险系统";
        setTimeout(hideTitle, 0);
        setTimeout(showTitle, 500);
        $(".mainBox").css("width", "360px");
        setTimeout(function(){$(".boxTitle").show();$(".boxText").show();}, 500);
    }
}
var isSonShow=false;
function moveBoxSon()
{
    if(isSonShow)
    {
        $(".sonBoxDiv").hide();
        $(".sonBoxContainer").html("");
        $(".mainDivSon").hide();
        isSonShow=false;
    }
    else
    {
        $(".sonBoxContainer").html("");
        if(nowBoxNum==1)
        {
            addSonBox("img/box-login.png","新建项目","newProjectDiv");
            addSonBox("img/box-login.png","查看项目","showProjectDiv");
            addSonBox("img/box-login.png","管理项目","manageProjectDiv");
            $(".sonBoxContainer").css("width",160*3+"px");
        }
        if(nowBoxNum==2)
        {
            addSonBox("img/box-login.png","修改密码","accountMnage");
            addSonBox("img/box-login.png","注销登陆","accountMnage");
            $(".sonBoxContainer").css("width",160*2+"px");
        }
        if(nowBoxNum==3 )
        {
            addSonBox("img/box-login.png","新建账号","newAccountDiv");
            addSonBox("img/box-login.png","账号管理","accountMnage");
            addSonBox("img/box-login.png","权限管理","accountMnage");
            $(".sonBoxContainer").css("width",160*3+"px");
        }
        $(".sonBoxDiv").show();
        isSonShow=true;
    }
}

function addSonBox(src,name,content)
{
    $(".sonBoxContainer").append("\
                    <div class='leftFlow smallBox'>\
                    <div class='sonBoxShowDiv'>\
                    <img src='"+src+"' class='boxImg' onclick='moveTo(\""+content+"\")'/>\
                    </div>\
                     <div class='sonBoxTitle'>"+
        name+"\
                    </div>\
                    </div>\
             ");
}
function moveTo(location)
{
    if(location=="null"){alert("功能未开放");return;}
    addConntent(location);
    $("html,body").animate({scrollTop:$("#"+location).offset().top-64},500);
}

function addConntent(name)
{
    $("#"+name).show();
}
function showProjectMore(proID)
{
    $("#projectShowContant").show();
    $("html,body").animate({scrollTop:$("#projectShowContant").offset().top-130},500);
}
function hideProShow()
{
    $("#projectShowContant").slideUp(500,function(){ $("html,body").animate({scrollTop:$("#showProjectDiv").offset().top-100},500);});
}
function showProjectMan(proID)
{
    $("#projectManageContant").show();
    $("html,body").animate({scrollTop:$("#projectManageContant").offset().top-130},500);
}
function hideProMan()
{
    $("#projectManageContant").slideUp(500,function(){ $("html,body").animate({scrollTop:$("#manageProjectDiv").offset().top-100},500);});
}

function shideSon(sonID)
{
    $("#"+sonID).slideUp(500);
    setTimeout(function(){   moveTo("topLocation");}, 500);
}