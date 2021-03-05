accountList = list()
index = int()


class Account():
    def __init__(self, name, password, phoneNumber, bakiye=1000):
        self.name = name
        self.password = password
        self.phoneNumber = phoneNumber
        self.bakiye = bakiye
        print("init is working")


def startUp():
    print("""" **************************GIRISE HOSGELDINIZ********************************
                1) KAYIT OL
                2) GIRIS YAP""")
    secim = input()
    if secim == "1":
        register()
        return
    if secim == "2":
        login()
        return


def register():
    name = input("Lutfen bir isim giriniz: ")
    password = input("Sifrenizi belirleyiniz: ")
    phoneNumber = input("Telefon numaranizi giriniz: ")
    account = Account(name, password, phoneNumber)
    accountList.append(account)
    startUp()
    return


def login():
    name = input("Lutfen adinizi giriniz: ")
    password = input("Lutfen sifrenizi giriniz: ")
    check = False

    for number in accountList:
        if number.name == name and number.password == password:
            global index
            index = accountList.index(number)
            check = True
            break
    if check:
        menu()
        return
    else:
        print("Yanlis isim sifre kombinasyonu, lutfen tekrar deneyin")
        login()
        return


def menu():
    while True:
        print("""" **************************MENUYE HOSGELDINIZ********************************
                    1) Bilgileri goster
                    2) Para yatir
                    3) Para cek
                    4) Para gonder
                    5) Hesaptan cik
                    6) Uygulamadan cik""")
        secim = input()

        if secim == "6":
            print("Programdan cikiliyor...")
            return

        elif secim == "1":
            print(f"""                       Bakiyeniz: {accountList[index].bakiye}
                       Adiniz: {accountList[index].name}
                       Numaraniz: {accountList[index].phoneNumber}""")


        elif secim == "2":
            miktar = int(input("Ne kadar yatirmak istiyorsunuz? "))
            paraYatir(miktar)

        elif secim == "3":
            cekimMiktar = int(input("Ne kadar cekmek istiyorsunuz? "))
            paraCek(cekimMiktar)

        elif secim == "4":
            numara = input("Para gondermek istediginiz telefon numarasini giriniz: ")
            gonderMiktar = int(input("Gondermek istediginiz miktari giriniz: "))
            paraGonder(numara, gonderMiktar)


        elif secim == "5":
            login()
            return


def paraYatir(miktar):
    accountList[index].bakiye += miktar
    print(f"{miktar} tl hesabiniza yatirildi.\nYeni bakiyeniz {accountList[index].bakiye}")


def paraCek(miktar):
    if miktar <= accountList[index].bakiye:
        accountList[index].bakiye -= miktar
        print(f"{miktar} tl cekildi, yeni bakiye: {accountList[index].bakiye}")
    else:
        print(f"Yetersiz bakiye, bakiyeniz= {accountList[index].bakiye}")
        yeniMiktar = int(input("Yeni miktari giriniz: "))
        paraCek(yeniMiktar)
        return


def paraGonder(numara, gonderMiktar):
    check = True
    if gonderMiktar < accountList[index].bakiye:
        for element in accountList:
            if element.phoneNumber == numara:
                accountList[index].bakiye -= gonderMiktar
                element.bakiye += gonderMiktar
                check = False
                break

        if check:
            yeniNumara = input("Lutfen gecerli bir numara giriniz: ")
            paraGonder(yeniNumara, gonderMiktar)
            return
    else:
        yeniMiktar = int(input("Lutfen bakiyenizden daha dusuk bir deger giriniz: "))
        paraGonder(numara, yeniMiktar)
        return


startUp()
