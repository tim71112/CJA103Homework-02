<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta http-equiv="refresh"
	content="3;url=${pageContext.request.contextPath}/dawuHomework.jsp">
<title>提交成功</title>
<style>
body {
	font-family: "Microsoft JhengHei", sans-serif;
	display: flex;
	justify-content: center;
	align-items: center;
	height: 100vh;
	margin: 0;
	background-color: #f4f7f6;
}

.card {
	background: white;
	padding: 40px;
	border-radius: 10px;
	box-shadow: 0 4px 15px rgba(0, 0, 0, 0.1);
	text-align: center;
}

h2 {
	color: #28a745;
}

p {
	color: #666;
}

.loader {
	border: 4px solid #f3f3f3;
	border-top: 4px solid #3498db;
	border-radius: 50%;
	width: 30px;
	height: 30px;
	animation: spin 2s linear infinite;
	margin: 20px auto;
}

@
keyframes spin { 0% {
	transform: rotate(0deg);
}
100
%
{
transform
:
rotate(
360deg
);
}
}
</style>
</head>
<body>
	<div class="card">
		<h2>🎉 提交成功！</h2>
		<p>我們已經收到你的訴求，將會盡快為您處理。</p>
		<div class="loader"></div>
		<p style="font-size: 0.8em; color: #999;">
			系統將在 3 秒後自動導向提交頁面...<br> <a
				href="${pageContext.request.contextPath}/dawuHomework.jsp">點擊此處立即返回</a>
		</p>
	</div>
</body>
</html>