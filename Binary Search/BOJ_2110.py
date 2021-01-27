global N
global C
N,C = map(int,input().split())

global array
array = []

for i in range(N):
    array.append(int(input()))

array.sort()

global answer
answer = []

answer.append(array[0])
answer.append(array[N-1])
C-=2

def bs(start, end):
    global C
    if start==end:
        return 0
    if C==0:
        return 0
    mid=(start+end)//2
    answer.append(array[mid])
    C-=1
    bs(start,mid-1)
    bs(start,mid+1)

bs(0,N-1)

print(answer[C-1]," ",answer[C-2])
print(answer[0],answer[1],answer[2])
