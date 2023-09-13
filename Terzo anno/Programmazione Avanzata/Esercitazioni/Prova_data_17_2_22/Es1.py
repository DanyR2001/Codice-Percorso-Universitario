
class StranaTupla(tuple):

    def __new__(cls, lib):
        return tuple([nome for i,nome in enumerate(lib) if i%2==0])
        """li = list()
        for i in range(0, len(lib) ):
            if i % 2 == 0:
                li.append(lib[i])
        return tuple(li)"""


if "__main__"==__name__:
    x=StranaTupla(["ha",1,4,"cipolle"])
    print(x)
