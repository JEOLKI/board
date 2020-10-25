<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<ul class="nav nav-sidebar">
	<li class="active"><a href="${cp }/boardGubunRegist">게시판생성</a></li> <br>
	
	<c:forEach items="${boardGubunList }" var="boardGubun">
		<c:if test="${boardGubun.gubun_yn == 'y' }">
			<li class="active"><a href="#">${boardGubun.gubun_nm }</a></li>
		</c:if>
	</c:forEach>
	
</ul>