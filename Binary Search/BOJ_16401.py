M,N=list(map(int,input().split(' ')))
L=list(map(int,input().split()))

L.sort()

low=1
high=L[N-1]

ans=0

while low<=high:
    temp=0
    mid=(low+high)//2
    for i in range(N):
        temp+=L[i]//mid
    if M<=temp:
        low=mid+1
        ans=mid
    else:
        high=mid-1

print(ans)
