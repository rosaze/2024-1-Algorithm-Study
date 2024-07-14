# 첫째 줄에 배열의 크기인 정수 n과 k씨가 일한 횟수인 정수 m을 입력합니다.
# 둘째 줄에는 배열에 포함된 정수를 순서대로 입력합니다. 각 정수는 절댓값이 200을 넘지 않는 정수입니다.
# 다음 줄 부터 m개 줄에 걸쳐 k씨가 고른 범위인 정수 i, j와 정수 k를 입력합니다.

n, m = map(int, input().split())

numbers = list(map(int, input().split()))

commands = []
for _ in range(m):
    command = list(map(int, input().split()))
    commands.append(command)

results = []

for command in commands:
    start, end, pos = command
    sub_list = numbers[start-1:end]
    sub_list.sort()
    result = sub_list[pos-1]
    results.append(result)

for result in results:
    print(result)