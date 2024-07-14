
"""
문제
양의 정수 N이 주어졌을 때, 이 수를 소인수분해 한 결과를 출력하는 프로그램을 작성하시오.
- 에라토스테네스의 채로 소수 리스트를 만들어서 전달한 뒤, 각 소수와 그 수로 n을 나눌 수 있는
횟수를 딕셔너리로 정리한다.
"""


def prime(n):
    primes=[True]*(n+1)
    p=2
    while p*p<=n:
        if primes[p]:
            for i in range(p*p,n+1,p):
                primes[i]=False
        p+=1
    primenum=[p for p in range(2,n+1) if primes[p]]
    return primenum


def cnt(n):
    lst=prime(n)
    dic={}
    for items in lst:
        dic[items]=0
    for i in range(len(lst)):
        if n%lst[i]==0:
            while n%lst[i]==0:
                n=n//lst[i]
                dic[lst[i]]+=1
                
    return [[k,v] for k,v in dic.items() if v>0]

T=int(input())

for _ in range(T):
    n=int(input())
    ans=cnt(n)
    for items in ans:
        print(*items)


