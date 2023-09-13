from moduloBase import Base
class Der1(Base):
    x=0

class Der2(Base):

    def __init__(self):
        super().__init__()

    def print_x(self):
        super(Der2, self).print_x()

