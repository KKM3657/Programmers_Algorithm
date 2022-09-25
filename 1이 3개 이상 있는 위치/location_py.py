def in_range(x, y, num):
    return 0 <= x and x < num and 0 <= y and y < num

num = int(input())
arr_2d = []
dxs, dys = [0, 1, 0, -1], [1, 0, -1, 0]

for _ in range(num):
    arr_1d = list(map(int, input().split()))
    arr_2d.append(arr_1d)

count = 0
for i in range(num):
    for j in range(num):
        cnt = 0
        for dx, dy in zip(dxs, dys):
            dx, dy = i + dx , j + dy 
            if in_range(dx,dy,num) and arr_2d[dx][dy] == 1:
                cnt += 1
        if cnt >= 3:
            count += 1
print(count)