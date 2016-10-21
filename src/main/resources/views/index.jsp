<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<script language="JavaScript" src="assets/js/jquery-3.1.1.js"></script>
<script type="text/javascript">
	$(function(){ 
		//alert(" on load ! ");
	}); 

	function hello(){
		alert("hello world ! ");
	}
</script>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Spring mvc 用例</title>
	12  ASYNC测试 <a href="${pageContext.request.contextPath}/async/defer">ASYNC测试 /async/defer"</a> <br/>
	11  SSE测试 <a href="${pageContext.request.contextPath}/sse">SSE测试 /sse" </a> <br/>
	10> 文件上传 
			<div>
				<form action="${pageContext.request.contextPath}/upload/file" enctype="multipart/form-data" method="post">
					<input type="file" name="file">  	
					<button type="submit" value = "上传" /> 上传</button>
				</form>
			</div>
	9> <a href='${pageContext.request.contextPath}/advice/err?id=100&name=营销管理'> AdviceController 测试链接 > /advice/err?id=100&name=营销管理 </a><br/>
	8> 静态资源访问(导入jquery脚本)：<button onclick="hello()">脚本测试</button><br/>
	7> <a href='${pageContext.request.contextPath}/book/returnJson.json?id=122'> 测试返回Json > /book/returnJson.json?id=122 </a><br/>
	6> <a href='${pageContext.request.contextPath}/book/name1'> 测试链接1 > /book/name1 </a>    测试链接2    <a href='${pageContext.request.contextPath}/book/name2'>  > /book/name2 </a><br/>
	5> <a href='${pageContext.request.contextPath}/book/book?id=123&name=营销管理书'> 测试链接 > /book/book?id=100&name=营销管理书 </a><br/>
	4> <a href='${pageContext.request.contextPath}/book/reqparam?id=123'> 测试链接 > /book/reqparam?id=123 </a><br/>
	3> <a href='${pageContext.request.contextPath}/book/pathvar/参数A'> 测试链接 > /book/pathvar/参数A </a><br/>
	2> <a href='${pageContext.request.contextPath}/book'> 测试链接 > /book </a><br/>
	1> <a href='${pageContext.request.contextPath}/'> 首页1 > / </a>  快捷配置： <a href='${pageContext.request.contextPath}/index'> 首页2 /index  </a>
</head>
<body>

</body>
</html>