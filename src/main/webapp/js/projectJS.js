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
            refreshAllPro();
            moveTo("manageProjectDiv");
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
        proID=res[i].projectId;
        var proName;
        var proShow;
        var rprores=myPost("project/findProjectByID",{"id":proID},"");
        if(rprores==null) continue;
        createrID=rprores.creater;
        var member=myPost("user/findUserByID",{"id":createrID},"");

        $("#projectShowBar").append("  <div class='projectShowDiv' onclick='showProjectMore("+proID+")'>\
                                   <div class='projectShowName'>"+rprores.name+"</div>\
                                         <div class='projectShowCreater threeBorder'>"+member.name+"</div>\
                                         <div class='projectShowText threeBorder'>"+rprores.description+"</div>\
                                        </div>");
        proNum++;

    }
    if(proNum==0)
    {
        $("#projectShowBar").html("还没有参与项目");
        canShowRoll=false;
        $("#projectShowBar").css("font-size","30px");
        $("#projectShowBar").css("width",600+"px");
        $("#projectShowBar").css("margin-top",200+"px");
        return;
    }
    $("#projectShowBar").css("width",proNum*300+"px");
    var l=proNum*300;
    var ll=parseInt($("#projectShowBarHider").css("width"));
    if( l<ll)
    {
        $("#projectShowBar").css("margin-left",(ll-l)/2+"px");
        $("#projectShowBar").css("margin-right",(ll-l)/2+"px");
        canShowRoll=false;
    }
    else
    {
        $("#projectShowBar").css("margin-left",0+"px");
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
    $("#projectManageBar").html("");
    var proID;
    var proNum=0;
    if(res!=null)
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
        }

    if(proNum==0)
    {
        $("#projectManageBar").html("还没有参与项目");
        canManRoll=false;
        $("#projectManageBar").css("font-size","30px");
        $("#projectManageBar").css("width",600+"px");
        $("#projectManageBar").css("margin-top",200+"px");
        return;
    }
    $("#projectManageBar").css("width",proNum*300+"px");
    var l=proNum*300;
    var ll=parseInt($("#proManaBarHider").css("width"));
    if( l<ll)
    {
        $("#projectManageBar").css("margin-left",(ll-l)/2+"px");
        $("#projectManageBar").css("margin-right",(ll-l)/2+"px");

        canManRoll=false;

    }
    else
    {
        $("#projectManageBar").css("margin-left",0+"px");
        canManRoll=true;
    }
}
var isAddOn=false;

var nowProMenId;
var nowProSelMemID=-1;
var relaID=-1;
function showProjectMan(proID)
{
    nowProSelMemID=-1;
    relaID=-1;
    nowProMenId=proID;
    isAddOn=false;
    $("#showMemberName").html("成员名");
    $("#projectManageContant").show();

    var pro=myPost("project/findProjectByID",{"id":proID},"");
    $("#proManMoreName").html(pro.name);
    $("#proMemberList").html("");
    $("#proMemberList").append(" <tr> <th>成员列表</th></tr><tr> <td id='addMemTd' class='roundBorder' onclick='addMember("+proID+")'>+添加成员+</td></tr>");

    var memList=myPost("projectUserRelationship/findProjectUserRelationshipByProject",{"projectId":proID},"");

    for(var i=0;i<memList.length;i++)
    {
        var memID=memList[i].userId;
        var member=myPost("user/findUserByID",{"id":memID},"");
        $("#proMemberList").append("<tr onclick='showProMember("+memList[i].id+","+memID+")'> <td>"+member.name+"</td></tr>");
    }

    $("html,body").animate({scrollTop:$("#projectManageContant").offset().top-130},500);
}


function showProMember(relationID,memID,name)
{
    nowProSelMemID=memID;
    relaID=relationID;
    var member=myPost("user/findUserByID",{"id":memID},"");
    $("#showMemberName").html(member.name);
}


function delMember()
{

    if(nowProSelMemID==-1){nowProSelMemID=userID;}
    if(nowProSelMemID==userID)
    {
        if (confirm("这将删除整个项目"))
        {
            var result=myPost("/project/deleteProject",{"id":nowProMenId},"");
            if(result==null)
            {
                alert("删除失败！");
                return;
            }
            else
            {
                refreshAllPro();
                return;
            }
        }
        else
        {
            nowProSelMemID=-1;
            return;
        }
    }
    var result=myPost("projectUserRelationship/deleteProjectUserRelationship",{"id":relaID},"");
    if(result==null)
    {
        alert("删除失败！");
        return;
    }
    else
    {
        showProjectMan(nowProMenId);
    }
}

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
var nowProId;

