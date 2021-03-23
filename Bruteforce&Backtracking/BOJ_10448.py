num = []
num.append(0)
for i in range(1,1001):
    num.append(num[i-1]+i)
    
n=int(input())

for i in range(n):
    ck=False
    a=int(input())
    for j in range(1,a):
        if ck==True: break
        for k in range(j,a):
            if ck==True: break
            for h in range(k,a):
                if ck==True: break
                if num[j]+num[k]+num[h]==a:
                    ck=True
                    break
    if ck:
        print(1)
    else:
        print(0)
            
