// class2.js
let year = 2024;
let month = 2;

let day1 = new Date(year, month - 1, 1); // {} new Object()
let day2 = new Date(year, month, 0); // 이달의 마지막날 구하기
console.log(day1.getDay(), day2.getDate()); // Date: 몇 일 Day: 요일(0:일요일, 1:월요일, ...), Month: 몇 월(0:1월, 1:2월, ...)

class Calender {
    constructor(year, month) {
        this.year = year;
        this.month = month;
    }

    days = ['Sun', 'Mon', 'Tue', 'Wed', 'Thu', 'Fri', 'Sat'];

    makeCalender() {
        console.log('달력생성');
        this.makeTitle(document.getElementById('theader'));
        this.makeBody(document.getElementById('tbody'));
    }

    makeTitle(pos = {}) {
        let tr = document.createElement('tr');
        this.days.forEach((day) => {
            let th = document.createElement('th');
            th.innerText = day;
            tr.appendChild(th);
        })
        pos.appendChild(tr);
    }

    makeBody(pos = {}) {
        let tr = document.createElement('tr');
        // 공백
        let firstDay = this.getFirstDay();
        for (let i = 0; i < firstDay; i++) {
            let td = document.createElement('td');
            td.innerText = '';
            tr.appendChild(td);
        }
        // 날짜
        let lastDate = this.getLastDate();
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

    getFirstDay() {
        let firstDay = new Date(this.year, this.month - 1, 1);
        return firstDay.getDay();
    }

    getLastDate() {
        // 년, 월: this.year, this.month
        let lastDate = new Date(this.year, this.month, 0);
        return lastDate.getDate();
    }
}
const cal = new Calender(year, month);
document.getElementById("yearMonth").innerHTML = `${year}년 ${month}월`;
cal.makeCalender();