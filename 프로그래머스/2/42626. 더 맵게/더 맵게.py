import heapq

def solution(scoville, K):
    answer = 0
    heapq.heapify(scoville)    
    while True:
        if scoville[0] >= K:
            return answer
        elif len(scoville) == 1 and scoville[0] < K:
            return -1
        else:
            first_scoville = heapq.heappop(scoville)
            second_scoville = heapq.heappop(scoville) * 2
            new_scoville = first_scoville + second_scoville
            heapq.heappush(scoville, new_scoville)
            answer += 1
