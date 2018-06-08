<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles"%>


<section class="content-header">
       <span class="nav-title">分类列表</span>
</section>
<section class="content">
	<div class="row">
		<div class="col-md-12">
			<form class="form form-horizontal" method="POST" id="form" action="/category/list_data">
				<div class="form-group">
					<label class="control-label col-xs-4 col-md-2">关键字</label>						
					<div class="col-xs-8 col-md-3">
						<input type="text" class="form-control" placeholder="请输入关键字进行查询" maxlength="50" id="keyword">
					</div>
					<label class="control-label col-xs-4 col-md-2">应用分类</label>						
					<div class="col-xs-8 col-md-3">
						<select class="form-control fpx-select-nosearch" id="appType">
							<option value="-1">全部</option>
							<c:forEach var="appCategory" items="${lstCategory}">
								<option value="${appCategory.code}">${appCategory.name}</option>							
							</c:forEach>
						</select>
					</div>
				</div>
				<div class="form-group">
					<label class="control-label col-xs-4 col-md-2">所属分类</label>						
					<div class="col-xs-8 col-md-3">
						<select class="form-control fpx-select-nosearch" id="category">
							<option value="-1">全部</option>
							<c:forEach var="appType" items="${lstAppType}">
								<option value="${appType.value}">${appType.name}</option>							
							</c:forEach>
						</select>
					</div>
					<label class="control-label col-xs-4 col-md-2">所属业务</label>						
					<div class="col-xs-8 col-md-3">
						<select class="form-control fpx-select-nosearch" id="busiType">
							<option value="-1">全部</option>
							<c:forEach var="businessType" items="${lstBusinessType}">
								<option value="${businessType.id}">${businessType.name}</option>							
							</c:forEach>
						</select>
					</div>
					<div class="col-xs-6 col-md-2 text-left">
						<button type="button" class="btn btn-primary btn-submit">查询</button>
					</div>
				</div>
			</form>
		</div>
	</div>
		  	
	<div class="row">
		<div class="col-md-12" id="tableWraper">
			<tiles:insertAttribute name="category.list.data" />
		</div>
	</div>
</section>

