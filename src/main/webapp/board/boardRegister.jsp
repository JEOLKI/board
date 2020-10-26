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
			var imgtag = $(".note-editable img");
			
			for(i=0 ; i< imgtag.length  ; i++){
				var src = $(".note-editable img")[i].src;
				var filename = $(".note-editable img")[i].dataset.filename;

				$("#file"+(i+1)).val(src+"; filename="+filename);
			}

			//console.log(srcs)
			
			$(".note-editable img").remove();
			var content = $(".note-editable p").html();
			$("#board_content").val(content);
			//console.log(content);
			
			if($(".note-editable img").length > 5){
				alert("첨부파일은 5개까지 가능합니다.");
				$(".note-editable img")[4].remove();
			} else {
				$("#boardRegFrm").submit();
			}
			
			
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
				<form id="boardRegFrm" action="${cp }/boardRegist" method="POST">
					<input class="form-control" type="text" placeholder="글제목" id="board_title" name="board_title"><br>
					<textarea id="summernote" name="editordata"></textarea>
					<input HIDDEN id="board_content" name="board_content">
					<input HIDDEN id="file1" name="file1">
					<input HIDDEN id="file2" name="file2">
					<input HIDDEN id="file3" name="file3">
					<input HIDDEN id="file4" name="file4">
					<input HIDDEN id="file5" name="file5">
					<input id="boardRegBtn" type="button" value="저장">
				</form>
			</div>
		</div>
	</div>
</body>
</html>
