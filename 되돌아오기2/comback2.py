array = input()
x, y = 0, 0
dxs, dys = [0, 1, 0, -1], [1, 0, -1, 0]
dir_num = 0
cnt = 0
answer = False

for i in range(len(array)):
    nx, ny = x + dxs[dir_num], y + dys[dir_num]
    if array[i] == 'F':
        cnt += 1
        x, y = nx, ny
        if x == 0 and y==0:
            print(cnt)
            answer = True
            break
    elif array[i] == 'R':
        dir_num = (dir_num + 1) % 4
        cnt += 1
    else:
        dir_num = (dir_num - 1 + 4) % 4
        cnt += 1
    

if not answer:
    print(-1)
