
"""
    Scrivere una funzione che prende in input una lista L e restituisce una lista di |L|!
    liste in cui ciascuna lista contiene una diversa permutazione degli elementi della lista input L
"""

import datetime


def genPerms(l):
    if not l:  # needed for recursion
        return [[]]
    res = []
    i = 0
    for x in l:
        templist = l[:]
        templist.remove(x)
        res.extend([[x] + r for r in genPerms(templist)])
        i += 1
    return res

if __name__=="__main__":
    x=['1','2','3','4','5','6','7','8','9']
    start_time = datetime.datetime.now()
    li=genPerms(x)
    end_time = datetime.datetime.now()
    print(end_time-start_time)
    print(len(li))