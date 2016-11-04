<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>

<c:import url="./_head.jsp" var="head">
	<c:param name="title" value="Users Statistics | GitMining"/>
</c:import>
${head}

<body>

<div class="app">

	<c:import url="./_topbar.jsp" var="topbar">
		<c:param name="searchType" value="User"/>
	</c:import>
	${topbar}

	<c:import url="./_sidebar.jsp" var="sidebar">
		<c:param name="activeItem" value="User-Statistics"/>
	</c:import>
	${sidebar}

	<div class="main">
		<div class="header">
			<h1>Users Statistics</h1>
			<div class="options">
			</div>
		</div>
		<div class="content">
			<div class="list">
				<div class="item">
					<div class="item-title">Users' Companies</div>
					<div style="width: 800px;height: 550px;" class="item-image" id="userCom"></div>
				</div>
				<div class="item">
					<div class="item-title">Users' Types</div>
					<div style="width: 800px;height: 550px;" class="item-image" id="userType"></div>
				</div>
				<div class="item">
					<div class="item-title">Users' Repositories</div>
					<div style="width: 800px;height: 550px;" class="item-image" id="userRepo"></div>
				</div>
				<div class="item">
					<div class="item-title">Users' Gists</div>
					<div style="width: 800px;height: 550px;" class="item-image" id="userGist"></div>
				</div>
				<div class="item">
					<div class="item-title">Users' Followers</div>
					<div style="width: 800px;height: 550px;" class="item-image" id="userFollower"></div>
				</div>
				<div class="item">
					<div class="item-title">Users' Followings</div>
					<div style="width: 800px;height: 550px;" class="item-image" id="userFollowing"></div>
				</div>
			</div>
		</div>
	</div>
</div>

<c:import url="./_script.jsp" var="script"></c:import>
${script}

<script type="text/javascript">
	//user's companies
	var comName = ${comName};
	var comData = ${comData};
	//users' types
	var typeName = ${typeName};
	var typeData = ${typeData};
	//柱状图 users' repo
	var repoNum = ${repoNum}
	var repoData = ${repoData}
	//柱状图 users' gist
	var gistNum = ${gistNum}
	var gistData = ${gistData}
	//柱状图 users' follower
	var followerNum = ${followerNum}
	var followerData = ${followerData}
	//柱状图 users' following
	var followingNum = ${followingNum}
	var followingData = ${followingData}
</script>
<script src="/assets/js/user-stats.js"></script>

</body>
</html>