x=int(input())
res=int(input())
disturbed=int(input())
if disturbed:
    if res:#성공하면
        res2=int(input())
        ans=res2+x
    else:# fail
        ans=0
        for _ in range(x):
            res2=int(input())
            ans+=res2
else:
    ans=x
    
print(ans)
