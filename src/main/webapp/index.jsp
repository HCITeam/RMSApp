<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!doctype html>
<html>
    <head>
        <meta charset="utf-8">
        <meta http-equiv="x-ua-compatible" content="ie=edge">
        <title>风险管理系统</title>
        <!-- Place favicon.ico in the root directory -->
        <link rel="stylesheet" href="css/main.css">
        <link rel="stylesheet" href="css/allTitle.css">
        <link rel="stylesheet" href="css/allContant.css">
        <link rel="stylesheet" href="css/mainDiv.css">
        <link rel="stylesheet" href="css/projectShow.css">
        <link rel="stylesheet" href="css/accountShow.css">
        <script src="js/jquery-2.1.4.min.js"></script>
        <script src="js/contentManager.js"></script>
        <script src="js/dataManage.js"></script>
    </head>
    <body  id="topLocation">
        <!--[if lt IE 8]>
            <p class="browserupgrade">You are using an <strong>outdated</strong> browser. Please <a href="http://browsehappy.com/">upgrade your browser</a> to improve your experience.</p>
        <![endif]-->
        <img src="img/top.png" class="toTopImg" onclick="moveTo('topLocation');">

        <div class="allTitle">
            <img src="img/logo.png" class="logoImg">
            <div class="icons">
                <img src="img/box-login.png" class="topImg" onclick="moveTo('topLocation');">
            </div>
        </div>

        <div class="allContant">
            <div class="contantTitle contanter bottomLine">
                登陆系统
            </div>
            <div class="loginDiv">
                <div class="boxDiv">
                    <img src="img/box-login.png" class="boxImg" onclick="login()">

                </div>
                <div class="loginBox contanter bottomLine">
                    <input id="loginName" class="contantInputer passInputer" type="text" placeholder="在这里输入账号"/>
                </div>
                <div class="loginBox contanter bottomLine">
                    <input id="loginPassword" class="contantInputer passInputer" type="password" placeholder="在这里输入密码"/>
                </div>
            </div>
            <div  class="boxContant">
                <div class="mainBox leftFlow box1">
                    <div class="mainBoxDiv">
                        <img src="img/box-login.png" class="boxImg boxImg1" onclick="smallBox(1)"/>
                    </div>
                    <div class="boxTitle">
                        项目管理
                    </div>
                    <div class="boxText">
                        包含新建项目、管理项目成员、管理项目风险、追踪项目风险等所有与项目有关的功能。<br/>点击图标进入项目管理，需要用户登陆并且有相关的操作权限
                    </div>
                </div>
                <div class="mainBox leftFlow box2">
                    <div class="mainBoxDiv">
                        <img src="img/box-login.png" class="boxImg boxImg1" onclick="smallBox(2)"/>
                    </div>
                    <div class="boxTitle">
                        账号管理
                    </div>
                    <div class="boxText">
                        包含重新登陆、修改密码、用户资料管理、用户账号删除、用户项目记录查询等用户相关功能。<br/>点击图标进入账号管理，需要用户登陆并且有相关的操作权限
                    </div>
                </div>
                <div class="mainBox leftFlow box3">
                    <div class="mainBoxDiv">
                        <img src="img/box-login.png" class="boxImg boxImg1" onclick="smallBox(3)"/>
                    </div>
                    <div class="boxTitle">
                        系统管理
                    </div>
                    <div class="boxText">
                        包含创建账号、删除账号、账号权限管理、系统功能查看、系统日志查看等系统相关功能。<br/>点击图标进入系统管理，需要用户登陆并且有相关的操作权限
                    </div>
                </div>
                <div class="leftFlow sonBoxDiv">
                    <div class="sonBoxContainer">
                    </div>
                </div>
            </div>
        </div>
        <!-- 新建项目-->
        <div class="mainDiv">
            <div class="mainDivSon" id="newProjectDiv">
                <div class="divSonTitle">
                    <div class="divSonTitleImg">
                        <img src="img/box-login.png" class="sonTitleImg setPointer" onclick=""/>
                    </div>
                    <div class="divSonIconBar">
                        <img src="img/small.png" class="sonTitleIcon setPointer" onclick="shideSon('newProjectDiv')"/>

                        <img src="img/refresh.png" class="sonTitleIcon setPointer" onclick=""/>
                    </div>
                </div>

                <div style="margin-top: 170px;">
                    <div class="contanter bottomLine newProjectInputer" style="width:600px">
                        <input class="contantInputer newProName" type="text" placeholder="在这里输入新的项目名"/>
                    </div>

                    <div class="contanter bottomLine newProjectInputer" style="width:600px">
                        <textarea  rows="10" cols="30" class="projeceArea" placeholder="在这里输入项目描述"></textarea>
                    </div>

                    <div class="newProjectIconBar">

                        <img src="img/yes.png" class="newProjectIcon setPointer" onclick=""/>
                        <img src="img/delete.png" class="newProjectIcon setPointer" onclick=""/>

                    </div>
                </div>

            </div>
            <!-- 项目查看-->
            <div class="mainDivSon" id="showProjectDiv">
                <div class="divSonTitle">
                    <div class="divSonTitleImg">
                        <img src="img/box-login.png" class="sonTitleImg setPointer" onclick=""/>
                    </div>

                    <div class="divSonIconBar">
                        <img src="img/small.png" class="sonTitleIcon setPointer" onclick="shideSon('showProjectDiv')"/>

                        <img src="img/refresh.png" class="sonTitleIcon setPointer" onclick=""/>
                    </div>
                </div>
                <div id="projectShowBarHider" class="projectShowBarHider" style="width:80%;overflow:hidden;margin-left: auto;margin-right: auto">
                    <div id="projectShowBar" class="projectShowBar">
                        <div class="projectShowDiv" onclick="showProjectMore('项目1')">
                            <div class="projectShowName">项目1</div>
                            <div class="projectShowCreater threeBorder">肖瑞</div>
                            <div class="projectShowText threeBorder">该配合你演出的我演视而不见</div>
                        </div>
                        <div class="projectShowDiv" onclick="showProjectMore('项目1')">
                            <div class="projectShowName">项目2</div>
                            <div class="projectShowCreater threeBorder">肖瑞</div>
                            <div class="projectShowText threeBorder">该配合你演出的我演视而不见</div>
                        </div>
                        <div class="projectShowDiv" onclick="showProjectMore('项目1')">
                            <div class="projectShowName">项目3</div>
                            <div class="projectShowCreater threeBorder">肖瑞</div>
                            <div class="projectShowText threeBorder">该配合你演出的我演视而不见</div>
                        </div>
                        <div class="projectShowDiv" onclick="showProjectMore('项目1')">
                            <div class="projectShowName">项目4</div>
                            <div class="projectShowCreater threeBorder">肖瑞</div>
                            <div class="projectShowText threeBorder">该配合你演出的我演视而不见</div>
                        </div>
                        <div class="projectShowDiv" onclick="showProjectMore('项目1')">
                            <div class="projectShowName">项目1</div>
                            <div class="projectShowCreater threeBorder">肖瑞</div>
                            <div class="projectShowText threeBorder">该配合你演出的我演视而不见</div>
                        </div>
                        <div class="projectShowDiv" onclick="showProjectMore('项目1')">
                            <div class="projectShowName">项目1</div>
                            <div class="projectShowCreater threeBorder">肖瑞</div>
                            <div class="projectShowText threeBorder">该配合你演出的我演视而不见</div>
                        </div>
                        <div class="projectShowDiv" onclick="showProjectMore('项目1')">
                            <div class="projectShowName">项目1</div>
                            <div class="projectShowCreater threeBorder">肖瑞</div>
                            <div class="projectShowText threeBorder">该配合你演出的我演视而不见</div>
                        </div>
                        <div class="projectShowDiv" onclick="showProjectMore('项目1')">
                            <div class="projectShowName">项目1</div>
                            <div class="projectShowCreater threeBorder">肖瑞</div>
                            <div class="projectShowText threeBorder">该配合你演出的我演视而不见</div>
                        </div>
                        <div class="projectShowDiv" onclick="showProjectMore('项目1')">
                            <div class="projectShowName">项目1</div>
                            <div class="projectShowCreater threeBorder">肖瑞</div>
                            <div class="projectShowText threeBorder">该配合你演出的我演视而不见</div>
                        </div>
                        <div class="projectShowDiv" onclick="showProjectMore('项目1')">
                            <div class="projectShowName">项目1</div>
                            <div class="projectShowCreater threeBorder">肖瑞</div>
                            <div class="projectShowText threeBorder">该配合你演出的我演视而不见</div>
                        </div>
                    </div>
                </div>
                <div id="projectShowContant"  class="projectCard">

                    <div class="proLeft">
                        <div class="proLeftName">
                            <div class="proLeftNameShow">
                                项目1
                            </div>
                        </div>
                        <div class="proLeftMid"></div>
                        <div class="proLeftShow">
                            <div class="riskListShow">
                                <table class="riskListTab" cellspacing="10" border="0">
                                    <tr> <th>风险列表</th></tr>
                                    <tr> <td>风险1</td></tr>
                                    <tr> <td>风险1</td></tr>
                                    <tr> <td>风险1</td></tr>
                                    <tr> <td>风险1</td></tr>
                                    <tr> <td>风险1</td></tr>
                                    <tr> <td>风险1</td></tr>
                                    <tr> <td>风险1</td></tr>
                                    <tr> <td>风险1</td></tr>
                                    <tr> <td>风险1</td></tr>
                                    <tr> <td>风险1</td></tr>
                                    <tr> <td>风险1</td></tr>
                                    <tr> <td>风险1</td></tr>
                                    <tr> <td>风险1</td></tr>
                                    <tr> <td>风险1</td></tr>
                                    <tr> <td>风险1</td></tr>
                                    <tr> <td>风险1</td></tr>
                                    <tr> <td>风险1</td></tr>
                                    <tr> <td>风险1</td></tr>
                                    <tr> <td>风险1</td></tr>
                                    <tr> <td>风险1</td></tr>
                                    <tr> <td>风险1</td></tr>
                                    <tr> <td>风险1</td></tr>
                                    <tr> <td>风险1</td></tr>
                                    <tr> <td>+</td></tr>
                                </table>
                            </div>
                        </div>
                    </div>
                    <div class="proMid">

                    </div>
                    <div class="proRight">
                        <div>
                            <img src="img/small.png" class="sonTitleIcon setPointer"  onclick="hideProShow()">
                            <div class="proRightTitle">风险1</div>
                            <div class="fourBorder proRightShow">
                                <textarea  disabled="disabled" class="proRightShowArea" title="风险描述">这是一个风险这是一个风险这是一个风险这是一个风险这是一个风险这是一个风险这是一个风险这是一个风险这是一个风险</textarea>
                            </div>
                            <div style="width:80%;margin-top:30px;margin-left:auto;margin-right:auto;">
                                <table class="riskListTab riskShowTab" cellspacing="1" border="0" style="font-size: 15px">
                                    <tr> <th>创建者</th><td>xxxxxr</td><th>跟踪者</th><td>xxxxxxr</td><th>可能性</th><td>高</td><th>影响程度</th><td>高</td><th>触发器</th><td>66666666</td></tr>
                                </table>
                            </div>
                            <div class="riskListShow" style="height:300px;margin-top: 30px">
                                <table class="riskListTab riskShowTab" cellspacing="10" border="0">
                                    <tr> <th colspan="2">风险日志</th></tr>
                                    <tr><td>出现了</td> <td>他出现了</td></tr>
                                    <tr><td>出现了</td> <td>他出现了</td></tr>
                                    <tr><td>出现了</td> <td>他出现了</td></tr>
                                    <tr><td>出现了</td> <td>他出现了</td></tr>
                                    <tr><td>出现了</td> <td>他出现了</td></tr>
                                    <tr><td>出现了</td> <td>他出现了</td></tr>
                                    <tr><td>出现了</td> <td>他出现了</td></tr>
                                    <tr><td>出现了</td> <td>他出现了</td></tr>
                                    <tr><td>出现了</td> <td>他出现了</td></tr>
                                    <tr><td>出现了</td> <td>他出现了</td></tr>
                                    <tr><td>出现了</td> <td>他出现了</td></tr>
                                    <tr><td>出现了</td> <td>他出现了</td></tr>
                                    <tr><td>出现了</td> <td>他出现了</td></tr>
                                    <tr><td>出现了</td> <td>他出现了</td></tr>

                                    <tr> <td colspan="2">+</td></tr>
                                </table>
                            </div>
                        </div>

                        <div>
                            <img src="img/refresh.png" class="bottomIcon setPointer" onclick=""/>

                            <img src="img/small.png" class="bottomIcon setPointer" onclick=""/>

                            <img src="img/refresh.png" class="bottomIcon setPointer" onclick=""/>
                        </div>
                    </div>

                </div>
                <div style="width:100%;height:100px"></div>
            </div>
            <!-- 项目管理-->
            <div class="mainDivSon" id="manageProjectDiv">
                <div class="divSonTitle">
                    <div class="divSonTitleImg">
                        <img src="img/box-login.png" class="sonTitleImg setPointer" onclick=""/>
                    </div>

                    <div class="divSonIconBar">
                        <img src="img/small.png" class="sonTitleIcon setPointer" onclick="shideSon('manageProjectDiv')"/>

                        <img src="img/refresh.png" class="sonTitleIcon setPointer" onclick=""/>
                    </div>
                </div>
                <div class="projectShowBarHider" style="width:80%;overflow:hidden;margin-left: auto;margin-right: auto">
                    <div id="projectManageBar" class="projectShowBar">
                        <div class="projectShowDiv projectManageDiv" onclick="showProjectMan('面码')">
                            <div class="projectManageName">项目1</div>
                            <div class="projectShowCreater threeBorder">肖瑞</div>
                            <div class="projectShowText threeBorder">别逼一个最爱你的人即兴表演</div>
                        </div>
                        <div class="projectShowDiv projectManageDiv" onclick="showProjectMan('面码')">
                            <div class="projectManageName">项目1</div>
                            <div class="projectShowCreater threeBorder">肖瑞</div>
                            <div class="projectShowText threeBorder">别逼一个最爱你的人即兴表演</div>
                        </div>
                        <div class="projectShowDiv projectManageDiv" onclick="showProjectMan('面码')">
                            <div class="projectManageName">项目1</div>
                            <div class="projectShowCreater threeBorder">肖瑞</div>
                            <div class="projectShowText threeBorder">别逼一个最爱你的人即兴表演</div>
                        </div>
                        <div class="projectShowDiv projectManageDiv" onclick="showProjectMan('面码')">
                            <div class="projectManageName">项目1</div>
                            <div class="projectShowCreater threeBorder">肖瑞</div>
                            <div class="projectShowText threeBorder">别逼一个最爱你的人即兴表演</div>
                        </div>
                        <div class="projectShowDiv projectManageDiv" onclick="showProjectMan('面码')">
                            <div class="projectManageName">项目1</div>
                            <div class="projectShowCreater threeBorder">肖瑞</div>
                            <div class="projectShowText threeBorder">别逼一个最爱你的人即兴表演</div>
                        </div>
                        <div class="projectShowDiv projectManageDiv" onclick="showProjectMan('面码')">
                            <div class="projectManageName">项目1</div>
                            <div class="projectShowCreater threeBorder">肖瑞</div>
                            <div class="projectShowText threeBorder">别逼一个最爱你的人即兴表演</div>
                        </div>
                        <div class="projectShowDiv projectManageDiv" onclick="showProjectMan('面码')">
                            <div class="projectManageName">项目1</div>
                            <div class="projectShowCreater threeBorder">肖瑞</div>
                            <div class="projectShowText threeBorder">别逼一个最爱你的人即兴表演</div>
                        </div>
                        <div class="projectShowDiv projectManageDiv" onclick="showProjectMan('面码')">
                            <div class="projectManageName">项目1</div>
                            <div class="projectShowCreater threeBorder">肖瑞</div>
                            <div class="projectShowText threeBorder">别逼一个最爱你的人即兴表演</div>
                        </div>
                        <div class="projectShowDiv projectManageDiv" onclick="showProjectMan('面码')">
                            <div class="projectManageName">项目1</div>
                            <div class="projectShowCreater threeBorder">肖瑞</div>
                            <div class="projectShowText threeBorder">别逼一个最爱你的人即兴表演</div>
                        </div>
                        <div class="projectShowDiv projectManageDiv" onclick="showProjectMan('面码')">
                            <div class="projectManageName">项目1</div>
                            <div class="projectShowCreater threeBorder">肖瑞</div>
                            <div class="projectShowText threeBorder">别逼一个最爱你的人即兴表演</div>
                        </div>
                    </div>
                </div>

                <div id="projectManageContant" class="projectCard">

                    <div class="proLeft">
                        <div class="proLeftName">
                            <div class="proLeftNameShow">
                                项目1
                            </div>
                        </div>
                        <div class="proLeftMid"></div>
                        <div class="proLeftShow">
                            <div class="riskListShow">
                                <table class="riskListTab" cellspacing="10" border="0">
                                    <tr> <th>码农1列表</th></tr>
                                    <tr> <td>码农1</td></tr>
                                    <tr> <td>码农1</td></tr>
                                    <tr> <td>码农1</td></tr>
                                    <tr> <td>码农1</td></tr>
                                    <tr> <td>码农1</td></tr>
                                    <tr> <td>码农1</td></tr>
                                    <tr> <td>码农1</td></tr>
                                    <tr> <td>码农1</td></tr>
                                    <tr> <td>码农1</td></tr>
                                    <tr> <td>码农1</td></tr>
                                    <tr> <td>码农1</td></tr>
                                    <tr> <td>码农1</td></tr>
                                    <tr> <td>码农1</td></tr>
                                    <tr> <td>码农1</td></tr>
                                    <tr> <td>码农1</td></tr>
                                    <tr> <td>码农1</td></tr>
                                    <tr> <td>码农1</td></tr>
                                    <tr> <td>码农1</td></tr>
                                    <tr> <td>码农1</td></tr>
                                    <tr> <td>码农1</td></tr>
                                    <tr> <td>码农1</td></tr>
                                    <tr> <td>码农1</td></tr>
                                    <tr> <td>码农1</td></tr>
                                    <tr> <td>+</td></tr>
                                </table>
                            </div>
                        </div>
                    </div>
                    <div class="proMid">

                    </div>
                    <div class="proRight">
                        <div>
                            <img src="img/small.png" class="sonTitleIcon setPointer" style="margin-top:0px;" onclick="hideProMan()">
                            <div class="proRightTitle">码农1</div>
                            <div class="riskListShow" style="height:500px;margin-top: 30px">
                                <table class="riskListTab riskShowTab" cellspacing="10" border="0">
                                    <tr> <th colspan="2">权限列表</th></tr>
                                    <tr><td>查看</td> <td>不可</td></tr>
                                    <tr><td>修改</td> <td>不可</td></tr>
                                    <tr><td>查看</td> <td>不可</td></tr>
                                    <tr><td>修改</td> <td>不可</td></tr>
                                    <tr><td>查看</td> <td>不可</td></tr>
                                    <tr><td>修改</td> <td>不可</td></tr>
                                    <tr><td>查看</td> <td>不可</td></tr>
                                    <tr><td>修改</td> <td>不可</td></tr>
                                    <tr><td>查看</td> <td>不可</td></tr>
                                    <tr><td>修改</td> <td>不可</td></tr>
                                    <tr><td>查看</td> <td>不可</td></tr>
                                    <tr><td>修改</td> <td>不可</td></tr>
                                    <tr><td>查看</td> <td>不可</td></tr>
                                    <tr><td>修改</td> <td>不可</td></tr>

                                    <tr> <td colspan="2">+</td></tr>
                                </table>
                            </div>
                        </div>

                        <div style="margin-top: 0px">
                            <img src="img/refresh.png" class="bottomIcon setPointer" onclick=""/>

                            <img src="img/small.png" class="bottomIcon setPointer" onclick=""/>

                            <img src="img/refresh.png" class="bottomIcon setPointer" onclick=""/>
                        </div>
                    </div>

                </div>

                <div style="width:100%;height:100px"></div>
                </div>
            <!-- 新建账号-->
            <div class="mainDiv">
                <div class="mainDivSon" id="newAccountDiv">
                    <div class="divSonTitle">
                        <div class="divSonTitleImg">
                            <img src="img/box-login.png" class="sonTitleImg setPointer" onclick=""/>
                        </div>
                        <div class="divSonIconBar">
                            <img src="img/small.png" class="sonTitleIcon setPointer" onclick="shideSon('newAccountDiv')"/>

                            <img src="img/refresh.png" class="sonTitleIcon setPointer" onclick=""/>
                        </div>
                    </div>

                    <div style="margin-top: 100px;">
                        <div class="contanter bottomLine newProjectInputer" style="width:300px">
                            <input class="contantInputer newProName" type="text" placeholder="在这里输入新的用户名"/>
                        </div>

                        <div class="contanter bottomLine newProjectInputer" style="width:300px">
                            <input class="contantInputer newProName" type="password" placeholder="在这里输入用户密码"/>
                        </div>

                        <div class="contanter bottomLine newProjectInputer" style="width:300px">
                            <input class="contantInputer newProName" type="password" placeholder="在这里确认用户密码"/>
                        </div>

                        <div class="newProjectIconBar">

                            <img src="img/yes.png" class="newProjectIcon setPointer" onclick=""/>
                            <img src="img/delete.png" class="newProjectIcon setPointer" onclick=""/>

                        </div>
                    </div>

                </div>
                <!--账号管理-->
                <div class="mainDivSon" id="accountMnage">
                    <div class="divSonTitle">
                        <div class="divSonTitleImg">
                            <img src="img/box-login.png" class="sonTitleImg setPointer" onclick=""/>
                        </div>
                        <div class="divSonIconBar">
                            <img src="img/small.png" class="sonTitleIcon setPointer" onclick="shideSon('accountMnage')"/>

                            <img src="img/refresh.png" class="sonTitleIcon setPointer" onclick=""/>
                        </div>
                    </div>

                    <div style="width:880px;margin-top:100px;height:700px;margin-left: auto;margin-right:auto;">
                        <div class="accountBox">这 </div>
                        <div class="accountBox">个 </div>
                        <div class="accountBox">功 </div>
                        <div class="accountBox">能 </div>
                        <div class="accountBox">还 </div>
                        <div class="accountBox">没 </div>
                        <div class="accountBox">来 </div>
                        <div class="accountBox">的 </div>
                        <div class="accountBox">及 </div>
                        <div class="accountBox">完 </div>
                        <div class="accountBox">成 </div>
                    </div>
                </div>

            </div>
        </div>
        <div class="bottomDiv">
        </div>
        <script>

        </script>
    </body>
</html>
