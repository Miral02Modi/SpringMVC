<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" isELIgnored="false"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
<script>
	$(document).ready(function() {
		var data = {};
	
		$("input").keyup(function() {
			
			data.email = $("#email").val();
			console.log("inside keyPress" + data.email);
			if(data.email ==  ""){
				$("#ajaxResponce").text("");
				return;
			}
			$.ajax({
				url : 'http://localhost:8080/MvcDatabase/dataCheck',
				data : data,
				type : 'post',
				success : function(message) {
											
					 if(message == 0){
							$("#ajaxResponce").text("available")
					}else{
						$("#ajaxResponce").text("unavailable")
					}
				},
				error : function() {
					console.log("error");
				}
			});
		});
	});
</script>

</head>

<body>
	Successfull... ${status}
	<form>
		<input type="text" id="email" name="email">
		<p id="ajaxResponce"></p>
		<!-- <p>
			Keypresses: <span>0</span>
		</p> -->
	</form>
	<div id="ajaxResponce1" autocomplete="off">Ajax megic</div>

</body>
</html>