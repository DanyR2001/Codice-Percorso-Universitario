import collections
import functools
import numbers
import os


def coroutine(function):
    @functools.wraps(function)
    def wrapper(*args, **kwargs):
        generator = function(*args, **kwargs)
        next(generator)
        return generator

    return wrapper

@coroutine
def sender(receiver=None, maximum=None):
    somma=0
    lista=list()
    while True:
        number=(yield )
        if maximum is not None and receiver is not None:
            if isinstance(number,numbers.Number):
                somma+=number
                lista.append(number)
                if somma>= maximum:
                    receiver.send(lista)
                    somma=0
                    lista.clear()
            else:
                receiver.close()
                break


@coroutine
def writer(NameFile=None):
    while True:
        lista=(yield)
        if isinstance(lista,collections.abc.Collection):
            if NameFile is not None:
                fp=open(NameFile,"a")
                for element in lista:
                    fp.write(str(element)+" ")
                fp.write("\n")
                fp.close()
        else:
            break


def main():
    s = sender(writer("file"), 100.5)

    for i in range(3, 10):
        for x in range(1, 30, i):
            try:
                s.send(x)

            except StopIteration:
                print("Il sender {} non accetta piu` richieste perche' e` stato inviato un oggetto non numerico".format(s))
                print()
    o = open("file", 'r')
    print("Questo e` il contenuto del file:")
    for line in o:
        print(line)
#---------------------------------------
    for i in range(6, 10):
        for x in range(7, 60, i):
            try:
                s.send(x)
            except StopIteration:
                print("Il sender {} non accetta piu` richieste perche' e` stato inviato un oggetto non numerico".format(s))
                print()

    o = open("file", 'r')
    print("Questo e` il contenuto del file:")
    for line in o:
        print(line)

    for i in range(6, 8):
        for x in range(7, 15, i):
            try:
                s.send(x)
            except StopIteration:
                print("Il sender {} non accetta piu` richieste perche' e` stato inviato un oggetto non numerico".format(s))
                print()

    try:
        s.send('pop')
    except StopIteration:
        print("Il sender {} non accetta piu` richieste perche' e` stato inviato un oggetto non numerico".format(s))
        print()

    o = open("file", 'r')
    print("Questo e` il contenuto del file:")
    for line in o:
        print(line)

    s.close()
    os.remove("file")


if __name__ == "__main__":
    main()

"""
Ricordatevi di cancellare il file ogni volta che eseguite il programma!

Il programma deve stampare: 

Questo e` il contenuto del file:
1 4 7 10 13 16 19 22 25 

28 1 5 9 13 17 21 25 

29 1 6 11 16 21 26 

1 7 13 19 25 1 8 15 22 

29 1 9 17 25 1 10 19 

Questo e` il contenuto del file:
1 4 7 10 13 16 19 22 25 

28 1 5 9 13 17 21 25 

29 1 6 11 16 21 26 

1 7 13 19 25 1 8 15 22 

29 1 9 17 25 1 10 19 

28 7 13 19 25 31 

37 43 49 

55 7 14 21 28 

35 42 49 

56 7 15 23 

31 39 47 

55 7 16 25 

34 43 52 

Il sender {} non accetta piu` richieste perche' e` stato inviato un oggetto non numerico

Questo e` il contenuto del file:
1 4 7 10 13 16 19 22 25 

28 1 5 9 13 17 21 25 

29 1 6 11 16 21 26 

1 7 13 19 25 1 8 15 22 

29 1 9 17 25 1 10 19 

28 7 13 19 25 31 

37 43 49 

55 7 14 21 28 

35 42 49 

56 7 15 23 

31 39 47 

55 7 16 25 

34 43 52 

"""
