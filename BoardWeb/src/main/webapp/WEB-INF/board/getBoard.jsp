<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
	
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>

<%@ include file="../layout/menu.jsp" %>
<%@ include file="../layout/nav.jsp" %>

	<h3>상세화면</h3>
	
	<form name="myForm" action="modifyForm.do">
		<input type="hidden" name="bno" value="${vo.boardNo }">
		<table class="table">
			<tbody>
				<tr>
					<td>글번호</td>
					<td colspan="3">${vo.boardNo }</td>
				</tr>
				<tr>
					<td>제목</td>
					<td colspan="3">${vo.title }</td>
				</tr>
				<tr>
					<td>내용</td>
					<td colspan="3">${vo.content }</td>
				</tr>
				<tr>
					<td>작성자</td>
					<td colspan="3">${vo.writer }</td>
				</tr>
				<tr>
					<td>작성일</td>
					<td><fmt:formatDate value="${vo.writeDate }" pattern="yyyy-MM-dd"/></td>
					<td>조회수</td>
					<td>${vo.clickCnt }</td>
				</tr>
				<tr>
					<td>이미지</td>
					<td colspan="3"></td>
				</tr>
				<tr>
					<td colspan="4" align="center">
					<c:choose>
					<c:when test="${logName eq vo.writer }">
						<input type="submit" value="수정">
						<input type="button" onclick="deleteFun()" value="삭제">
					</c:when>
					<c:when test="${logName eq '관리자' }">
						<input type="submit" value="수정">
						<input type="button" onclick="deleteFun()" value="삭제">
					</c:when>
					<c:otherwise>
						<input type="submit" disabled value="수정">
						<input type="button" disabled onclick="deleteFun()" value="삭제">
					</c:otherwise>
					</c:choose>
					</td>
				</tr>
			</tbody>
		</table>
	</form>
	<br>
	<a href="boardList.do">글목록으로</a>
	<script type="text/javascript">
		function deleteFun(){
<!--			console.log(window);	-->
			document.forms.myForm.action = "removeForm.do";
			document.forms.myForm.submit();
		}
		
	</script>
<%@ include file="../layout/foot.jsp" %>