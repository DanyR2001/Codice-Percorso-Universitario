
class MyClass:

    def __init__(self,x):
        self.x=x

    def marco(self):
        print("x")
        if self.x%2==0:
            print("marco pari")
        else:
            print("marco dispari")

    def carlo(self):
        if self.x % 2 == 0:
            print("carlo pari")
        else:
            print("carlo dispari")