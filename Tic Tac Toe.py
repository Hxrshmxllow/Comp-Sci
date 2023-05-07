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
    #checks all 8 combinations (3rows, 3columns, 2diagonals)
    combinations = [0, 0, 0, 0, 0, 0, 0, 0] 
    for row in range(3):
        for column in range(3):
            if gameboard[row][column] == " X ":
                combinations[row] += 1
                combinations[column + 3] += 1
            elif gameboard[row][column] == "   ":
                availablecells.append([row, column])
                 
    for i in range(8):
        if combinations[i] == 0 or combinations[i] < 3 and combinations[i] == 2:
            for cells in availablecells:
                 if cells[0] == i:
                    gameboard[cells[0]][cells[1]] = " O "
                    printboard()
                    return
        elif combinations[i] == 3 or combinations[i] < 6 and combinations[i] == 2:
            for cells in availablecells:
                 if cells[1] == i:
                    gameboard[cells[0]][cells[1]] = " O "
                    printboard()
                    return
    cell = random.choice(availablecells)
    gameboard[cell[0]][cell[1]] = " O "
    printboard()
    return
              

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
                computer()
        else:
            print("Cannot place there. Try again!")
        

if __name__ == "__main__":
    main()
