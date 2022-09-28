n = int(input())
# 격자점 생성
grid = [
    list(map(int,input().split()))
    for _ in range(n)
]

max_cnt = 0

# 동전 갯수 찾기
def much_coin(r,c):
    cnt = 0
    for i in range(r, r+3):
        for j in range(c, c+3):
            cnt += grid[i][j]
    return cnt

# 완전 탐색
for row in range(n):
    if row + 2 >= n:
        continue
    for col in range(n):
        if col + 2 >= n:
            continue
        cnt = much_coin(row,col)
        max_cnt = max(cnt, max_cnt)

print(max_cnt)