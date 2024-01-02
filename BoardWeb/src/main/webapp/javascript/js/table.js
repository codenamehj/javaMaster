// table.js 
// for(let prop in obj1){    }
// table 생성 start
let tbl = document.createElement('table');
tbl.setAttribute('border', 1); // attribute 추가
tbl.setAttribute('id', 'list');
tbl.appendChild(makeHead());
tbl.appendChild(makeBody());
//table 생성 end

// 추가버튼 클릭 이벤트
document.getElementById('addBtn').addEventListener('click', function () {
    let id = document.getElementById('uid').value;
    let name = document.getElementById('uname').value;
    let phone = document.getElementById('uphone').value;

    if (!id || !name || !phone) {
        alert('값을 입력하세요.');
        return; // 뒤로 넘어가지 않음.
    }

    let obj = { id, name, phone };
    document.querySelector('#list>tbody').appendChild(makeTr(obj));

    // 값 초기화
    document.getElementById('uid').value = '';
    document.getElementById('uname').value = '';
    document.getElementById('uphone').value = '';
    // id에 포커스
    document.getElementById('uid').focus();
});

// 변경버튼 클릭 이벤트
document.querySelector('#editBtn').addEventListener('click', function () {
    // 찾을 값:
    let findId = document.getElementById('uid').value;
    let phone = document.getElementById('uphone').value;
    // 찾을 대상:
    let target = document.querySelectorAll('#list>tbody>tr');

    target.forEach(function (item, idx, ary) {
        let tr = item;
        if (tr.children[0].innerText == findId) {
            tr.children[2].innerText = phone;
        }
    })

    // 값 초기화
    document.getElementById('uid').value = '';
    document.getElementById('uname').value = '';
    document.getElementById('uphone').value = '';
    // id에 포커스
    document.getElementById('uid').focus();
})

// 선택삭제버튼 클릭 이벤트
document.querySelector('#delBtn').addEventListener('click', function(){
    document.querySelectorAll('#list>tbody>tr>td>input:checked').forEach(function(item){
        item.parentElement.parentElement.remove();
    })
})


document.querySelector('body').appendChild(tbl);

function makeHead() {
    // thead
    let thd = document.createElement('thead');
    // tr
    let tr = document.createElement('tr');
    // th*3
    for (let prop in obj1) {
        let th = document.createElement('th');
        th.innerText = prop.toUpperCase();
        tr.appendChild(th);
    }
    //삭제
    let th = document.createElement('th');
    th.innerText = '삭제';
    tr.appendChild(th);
    //체크박스
    th = document.createElement('th');
    th.innerText = '선택삭제';
    tr.appendChild(th);

    thd.appendChild(tr);
    return thd;
}

function makeBody() {
    // tbody 시작
    let tbd = document.createElement('tbody');
    // tr
    for (let friend of friends) {
        tbd.appendChild(makeTr(friend));
    }
    return tbd;
}

function makeTr(obj = {}) {
    // <tr><td>user1</td><td>홍길동</td><td>0101-1111</td></tr>
    // tr
    let trb = document.createElement('tr');
    trb.addEventListener('click', function () {
        document.getElementById('uid').value = this.children[0].innerText;
        document.getElementById('uname').value = this.children[1].innerText;
        document.getElementById('uphone').value = this.children[2].innerText;
    })
    // td
    for (let prop in obj) {
        let td = document.createElement('td');
        td.innerText = obj[prop];
        trb.appendChild(td);
    }
    // 삭제버튼 생성
    let td = document.createElement('td');
    let btn = document.createElement('button');
    // button 이벤트 등록
    btn.addEventListener('click', function (e) { // 이벤트핸들러
        e.stopPropagation(); // ★★★ 상위요소로 이벤트 전파 차단
        this.parentElement.parentElement.remove();
    });
    btn.innerText = '삭제';
    td.appendChild(btn);
    trb.appendChild(td);

    // 체크박스 생성
    td = document.createElement('td');
    td.setAttribute('align', 'center');

    let chkbox = document.createElement('input');
    chkbox.addEventListener('click', function (e) {
        e.stopPropagation(); // 상위요소로 이벤트 전파 차단
    })
    chkbox.setAttribute('type', 'checkbox');

    td.appendChild(chkbox);
    trb.appendChild(td);

    return trb;
}