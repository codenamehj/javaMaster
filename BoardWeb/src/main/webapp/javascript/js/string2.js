// string2.js

const keyword = '홍';
const wordAry = ['사과', '홍씨', '홍장군', '김시홍', '감자']
// 1. 배열에서 '홍'이 들어간 단어의 갯수를 구하기.
// let cnt = 0;
// for (words of wordAry) {
//     if (words.indexOf(keyword) != -1) {
//         cnt++;
//     }
// }
// console.log("배열에서 '홍'이 들어간 단어의 갯수는 " + cnt + "개입니다.");
console.log(wordAry.filter(val => val.indexOf(keyword) != -1).length);


const url = 'http://localhost/BoardWeb/index.jsp?x=12&y=23';
// 2. url에서 파라미터 (x, y)의 값을 찾기.
// let queryString = url.substring(url.indexOf('?'), url.length);
// let splited = queryString.replace('?', '').split(/[=?&]/);
// let param = {};
// for (let i = 0; i < splited.length; i++) {
//     param[splited[i]] = splited[++i];
// }
// console.log(queryString);
// console.log(splited);
// console.log('(' + param.x + ',' + param.y + ')');
console.log(url.match(/\d+/g)[0], url.match(/\d+/g)[1]); // 정규식 \d: 숫자


const word = '안녕하세요xx만나서xx반갑습x니x다.';
// 3. "안녕하세요 만나서 반갑습니다." 문장으로 변환하기.
// let repX = word.replace(/x/g, ' ');
// let repAry = repX.split(' ').filter(val => val);
// repAry[2] = repAry[2].concat(repAry[3], repAry[4]);
// repAry[3] = ''; repAry[4] = '';
// console.log(repAry.join(' '));
console.log(word.replace(/xx/g, ' ').replace(/x/g, ''));