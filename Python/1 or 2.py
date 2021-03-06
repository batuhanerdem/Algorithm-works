import random

accountList = list()
index = 0
check1 = False
check2 = False
check3 = False
horse1 = ""
horse2 = ""
money1 = int()
money2 = int()
money3 = int()
number = int()
number2 = int()
number3 = int()
element = int()
element2 = int()
element3 = int()
horse1List = list()
horse2List = list()
numberList = [number, number2, number3]
elementList = [element, element2, element3]
checkList = [check1, check2, check3]
horseList = [horse1, horse2]
horseListList = [horse1List, horse2List]
moneyList = list()

class Account():
    def __init__(self, username, password, money=100):
        self.username = username
        self.password = password
        self.money = money


def startUp():
    while True:
        choose = input("1- Register\n"
                       "2- Log in\n")
        if choose == "1":
            register()
            return
        elif choose == "2":
            login()
            return
        else:
            print("Wrong choice.")


def register():
    username = input("Please enter an username: ")
    password = input("Please enter a password: ")
    account = Account(username, password)
    accountList.append(account)
    print("Correctly registered!")
    startUp()
    return


def login():
    check = True
    username = input("Please enter your username: ")
    password = input("Please enter your password: ")
    for number in accountList:
        if username == number.username and password == number.password:
            check = False
            global index
            index = accountList.index(number)

    if check:
        print("Username and password doesnt match.")
        while True:
            choice = input("Do you want to register? (yes - no) ")
            if choice == "yes":
                register()
                return
            elif choice == "no":
                login()
                return
            else:
                print("Please enter yes or no.")
    menu()


def menu():
    while True:
        chose = input("\n\n1) Play the game\n"
                      "2) Log out\n"
                      "3) Show money\n"
                      "4) Delete the account\n"
                      "5) Exit the program\n\n")

        if chose == "5":
            print("Exiting...")
            return
        elif chose == "1":
            bet()
            game()
            return
        elif chose == "2":
            startUp()
            return
        elif chose == "3":
            print(f"Money is {accountList[index].money}")
        elif chose == "4":
            print(f"{accountList[index].username} is deleted.")
            accountList.remove(accountList[index])
            startUp()
            return


def game():
    horse1start = "Horse 1: "
    horse2start = "Horse 2: "
    global moneyList
    global horse1List
    global horse2List
    global horse1
    global horse2
    global horseListList
    global horseList

    for a in range(0, 3):
        input(f"Press enter for {a + 1}. tour.")
        horse1List.append(random.randint(3, 50))
        horse2List.append(random.randint(3, 50))
        for elementList[a] in range(0, horse1List[a]):
            horseList[0] += "-"
        print(horse1start, horseList[0])

        for numberList[a] in range(0, horse2List[a]):
            horseList[1] += "-"
        print(horse2start, horseList[1])

        if checkList[a] and len(horseList[0]) > len(horseList[1]):
            accountList[index].money += 2 * moneyList[a]
            print(
                f"Congratz you won {a + 1}. tour!\nYou won {moneyList[a]} usd.\nNew total money is {accountList[index].money}")

        elif not checkList[a] and len(horseList[1]) > len(horseList[0]):
            accountList[index].money += 2 * moneyList[a]
            print(
                f"Congratz you won {a + 1}. tour!\nYou won {moneyList[a]} usd.\nNew total money is {accountList[index].money}")
        else:
            print(f"You lose {a + 1}. tour.")

    horseList[0] = ""
    horseList[1] = ""

    menu()


def bet():
    global check1
    global check2
    global check3
    global money1
    global money2
    global money3
    global moneyList

    guess1 = input("Who wins round one? ( 1 - 2 ) (odd ratio is 2)\n")
    money1 = int(input("How much money do you want to bet for round 1?\n "))
    moneyList.append(money1)
    accountList[index].money -= money1
    guess2 = input("Who wins round two? ( 1 - 2 ) (odd ratio is 2)\n")
    money2 = int(input("How much money do you want to bet for round 2?\n"))
    moneyList.append(money2)
    accountList[index].money -= money2
    guess3 = input("Who wins the game? ( 1 - 2 ) (odd ratio is 2)\n")
    money3 = int(input("How much money do you want to bet for game?\n "))
    moneyList.append(money3)
    accountList[index].money -= money3

    if guess1 == "1":
        check1 = True
    if guess2 == "1":
        check2 = True
    if guess3 == "1":
        check3 = True


print("WELCOME TO THE GAME")
startUp()
