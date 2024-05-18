function solution(times) {
	maximum = Number.MIN_SAFE_INTEGER;
	let timeLine = [];

	// 시간 순서대로 정렬하기 위해, 한 배열에 들어있는 두개의 원소를 반복문을 통해 분리함
	// ex) [14, 18] -> [14, 's'], [18, 'e']
	// 분리한 배열을 모두 timeLine에 추가
	// timeLine = [[14, 's'], [18, 'e], ...]
	// s는 start, e는 end
	for (let x of times) {
		timeLine.push([x[0], "s"]);
		timeLine.push([x[1], "e"]);
	}

	// start와 end를 정렬하기 위해, 아스키코드로 변환
	// 아스키코드에서는 e가 앞순서이기 때문에 오름차순 정렬
	// 'e'의 아스키 코드 값: 101
	// 's'의 아스키 코드 값: 115
	timeLine.sort((a, b) => {
		if (a[0] === b[0]) {
			return a[1].charCodeAt() - b[1].charCodeAt();
		} else {
			return a[0] - b[0];
		}
	});

	// timeLine: [[5, 's'], [12, 's'], [14, 'e'], [14, 's'], ...]

	// 새로운 인원이 오면 count+1, 기존 인원이 나가면 count-1을 하여,
	// 머물러 있는 최대 인원을 구한다.
	let count = 0;
	for (let x of timeLine) {
		if (x[1] === "s") {
			count++;
		} else {
			count--;
		}

		maximum = Math.max(maximum, count);
	}

	return maximum;
}

// 테스트 케이스
console.log(
	solution([
		[14, 18],
		[12, 15],
		[15, 20],
		[20, 30],
		[5, 14],
	])
); // 2
