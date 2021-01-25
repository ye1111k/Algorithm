N=int(input())

low=0
high=N
mid=high

while low<=high:
    mid=(low+high)//2
    if mid*mid==N: break
    elif mid*mid<N: low=mid+1
    else: high=mid-1

print(mid)
