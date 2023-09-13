class C:
    papi = "ciao"
    marco = "ciao"

    @classmethod
    def aggiuntaProprieta(cls):

        def aggProp(key,value):

            privateName="__"+key

            def getkey(self):
                if privateName not in vars(self):
                    setattr(self,privateName,value)
                return getattr(self, privateName)

            def setkey(self, val):
                if type(val) != str:
                    raise TypeError("Non è possibile assegnare a {} il tipo {}".format(key, type(key)))
                else:
                    setattr(self,privateName,val)

            def delkey(self):
                del self.key

            return property(getkey,setkey,delkey)

        for key,value in vars(cls).items():
            if isinstance(value, str) and key != "__module__" and key != "__doc__" and not callable(value):
                print(key, ":", value)
                setattr(cls,key,aggProp(key,value))


if __name__ == "__main__":

    c = C()
    C.aggiuntaProprieta()
    print(vars(C))
    print("1",c.papi)
    c.papi = "10"
    print("2",c.papi)
    print(vars(C))
    c.papi = 10
    print("3",c.papi)
    print(vars(C))
    del C.marco