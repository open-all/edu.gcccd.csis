
class primeOrNot:

#primality test of any int n
    def primeOrNot(n):
        n = abs(int(n))
        if n < 2:
            result = "not prime"
        elif n != 2 and n % 2 == 0:
            return "not prime"
        elif( all(n % i for i in range(3, int(n**0.5)+1))):
                return "prime"
        else:
            return "not prime"



#returns the smallest divisor of any given int n
    def smallest_divisor(n):
        n = abs(int(n))
        if(n%2 == 0):
            return 2
        else:
            potential_divisor = 3
            while(potential_divisor * potential_divisor <= n):
                if (n % potential_divisor == 0):
                    return int(potential_divisor)
                potential_divisor += 2
            return potential_divisor

    def main(self):

        loop = 1
        while(loop):
            try:
                n = input("Enter any number")
                print(self.primeOrNot(int(n)))
                break
            except(ValueError):
                print("\nPlease enter only numbers\n")
                continue

        print("The smallest divisor is " + str(self.smallest_divisor(n)))


if __name__ == '__main__':
    primeOrNot.main(primeOrNot)
