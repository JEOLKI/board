<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<!-- The above 3 meta tags *must* come first in the head; any other head content must come *after* these tags -->
<meta name="description" content="">
<meta name="author" content="">
<!-- <link rel="icon" href="../../favicon.ico"> -->

<title>Signin Template for Bootstrap</title>

<!-- Bootstrap core CSS -->
<link href="${pageContext.request.contextPath }/css/bootstrap.min.css" rel="stylesheet">

<!-- Custom styles for this template -->
<link href="${pageContext.request.contextPath }/css/signin.css" rel="stylesheet">

<script type="text/javascript" src="${pageContext.request.contextPath }/js/js.cookie-2.2.1.min.js"></script>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>


<script type="text/javascript">

	function getCookieValue(cookieName){

		// 자바 스크립트 로직
		var cookies = document.cookie.split("; ")
		
		for(var i = 0 ; i < cookies.length ; i++) {
			
			var cookie = cookies[i].split("=");
			
			if(cookie[0] == cookieName) {
				console.log(cookie[1]);
			}
		}

		//원하는 쿠키가 없는경우
		return "";
		
	}

	function setCookie(cookieName, cookieValue, expires) {

		var today = new Date();

		// 현재날짜에서 미래로 + expires 만큼 한 날짜 구하기
		today.setDate(today.getDate() + expires);

		document.cookie = cookieName + "=" + cookieValue + "; path=/; expires="+ today.toGMTString();

		console.log(document.cookie)
		
	}

	// 해당 쿠키의 expires속성을 과거날짜로 변경
	function deleteCookie(cookieName) {
		setCookie(cookieName, "", -1);
	}
	
	$(function(){
		
		// remember me cookie 확인
		if(Cookies.get("REMEMBERME") == "Y"){
			$("#inputEmail").val(Cookies.get("USERNM"));
			$("input[type=checkbox]").prop("checked", true);
		};

		// sign in 버튼이 클릭 되었을 때 이벤트 헨들러
		$("button").on("click", function(){

			if( $("input[type=checkbox]").prop("checked") ){
				Cookies.set("USERNM", $("#inputEmail").val());
				Cookies.set("REMEMBERME", "Y");
			} else {
				Cookies.remove("USERNM");
				Cookies.remove("REMEMBERME");
			}

			// submit
			$("form").submit();

		})

	});

	
</script>




</head>

<body>

	<div class="container">

		<form class="form-signin" action="${pageContext.request.contextPath }/login" method="POST">
			<h2 class="form-signin-heading">Please sign in</h2>
			<label for="inputEmail" class="sr-only">Email address</label> 
			<input type="email" id="inputEmail" name="userId" class="form-control" placeholder="Email address" required autofocus value="brown"> 
			<label for="inputPassword" class="sr-only">Password</label> 
			<input type="password" id="inputPassword" name="password" class="form-control" placeholder="Password" required value="brownPass">
			<div class="checkbox">
				<label> 
					<input type="checkbox" value="remember-me"> Remember me
				</label>
			</div>
			<button class="btn btn-lg btn-primary btn-block" type="button">Sign in</button>
		</form>

	</div>
	<!-- /container -->

</body>
</html>
