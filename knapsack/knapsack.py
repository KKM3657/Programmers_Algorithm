def knapsack(i, size):
    global X, value, mp
    if i >= n or size <= 0: return  # 모든 갯수를 확인한 경우, 크기를 넘어가는 경우 return
    s_sum, p_sum = 0, 0
    for j in range(0, i):  # s_sum, p_sum 계산
        if X[j] == 1:
            s_sum = s_sum + value[j][0]
            p_sum = p_sum + value[j][1]
    # X[i] = 1 인 경우 try
    if value[i][0] <= size:  # i의 사이즈 확인
        B = frac_knapsack(i + 1, size - value[i][0])  # 최대 예상가치 계산
        if mp < p_sum + value[i][1] + B:  # 최대 예상가치가 기존의 최대 예상가치를 넘으면 시행
            X[i] = 1  # i번째 선택
            mp = max(mp, p_sum + value[i][1])
            knapsack(i + 1, size - value[i][0])  # 다음 번째 시행
    # X[i] = 0 인 경우 try
    B = frac_knapsack(i + 1, size)  # 최대 예상가치 계산
    if mp < p_sum + B:  # 최대 예상가치가 기존의 최대 예상가치를 넘으면 시행
        X[i] = 0  # i번째 선택 X
        knapsack(i + 1, size)


def frac_knapsack(i, size):  # 최대 예상가치 계산
    global value, n  # 가성비가 좋은것부터 선택
    p_sum = 0
    while i < n and size > 0:  # 크기를 넘어가는 경우, 갯수를 넘어가는 경우 없을 때 까지 반복
        if size - value[i][0] > 0:  # 크기를 넘어가는지 확인
            size = size - value[i][0]  # 넘어가지 않으면 배낭에 추가
            p_sum = p_sum + value[i][1]  # 가치를 더하기
            i = i + 1  # 다음 아이템 확인
        else:  # 크기를 넘어가는 경우
            p_sum = p_sum + (size * value[i][2])  # 넘어가면 남은자리는 최대 가성비로 계산하여 빠짐없이 채움
            i = i + 1
            size = 0
    return p_sum  # 최대 예상가치 반환


k = int(input())
n = int(input())
S = list((int(x) for x in input().split()))
P = list((int(y) for y in input().split()))
X = [0] * n
value = [[0 for col in range(3)] for row in range(n)]  # 크기, 가치, 가성비 순으로 저장
mp = 0  # 최대 가치
for i in range(0, n):
    value[i][0], value[i][1] = S[i], P[i]
    value[i][2] = P[i] / S[i]

value.sort(key=lambda x: -x[2])  # 가성비 기준으로 내림차순 정렬
knapsack(0, k)  # 최대 가치 계산
print(mp)
