N=int(input())

array=list(map(int, input().split()))

array.sort()

if(N%2==1):
    a=N//2
    
else:
    a=N//2-1

print(array[a])
