<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>汽車安裝服務 - 提交申訴案件</title>
<style>
body {
	font-family: "Microsoft JhengHei", sans-serif;
	margin: 30px;
	background-color: #f4f7f6;
}

.container {
	background: white;
	padding: 25px;
	border-radius: 8px;
	box-shadow: 0 2px 10px rgba(0, 0, 0, 0.1);
	max-width: 600px;
	margin: auto;
}

h2 {
	color: #333;
	border-bottom: 2px solid #007bff;
	padding-bottom: 10px;
}

.error-box {
	background-color: #ffebee;
	color: #c62828;
	padding: 10px;
	border-radius: 4px;
	margin-bottom: 20px;
}

.form-item {
	margin-bottom: 20px;
}

label {
	font-weight: bold;
	display: block;
	margin-bottom: 8px;
}

input[type="text"], textarea {
	width: 100%;
	padding: 10px;
	border: 1px solid #ccc;
	border-radius: 4px;
	box-sizing: border-box;
}

.checkbox-group {
	background: #fafafa;
	padding: 15px;
	border-radius: 4px;
	border: 1px solid #eee;
}

.checkbox-group input {
	margin-right: 10px;
}

.btn-send {
	background-color: #28a745;
	color: white;
	border: none;
	padding: 12px 24px;
	border-radius: 4px;
	cursor: pointer;
	font-size: 16px;
	width: 100%;
}

.btn-send:hover {
	background-color: #218838;
}
</style>
</head>
<body>

	<div class="container">
		<h2>提交新申訴案件</h2>

		<c:if test="${not empty errorMsgs}">
			<div class="error-box">
				<strong>請修正以下錯誤：</strong>
				<ul>
					<c:forEach var="message" items="${errorMsgs}">
						<li>${message}</li>
					</c:forEach>
				</ul>
			</div>
		</c:if>

		<form method="post"
			action="${pageContext.request.contextPath}/emp/emp.do"
			enctype="multipart/form-data">

			<div class="form-item">
				<label>會員編號：</label> <input type="text" name="comm"
					value="${param.comm}" placeholder="請輸入會員編號">
			</div>

			<div class="form-item">
				<label>安裝訂單編號 <span style="color: red;">*必填</span>：
				</label> <input type="text" name="sal" value="${param.sal}"
					placeholder="範例：1001">
			</div>

			<div class="form-item">
				<label>申訴原因 (可多選)：</label>
				<div class="checkbox-group">
					<label><input type="checkbox" name="job" value="技術人員態度不佳">
						技術人員態度不佳</label> <label><input type="checkbox" name="job"
						value="安裝品質不良"> 安裝品質不良</label> <label><input
						type="checkbox" name="job" value="技師遲到/未到"> 技師遲到/未到</label> <label><input
						type="checkbox" name="job" value="收費與報價不符"> 收費與報價不符</label>
				</div>
			</div>

			<div class="form-item">
				<label>詳細內容描述 <span style="color: red;">*必填</span>：
				</label>
				<textarea name="ename" rows="5" placeholder="請詳細說明經過...">${param.ename}</textarea>
			</div>

			<div class="form-item">
				<label>上傳現場證明照片：</label> <input type="file" name="up_file">
			</div>

			<input type="hidden" name="action" value="insert">
			<button type="submit" class="btn-send">送出申訴案件</button>

			<div style="margin-top: 20px; text-align: center;">
				<a
					href="${pageContext.request.contextPath}/emp/emp.do?action=getAll">進入申訴案件管理中心</a>
			</div>
		</form>
	</div>

</body>
</html>