function showProjectMore(proID)
{
    nowProId=proID;
    var pro=myPost("project/findProjectByID",{"id":proID},"");
    $("#projectShowContant").show();
    $("#proShowMoreTit").html(pro.name);

    nowRiskID=-1;
    var memList=myPost("projectRisk/findProjectRiskByProject",{"projectId":proID},"");
    $("#riskListTab").html("<tr> <th>风险列表</th></tr><tr> <td id='addRiskTd'class='roundBorder'onclick='addRisk()'>添加风险</td></tr>");
    if(memList==null) memList=[];
    for(var i=0;i<memList.length;i++)
    {
        var risk=memList[i];
        var riskID=risk.id;
        $("#riskListTab").append("<tr> <td onclick='showRisk("+riskID+")'>"+risk.name+"</td></tr>");
    }
    $("html,body").animate({scrollTop:$("#projectShowContant").offset().top-130},500);

    $("#proShowTitle").html("风险名");
    $("#riskShow").attr("placeholder","风险描述");
    $("#riskShow").attr("disabled",true);
    $("#riskShow").val("风险描述");
    $("#riskCreater").html("");
    $("#riskTracker").html("");
    $("#riskPoss").html("");
    $("#riskInfluence").html("");
    $("#riskThreshold").html("");
    $("#riskListTable").html(" <tr> <th colspan='2'>风险日志</th></tr><tr><td colspan='2'>暂无</td></tr>");
    $("#riskBtnYes").hide();
    $("#riskBtnNo").hide();
    $("#riskBtnRes").show();
    $("#riskBtnEdit").hide();

}
var nowRiskID=-1;
function showRisk(id)
{
    $(".delTrackTd").hide();
    nowRiskID=id;
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
    var trackList=myPost("projectTrack/findProjectTrackByRisk",{"riskId":id},"");
    if(trackList==null) trackList=[];
    if(risktracker==userID) $("#riskListTable").html("<tr> <th>名称</th><th>触发原因</th><th>触发时间</th><th class='delTrackTd'>操作</th></tr><tr id='newTrackTr'><td colspan='3' id='newTrackTd' class='roundBorder' onclick='doNewTrack("+nowRiskID+")'>+添加、编辑日志+</td></tr>");
    else $("#riskListTable").html("<tr> <th>名称</th><th>触发原因</th><th >触发时间</th><th class='delTrackTd'>操作</th></tr>");
    for(var i=0;i<trackList.length;i++)
    {
        var track=trackList[i];
        var id=track.id;
        var name=track.risk;
        var cause=track.cause;
        var time=track.updateTime;
        $("#riskListTable").append("<tr id='track"+id+"tr'> <td>"+name+"</td><td>"+cause+"</td><td>"+timestampformat(time)+"</td><td class='delTrackTd' onclick='doDelTrack("+id+")'><img src='img/delete.png' class='bottomIcon setPointer'style='width:10px' /></td></tr>");
    }
    if(trackList.length==0)
    {
        $("#riskListTable").append("<tr id='track"+id+"tr'> <td colspan='4'>暂无</td></tr>");
    }
    $("#riskBtnYes").hide();
    $("#riskBtnNo").show();
    $("#riskBtnRes").show();
    $("#riskBtnEdit").show();
}

function doDelTrack(id)
{
    if(confirm("确定删除吗?"))
    {
        var res=myPost("projectTrack/deleteProjectTrack",{"id":id},"");
        if(res==null)
        {
            alert("删除失败");
        }
        else
        {
            $("#track"+id+"tr").hide();
        }
    }
}

