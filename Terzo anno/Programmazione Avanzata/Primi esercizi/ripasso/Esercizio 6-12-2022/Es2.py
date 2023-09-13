import multiprocessing

def add_jobs(listaParole, listaFile, jobs):
    for name in listaFile:
        jobs.put((listaParole, name))

def worker(jobs, results):
    while True:
        listaParole, nome = jobs.get()
        try:
            result = search(listaParole, nome)
            results.put(result)
        finally:
            jobs.task_done()

def search(listaParole,file):
    counterWord={}
    for word in listaParole:
        counterWord[word]=0
        fp=open(file,"r")
        all_word=fp.read().split()
        counterWord[word]+=all_word.count(word)
        fp.close()
    maxy=max(counterWord.values())
    name = [name for name, value in counterWord.items() if value==maxy]
    Stringa="La stringa della lista {} che appare il maggior numero di volte nel file {} e` {}.\n".format(listaParole,file,name[0])
    Stringa+="Essa appare {} volte nel file.".format(maxy)
    return Stringa


def create_processes(jobs,result, concurrency):
    for _ in range(concurrency):
        process = multiprocessing.Process(target=worker, args=(jobs,result))
        process.daemon =True
        process.start()

def stampaParole(listaParole:list,listaFile:list,concorrenza:int):
    canceled =False
    jobs = multiprocessing.JoinableQueue()
    results = multiprocessing.Queue()
    add_jobs(listaParole,listaFile, jobs)
    create_processes(jobs, results, concorrenza)
    try:
        jobs.join()
    except KeyboardInterrupt:
        # May not work on Windows
        canceled =True
    lista=list()
    while not results.empty():# Safe because all jobs have finished
        result = results.get_nowait()
        lista.append(result)

    for line in lista:
        print(line)

def main():


    files =["file1" ,"file2" ,"file3" ,"file4"]
    parole =["computer" ,"very" ,"with" ,"is" ,"algorithms"]


    stampaParole(parole ,files ,4)





if __name__ == "__main__":
    main()

"""  Ecco cosa deve essere stampato (l'ordine delle righe potrebbe cambiare):
La stringa della lista ['computer', 'very', 'with', 'is', 'algorithms'] che appare il maggior numero di volte nel file file2 e` "very".
Essa appare 3 volte nel file.

La stringa della lista ['computer', 'very', 'with', 'is', 'algorithms'] che appare il maggior numero di volte nel file file1 e` "computer".
Essa appare 48 volte nel file.

La stringa della lista ['computer', 'very', 'with', 'is', 'algorithms'] che appare il maggior numero di volte nel file file4 e` "is".
Essa appare 2 volte nel file.

La stringa della lista ['computer', 'very', 'with', 'is', 'algorithms'] che appare il maggior numero di volte nel file file3 e` "is".
Essa appare 113 volte nel file.

"""
