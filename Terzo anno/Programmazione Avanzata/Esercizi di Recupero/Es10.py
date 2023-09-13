
"""
    Scrivere una funzione apply(due_things) che prende in input una tupladue_thingsche contiene  tupledella forma
    (meth, arg1,arg2,...) dove methè un metodo di istanza di una certa classe C e  arg1, arg2,... sono gli
    argomenti diversi da self con cui deve essere invocato meth. Nella prima tupladi due_things, methè la classe C
    e gli argomenti sono quelli da passare al costruttore per creare l’istanza di C su cui invocare i metodi
    delle restanti tupledi due_things. La funzione applica restituisce una lista contenente come primo
    elemento l’istanza creata e come restanti elementi i valori restituiti dalle invocazioni dei metodi delle
    restanti tuple.
"""

def apply(due_things):

    print(due_things)
    listResult=list()

    func,*args=due_things[0]
    obj = func(*args)
    listResult.append(obj)
    for i in range(1,len(due_things)):
        print(i)
        func, *args = due_things[i]
        print(func,*args)
        res=func(obj,*args)
        listResult.append(res)

    return listResult

class popCorn:

    def __init__(self,cipolle):
        print(cipolle)

    def ciao(self,*ciao):
        print("hahah",*ciao)
        return "haha"+str(ciao)

    def stampa_tutto(self,*args,**kwargs):
        print(*args,**kwargs)
        return "cipolle"

print(apply(((popCorn,("mario","maria")),(popCorn.ciao,("marco","giulio")),(popCorn.stampa_tutto,("hahhahaha","hihihihihi"),{"mamma":"mia","if you":"go egain"}))))