function addRisk()
{
    nowRiskID=-1;
    $("#proShowTitle").html("<input id='newRiskName' class='contantInputer newProName' type='text' placeholder='在这里输入新的风险名'/>");
    $("#riskShow").attr("placeholder","在这里输入风险描述");
    $("#riskShow").attr("disabled",false);
    $("#riskShow").val("");
    $("#riskCreater").html(userName);
    $("#riskTracker").html("<input id='newRiskTrackerName' class='contantInputer newMemberInputer' style='width:70px;font-size: 15px' type='text' placeholder='输入姓名'/>");
    //$("#riskPoss").html("<input id='newRiskPoss' class='contantInputer newMemberInputer newRiskInputer' type='text' placeholder='?'/>");
    $("#riskPoss").html("<select name='newRiskPoss' id='newRiskPoss' class='contantInputer newMemberInputer newRiskInputer'>\
    <option value='高'>高</option>\
    <option value='中'>中</option>\
    <option value='低'>低</option>\
    </select>");

   // $("#riskInfluence").html("<input id='newRiskInflu' class='contantInputer newMemberInputer newRiskInputer' type='text' placeholder='?'/>");
    $("#riskInfluence").html("<select name='newRiskInflu' id='newRiskInflu' class='contantInputer newMemberInputer newRiskInputer'>\
    <option value='高'>高</option>\
    <option value='中'>中</option>\
    <option value='低'>低</option>\
    </select>");
    $("#riskThreshold").html("<input id='newRiskThre' class='contantInputer newMemberInputer ' type='text' style='width:120px;font-size: 15px' placeholder='请输入触发原因'/>");
    $("#riskListTable").html(" <tr> <th colspan='2'>风险日志</th></tr><tr><td colspan='2'>暂无</td></tr>");
    $("#riskBtnYes").show();
    $("#riskBtnNo").show();
    $("#riskBtnRes").hide();
    $("#riskBtnEdit").hide();
}
var nowEditId;
function editRisk()
{
    var title=$("#proShowTitle").html();
    var show=$("#riskShow").html();
    var tracker=$("#riskTracker").html();
    var poss=$("#riskPoss").html();
    var influence=$("#riskInfluence").html();
    var shold=$("#riskThreshold").html();
    nowEditId=nowRiskID;
    nowRiskID=-2;
    $("#proShowTitle").html("<input id='newRiskName' class='contantInputer newProName' type='text' placeholder='在这里输入新的风险名' value='"+title+"'/>");
    $("#riskShow").attr("placeholder","在这里输入风险描述");
    $("#riskShow").attr("disabled",false);
    $("#riskShow").val(show);
    $("#riskCreater").html(userName);
    $("#riskTracker").html("<input id='newRiskTrackerName' class='contantInputer newMemberInputer' style='width:70px;font-size: 15px' type='text' placeholder='输入姓名'value='"+tracker+"'/>");
    //$("#riskPoss").html("<input id='newRiskPoss' class='contantInputer newMemberInputer newRiskInputer' type='text' placeholder='?'value='"+poss+"'/>");
    //$("#riskInfluence").html("<input id='newRiskInflu' class='contantInputer newMemberInputer newRiskInputer' type='text' placeholder='?'value='"+influence+"'/>");

    $("#riskPoss").html("<select name='newRiskPoss' id='newRiskPoss' class='contantInputer newMemberInputer newRiskInputer'value='"+poss+"'>\
    <option value='高'>高</option>\
    <option value='中'>中</option>\
    <option value='低'>低</option>\
    </select>");
    $("#newRiskPoss option[value='"+poss+"']").attr("selected", "selected");

    $("#riskInfluence").html("<select name='newRiskInflu' id='newRiskInflu' class='contantInputer newMemberInputer newRiskInputer' value='"+influence+"'>\
    <option value='高'>高</option>\
    <option value='中'>中</option>\
    <option value='低'>低</option>\
    </select>");
    $("#newRiskInflu option[value='"+influence+"']").attr("selected", "selected");

    $("#riskThreshold").html("<input id='newRiskThre' class='contantInputer newMemberInputer ' type='text' style='width:120px;font-size: 15px' placeholder='请输入触发原因'value='"+shold+"'/>");
    $("#riskListTable").html(" <tr> <th colspan='2'>风险日志</th></tr><tr><td colspan='2'>暂不显示</td></tr>");
    $("#riskBtnYes").show();
    $("#riskBtnNo").show();
    $("#riskBtnRes").hide();
    $("#riskBtnEdit").hide();
}



