import multiprocessing

def search(j:int,numero:int):
    dizionario=dict()
    for i in range(1,numero+1):
        dizionario[i]=i+j
    return dizionario

def worker(jobs,results):
    while True:
        i,numero=jobs.get()
        try:
            result=search(i,numero)
            results.put(result)
        finally:
            jobs.task_done()

def create_process(jobs,results,concorrenza):
    for _ in range(concorrenza):
        processo=multiprocessing.Process(target=worker,args=(jobs,results))
        processo.daemon=True
        processo.start()

def add_jobs(listaNumeri,jobs):
    for i,value in enumerate(listaNumeri):
        jobs.put((i+1,value))

def creaDizionari(listaNumeri:list,concorrenza:int):
    jobs=multiprocessing.JoinableQueue()
    results=multiprocessing.Queue()
    add_jobs(listaNumeri,jobs)
    create_process(jobs,results,concorrenza)

    try:
        jobs.join()
    except KeyboardInterrupt:
        print("annullamento in corso...")

    lista=list()
    while not results.empty():
        result=results.get_nowait()
        lista.append(result)

    for item in lista:
        print(item)

if __name__=="__main__":
    l1=[5,10,20,2]
    creaDizionari(l1,4)