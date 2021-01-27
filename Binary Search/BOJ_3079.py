N,M=map(int,input().split())
T=[]

for i in range(N):
    T.append(int(input()))

T.sort()

low=1
high=T[N-1]*M
answer=high

while low<=high:
    mid=(low+high)//2
    count=0;
    for i in range(N):
        count+=mid//T[i]
    if M<=count:
        answer=mid
        high=mid-1
    else:
        low=mid+1

print(answer)
