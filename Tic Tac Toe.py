import random

gameboard = [['   ','   ','   '], 
             ['   ','   ','   '], 
             ['   ','   ','   ']]

def printboard():
    print("-_-| 1 | 2 | 3 ")
    print("---------------")
    for i in range(3):
        print(str(i + 1) + "  |" + gameboard[i][0] + "|" + gameboard[i][1] + "|" + gameboard[i][2])
        if i != 2:
            print("---|---|---|---")

def computer():
     availablecells = []
     usermatches = 0
     #check rows for two matches of X
     for row in range(3):
          for column in range(3):
            if gameboard[row][column] == " X ":
                usermatches += 1
            elif gameboard[row][column] == "   ":
                availablecells.append([row, column])
            if usermatches == 2:
                 for cell in availablecells:
                      if row == cell[0]:
                           gameboard[row][cell[1]] = " O "
                           printboard()
                           return
          
     
     #check columns for two matches of X
     for row in range(3):
          usermatches = 0
          for column in range(3):
            if gameboard[row][column] == " X ":
                usermatches += 1
            elif gameboard[row][column] == "   ":
                availablecells.append([row, column])
                

def main():
    winner = False
    print("Welcome to Tic Tac Toe!")
    printboard()
    loop = True
    while loop == True:
        row = 0
        column = 0
        while (row > 3 or row <= 0):
                row = int(input("Enter the row number (1-3): "))
                if(row > 3 or row <= 0):
                    print("Please try a number between 0 and 3.")
        while (column > 3 or column <= 0):
            column = int(input("Enter the column number (1-3): ")) 
            if(column > 3 or column <= 0):
                    print("Please try a number between 0 and 3.")
        if gameboard[row - 1][column - 1] == "   ":
                gameboard[row - 1][column - 1] = " X "
                printboard()
        else:
            print("Cannot place there. Try again!")
        computer()

if __name__ == "__main__":
    main()