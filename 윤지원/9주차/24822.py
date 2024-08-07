"""
musical trees 24822
주어진 n개의 사람들 위치
주어진 m개의 나무 위치
the person can only take positions that are lower than itsself

"""
def musical_trees(n, m, people_positions, tree_positions):
    # 사람의 위치와 나무의 위치를 정렬합니다.
    people_positions.sort()
    tree_positions.sort()

    # 각 사람이 가장 가까운 나무를 선택하는 리스트
    closest_tree = [-1] * n
    
    # 각 나무가 선택되었는지 여부를 저장하는 리스트
    tree_taken = [False] * m
    
    # 각 사람에 대해 가장 가까운 나무를 선택
    for i in range(n):
        min_distance = float('inf')
        chosen_tree = -1
        for j in range(m):
            distance = abs(people_positions[i] - tree_positions[j])
            if distance < min_distance:
                min_distance = distance
                chosen_tree = j
            #업데이트한 거리와 새 거리가 같으면 나무의 위치가 더 작은
            # 나무를 선택. 
            elif distance == min_distance and tree_positions[j] < tree_positions[chosen_tree]:
                chosen_tree = j
        closest_tree[i] = chosen_tree

    # 실제로 나무를 차지하는 사람을 확인
    people_without_tree = 0
    for i in range(n):
        if tree_taken[closest_tree[i]]:
            people_without_tree += 1
        else:
            tree_taken[closest_tree[i]] = True
    
    return people_without_tree

# 입력 받기
n, m = map(int, input().split())
people_positions = list(map(int, input().split()))
tree_positions = list(map(int, input().split()))

# 결과 출력
result = musical_trees(n, m, people_positions, tree_positions)
print(result)
