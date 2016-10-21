<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>SSE （Server Send Event）服務器端发送事件</title>
</head>
<body>
	<div id = "msgFromPush">
		aaaaaaaaaaaaaaaaaa
	</div>


<script language="JavaScript" src="assets/js/jquery-3.1.1.js"></script>
<script type="text/javascript">
	$(function(){ 
		//alert(" on load ! "); 
	}); 

	if(!!window.EventSource){
		var s ="";
		var source = new EventSource('sse/push');
		
		source.addEventListener('message',function(e){
			s += e.data + "<br/>";
			$("#msgFromPush").html(s);
		});
		
		source.addEventListener('open',function(e){
			console.log('open连接打开.');
		},false);
		
		source.addEventListener('error',function(e){
			if(e.srcElement.readyState == EventSource.CLOSED){
				console.log('连接关闭');
			}else{
				console.log('error='+e.srcElement.readyState);
			}
		},false);
	}else{
		console.log('你的浏览器不支持SSE');
	}
</script>
</body>
</html>