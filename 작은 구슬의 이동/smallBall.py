n, time = tuple(map(int, input().split()))
x , y , dir_letter = input().split()
x, y = int(x)-1, int(y)-1
dxs, dys = [0, 1, -1, 0], [1, 0, 0, -1]
if dir_letter == 'U':
    dir_num = 2
elif dir_letter == 'D':
    dir_num = 1
elif dir_letter == 'R':
    dir_num = 0
else:
    dir_num = 3

def is_range(nx, ny, n):
    return 0 <= nx and nx < n and 0 <= ny and ny < n

for _ in range(time):
    nx, ny = x + dxs[dir_num], y + dys[dir_num]
    if not is_range(nx, ny, n):
        dir_num = 3 - dir_num
    else:
        x, y = nx, ny
    
print(x+1,y+1)