def solution(s):
    map = {
        "pP":0,
        "yY":0
    }
    
    for element in s:
        if element == "p" or element == "P":
            map["pP"] += 1
        elif element == "y" or element == "Y":
            map["yY"] += 1
    
    if map["pP"] == map["yY"]:
        return True
    else:
        return False
        