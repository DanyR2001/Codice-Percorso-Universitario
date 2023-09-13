import collections.abc
import multiprocessing


def Search(p,namefile):
    try:
        fp=open(namefile,"r")
        count_p=fp.read().split().count(p)
        fp.close()
        if count_p > 0:
            fpword=open(namefile,"r")
            fpseek=open(namefile,"r")
            caratteri=0
            for line in fpword:
                for word in line.split():
                    if word== p:
                        fpword.close()
                        fpseek.close()
                        return "La parola {} appare nel file {} in posizione {}.".format(p,namefile,caratteri)
                    caratteri += fpseek.seek(len(word)+1)
        else:
            return "La parola {} non appare nel file {}.".format(p,namefile)
    except FileNotFoundError:
        return "file inseistente"

def worker(jobs,results):
    while True:
        p,nameFile=jobs.get()
        try:
            result=Search(p,nameFile)
            results.put(result)
        finally:
            jobs.task_done()

def add_jobs(P, listaFile, jobs):
    for file in listaFile:
        jobs.put((P,file))


def create_processes(jobs, results, concorrenza):
    for _ in range(concorrenza):
        process=multiprocessing.Process(target=worker,args=(jobs,results))
        process.daemon=True
        process.start()



def stampa(P:str,listaFile:collections.abc.Collection,concorrenza:int):
    jobs = multiprocessing.JoinableQueue()
    results = multiprocessing.Queue()
    add_jobs(P, listaFile, jobs)
    create_processes(jobs, results, concorrenza)
    try:
        jobs.join()
    except KeyboardInterrupt as err:
        print(err)# May not work on Windows
    lista=list()
    while not results.empty():
        result = results.get_nowait()
        lista.append(result)
    for line in lista:
        print(line)


if "__main__"==__name__:
    files = ["file1", "file2"]
    parole = "fresca"

    stampa(parole, files, 2)