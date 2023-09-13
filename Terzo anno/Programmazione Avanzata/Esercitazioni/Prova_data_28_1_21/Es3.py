
class FSet(frozenset):

    def __new__(cls,insieme):
        res=list()
        for i,x in enumerate(insieme):
            if i%2==0:
                res.append(x)
        return frozenset(res)



if "__main__"==__name__:
    x=FSet({1,2,3,4})
    print(x)