a,b,c = map(int, input().split())

res=0

# a=b=c / 주사위 3개의 숫자가 모두 같은 경우
if a==b and b==c:
    res=10000+a*1000
    print(res)


# a=b a=c / 주사위 2개의 숫자가 같은 경우1
elif a==b or a==c:
    res=1000+a*100
    print(res)

# b=c / 주사위 2개의 숫자가 같은 경우2
elif b==c:
    res=1000+b*100
    print(res)


# a!=b!=c / 주사위 숫자가 모두 다른 경우
else:
    list=[a,b,c]

    largest=list[0] #임의로 맨 첫번째 값을 지정
    for i in list:
        if i > largest: #지정한 값과 i를 비교하며
            largest=i #리스트 안의 가장 큰 수를 largest에 넣기
    res=largest*100
    print(res)