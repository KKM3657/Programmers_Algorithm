# n 입력
n = int(input())
array = []

for _ in range(n):
    array.append(int(input()))

f_st, f_la = tuple(map(int,input().split()))
s_st, s_la = tuple(map(int,input().split()))
# 해당부분은 넘어가고 다시 저장
def delete_block(n_array,start, end):
    temp = []
    for i in range(len(n_array)):
        if (start - 1) <= i <= (end - 1):   # 넘어가는 구간
            continue
        temp.append(n_array[i])
    n_array = [0] * len(temp)   # array 초기화
    for i in range(len(temp)):  # temp를 array에 복사
        n_array[i] = temp[i]
    return n_array

array = delete_block(array,f_st,f_la)
array = delete_block(array,s_st,s_la)

print(len(array))
for i in range(len(array)):
    print(array[i])

