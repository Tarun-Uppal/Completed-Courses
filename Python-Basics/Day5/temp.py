height = 5
for i in range(height):
    for x in range((height - 1) - i):
        print(" ", end="")
    for x in range(i + 1):
        print("#", end="")
    print(" ", end="")
    for x in range(i + 1):
        print("#", end="")
    print("")