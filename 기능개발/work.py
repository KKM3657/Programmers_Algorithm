import math
def solution(progresses, speeds):
    content, count, prev_day = 0, 0, 0
    answer = []
    while True:
        if content == len(progresses):
            answer.append(count)
            break
        leave = 100 - progresses[content]
        day = math.ceil(leave / speeds[content])
        content += 1
        if prev_day == 0:
            prev_day = day
            count += 1
            continue
        if day <= prev_day:
            count += 1
        else:
            answer.append(count)
            count = 1
            prev_day = day

    return answer