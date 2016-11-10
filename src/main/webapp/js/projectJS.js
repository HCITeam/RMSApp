/**
 * Created by xiaoskeleton on 2016/11/9.
 */

function refreshAllPro()
{
    refreshProjectShow();
    refreshProMenageShow();
}

function upPro()
{
    if($("#newProName").val()=="")
    {
        alert("项目名不能为空");
    }
    else if($("#newProShow").val()=="")
    {
        alert("描述不能为空");
    }
    else
    {
        var res=myPost("project/addProject",{"name":$("#newProName").val(),"description":$("#newProShow").val(),"creater":userID},"");
        if(res!=null)
        {
            var resRelation=myPost("/projectUserRelationship/addProjectUserRelationship",{"userId":userID,"projectId":res.id},"");
            cancelPro();
            shideSon("newProjectDiv");
        }
        else
        {
            alert("创建失败");
        }
    }
}

function cancelPro()
{
    $("#").val("");
    $("#newProName").val("");
}
function refreshProjectShow()
{
    showProjectBar(userID);
    $("#projectShowContant").slideUp(500);
}
function showProjectBar(userId)
{
    var res=myPost("projectUserRelationship/findProjectUserRelationshipByUser",{"userId":userId},"");
    if(res==null) return;
    $("#projectShowBar").html("");
    var proID;
    var proNum=0;
    for(var i=0;i<res.length;i++)
    {
        proNum++;
        proID=res[i].projectId;
        var proName;
        var proShow;
        var rprores=myPost("project/findProjectByID",{"id":proID},"");
        createrID=rprores.creater;
        var member=myPost("user/findUserByID",{"id":createrID},"");

        $("#projectShowBar").append("  <div class='projectShowDiv' onclick='showProjectMore("+proID+")'>\
                                   <div class='projectShowName'>"+rprores.name+"</div>\
                                         <div class='projectShowCreater threeBorder'>"+member.name+"</div>\
                                         <div class='projectShowText threeBorder'>"+rprores.description+"</div>\
                                        </div>");
        $("#projectShowBar").css("width",proNum*300+"px");
    }

    var l=proNum*300;
    if( l<parseInt($("#projectShowBarHider").css("width")))
    {
        canShowRoll=false;
    }
    else
    {
        canShowRoll=true;
    }
}

function refreshProMenageShow()
{
    showProMenageBar(userID);
    $("#projectManageContant").slideUp(500);
}

function showProMenageBar(userId)
{
    var res=myPost("/project/findProjectByCreater",{"creater":userId},"");
    if(res==null) return;
    $("#projectManageBar").html("");
    var proID;
    var proNum=0;
    for(var i=0;i<res.length;i++)
    {
        proNum++;
        proID=res[i].id;
        var proName=res[i].name;
        var proShow=res[i].description;
        $("#projectManageBar").append("  <div class='projectShowDiv projectManageDiv' onclick='showProjectMan("+proID+")'>\
                                   <div class='projectManageName'>"+proName+"</div>\
                                         <div class='projectShowCreater threeBorder'>"+userName+"</div>\
                                         <div class='projectShowText threeBorder'>"+proShow+"</div>\
                                        </div>");
        $("#projectManageBar").css("width",proNum*300+"px");
    }

    var l=proNum*300;
    if( l<parseInt($("#proManaBarHider").css("width")))
    {
        canManRoll=false;
    }
    else
    {
        canManRoll=true;
    }
}

function showProjectMan(proID)
{
    $("#projectManageContant").show();

    var pro=myPost("project/findProjectByID",{"id":proID},"");
    $("#proManMoreName").html(pro.name);
    $("#proMemberList").html("");
    $("#proMemberList").append(" <tr> <th>成员列表</th></tr><tr> <td id='addMemTd' onclick='addMember("+proID+")'>+添加成员+</td></tr>");

    var memList=myPost("projectUserRelationship/findProjectUserRelationshipByProject",{"projectId":proID},"");

    for(var i=0;i<memList.length;i++)
    {
        var memID=memList[i].userId;
        var member=myPost("user/findUserByID",{"id":memID},"");
        $("#proMemberList").append("<tr> <td>"+member.name+"</td></tr>");
    }

    $("html,body").animate({scrollTop:$("#projectManageContant").offset().top-130},500);
}

var isAddOn=false;

function addMember(proID)
{
    if(isAddOn) return;
    isAddOn=true;
    $("#addMemTd").html("<input id='newMemberInputer' class='contantInputer newMemberInputer' type='text' placeholder='请输入新成员名' onblur='addMemSubmit("
        +proID+")'/>");
    //$("#addMemTd").after("<tr><td>/td></tr>")
}
function addMemSubmit(proID)
{
    var memName=$("#newMemberInputer").val();
    var member=myPost("user/findUserByName",{"name":memName},"");
    if(member==null) {alert("没有这个用户！");return;}
    userID=member.id;
    var resRelation=myPost("/projectUserRelationship/addProjectUserRelationship",{"userId":userID,"projectId":proID},"");
    if(resRelation==null){alert("添加失败！");return;}
    $("#addMemTd").html("+添加成员+");
    $("#addMemTd").parent().after("<tr><td>"+memName+"</td></tr>");
    isAddOn=false;
}

function showProjectMore(proID)
{
    var pro=myPost("project/findProjectByID",{"id":proID},"");
    $("#projectShowContant").show();
    $("#proShowMoreTit").html(pro.name);

    var memList=myPost("projectRisk/findProjectRiskByProject",{"projectId":proID},"");
    $("#riskListTab").html("<tr> <th>风险列表</th></tr><tr> <td id='addRiskTd'onclick='addRisk()'>添加风险</td></tr>");
    for(var i=0;i<memList.length;i++)
    {
        var risk=memList[i];
        var riskID=risk.id;
        $("#riskListTab").append("<tr> <td onclick='showRisk("+riskID+")'>"+risk.name+"</td></tr>");
    }

    $("html,body").animate({scrollTop:$("#projectShowContant").offset().top-130},500);
}

function showRisk(id)
{

    var risk=myPost("projectRisk/findProjectRiskByID",{"id":id},"");
    var riskName=risk.name;
    var riskContent=risk.content;
    var riskpossibility=risk.possibility;
    var riskinfluenceLevel=risk.influenceLevel;
    var riskthreshold=risk.threshold;
    var riskcreater=risk.creater;
    var risktracker=risk.tracker;
    var creater=myPost("user/findUserByID",{"id":riskcreater},"");
    var tracker=myPost("user/findUserByID",{"id":risktracker},"");
    switch(riskpossibility)
    {
        case 1:
            riskpossibility="低";
            break;
        case 2:
            riskpossibility="中";
            break;
        case 3:
            riskpossibility="高";
            break;
        default:
            riskpossibility="未知";
            break;
    }
    switch(riskinfluenceLevel)
    {
        case 1:
            riskinfluenceLevel="低";
            break;
        case 2:
            riskinfluenceLevel="中";
            break;
        case 3:
            riskinfluenceLevel="高";
            break;
        default:
            riskinfluenceLevel="未知";
            break;
    }
    $("#proShowTitle").html(riskName);
    $("#riskShow").html(riskContent);
    $("#riskPoss").html(riskpossibility);
    $("#riskInfluence").html(riskinfluenceLevel);
    $("#riskThreshold").html(riskthreshold);
    $("#riskCreater").html(creater.name);
    $("#riskTracker").html(tracker.name);


}

function addRisk()
{

}