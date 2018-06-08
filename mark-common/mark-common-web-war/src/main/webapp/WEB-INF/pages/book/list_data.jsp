<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles"%>

<c:set var="hasResult" value="${!empty pagination.data and fn:length(pagination.data)>=1}"/>	

<table class="table table-bordered table-striped mam-table-fixed mam-centertable"style="width:100%;">
	<thead>
		<tr>
			<th>分类代码</th>
			<th>中文名称</th>
			<th>英文名称</th>
			<th>创建人</th>
			<th>创建时间</th>
			<th>修改人</th>
			<th>修改时间</th>
			<th>操作</th>
		</tr>
	</thead>
	<tbody>
		<c:forEach var="category" items="${pagination.data}">
			<tr>
				<td>${category.code}</td>
				<td>${category.name}</td>
				<td>${category.enName}</td>
				<td>${category.creatorName}</td>
				<td>${category.createTime}</td>
				<td>${category.modifierName}</td>
				<td>${category.modifyTime}</td>
				<td>
					<span class="iconfont icon-edit" data-id="${category.id}"></span>
					<span class="iconfont icon-delete" data-id="${category.id}"></span>
				</td>
			</tr>
		</c:forEach>
	</tbody>
</table>

<c:if test="${hasResult}">
	<div class="row">
		<div class="col-xs-12">
		</div>
	</div>
</c:if>

