def leftFit(words):
    num = len(words)
    A = []
    penalty = [[-1 for col in range(num + 1)] for row in range(num + 1)]  # DP table
    n1 = findN(1, words)  # 1번줄에서 나올수 있는 words 수
    for m in range(1, n1 + 1):  # 1번줄 DP table 채우기
        space = findSpace(1, m, words)  # 각 원소에 해당하는 공백 구하기
        penalty[1][m] = (space ** 3)  # penalty 계산
        if penalty[1][num] == 0:  # 1번줄로 표현 가능한 경우
            return 0
    n1 = n1 + 1  # 다음 줄로 넘어간다
    n1 = findN(n1, words)  # 2번줄에서 나올수 있는 words 수
    for i in range(2, num + 1):  # i는 줄
        for j in range(i, n1 + 1):  # j는 끝의 자리가 들어올수 있는곳
            n2 = findRN(j, words)  # j를 구성할때의 시작점이 어디 부분인지 구하기
            if n2 > i:  # 시작점이 (i,i)보다 크면 시작을 시작점부터
                s = n2
            else:  # 아닌 경우 (i,i)부터 시작
                s = i
            for k in range(s, j + 1):  # k는 끝의 자리에 해당한 값이 나올수 있는 경우 #TODO: k != j
                space = findSpace(k, j, words)  # 남은 공백수
                if penalty[i - 1][k - 1] < 0:  # 이전 값이 없는 경우 넘어감
                    continue
                penalty1 = penalty[i - 1][k - 1] + (space ** 3)  # 페널티 계산
                # k: i ~ j-1까지 봐야함.
                A.append(penalty1)  # 최소를 구하기 위해 리스트에 저장
            penalty[i][j] = min(A)  # 최소값을 penalty에 저장
            A.clear()  # 리스트 초기화
            if penalty[i][num] != -1:  # 모든 줄을 보고 최초의 최소값이 나오면 종료
                return penalty[i][num]
        n1 = n1 + 1  # 다음줄로 이동
        n1 = findN(n1, words)  # 다음줄에서 나올 수 있는 words의 수


def findN(s, words):  # 시작점에서 나올수 있는 최대 words 구하기
    num = len(words)  # words의 길이
    global W          # 입력받은 W
    space = W         # 공백 초기화
    i = s             # 시작점
    while i <= num:   # 최대 words가 어디인지 구하기
        if space - len(words[i - 1]) > 0:
            space = space - len(words[i - 1]) - 1
        elif space - len(words[i - 1]) == 0:
            return i
        else:
            return i - 1
        i = i + 1
    return num     # 끝까지 다 돌면 num return


def findRN(f, words):   # 역으로 끝점에서 나올수 있는 최소점 words 구하기
    num = len(words)    # words 길이
    global W            # 입력받은 W
    space = W           # 공백 초기화
    i = f               # 끝점
    while i >= 1:       # 끝점 부터 나올 수 있는 최소점
        if space - len(words[i - 1]) > 0:
            space = space - len(words[i - 1]) - 1
        elif space - len(words[i - 1]) == 0:
            return i
        else:
            return i + 1
        i = i - 1
    return 1        # 끝까지 다 돌면 1 return


def findSpace(s, f, words):     # 남은 공백 구하기
    num = len(words)
    global W
    space = W
    i = s
    while i <= f:       # 최대 나올 수 있는 words까지 더했을때 남은 공백
        if space - len(words[i - 1]) > 0:
            if i == f:
                return space - len(words[i - 1])
            space = space - len(words[i - 1]) - 1
        elif space - len(words[i - 1]) == 0:
            return 0
        else:
            return space
        i = i + 1
    return space - len(words[num - 1]) - 1


W = int(input().strip())
words = input().split(" ")
penalty = leftFit(words)
print(penalty)
