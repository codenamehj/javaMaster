// calender.js
let days = ['Sun', 'Mon', 'Tue', 'Wed', 'Thu', 'Fri', 'Sat']

let lastDate = getLastDate(1);
let firstDay = getFirstDay(1);
console.log(lastDate);
console.log(firstDay);

makeCalender(1);

// 달력 생성
function makeCalender(month) {
    makeTitle(days, document.getElementById('theader'));
    makeBody(month, document.getElementById('tbody'));
}

function getLastDate(month) {
    // 월 입력 => 마지막 날을 반환. 31, 29, 31, 30, 31, 30, 31, 31, ...
    if (month != 2 && month < 8) {
        if (month % 2 == 1) {
            return 31;
        } else return 30;
    } else if (month > 7 && month <= 12) {
        if (month % 2 == 0) {
            return 31;
        } else return 30;
    } else return 29;
}

function getFirstDay(month) {
    // 월 입력 => 1일의 위치(공백이 몇개 반환)
    switch (month) {
        case 1:
            return 1;
        case 2:
            return 4;
        case 3:
            return 5;
        case 4:
            return 1;
        case 5:
            return 3;
        case 6:
            return 6;
        case 7:
            return 1;
        case 8:
            return 4;
        case 9:
            return 0;
        case 10:
            return 2;
        case 11:
            return 5;
        case 12:
            return 0;
    }
}

// header 생성
function makeTitle(dayAry = [], pos = {}) {
    let tr = document.createElement('tr');
    dayAry.forEach(function (day) {
        console.log(day);
        let th = document.createElement('th');
        th.innerText = day;
        tr.appendChild(th);
    })
    pos.appendChild(tr);
}

// 날짜 생성
function makeBody(month = 1, pos = {}) {
    let tr = document.createElement('tr');
    // 공백
    let firstDay = getFirstDay(month);
    for (let i = 0; i < firstDay; i++) {
        let td = document.createElement('td');
        td.innerText = '';
        tr.appendChild(td);
    }
    // 날짜
    let lastDate = getLastDate(month);
    for (let i = 1; i <= lastDate; i++) {
        let td = document.createElement('td');
        // td 속성 추가.
        // 토요일: lightskyblue, 일요일: lightpink
        if ((firstDay + i) % 7 == 0) {
            td.setAttribute('style', 'background-color: lightskyblue');
        } else if ((firstDay + i) % 7 == 1) {
            td.setAttribute('style', 'background-color: lightpink');
        }
        td.innerText = i;
        tr.appendChild(td);

        if ((firstDay + i) % 7 == 0) {
            pos.appendChild(tr);
            tr = document.createElement('tr');
        }
    }
    pos.appendChild(tr);
}