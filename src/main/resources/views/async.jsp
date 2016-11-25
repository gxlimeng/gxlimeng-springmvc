<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
    	
    	<script type="text/javascript" src="assets/js/jquery-3.1.1.js"></script>
    	<script type="text/javascript">

    		deferred();
    		
    		function deferred(){
    			$.get('async/defer',function(data){
    				console.log(data);
    				deferred();
    			});
    		}
    		
    	</script>
 	</body>
</html>