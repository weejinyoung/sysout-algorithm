def get_wierd_char(s):
    result = ''
    for i in range(len(s)):
        if i % 2 == 0:
            result += s[i].upper()
        else:
            result += s[i].lower()
    return result

def to_word_list(s):
    return s.split(' ')

def solution(s):
    answer = ''
    word_list = to_word_list(s)
    for word in word_list:
        answer += get_wierd_char(word) + ' '
    answer = answer[:-1]
    return answer