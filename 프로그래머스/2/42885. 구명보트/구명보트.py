def solution(people, limit):
    count = 0
    people.sort()  
    
    left = 0
    right = len(people) - 1
    
    while left <= right:
        if people[left] + people[right] <= limit:
            left += 1
        right -= 1
        count += 1
    
    return count