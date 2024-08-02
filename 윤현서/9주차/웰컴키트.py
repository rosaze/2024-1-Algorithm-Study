people = int(input())

size_shirts = list(map(int, input().split()))

shirt_bundle, pen_bundle = map(int, input().split())

shirt_cnt = 0
pen_bundle_cnt = 0
pen_cnt = 0

for i in range(6):
    if size_shirts[i] == 0:
        continue
    elif size_shirts[i] < shirt_bundle:
        shirt_cnt += 1
    elif size_shirts[i] % shirt_bundle == 0:
        shirt_cnt += size_shirts[i] // shirt_bundle
    else: 
        shirt_cnt += size_shirts[i] // shirt_bundle + 1  

pen_bundle_cnt = people // pen_bundle
pen_cnt = people % pen_bundle

print(shirt_cnt)
print(pen_bundle_cnt, pen_cnt)
    
