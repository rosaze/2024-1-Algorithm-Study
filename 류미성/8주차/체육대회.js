// [PCCP 모의고사 #1] 2번 - 체육대회

function solution(ability) {
	const students = ability.length; // 학생 수
	const sports = ability[0].length; // 종목 수
	let maxSum = 0; // 능력치 최대
	let visited = Array(students).fill(false);

	const dfs = (sum, count) => {};

	return maxSum;
}

// 테스트 케이스
console.log(
	solution([
		[40, 10, 10],
		[20, 5, 0],
		[30, 30, 30],
		[70, 0, 70],
		[100, 100, 100],
	])
); // 210

console.log(
	solution([
		[20, 30],
		[30, 20],
		[20, 30],
	])
); // 60