function doNewRisk()
{
    if($("#newRiskName").val()=="")
    {
        alert("风险名不能为空");
        return;
    }
    if($("#riskShow").val()=="")
    {
        alert("风险描述不能为空");
        return;
    }
    if($("#newRiskTrackerName").val()=="")
    {
        alert("追踪者名不能为空");
        return;
    }
    if($("#newRiskPoss").val()!="高"&&$("#newRiskPoss").val()!="中"&&$("#newRiskPoss").val()!="低")
    {
        alert("可能性应该为高或中或低");
        return;
    }
    if($("#newRiskInflu").val()!="高"&&$("#newRiskInflu").val()!="中"&&$("#newRiskInflu").val()!="低")
    {
        alert("影响应该为高或中或低");
        return;
    }
    if($("#newRiskThre").val()=="")
    {
        alert("触发器不能为空");
        return;
    }

    var newRiskPoss;
    if($("#newRiskPoss").val()=="高")
    {
        newRiskPoss=3;
    }
    else if($("#newRiskPoss").val()=="中")
    {
        newRiskPoss=2;
    }
    else
    {
        newRiskPoss=1;
    }
    var newRiskInflu;
    if($("#newRiskInflu").val()=="高")
    {
        newRiskInflu=3;
    }
    else if($("#newRiskInflu").val()=="中")
    {
        newRiskInflu=2;
    }
    else
    {
        newRiskInflu=1;
    }
    var member=myPost("user/findUserByName",{"name":$("#newRiskTrackerName").val()},"");
    if(member==null)
    {
        alert("追踪者输入错误");
        return;
    }
    //projectId,name,content, possibility, influenceLevel, threshold, creater, tracker
    if(nowRiskID==-2)
    {
        //nowEditId
        var res=myPost("projectRisk/updateProjectRisk",{"id":nowEditId,"projectId":nowProId,"name":$("#newRiskName").val(),"content":$("#riskShow").val(),"possibility":newRiskPoss,"influenceLevel":newRiskInflu,"threshold":$("#newRiskThre").val(),"creater":userID,"tracker":member.id},"");
        if(res==null)
        {
            alert("修改失败");
        }
        else
        {
            showRisk(nowEditId);
        }
        return;
    }

    var res=myPost("projectRisk/addProjectRisk",{"projectId":nowProId,"name":$("#newRiskName").val(),"content":$("#riskShow").val(),"possibility":newRiskPoss,"influenceLevel":newRiskInflu,"threshold":$("#newRiskThre").val(),"creater":userID,"tracker":member.id},"");
    if(res==null)
    {
        alert("新建失败");
    }
    else
    {
        showProjectMore(nowProId);
    }
}
function delNewRisk()
{
            if(nowRiskID==-1)
            {
                showProjectMore(nowProId);
            }
            else if(nowRiskID==-2)
            {
                showRisk(nowEditId);
            }
            else
            {
                if(confirm("确定删除这个风险吗"))
                {
                    var res=myPost("projectRisk/deleteProjectRisk",{"id":nowRiskID},"");
                    if(res==null)
                    {
                        alert("删除失败");
                    }
            else
            {
                showProjectMore(nowProId);
            }
        }
    }
}
function doNewTrack(riskID)
{
    //showRisk(riskID);
    $(".delTrackTd").show();
    $("#newTrackTr").html("<td><input id='newTrackName' class='contantInputer newMemberInputer' style='width:100%;font-size: 20px' type='text' placeholder='输入新日志名称'/></td>" +
                            "<td><input id='newTrackContent' class='contantInputer newMemberInputer' style='width:100%;font-size: 20px' type='text' placeholder='输入触发原因'/></td>" +
                            "<td>自动生成</td>" +
                            "<td onclick='showRisk("+riskID+")'><img src='img/delete.png' class='bottomIcon setPointer'style='width:10px''/> </td>" +
                            "<td onclick='doNewTrackSend("+riskID+")'><img src='img/yes.png' class='bottomIcon setPointer'style='width:10px'/></td>");

}

function doNewTrackSend(riskID)
{
    //riskId, risk, state, cause, tracker, updateTime
    if($("#newTrackName").val()=="")
    {
        alert("日志名称不能为空");
        return;
    }
    if($("#newTrackContent").val()=="")
    {
        alert("触发原因不能为空");
        return;
    }
    var res=myPost("projectTrack/addProjectTrack",{"riskId":riskID,"risk":$("#newTrackName").val(),"state":0,"cause":$("#newTrackContent").val(),"tracker":userID,"updateTime":"2012-12-22 00:00:00"},"");
    if(res==null)
    {
        alert("新建失败");
    }
    else
    {
        showRisk(riskID);
    }
}


