// Node.js 코드로 변환된 Fibonacci 함수
// count 변수를 전역 변수로 설정
let cnt = 0;

// Fibonacci 함수 정의
function fibo(n) {
  cnt += 1; // 함수 호출 시마다 count 증가
  if (n <= 1) {
    // n이 1 이하일 경우, (0, n)을 반환
    return [0, n];
  } else {
    // 재귀적으로 n-1에 대해 fibo 함수 호출
    let [a, b] = fibo(n - 1);
    // (b, a+b)를 반환하여 Fibonacci 수열 생성
    return [b, a + b];
  }
}

// 입력 받기
const n = parseInt(prompt("Enter a number: "));

// Fibonacci 함수 호출 및 결과 출력
let [a, b] = fibo(n);
console.log(b); // Fibonacci 수열의 n번째 항 출력

// count 변수 출력 (선택 사항)
// console.log(`Function was called ${cnt} times`);
