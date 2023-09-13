class Base:

    x=__name__

    def __init_subclass__(cls, **kwargs):
        cls.x=cls.__name__


    def print_x(self):
        print("name_mod: ",self.__class__.__name__,", x value: ", self.__class__.x)


    def modifica_x(self,x1):
        self.__class__.x=x1


