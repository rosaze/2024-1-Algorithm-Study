"""문제
어떤 양의 정수 X의 각 자리가 등차수열을 이룬다면, 그 수를 한수라고 한다. 등차수열은 연속된 두 개의 수의 차이가 일정한 수열을 말한다. N이 주어졌을 때, 1보다 크거나 같고, N보다 작거나 같은 한수의 개수를 출력하는 프로그램을 작성하시오. 

입력
첫째 줄에 1,000보다 작거나 같은 자연수 N이 주어진다.

출력
첫째 줄에 1보다 크거나 같고, N보다 작거나 같은 한수의 개수를 출력한다.

아이디어: 1부터 99까지는 전부 한수이므로 digits 의 자릿수에 따라 False True 를 나눈다.
"""
def hansu(num):
    digits=list(map(int,str(num)))
    if len(digits)<=2:
        return True
    else:
        gap=digits[1]-digits[0]
        if digits[2]-digits[1]!=gap:
            return False
        else: return True

n=int(input())
count=0
for i in range(1,n+1):
    if hansu(i):
        count+=1
print(count)
