def solution(k, tangerine):
    answer = 0
    map = {}
    for item in tangerine:
        map[item] = map.get(item, 0) + 1
    sorted_map = dict(sorted(map.items(), key=lambda item: item[1], reverse=True))
    
    for key, value in sorted_map.items():
        if k <= 0:
            return answer
        k -= value
        answer += 1
        
    return answer
    