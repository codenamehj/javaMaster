/**
 * service.js
 */

function makeLi(reply = {}) {
	// start
	let li = document.createElement('li');
	let span = document.createElement('span');
	span.innerText = '글번호 ' + reply.replyNo;
	li.appendChild(span);
	span = document.createElement('span');
	span.innerText = ' ' + reply.name;
	li.appendChild(span);
	span = document.createElement('span');
	span.innerText = ' : ' + reply.reply;
	li.appendChild(span);

	// 삭제버튼
	let btn = document.createElement('button');
	btn.addEventListener('click', async function() {
		// 댓글번호 삭제 후 화면에서 제거
		// await fetch함수
		const promise = await fetch('delReplyJson.do?rno=' + reply.replyNo);
		const result = await promise.json();
		try {
			if (result.retCode == 'OK') {
				alert('삭제됨');
				// btn.parentElement.remove();
				// bno, page => 페이지리스트, 페이징리스트
				showList(pageInfo);

			} else if (result.retCode == 'NG') {
				alert('처리 중 에러');
			}
		} catch (err) {
			console.error('예외=> ', err);
		}

		/*
		// fetch함수
		// 댓글번호 삭제 후 화면에서 제거
		fetch('delReplyJson.do?rno=' + reply.replyNo)
		.then(str => str.json())
		.then(result => {
			if (result.retCode == 'OK') {
				alert('삭제됨');
				// btn.parentElement.remove();
				// bno, page => 페이지리스트, 페이징리스트
				showList(pageInfo);

			} else if (result.retCode == 'NG') {
				alert('처리 중 에러');
			}
		})
		.catch(err => console.error(err));*/

		/*// 댓글번호 삭제 후 화면에서 제거
		let delHtp = new XMLHttpRequest();
		delHtp.open('get', 'delReplyJson.do?rno=' + reply.replyNo);
		delHtp.send();
		delHtp.onload = function() {
			let result = JSON.parse(delHtp.responseText)
			if (result.retCode == 'OK') {
				alert('삭제됨');
				// btn.parentElement.remove();
				// bno, page => 페이지리스트, 페이징리스트
				showList(pageInfo);

			} else if (result.retCode == 'NG') {
				alert('처리 중 에러');
			}
		}*/
	}, true);
	btn.innerText = '삭제';
	li.appendChild(btn); // end

	return li;
}