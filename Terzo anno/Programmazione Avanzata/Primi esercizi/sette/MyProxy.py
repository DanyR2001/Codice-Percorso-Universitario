from MyClass import MyClass
class MyProxy:

    def __init__(self,x):
        self.classe=MyClass(x)

    def __getattr__(self, item):
        return getattr(self.classe,item)
