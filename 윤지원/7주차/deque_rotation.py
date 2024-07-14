def min_hours(T, test_cases):
    results = []
    for n, m in test_cases:
        # Initialize an array to track how many topics each person knows
        knowledge = [0] * n        
        hours = 0
        while any(knowledge[i] < m for i in range(n - 1)):
            # Each hour, try to spread knowledge from right to left
            new_knowledge = knowledge[:]
            for i in range(n - 1):
                if knowledge[i + 1] > knowledge[i]:
                    transfer = min(knowledge[i + 1] - knowledge[i], m - knowledge[i])
                    new_knowledge[i] += transfer
            
            knowledge = new_knowledge
            hours += 1
        
        results.append(hours)
    
    return results

# Input handling
T = int(input().strip())
test_cases = [tuple(map(int, input().strip().split())) for _ in range(T)]

# Calculate results and print them
results = min_hours(T, test_cases)
for result in results:
    print(result)


1 2
2 3
3 4 1 2
4 5 2 3 (1끝)
3 4 1 2
4 5 2 3 (2끝)
3 4
4 5 (3끝)
