height = 5
for i in range(height):
    print(" " * ((height - 1) - i), end="")
    print("#" * (i + 1), end="")
    print(" ", end="")
    print("#" * (i + 1))