
#Scrivere una classe che permetta di usare una lista in uno statement with.

class ListUseWhit:

    def __init__(self):
        self.lista=list()

    def __enter__(self):
        return self.lista

    def __exit__(self, exc_type, exc_val, exc_tb):
        print("err",exc_type,exc_val,exc_tb)
        del self.lista
        return True


def main():
    with ListUseWhit() as lista:
        lista.append("ciao")
        print("ciao")
        print(lista)
    print("haha")

if __name__=="__main__":
    main()
