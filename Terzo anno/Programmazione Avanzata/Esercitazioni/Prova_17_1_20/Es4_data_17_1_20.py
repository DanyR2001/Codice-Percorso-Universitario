from multiprocessing import Process


def cerca(listaPAR,listFile,concorrenza):
    numFile = int(len(listFile)/concorrenza)
    process = list()
    minIndex = 0
    maxIndex=numFile
    for i in range(concorrenza):
        p = Process(target=findInFile, args=(listaPAR, listFile, minIndex, maxIndex))
        minIndex+=numFile
        maxIndex+=numFile
        process.append(p)
        p.start()
    for p in process:
        p.join()


def findInFile(listaPAR,files,minIndex,maxIndex):
    for i in range(minIndex,maxIndex):
        fp = open(files[i], "r")
        lista = {}
        for word in listaPAR:
            lista[word] = 0
        for line in fp:
            for x in listaPAR:
                lista[x]+=line.count(x)
        print(files[i],lista)
        print(files[i],max(lista,key=lista.get))
        fp.close()

if "__main__"==__name__:
    listaParole=["ciao","casa"]
    listaFile=["file1.txt","file2.txt"]
    cerca(listaParole,listaFile,2)