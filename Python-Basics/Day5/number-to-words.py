def main():
    number = int(input("please enter a number: "))
    temp = 0
    # crores
    digitCount = len(str(number))
    if digitCount == 8 or digitCount == 9:
        temp = number - (number%10000000)
        print(zerotonineteen(temp / 10000000) + " crore ", end="")
        number -= temp
        
    # lakhs
    digitCount = len(str(number))
    if digitCount == 7 or digitCount == 6:
        temp = number - (number%100000)
        print(zerotonineteen(temp / 100000) + " lakh ", end="")
        number -= temp
    
    # thousands
    digitCount = len(str(number))
    if digitCount == 5:
        temp = number - (number % 1000)
        if (temp / 1000) > 20:
            print(twentytoninetynine(temp / 1000), end="")
        else:
            print(zerotonineteen(temp / 1000), end="")
        print(" thousand ", end="")
        number -= temp
        
    if digitCount == 4:
        temp = number - (number % 1000)
        print(zerotonine(temp / 1000) + " thousand ", end="")
        number -= temp
        
    # hundreds
    digitCount = len(str(number))
    if digitCount == 3:
        temp = number - (number%100)
        print(zerotonine(temp / 100) + " hundred ", end="")
        number -= temp
    
    # tens
    digitCount = len(str(number))
    if digitCount == 2:
        temp = number - (number%10)
        print(twentytoninetynine(temp), end="")
        number -= temp
    
    # ones
    digitCount = len(str(number))
    if digitCount == 1:
        print(zerotonine(number), end="")
        number = 0
        
def zerotonineteen(number):
    if number > 19:
        return twentytoninetynine(number) 
    if number < 10:
        return zerotonine(number)
    else:
        if number == 10:
            return "Ten"
        elif number == 11:
            return "Eleven"
        elif number == 12:
            return "Twelve"
        elif number == 13:
            return "Thirteen"
        elif number == 14:
            return "Fourteen"
        elif number == 15:
            return "Fifteen"
        elif number == 16:
            return "Sixteen"
        elif number == 17:
            return "Seventeen"
        elif number == 18:
            return "Eighteen"
        elif number == 19:
            return "Nineteen"
        else:
            return ""
    
def zerotonine(number):
        if number == 0:
            return ""
        elif number == 1:
            return "One"
        elif number == 2:
            return "Two"
        elif number == 3:
            return "Three"
        elif number == 4:
            return "Four"
        elif number == 5:
            return "Five"
        elif number == 6:
            return "Six"
        elif number == 7:
            return "Seven"
        elif number == 8:
            return "Eight"
        elif number == 9:
            return "Nine"

def tenswithoutzero(number):
        if number == 1:
            return "Ten"
        elif number == 2:
            return "Twenty"
        elif number == 3:
            return "Thirty"
        elif number == 4:
            return "Forty"
        elif number == 5:
            return "Fifty"
        elif number == 6:
            return "Sixty"
        elif number == 7:
            return "Seventy"
        elif number == 8:
            return "Eighty"
        elif number == 9:
            return "Ninety"
        else:
            return " "
        
def twentytoninetynine(number):
    tens = tenswithoutzero(round(number / 10))
    ones = zerotonineteen(round(number % 10))
    return tens + " " + ones

main()