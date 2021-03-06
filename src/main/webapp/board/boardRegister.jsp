<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
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

<%@ include file="/layout/commonLib.jsp" %>

<!-- include summernote css/js -->
<link href="https://cdn.jsdelivr.net/npm/summernote@0.8.18/dist/summernote.min.css" rel="stylesheet">
<script src="https://cdn.jsdelivr.net/npm/summernote@0.8.18/dist/summernote.min.js"></script>

<title>boardRegist</title>

<script src="https://t1.daumcdn.net/mapjsapi/bundle/postcode/prod/postcode.v2.js"></script>
<script>

		
	$(document).ready(function(){

		$('#summernote').summernote({
				 height: 600
		});

		$('#boardRegBtn').on('click', function(){
			
			$("#boardRegFrm").submit();
			
		});

		cnt = 1;
		
		$("#atchBtn").on('click', function(){

			if($(".fileinput").length < 5){
				
				var input = '<input class="fileinput" id="file'+cnt+'" type="file" name="file'+cnt+'"/>';
				$('#filediv').append(input)

				cnt = cnt + 1;
			}
			
			
		})


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
				<form id="boardRegFrm" action="${cp }/boardRegist" method="POST" enctype="multipart/form-data">
					<input class="form-control" type="text" placeholder="글제목" id="board_title" name="board_title"><br>
					<textarea id="summernote" name="editordata"></textarea>
					<div id="filediv">
						<button id="atchBtn" type="button">첨부파일추가</button>
					</div>
					<input id="boardRegBtn" type="button" value="저장">
				</form>
			</div>
		</div>
	</div>
</body>
</html>
