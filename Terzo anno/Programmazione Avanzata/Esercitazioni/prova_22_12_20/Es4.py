
import sys
import multiprocessing
from concurrent.futures import ProcessPoolExecutor, as_completed


def worker(nome,file):
    fp=open(nome,"w")
    fp2=open(file,"r")
    numCaratteri=0
    for i,word in enumerate(fp2):
        if i%2==0:
            fp.write(word)
            numCaratteri+=len(word)
    fp.close()
    fp2.close()
    return "Il file {} contiene {} caratteri".format(nome,str(numCaratteri))

def creaIFile(listaNomiFile:list,listaFileDaCopiare:list,concorrenza):

    futures = set()

    with ProcessPoolExecutor(max_workers=concorrenza) as executor:
        for nome,file in zip(listaNomiFile,listaFileDaCopiare):
            futures.add(executor.submit(worker,nome,file))

    for item in as_completed(futures):
        curr_p = item.result()
        print(curr_p)

if "__main__"==__name__:
    l1=["massimo.txt","mario.txt"]
    l2=["leggi1.txt","leggi2.txt"]
    creaIFile(l1,l2,2)
