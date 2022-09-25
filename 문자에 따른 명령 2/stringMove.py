string = input()
dir_num = 3
x, y = 0, 0
dx, dy = [1,0,-1,0], [0,-1,0,1]
for i in range(len(string)):
    if string[i] == "R":
        dir_num = (dir_num + 1) % 4
    elif string[i] == "L":
        dir_num = (dir_num - 1 + 4) % 4
    else:
        x, y = x + dx[dir_num], y + dy[dir_num]

print(x,y)