<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page import="java.util.*"%>
<%@ page import="dawuHomework.emp.entity.Emp"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>汽車安裝服務 - 申訴管理清單</title>
<style>
body {
	font-family: "Microsoft JhengHei", sans-serif;
	margin: 20px;
	background-color: #f8f9fa;
}

table {
	width: 100%;
	border-collapse: collapse;
	margin-top: 20px;
	background-color: white;
	box-shadow: 0 2px 10px rgba(0, 0, 0, 0.1);
}

th, td {
	padding: 12px;
	border: 1px solid #dee2e6;
	text-align: left;
	vertical-align: middle;
}

th {
	background-color: #007bff;
	color: white;
}

tr:nth-child(even) {
	background-color: #f2f2f2;
}

tr:hover {
	background-color: #e9ecef;
}

.img-preview {
	max-width: 100px;
	max-height: 100px;
	border-radius: 4px;
	border: 1px solid #ddd;
}

.edit-btn {
	background-color: #ffc107;
	border: none;
	padding: 6px 12px;
	border-radius: 4px;
	cursor: pointer;
	font-weight: bold;
}
</style>
</head>
<body>

	<div
		style="border-bottom: 2px solid #007bff; padding-bottom: 10px; margin-bottom: 20px;">
		<h2>汽車安裝服務 - 申訴案件管理中心</h2>
	</div>

	<table>
		<thead>
			<tr>
				<th>案件編號</th>
				<th>會員編號</th>
				<th>訂單編號</th>
				<th>申訴原因</th>
				<th>詳細描述</th>
				<th>證明照片</th>
				<th>提交日期</th>
				<th>案件狀態</th>
				<th>操作</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach var="emp" items="${empList}">
				<tr>
					<td>${emp.empno}</td>
					<td>${emp.comm}</td>
					<td>${emp.sal}</td>
					<td>${emp.job}</td>
					<td>${emp.ename}</td>
					<td><c:if test="${not empty emp.attachment}">
							<img
								src="${pageContext.request.contextPath}/emp/emp.do?action=getPic&empno=${emp.empno}"
								class="img-preview">
						</c:if> <c:if test="${empty emp.attachment}">無圖片</c:if></td>
					<td>${emp.hiredate}</td>
					<td style="color: green; font-weight: bold;">待處理</td>
					<td>
						<form method="post"
							action="${pageContext.request.contextPath}/emp/emp.do">
							<input type="hidden" name="empno" value="${emp.empno}"> <input
								type="hidden" name="action" value="getOne_For_Update">
							<button type="submit" class="edit-btn">編輯/調整</button>
						</form>
					</td>
				</tr>
			</c:forEach>
		</tbody>
	</table>

	<div style="margin-top: 20px;">
		<a href="${pageContext.request.contextPath}/dawuHomework.jsp">←
			返回提交新申訴案件</a>
	</div>

</body>
</html>