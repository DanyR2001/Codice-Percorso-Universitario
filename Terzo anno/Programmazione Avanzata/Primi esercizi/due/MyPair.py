class Pair:
    #getKey, getValue, setKey, setValue
    def __init__(self,Key,Value):
        self.Key=Key
        self.Value=Value

    def getKey(self):
        return self.Key

    def getValue(self):
        return self.Value

    def setKey(self,newKey):
        self.Key=newKey

    def setValue(self,newValue):
        self.Value=newValue
