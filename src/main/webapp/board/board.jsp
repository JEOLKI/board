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

<title>board</title>

<%@ include file="/layout/commonLib.jsp" %>

<script type="text/javascript">

	$(document).ready(function(){
		/* $('#updateBtn').on('click', function(){

			var userid = $(this).data("userid");
			document.location="/memberUpdate?userid=" + userid;
			
		});

		$("#profileDownBtn").on('click', function(){
			// 사용자 한명의 정보이기 때문에 url에 바로 EL을 사용하여 한명의 정보를 받아올 수 있다.
			document.location="/profileDownload?userid=${memberVo.userid}";
		}) */


		$("#replyRegBtn").on('click', function(){

			console.log("ss")

			$("#replyfrm").submit();

		});

		$("#replyDelBtn").on('click', function(){
			var reply_sq = $(this).data("reply_sq");
			document.location="${cp }/replyDelete?reply_sq=" + reply_sq +"&board_sq=${boardVo.board_sq }";
		});

		$("#boardDelBtn").on('click', function(){
			document.location="/boardDelete?board_sq=${boardVo.board_sq }&gubun_sq=${boardVo.gubun_sq}&gubun_nm=${param.gubun_nm}";
		});

		$("#boardChildBtn").on('click', function(){
			document.location="/boardRegist?gubun_sq=${boardVo.gubun_sq }&board_sq=${boardVo.board_sq }&group_no=${boardVo.group_no }";
		})


		$('#reply_content').on('keyup', function(){
			console.log("ss")
		    var reply_content = $(this).val();
		    $('#counter').html("("+reply_content.length+" / 최대 500자)");    //글자수 실시간 카운팅

		    if (reply_content.length > 500){
		        alert("최대 500자까지 입력 가능합니다.");
		        $(this).val(reply_content.substring(0, 500));
		        $('#counter').html("(500 / 최대 500자)");
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
		
<!-- 					<div class="form-group">
						<label for="userNm" class="col-sm-2 control-label">사용자 아이디</label>
						<div class="col-sm-10">
							<input type="text" class="form-control" id="userId" name="userId"
								placeholder="사용자 아이디">
						</div>
					</div> -->
					
					<%-- <div class="form-group">
						<label for="userNm" class="col-sm-2 control-label">사용자 사진</label>
						<div class="col-sm-10">
							<img src="${cp }/profile/${memberVo.filename}"/>
							
							<img src="${cp }/profileImg?userid=${memberVo.userid }"/> <br>
							<button id="profileDownBtn" type="button" class="btn btn-default">다운로드 : ${memberVo.realFilename }</button>
						</div>
					</div> --%>
					
					<div class="form-group">
						<label for="board_title" class="col-sm-2 control-label">제목</label>
						<div class="col-sm-10">
							<label class="control-label">${boardVo.board_title }</label>
						</div>
					</div>

					<div class="form-group">
						<label for="userid" class="col-sm-2 control-label">작성자</label>
						<div class="col-sm-10">
							<label class="control-label">${boardVo.userid }</label>
						</div>
					</div>
					
					<div class="form-group">
						<label for="board_date" class="col-sm-2 control-label">등록일자</label>
						<div class="col-sm-10">
							<label class="control-label"><fmt:formatDate value="${boardVo.board_date }" pattern="YYYY-MM-dd"/></label>
						</div>
					</div>
					
					<div class="form-group">
						<label for="board_content" class="col-sm-2 control-label">글 내용</label>
						<div class="col-sm-10">
							<!-- <img alt="" src="data:image/jpeg;base64,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">
							 --><label class="control-label">${boardVo.board_content }</label>
						</div>
					</div>
					
					<div class="form-group">
						<label for="board_content" class="col-sm-2 control-label">첨부파일</label>
						<div class="col-sm-10">
						
							<c:forEach items="${atchFileList }" var="atchfile">
								<label class="control-label">${atchfile.atch_filename }</label><br>
							</c:forEach>
						</div>
					</div>
					
					<c:if test="${boardVo.userid == S_MEMBER.userid }">
						<div class="form-group">
							<div class="col-sm-offset-2 col-sm-10">
								<button id="updateBtn" type="button" class="btn btn-default" data-userid="${boardVo.board_sq }">수정</button>
								<button id="boardDelBtn" type="button" class="btn btn-default" data-board_sq="${boardVo.board_sq }">삭제</button>
								<button id="boardChildBtn" type="button" class="btn btn-default" data-board_sq="${boardVo.board_sq }">답글</button>
							</div>
						</div>
					</c:if>
					
					
					
					<div class="form-group">
						<label for="zipcode" class="col-sm-2 control-label">댓글</label>
						<div class="col-sm-10">
							<c:forEach items="${replyList }" var="reply">
							
								<c:choose>
									<c:when test="${reply.reply_yn == 'n' }">
										<label class="control-label">[삭제된 댓글 입니다.]</label>
									</c:when>
									<c:otherwise>
										<label class="control-label">
										<span>${reply.reply_content }</span> [${reply.userid } / <fmt:formatDate value="${reply.reply_date }" pattern="YYYY-MM-dd"/>]
										</label>
										<c:if test="${reply.userid == S_MEMBER.userid }">
											<button id="replyDelBtn" data-reply_sq="${reply.reply_sq }">삭제</button>
										</c:if>
									</c:otherwise>
								</c:choose>

								
								<br>
							</c:forEach>
							<br>
							
							<form id="replyfrm" action="${cp }/replyRegist" method="get">
								<input HIDDEN type="text" name="board_sq" value="${boardVo.board_sq }">
								<input HIDDEN type="text" name="userid" value="${S_MEMBER.userid }">
								<textarea id="reply_content" name="reply_content" rows="" cols=""></textarea>
								<span style="color:#aaa;" id="counter">(500 / 최대 500자)</span>
								<button id="replyRegBtn" type="button">댓글저장</button>
							</form>
							
						</div>
					</div>

			</div>
		</div>
	</div>
</body>
</html>
