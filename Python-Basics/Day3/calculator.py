number1 = int(input("Please enter the first number: "))
number2 = int(input("please enter the second number: "))

function = int(input("1 for addition\n" +
                     "2 for subtraction\n" +
                     "3 for multiplication\n" +
                     "4 for division\n" +
                     "5 for remainder\n"))

if function == 1:
    print(str(number1) + " + " + str(number2) + " = " + str(number1 + number2))
if function == 2:
    print(str(number1) + " - " + str(number2) + " = " + str(number1 - number2))
if function == 3:
    print(str(number1) + " * " + str(number2) + " = " + str(number1 * number2))
if function == 4:
    print(str(number1) + " / " + str(number2) + " = " + str(number1 / number2))
if function == 5:
    print(str(number1) + " % " + str(number2) + " = " + str(number1 % number2))

    