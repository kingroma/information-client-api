<%@ page language="java" contentType="text/html; charset=UTF-8"  pageEncoding="UTF-8"%>
<%@ taglib prefix="c"   uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Program</title>
<style>
	thead tr td{
		border: 2px solid black;
	}
</style>
</head>
<body>
<table style="width:100%">
	<colgroup>
		<col width="10%"/>
		<col width="15%"/>
		<col width="15%"/>
		<col width="10%"/>
		<col width="5%"/>
		<col width="5%"/>
	</colgroup>
	<thead>
		<tr>
			<td>programId</td>
			<td>title</td>
			<td>synopsis</td>
			<td>programType</td>
			<td>genreCount</td>
			<td>productCount</td>
		</tr>
	</thead>
	<c:forEach var="r" varStatus="s" items="${list.result}" >
		<tbody>	
			<tr>
				<td>${r.programId }</td>
				<td>${r.title }</td>
				<td>${r.synopsis }</td>
				<td>${r.programType }</td>
				<td><c:if test="${r.genres != null }">${r.genres.size() }</c:if></td>
				<td><c:if test="${r.products != null }">${r.products.size() }</c:if></td>
			</tr>	
		</tbody>
	</c:forEach>
</table>
</body>
</html>