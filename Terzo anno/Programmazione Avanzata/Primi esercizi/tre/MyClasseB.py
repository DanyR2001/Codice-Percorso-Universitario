class ClasseA:
    """5"""
    imola = "piede"

    def __init__(self):
        self.y=5


class ClasseB(ClasseA):
    imbroglio="mano"

    def __init__(self):
        self.x=5

    def contaClasseVarIstanza(self, t, n):
        counter = 0
        for i, item in enumerate(ClasseB.__mro__):
            if i > n-1:
                break
            else:
                #print("i:", i, " item ", item)
                #print(vars(item))
                x = item()
                try:
                    for key, value in vars(x).items():
                        #print("in key",key,", in value ",value)
                        if type(value) == t:
                            counter += 1
                except:
                    print("except: no dict")
        print(counter)


    def contaClasseVar(self, t, n):
        counter = 0
        for i, item in enumerate(type(self).__mro__):
            if i > n-1:
                break
            else:
                try:
                    for key, value in vars(item).items():
                        print("in key",key,", in value ",value,", type ",type(value))
                        if key != '__module__' and key != '__doc__':
                            if type(value) == t:
                                counter += 1
                except:
                    print("except: no dict")
        print(counter)
