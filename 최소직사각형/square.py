def solution(sizes):
    row, column = [], []
    for value1, value2 in sizes:
        if value1 > value2:
            row.append(value1)
            column.append(value2)
        else:
            row.append(value2)
            column.append(value1)
    answer = max(row) * max(column)
    return answer