<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>20240110</title>
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.7.1/jquery.min.js"></script>
<script>
	$(document).ready(function() {
		// 책 목록 출력
		$.ajax('bookList.do', {
			method: 'get',
			dataType: 'json', // 서버의 데이터 포맷을 지정
			success: function(result) {
				console.log(result);
				$(result).each((idx, book) => {
					console.log(book);
					// tr, td 생성
					let tr = $('<tr />').append($('<td />').text(book.bookCode),
						$('<td />').text(book.bookName),
						$('<td />').text(book.bookAuthor),
						$('<td />').text(book.bookPress),
						$('<td />').text(book.bookPrice)
					);
					$('#list').append(tr);
				}); //forEach
			},
			error: function(err) {
				console.log(err);
			}
		})
	})
</script>
</head>
<body>
	<h3>책목록</h3>
	<table class="table" border="1">
		<thead>
			<tr>
				<th><input type="checkbox"></th>
				<th>도서코드</th>
				<th>도서명</th>
				<th>저자</th>
				<th>출판사</th>
				<th>가격</th>
				<th>삭제</th>
			</tr>
		</thead>
		<tbody id="list"></tbody>
	</table>
</body>
</html>