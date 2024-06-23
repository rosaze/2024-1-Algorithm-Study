# 나이순 정렬

count = int(input())
user = []

for i in range(count):
  age, name = input().split()
  user.append((int(age), name))  # 튜플로 추가하고 age를 int형으로 변환

# lambda 함수를 사용하여 리스트의 요소에서 나이를 추출
user = sorted(user, key=lambda x: x[0])  # 리스트를 나이 기준으로 정렬

for age, name in user:
  print(age, name)
