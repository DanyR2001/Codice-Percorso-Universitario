from MyPair import Pair


class Dictionary:
    from MyPair import Pair

    def __init__(self):
        self.l = list()

    def __len__(self):
        return len(self.l)

    def __getitem__(self, Key):
        if not self.isEmpty():
            for j in self.l:
                if j.getKey() == Key:
                    return j.getValue()
        else:
            return None

    def __contains__(self, Key):
        if not self.isEmpty():
            for j in self.l:
                if j.getKey() == Key:
                    return True
            return False
        else:
            return False

    def __setitem__(self, Key, Value):
        if Key in self:
            for j in self.l:
                if j.getKey() == Key:
                    j.setValue(Value)
        else:
            x = Pair()
            x.setValue(Value)
            x.setKey(Key)
            self.l.append(x)

    def isEmpty(self):
        if len(self.l) == 0:
            return True
        return False

    def __delitem__(self, Key):
        if not self.isEmpty():
            if Key in self:
                for j, item in enumerate(self.l):
                    if item.getKey() == Key:
                        self.l.pop(j)

    def __eq__(self, Dizionario):
        if self.isEmpty() == Dizionario.isEmpty() == True:
            return True
        elif self.isEmpty() != Dizionario.isEmpty():
            return False
        elif len(self) != len(Dizionario):
            return False
        else:
            for j in self.l:
                for i in Dizionario.l:
                    if j.getKey() == i.getKey():
                        if j.getValue() == i.getValue():
                            break
                else:
                    return False
            return True

    def __ne__(self, Dizionario):
        if self.isEmpty() == Dizionario.isEmpty() == True:
            return False
        elif self.isEmpty() != Dizionario.isEmpty():
            return True
        else:
            for j in self.l:
                for i in Dizionario.l:
                    if j.getKey() == i.getKey():
                        break
                else:
                    return True
            return False

    def print(self):
        if not self.isEmpty():
            for j in self.l:
                print("key: ", j.getKey(), ", value: ", j.getValue())
