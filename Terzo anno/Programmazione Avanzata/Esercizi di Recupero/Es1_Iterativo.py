
"""
    Scrivere una funzione che prende in input una lista L e restituisce una lista di |L|!
    liste in cui ciascuna lista contiene una diversa permutazione degli elementi della lista input L
"""

import datetime
import threading
from multiprocessing import Process


@staticmethod
def lists(l):
    returnment=list()
    dic=l.copy()
    queue=list()
    for el in l:
        tmp=list()
        tmp.append(el)
        queue.append(tmp)
    while len(queue)!=0 :
        #print(queue)
        #print(len(queue))
        x=queue.pop(0)
        #print(x)
        if len(x)==len(l):
            #print("aapeso")
            returnment.append(x)
        else:
            for i in dic:
                if i not in x:
                    tem = x.copy()
                    tem.append(i)
                    queue.append(tem)
        del(x)
    return returnment

def lists_tr(l,dic,returnment):
    queue=list()
    for el in l:
        tmp=list()
        tmp.append(el)
        queue.append(tmp)
    while len(queue)!=0 :
        #print(queue)
        #print(len(queue))
        x=queue.pop(0)
        #print(x)
        if len(x)==len(dic):
            #print(x)
            returnment.append(x)
        else:
            for i in dic:
                if i not in x:
                    tem = x.copy()
                    tem.append(i)
                    queue.append(tem)
        del(x)
    return returnment


if __name__ == '__main__':
    """Tread
    start_time = datetime.datetime.now()
    li=list()
    threads = list()
    for index in range(0,len(x)):
        tr = threading.Thread(target=lists_tr, args=(x[index],x,li,))
        threads.append(tr)
        tr.start()
    for index, thread in enumerate(threads):
        thread.join()
    end_time = datetime.datetime.now()"""
    x = ['1', '2', '3', '4', '5', '6', '7', '8', '9']
    li=list()
    process= list()
    start_time = datetime.datetime.now()
    for index in range(0,len(x)):
        p = Process(target=lists_tr, args=(x[index],x,li,))
        process.append(p)
        p.start()
    for index, p in enumerate(process):
        p.join()
    end_time = datetime.datetime.now()
    print(end_time-start_time)
    print(len(li))