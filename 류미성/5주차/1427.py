# 소트인사이드

n = int(input()) # 정수로 부터 입력 받음
x = list(str(n))  # 입력된 정수를 문자열로 변환하고, 각 문자를 리스트에 저장
x.sort(reverse=True) # 리스트를 내림차순으로 정렬

print(''.join(x)) # 정렬된 리스트의 문자들을 결합하여 출력