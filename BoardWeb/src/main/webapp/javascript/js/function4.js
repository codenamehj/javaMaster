// function4.js

// 달력을 생성하는 객체
const cal = {
    days: ['Sun', 'Mon', 'Tue', 'Wed', 'Thu', 'Fri', 'Sat'],

    makeCalender: function (month) {
        this.makeTitle(this.days, document.getElementById('theader'));
        this.makeBody(month, document.getElementById('tbody'));
    }, // end of makeCalender

    makeTitle: function (days, pos) {
        let tr = document.createElement('tr');
        days.forEach(function (day) {
            let th = document.createElement('th');
            th.innerText = day;
            tr.appendChild(th);
        })
        pos.appendChild(tr);
    }, // end of makeTitle

    makeBody: function (month, pos) {
        let tr = document.createElement('tr');
        // 공백
        let firstDay = this.getFirstDay(month);
        for (let i = 0; i < firstDay; i++) {
            let td = document.createElement('td');
            td.innerText = '';
            tr.appendChild(td);
        }
        // 날짜
        let lastDate = this.getLastDate(month);
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
    }, // end of makeBody

    getFirstDay(month) {
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
    }, // end of getFirstDay

    getLastDate(month) {
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
    } // end of getLastDate
}
cal.makeCalender(10);