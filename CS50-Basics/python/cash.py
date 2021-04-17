from cs50 import get_float

count = int()
count = 0

while True:
    money = get_float("Change owed: ")
    dollars = int()
    dollars = round(money * 100)
    if dollars > 0:
        break

while dollars / 25 >= 1:
    dollars -= 25
    count += 1

while dollars / 10 >= 1:
    dollars -= 10
    count += 1

while dollars / 5 >= 1:
    dollars -= 5
    count += 1
    
while dollars / 1 >= 1:
    dollars -= 1
    count += 1

print(count)