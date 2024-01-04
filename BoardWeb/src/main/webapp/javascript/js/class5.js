// class5.js
// Map, Set
const map = new Map();
map.set('홍길동', 20);
map.set('김민수', 22);
map.set('최성우', 25);
map.set('홍길동', 21); // 똑같은 key값이면 원래 있던 값을 뒤에 나온 값으로 변경.

map.delete('최성우');

console.log(map.get('김민수'));
// map.clear();

for (let key of map.keys()) {
    console.log(`key는 ${key}, value는 ${map.get(key)}`);
}
console.log(map.values());
for (let [key, value] of map.entries()) {
    console.log(key, value);
}
// 첫번째 매개값이 값, 두번째 매개값이 키.
map.forEach((val, key) => console.log('key: ' + key + ', val: ' + val));

// Set
const set = new Set();
set.add('홍길동');
set.add('김민수');
set.add('홍성길');
set.add('홍길동');

set.delete('김민수');

console.clear();
console.log(set.size);

set.forEach(name => console.log(name));

const numAry = [10, 14, 12, 10];
const num = new Set(numAry); // 배열 -> Set
num.forEach(number => console.log(number));
