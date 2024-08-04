L, R = map(int, input().split())

left = []
right = []

while True:
    if L//10 != 0:
        left.append(L%10)
        L //= 10
    if R//10 != 0:
        right.append(R%10)
        R //= 10

    if L//10 == 0 and R//10 == 0:
        left.append(L%10)
        right.append(R%10)
        break
cnt = 0
#자릿수가 같을때
if len(left) == len(right):
    cnt = 0
    #리스트에 숫자의 일의자리부터 인덱스0으로 저장되어 있다.
    #그래서 인덱스의 마지막 부분이 숫자의 가장 큰 부분이다.
    for i in range(len(left)-1, -1, -1):
        #자릿수의 값이 같다면
        if left[i] == right[i]:
            #그 값이 8인지 확인한다.
            if left[i] == right[i] == 8:
                cnt += 1
        #자릿수의 값이 틀리면. 더이상 고려해주지 않아도 된다.
        else:
            break
print(cnt)