<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page import="dawuHomework.emp.entity.Emp"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>汽車安裝服務 - 修改申訴案件</title>
<style>
body {
	font-family: "Microsoft JhengHei", sans-serif;
	margin: 20px;
	line-height: 1.6;
}

.error {
	color: red;
}

.form-group {
	margin-bottom: 15px;
}

.btn-submit {
	background-color: #007bff;
	color: white;
	border: none;
	padding: 8px 16px;
	border-radius: 4px;
	cursor: pointer;
}
</style>
</head>
<body>

	<h2>修改申訴案件內容 (案件編號：${emp.empno})</h2>

	<c:if test="${not empty errorMsgs}">
		<ul class="error">
			<c:forEach var="message" items="${errorMsgs}">
				<li>${message}</li>
			</c:forEach>
		</ul>
	</c:if>

	<form method="post"
		action="${pageContext.request.contextPath}/emp/emp.do">
		<div class="form-group">
			<strong>會員編號：</strong> ${emp.comm}
		</div>

		<div class="form-group">
			<strong>訂單編號：</strong> ${emp.sal}
		</div>

		<div class="form-group">
			<strong>申訴原因（可重新調整多選）：</strong><br> <input type="checkbox"
				name="job" value="技術人員態度不佳"
				${emp.job.contains('技術人員態度不佳') ? 'checked' : ''}> 技術人員態度不佳 <input
				type="checkbox" name="job" value="安裝品質不良"
				${emp.job.contains('安裝品質不良') ? 'checked' : ''}> 安裝品質不良 <input
				type="checkbox" name="job" value="技師遲到/未到"
				${emp.job.contains('技師遲到/未到') ? 'checked' : ''}> 技師遲到/未到 <input
				type="checkbox" name="job" value="收費與報價不符"
				${emp.job.contains('收費與報價不符') ? 'checked' : ''}> 收費與報價不符
		</div>

		<div class="form-group">
			<strong>詳細內容描述：</strong><br>
			<textarea name="ename" rows="5" cols="50" required>${emp.ename}</textarea>
		</div>

		<input type="hidden" name="empno" value="${emp.empno}"> <input
			type="hidden" name="action" value="update">

		<button type="submit" class="btn-submit">確認修改</button>
		<a href="${pageContext.request.contextPath}/emp/emp.do?action=getAll"
			style="margin-left: 10px;">取消並返回</a>
	</form>

</body>
</html>