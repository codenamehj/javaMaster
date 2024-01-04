// arrray4.js
// map, filter, find, indexOf, some, every

const str = '펭수, 라이언, 어피치, 콘, 브라운, 무지, 라이언, 어피치, 콘';

// 1. 콘이라는 이름은 몇 번?
const strSplit = str.split(', ');
console.log(`'콘'이라는 이름은 ${strSplit.filter(el => el == '콘').length}명 입니다.`);

// 2. 이름이 3자 이상은 몇 명?
console.log(`이름이 3자 이상은 ${strSplit.filter(el => el.length >= 3).length}명 입니다.`);

// 3. 2자인 이름이 있는지 여부확인
console.log(`이름이 2자인 사람이 있다? ${strSplit.some(el => el.length == 2)}`);

// 4. {no: 1, name: '펭수'} 형태의 값을 가지는 배열을 생성. 결과값을 strAry에 대입.
const strAry = strSplit.map((el, idx) => {
    let obj = {};
    obj.no = idx + 1;
    obj.name = el;
    return obj;
});

console.log(strAry);