n, t = tuple(map(int, input().split()))
array1 = list(map(int, input().split()))
array2 = list(map(int, input().split()))

for _ in range(t):
    temp1, temp2 = array1.pop(), array2.pop()
    array1.insert(0, temp2)
    array2.insert(0, temp1)

for i in range(n):
    print(array1[i] , end =  " ")
print()
for i in range(n):
    print(array2[i] , end =  " ")