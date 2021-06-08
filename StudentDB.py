class StudentDB:
    def __init__(self):
        self.mainProgram()
    def mainProgram(self):
        nameList = {}
        nl = 1
        userChoice2 = None
        while(userChoice2!="n"):
            self.programMenu()
            print()
            userChoice = int(input("What would you like to do: "))
            while(userChoice != 1 and userChoice != 2 and userChoice != 3 and userChoice != 4 and userChoice != 5):
                print("inproper input!")
                userChoice = int(input("What would you like to do: "))
            if(userChoice == 1):
                studFName = input("Enter student first name: ")
                studLName = input("Enter student last name: ")
                studEmail = input("Enter student email: ")
                studMajor = input("Enter student major: ")
                studentInfo = []
                studentInfo.append(studFName)
                studentInfo.append(studLName)
                studentInfo.append(studEmail)
                studentInfo.append(studMajor)
                nameList["student{}".format(nl)] = studentInfo
                nl+=1
            if(userChoice == 2):
                nameList2 = nameList.copy()
                adminChoice = int(input("Enter student number you would like to delete: "))
                for i in nameList2:
                    if(i == "student{}".format(adminChoice)):
                        del nameList["student{}".format(adminChoice)]
            if(userChoice == 3):
                self.printData(nameList)
            if(userChoice == 4):
                ff = input("Enter file name: ")
                f = open("{}.csv".format(ff), "w")
                f.write("First Name, Last Name, Email, Major\n")
                for i in nameList:
                    f.write("{},{},{},{}\n".format(nameList[i][0],nameList[i][1],nameList[i][2],nameList[i][3]))
                print("Database created!")
                break
                f.close()
            print()
            userChoice2 = input("Would you like to make any final changes?(y/n): ")
            if(userChoice2 == "y"):
                pass
            elif(userChoice2 == "n"):
                ff = input("Enter file name: ")
                f = open("{}.csv".format(ff), "w")
                f.write("First Name, Last Name, Email, Major\n")
                for i in nameList:
                    f.write("{},{},{},{}\n".format(nameList[i][0],nameList[i][1],nameList[i][2],nameList[i][3]))
                print("Database created!")
                break
                f.close()
            else:
                pass
            
            
    def printData(self, fake):
        for i in fake:
            print("{} - {}\n".format(i,fake[i]))
    def programMenu(self):
        print("=============================")
        print("1. Add student")
        print("2. Remove student")
        print("3. View current database")
        print("4. Print database to csv file")
        print("=============================")



def main():
    print("Student Database Program")
    sdb = StudentDB()

main()

