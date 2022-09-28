n, m = tuple(map(int, input().split())) # n,m 입력
# 격자점 초기화
grid = [
    [0] * n
    for _ in range(n)
]
# dx, dy 테크닉
dxs, dys = [0,0,1,-1], [1,-1,0,0]

# 격자 범위안에 있는지 판별
def inRange(x,y):
    return 0 <= x and x < n and 0 <= y and y < n

for _ in range(m):
    cnt = 0
    x, y = tuple(map(int, input().split()))
    x, y = x-1, y-1
    grid[x][y] = 1  # 색깔 칠하기
    for nx, ny in zip(dxs, dys):    # 4방향 색깔 확인
        nx, ny = x + nx, y + ny
        if inRange(nx,ny) and grid[nx][ny] == 1:
            cnt += 1
    if cnt == 3:    # 편한한 상태 판별 
        print(1)
    else:
        print(0)