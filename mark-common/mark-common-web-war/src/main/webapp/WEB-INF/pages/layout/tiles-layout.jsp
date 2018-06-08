<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<tiles:importAttribute name="scripts" />
<tiles:importAttribute name="stylesheets" />
<c:set var="CTX" value="${pageContext.request.contextPath }" />
<c:set var="version" value="0.0.1" />

<!DOCTYPE html>
<html lang="en">
<head>
	<meta charset="utf-8">
	<meta name="viewport" content="width=device-width, initial-scale=1.0, maximum-scale=1.0">
	<meta name="keywords" content="mark's sample web">
	<meta name="description" content="">
	<meta name="author" content="ThemeBucket">
	<link rel="shortcut icon" href="${CTX }/images/favicon.ico" type="image/x-icon" />
	
	<title><tiles:insertAttribute name="title" ignore="true" /></title>
	
	<script type="text/javascript">
		var FPX = window.FPX || {};
		FPX.CTX = '${CTX}';
		FPX.MAM = {};
	</script>
	<c:forEach var="stylesheet" items="${stylesheets}">
		<link rel="stylesheet" type="text/css" href="${CTX }${stylesheet}?_v=${version}" />
	</c:forEach>
	
</head>

<body class="sticky-header">

<section>
    <!-- left side start-->
    <div class="left-side sticky-left-side">
		<tiles:insertAttribute name="sidebar" />
    </div>
    <!-- left side end-->
    
    <!-- main content start-->
    <div class="main-content" >

        <!-- header section start-->
        <div class="header-section">
			<tiles:insertAttribute name="header" />
        </div>
        <!-- header section end-->

        <!--body wrapper start-->
        <div class="wrapper">
            <tiles:insertAttribute name="content" />
        </div>
        <!--body wrapper end-->

        <!--footer section start-->
        	<tiles:insertAttribute name="footer" />
        <!--footer section end-->
    </div>
    <!-- main content end-->
</section>

	<c:forEach items="${scripts}" var="script">
		<script type="text/javascript" src="${CTX }${script}?_v=${version}"></script>
	</c:forEach>
		
	<!-- HTML5 shim and Respond.js IE8 support of HTML5 elements and media queries -->
	<!--[if lt IE 9]>
		<script src="http://cdn.mark.ah.cn/html5shiv/3.7.2/html5.min.js"></script>
		<script src="http://cdn.mark.ah.cn/respond/1.4.2/respond.min.js"></script>
	<![endif]-->
	
</body>
</html>