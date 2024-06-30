// readline 모듈을 사용하여 사용자 입력을 받기 위한 설정
const readline = require("readline");
const rl = readline.createInterface({
  input: process.stdin,
  output: process.stdout,
});

// 사용자 입력을 처리하는 함수
rl.question("Enter the number of elements: ", (t) => {
  rl.question("Enter the elements separated by space: ", (input) => {
    let lst = input.split(" ").map(Number); // 입력을 공백으로 구분하여 숫자 배열로 변환
    lst.sort((a, b) => a - b); // 배열을 오름차순으로 정렬

    let cnt = 0; // 부분 합계를 저장할 변수
    let sum = 0; // 전체 합계를 저장할 변수

    // 요소를 순회하면서 부분 합계와 전체 합계를 계산
    for (let i = 0; i < t; i++) {
      cnt += lst[i];
      sum += cnt;
    }

    console.log(sum); // 최종 합계를 출력

    rl.close(); // readline 인터페이스 닫기
  });
});
