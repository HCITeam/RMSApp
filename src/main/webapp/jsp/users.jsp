<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>

<c:import url="./_head.jsp" var="head">
   <c:param name="title" value="Users | GitMining"/>
</c:import>
${head}

<body>

<div class="app">

<c:import url="./_topbar.jsp" var="topbar">
   <c:param name="searchType" value="User"/>
</c:import>
${topbar}

<c:import url="./_sidebar.jsp" var="sidebar">
   <c:param name="activeItem" value="User-Users"/>
</c:import>
${sidebar}

<div class="main">
	<div class="header">
		<h1>Users<span class="btn-filter on"><i class="fa fa-filter" aria-hidden="true"></i>Filter</span></h1>
		<div class="filters-wrapper">
			<div class="filters-section">
				<h2>Language: </h2>
				<a class="filter active">ALL</a>
				<c:forEach items="${languages}" var="language">
				<a class="filter">${language}</a>
				</c:forEach>
			</div>
			<div class="filters-section">
				<h2>Create Time: </h2>
				<a class="filter active">ALL</a>
				<c:forEach items="${years}" var="year">
				<a class="filter">${year}</a>
				</c:forEach>
			</div>
		</div>
		<div class="options">
			<a class="option active">ALL</a>
			<a class="option">FOLLOWERS ▼</a>
			<a class="option">REPOSITORIES ▼</a>
		</div>
	</div>
	<div class="content">
		<div class="board">
			<div class="card grid-3-4 grid-2-3-md grid-1-1-sm">
				<div class="card-wrapper">
				<c:forEach items="${list}" var="item">
					<div class="item">
						<div class="avatar"><img src=""></div>
						<div class="sibling">
							<a class="item-title">${item.name}</a>
							<div class="item-line">
								<span><i class="fa fa-users fa-fw" aria-hidden="true"></i>${item.followers}</span>
								<span><i class="fa fa-github-alt fa-fw" aria-hidden="true"></i>${item.repos}</span>
							</div>
							<div class="item-line">
								<c:if test="${!empty item.location}"><span><i class="fa fa-map-marker fa-fw" aria-hidden="true"></i>${item.location}</span></c:if>
								<c:if test="${!empty item.email}"><span><i class="fa fa-envelope fa-fw" aria-hidden="true"></i>${item.email}</span></c:if>
								<span><i class="fa fa-clock-o fa-fw" aria-hidden="true"></i>Join on ${item.joinTime}</span>
							</div>
						</div>
					</div>
				</c:forEach>
				</div>
			</div>

			<div class="card grid-1-4 grid-1-3-md hidden-sm">
				<div class="card-wrapper">
					<div class="card-title">
						Featured Recommendations
					</div>
					<div class="card-content">
					<c:forEach items="${recommendations}" var="item">
						<div class="item">
							<div class="avatar avatar-s"><img src=""></div>
							<div class="sibling">
								<a class="item-title">${item.name}</a>
								<div class="item-line">
									<span><i class="fa fa-users fa-fw" aria-hidden="true"></i>${item.followers}</span>
									<span><i class="fa fa-github-alt fa-fw" aria-hidden="true"></i>${item.repos}</span>
								</div>
							</div>
						</div>
					</c:forEach>
					</div>
				</div>
				<div class="card-wrapper">
					<div class="card-title">
						Top 5 Users
					</div>
					<div class="card-content">
					<c:forEach items="${tops}" var="item">
						<div class="item">
							<div class="avatar avatar-s"><img src=""></div>
							<div class="sibling">
								<a class="item-title">${item.name}</a>
								<div class="item-line">
									<span><i class="fa fa-users fa-fw" aria-hidden="true"></i>${item.followers}</span>
									<span><i class="fa fa-github-alt fa-fw" aria-hidden="true"></i>${item.repos}</span>
								</div>
							</div>
						</div>
					</c:forEach>
					</div>
				</div>
			</div>
		</div>
	</div>
	<div class="footer">
		<div class="pages">
			<a class="page">&lt;</a>
			<c:forEach items="${pages}" var="page">
			<a class="page${page == currentPage ? ' active' : ''}${page == '...' ? ' disable' : ''}">${page}</a>
			</c:forEach>
			<a class="page">&gt;</a>
		</div>
	</div>
</div>

</div>

<c:import url="./_script.jsp" var="script"></c:import>
${script}

<script>
	$(document).ready(function() {
		// Filter
		var $filters = $(".filters");
		$(".btn-filter").click(function(event) {
			if ($(this).hasClass("on")) {
				$(this).removeClass("on");
				$filters.slideUp();
			} else {
				$(this).addClass("on");
				$filters.slideDown();
			}
		});
	});
</script>

</body>
</html>