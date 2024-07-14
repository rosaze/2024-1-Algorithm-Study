'''
N의 분해합: N+N의 각 자리수의 합
M의 분해합이 N인 경우, M을 N의 생성자라 함.
245의 분해합 = 245 + 2 + 4 + 5 = 256
256의 생성자는 245
'''
def breaksum(num): #분해합 구하는 함수
    numList=list(map(int, str(num))) #자릿수별로 분해해서 리스트에 저장
    result = num #분해합 결과를 저장할 result 변수 생성

    #자릿수를 result에 더해줌.
    for i in range(len(numList)):
        result += int(numList[i])

    return result

#분해합 입력받기
createnum = int(input())

#생성자를 못찾았을 경우를 위한 boolean형 변수 생성
found=False

#분해합을 1부터 createnum까지 전부 구함
# - 구한 분해합이 입력받은 값(createnum)과 동일하면 break -> 가장 작은 생성자를 반환함
for i in range(createnum):
    n = breaksum(i)
    if n == createnum:
        print(i)
        found = True
        break

#생성자를 찾지 못하면 0 출력
if not found:
    print(0)