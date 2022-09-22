def solution(s):
    array = s.split(" ")
    max_value, min_value = int(array[0]), int(array[0])
    for k in array:
        value = int(k)
        if value > max_value:
            max_value = value
        if value < min_value:
            min_value = value
    answer = str(min_value) + " " + str(max_value)
    return answer