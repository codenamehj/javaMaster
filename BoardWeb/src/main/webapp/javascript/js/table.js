// table.js 
// for(let prop in obj1){    }
// table 생성 start
let tbl = document.createElement('table');
tbl.setAttribute('border', 1); // attribute 추가
tbl.appendChild(makeHead());
tbl.appendChild(makeBody());
//table 생성 end

//추가버튼 클릭 이벤트
document.getElementById('addBtn').addEventListener('click', function () {
    let id = document.getElementById('uid').value;
    let name = document.getElementById('uname').value;
    let phone = document.getElementById('uphone').value;


});

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

function makeTr(obj) {
    let trb = document.createElement('tr');
    // td
    for (let prop in obj) {
        let td = document.createElement('td');
        td.innerText = obj[prop];
        trb.appendChild(td);
    }
    let td = document.createElement('td');
    let btn = document.createElement('button');
    // button 이벤트 등록
    btn.addEventListener('click', function () { // 이벤트핸들러
        console.log(this.parentElement.parentElement.remove());
    });
    btn.innerText = '삭제';
    td.appendChild(btn);
    trb.appendChild(td);

    return trb;
}