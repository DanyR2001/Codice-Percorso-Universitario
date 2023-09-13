import functools


def coroutine(function):
    @functools.wraps(function)
    def wrapper(*args, **kwargs):
        generator = function(*args, **kwargs)
        next(generator)
        return generator
    return wrapper

@coroutine
def attacca(suffisso,myfile):
    fp = open(myfile, "a")
    fp.write("\n")
    fp.close()
    while True:
        stringa=str((yield))
        print(stringa,suffisso)
        if stringa.endswith(suffisso):
            raise ValueError("la stringa {} finisce con {}, corutine smette di funzionare".format(stringa,suffisso))
        else:
            temp=stringa+suffisso+"\n"
            fp=open(myfile,"a")
            fp.write(temp)
            fp.close()


def i_o(myFile,suffisso):
    all_Word= open(myFile,"r").read().split()
    heandler=attacca(suffisso,myFile)
    for word in all_Word:
        try:
            heandler.send(word)
        except ValueError as err:
            print(err)
        except StopIteration:
            pass
    heandler.close()



if __name__=="__main__":
    i_o("temp.txt","anni")
