'''
[while문] --> 시간초과나서 deque로 구현해봄.
import sys

n = int(sys.stdin.readline())
card = []
for i in range(1, n+1):
    card.append(i)

while len(card) != 1:
    card.pop(0)
    temp = card.pop(0)
    card.append(temp)

print(card[0])
'''

#deque문
from collections import deque
import sys

n = int(sys.stdin.readline())
card = deque(range(1, n + 1))

while len(card) > 1:
    card.popleft()  # 제일 위 카드를 버림
    card.append(card.popleft())  # 그 다음 제일 위 카드를 제일 아래로 옮김

print(card[0])