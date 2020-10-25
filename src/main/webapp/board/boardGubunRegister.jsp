<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<!-- The above 3 meta tags *must* come first in the head; any other head content must come *after* these tags -->
<meta name="description" content="">
<meta name="author" content="">
<link rel="icon" href="../../favicon.ico">

<title>Jsp</title>

<%@ include file="/layout/commonLib.jsp" %>

<script src="https://t1.daumcdn.net/mapjsapi/bundle/postcode/prod/postcode.v2.js"></script>
<script>

	$(document).ready(function(){
		

		$("#regBtn").on('click', function(){

			$("#frm").submit();
			
		});

			
	});



	

</script>


</head>

<body>

	<%@ include file="/layout/header.jsp" %>
	
	<div class="container-fluid">
		<div class="row">

			<div class="col-sm-3 col-md-2 sidebar">
			
				<%@ include file="/layout/left.jsp" %>
			
			</div>
			
			
			<div class="col-sm-9 col-sm-offset-3 col-md-10 col-md-offset-2 main">

				<form id="frm" role="form" action="${cp }/boardGubunRegist" method="POST">
					
					<label for="gubun_nm">게시판 이름</label>
					
					<input type="text" id="gubun_nm" name="gubun_nm" placeholder="게시판 이름">

					<select id="gubun_yn" name="gubun_yn">
						<option>사용</option>
						<option>미사용</option>
					</select>
			
					<button id="regBtn" type="button">생성</button>
					
				</form>
				
				<div>
					<c:forEach items="${boardGubunList }" var="boardGubun">
						<label for="gubun_nm">게시판 이름</label>
						<input type="text" value="${boardGubun.gubun_nm }" readonly="readonly">
						<select id="${boardGubun.gubun_sq }">
							<c:choose>
								<c:when test="${boardGubun.gubun_yn == 'y' }">
									<option selected="selected">사용</option>
									<option>미사용</option>
								</c:when>
								<c:when test="${boardGubun.gubun_yn == 'n' }">
									<option>사용</option>
									<option selected="selected">미사용</option>
								</c:when>
							</c:choose>
						</select>
						<button id="updateBtn" data-gubun_sq="${boardGubun.gubun_sq }" type="button">수정</button> <br>
					</c:forEach>
				</div>
			</div>
			
		</div>
	</div>
</body>
</html>
