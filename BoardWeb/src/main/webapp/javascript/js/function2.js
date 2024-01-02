// function2.js
let members = `[{"id":1,"first_name":"Lissi","last_name":"Ianizzi","email":"lianizzi0@wix.com","gender":"Female","sallery":9089},
{"id":2,"first_name":"Andriana","last_name":"Triner","email":"atriner1@samsung.com","gender":"Female","sallery":5474},
{"id":3,"first_name":"Urson","last_name":"Checketts","email":"uchecketts2@edublogs.org","gender":"Male","sallery":8136},
{"id":4,"first_name":"Ellwood","last_name":"Noell","email":"enoell3@answers.com","gender":"Male","sallery":3468},
{"id":5,"first_name":"Vanessa","last_name":"Ewing","email":"vewing4@deliciousdays.com","gender":"Female","sallery":5387},
{"id":6,"first_name":"Tommie","last_name":"Kuhlen","email":"tkuhlen5@dyndns.org","gender":"Male","sallery":2150},
{"id":7,"first_name":"Emory","last_name":"Rutherforth","email":"erutherforth6@eepurl.com","gender":"Male","sallery":4208},
{"id":8,"first_name":"Roderic","last_name":"Swindlehurst","email":"rswindlehurst7@auda.org.au","gender":"Male","sallery":5060},
{"id":9,"first_name":"Titus","last_name":"Jeanequin","email":"tjeanequin8@tiny.cc","gender":"Male","sallery":6370},
{"id":10,"first_name":"Patti","last_name":"Crennell","email":"pcrennell9@bloglines.com","gender":"Female","sallery":3391},
{"id":11,"first_name":"Fraze","last_name":"Brocket","email":"fbrocketa@drupal.org","gender":"Male","sallery":8813},
{"id":12,"first_name":"Owen","last_name":"Kettley","email":"okettleyb@harvard.edu","gender":"Male","sallery":3638},
{"id":13,"first_name":"Sherwynd","last_name":"Lucus","email":"slucusc@hubpages.com","gender":"Male","sallery":6960},
{"id":14,"first_name":"Broderick","last_name":"Wilkisson","email":"bwilkissond@linkedin.com","gender":"Male","sallery":9376},
{"id":15,"first_name":"Chalmers","last_name":"Grzegorecki","email":"cgrzegoreckie@nydailynews.com","gender":"Male","sallery":3787}]`;

let memberAry = JSON.parse(members); // 문자열 -> 객체 변환.
console.log(memberAry[14]);

let titles = ['아이디', '이름', '성씨', '이메일', '성별', '급여']

function makeHeader(fields = [], pos = {}) {
    let tr = document.createElement('tr');
    fields.forEach(function (field) {
        console.log(field);
        let th = document.createElement('th');
        th.innerText = field;
        tr.appendChild(th);
    })
    pos.appendChild(tr);
}

makeHeader(titles, document.getElementById('theader'));

function makeBody(data = [], pos = {}) {
    data.forEach(function (member) {
        console.log(member);
        let tr = document.createElement('tr');
        // tr에 속성 지정.
        if (member.gender == 'Female') {
            tr.setAttribute('style', 'background-color: lightpink');
        } else if (member.gender == 'Male') {
            tr.setAttribute('style', 'background-color: lightskyblue');
        }
        for (let prop in member) {
            let td = document.createElement('td');
            td.innerText = member[prop];
            tr.appendChild(td);
        }
        pos.appendChild(tr);
    })
}

makeBody(memberAry, document.getElementById('tbody'));