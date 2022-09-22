def solution(participant, completion):
    dict_table = {}
    for name in participant:
        if name in dict_table:
            dict_table[name] += 1
            continue
        dict_table[name] = 1
    for name in completion:
        if name in dict_table:
            dict_table[name] -= 1
    for name in dict_table:
        if dict_table[name] != 0:
            return name