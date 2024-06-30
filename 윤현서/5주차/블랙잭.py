'''
combination 라이브러리
combinations(반복 가능한 객체, n) //n = 몇 개를 뽑을지
'''
from itertools import combinations

card_num, target = map(int, input().split())
card_set = list(map(int,input().split()))
max_num = 0

for cards in combinations(card_set, 3):
    temp_sum = sum(cards)
    if max_num < temp_sum <= target:
        max_num = temp_sum

print(max_num)