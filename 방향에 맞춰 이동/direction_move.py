dx, dy = [1,-1,0,0] , [0,0,-1,1]
x, y = 0, 0

n = int(input())
for k in range(n):
    dir_num = 0
    a, b = input().split(" ");
    dist = int(b)
    
    if a == 'E':
        dir_num = 0
    elif a == 'W':
        dir_num = 1
    elif a == 'S':
        dir_num = 2
    elif a == 'N':
        dir_num = 3 

    x , y = x + (dx[dir_num] * dist), y + (dy[dir_num] * dist)

print(x, y)