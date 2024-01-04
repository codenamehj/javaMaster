// function5.js

//Array.prototype.foreach();
const ary = ['a', 'b', 'c'];
ary.forEach((elem) => console.log(elem)); // 화살표 함수 예제1
// ★ 화살표 함수 예제2
ary.forEach((elem, idx) => {
    if (idx > 0) {
        console.log(elem);
    }
})

Array.prototype.sum = function () {
    console.log(this);
    let result = 0;
    this.forEach(function (val) {
        result += val;
    })
    return result;
}
const numbers = [1, 2, 3, 4];
console.log('sum: ' + numbers.sum());