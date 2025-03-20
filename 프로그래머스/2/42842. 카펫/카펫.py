def solution(brown, yellow):
    total = brown + yellow
    
    for h in range(3, int(total**0.5) + 1):  
        if total % h == 0:  
            w = total // h
            
            if 2*w + 2*h - 4 == brown:
                return [w, h] 