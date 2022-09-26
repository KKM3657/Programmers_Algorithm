# 변수 선언 및 입력
n, m = tuple(map(int, input().split()))

# dx, dy 테크닉
dxs, dys = [0,1,0,-1], [1,0,-1,0]
x,y = 0, 0  # 초기위치
dir_num = 0 # R방형
# 격자판 생성
grid = [ 
    [0] * m
    for _ in range(n)
]
# 범위에 포함 되는지 판별
def is_range(nx,ny):
    return 0 <= nx and nx < n and 0 <= ny and ny < m

# 격자판 채우기
for i in range(1, n *m +1):
    grid[x][y] = i

    nx, ny = x + dxs[dir_num] , y + dys[dir_num]

    if not is_range(nx,ny) or grid[nx][ny] != 0:
       dir_num = (dir_num + 1) % 4

    x, y = x + dxs[dir_num] , y + dys[dir_num]

# 출력
for i in range(n):
    for j in range(m):
        print(grid[i][j], end = ' ')
    print()