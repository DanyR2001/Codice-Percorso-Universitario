import collections
import multiprocessing

Tupla=collections.namedtuple('Tupla',['filename','value'])

def max_num_occorrenze(P:str,listaDiFile:list,concorrenza:int):
    jobs=multiprocessing.JoinableQueue()
    results=multiprocessing.Queue()
    add_jobs(P,listaDiFile,jobs)
    create_process(jobs,results,concorrenza)
    try:
        jobs.join()
    except KeyboardInterrupt:
        print("Interruzione da tastiera")
    listaResult=list()
    while not results.empty():  # Safe because all jobs have finished
        result = results.get_nowait()
        listaResult.append(result)
    item =  [item for item in listaResult if item.value==max(item.value for item in listaResult)]

    return (item[0].filename,item[0].value)




def add_jobs(P,listaFile,jobs):
    for fileName in listaFile:
        jobs.put((P,fileName))

def create_process(jobs, results,concorrenza):
    for _ in range(concorrenza):
        proces=multiprocessing.Process(target=worker,args=(jobs,results))
        proces.daemon=True
        proces.start()

def worker(jobs,results):
    while True:
        P,fileName=jobs.get()
        try:
            result=findNum(P,fileName)
            results.put(result)
        finally:
            jobs.task_done()

def findNum(P,fileName):
    flag=True
    try:
        fp=open(fileName,"r")
    except FileNotFoundError:
        flag=False
    return Tupla(fileName,fp.read().split().count(P)) if flag else None


if __name__ == "__main__":
    l1=["file1","file2","file3","file4"]
    parola="rule"

    print(max_num_occorrenze(parola,l1,4))