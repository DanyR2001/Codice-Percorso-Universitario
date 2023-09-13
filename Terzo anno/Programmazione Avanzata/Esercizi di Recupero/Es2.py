
"""
    Scrivere una funzione che prende in input un intero positivo ne restituisce e produce un
    generatore degli interi  0, 1, 3, 6,10,... . In altre parole, l’i-esimo elemento  e`(0+1+2+...+i-1)
"""

@staticmethod
def func(n):
    sum=0
    for i in range(0,n):
        sum+=i
    return sum

if __name__=="__main__":
    print(func(4))