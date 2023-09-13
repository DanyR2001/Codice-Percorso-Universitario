
class Panino:

    __slots__ = {"varA":None,"varB":None,"dict":None}

    def __init__(self):
        Panino.__slots__["dict"] = locals()

    def __setattr__(self, key, value):
        if key in Panino.__slots__:
            Panino.__slots__["dict"]=locals()
            return super(Panino, self).__setattr__(key,value)
        else:
            return setattr(__class__,key,value)
