# 숫자 카드

n = int(input())
n_list = set(map(int, input().split()))  # n_list를 set으로 변환하여 시간 복잡도를 O(1)로 줄임
m = int(input())
m_list = list(map(int, input().split()))

card = []

for i in range(m):
    if m_list[i] in n_list:
        card.append("1")
    else:
        card.append("0")

print(" ".join(card))


# strip(): 문자열 끝에 불필요한 공백 삭제