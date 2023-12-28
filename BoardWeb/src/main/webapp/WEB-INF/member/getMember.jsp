<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

	<h3>회원상세</h3>
	
		<input type="hidden" name="mid" value="${vo.id }">
		<table class="table">
			<tbody>
				<tr>
					<td>아이디</td>
					<td>${vo.id }</td>
				</tr>
				<tr>
					<td>비밀번호</td>
					<td>${vo.pw }</td>
				</tr>
				<tr>
					<td>이름</td>
					<td>${vo.name }</td>
				</tr>
				<tr>
					<td>권한</td>
					<td>${vo.responsibility }</td>
				</tr>
				<tr>
					<td colspan="2" align="center">
						<input type="submit" value="수정">
						<input type="button" value="삭제">
					</td>
				</tr>
			</tbody>
		</table>