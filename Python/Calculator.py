def calculator(num1, num2, ops):
    if ops == "+":
        print(f"{num1} {ops} {num2} = {num1 + num2}")
    if ops == "-":
        print(f"{num1} {ops} {num2} = {num1 - num2}")
    if ops == "*":
        print(f"{num1} {ops} {num2} = {num1 * num2}")
    if ops == "/":
        print(f"{num1} {ops} {num2} = {num1 / num2}")


while True:

    ops = input("Please enter the operation(+ - / * exit): ")
    if ops == "exit":
        print("Program is ending...")
        break
    elif ops not in "+-/*":
        print("Wrong operation.")

    else:
        number1 = int(input("Please enter the first number: "))
        number2 = int(input("Please enter the second number: "))
        calculator(number1, number2, ops)
