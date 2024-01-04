// string1.js
let str1 = 'Hello';
console.log(str1, typeof str1);
let str2 = new String("Hello");
console.log(str2, typeof str2);

console.log(str1 == str2); // 값만 비교.
console.log(str1 === str2); // 타입까지 비교.

console.log(str1.substring(1, 3)); // 인덱스 값이 1부터 3 이전까지 자름.

let word = "   Hello, World ";
console.log(word.trim()); // trim(): 문자열 안의 처음과 끝 여백 삭제.
// const obj = new Object(); {}
// const reg = new RegExp(); /값/
console.log(word.replace(/l/g, 'L')); // replace(): 문자열 안의 문자를 다른 문자로 바꿈.
console.log(word.replace(/\s/g, '')); // 문자열 안 모든 공백 없애기. 

word = '  how are you   to day  everyone.  ';
console.log(word.split(' ').filter((val) => val).join(' '));