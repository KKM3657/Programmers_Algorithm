num = int(input())
x, y = 0, 0
answer = False
dxs, dys = [1,0,-1,0], [0,-1,0,1]
dir_letter ={
    'E' : 0,
    'W' : 2,
    'S' : 1,
    'N' : 3
}
cnt = 0
for _ in range(num):
    direct, dist = tuple(input().split())
    dist = int(dist)
    for _ in range(dist):
        nx, ny  = x + dxs[dir_letter[direct]] , y + dys[dir_letter[direct]]
        if nx == 0 and ny == 0:
            print(cnt + 1)
            answer = True
            break 
        else:
            x, y = nx, ny
            cnt += 1
    if answer:
        break

if not answer:
    print(-1)    