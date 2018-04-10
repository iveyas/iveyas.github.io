import os
import random
import sys
import time

queens = {}             # queens[i] contains the column of each queen
size = int(sys.argv[1]) # Get the board size from the command line

# Create the board as a two-dimensional list
board = [[0 for c in range(size)] for r in range(size)]


def display(pBoard):
	'''
		Generic display method that a board (an nXn list) passed via pBoard
	'''
	for r in range(size):
		line = " "
		for c in range(size):
			st = ""
			if pBoard[r][c] == 0:
				st = "0"
			else:
				st =   "."
			line += st + " "
		print(line)


def addToThreats(row, col, change):
	'''
		Propagates constraints to the:
			col - Current column passed. past the row
			diagonals - the Diagonals of row,col
		Change of +1 adds a threat (increases constraint) at each location
		Change of -1 removes a threat (decreases constraint) at each location
	'''
	# Change the column past the current row
	for j in range(0,row):
		board[j][col] += change
	# Change the diagonal beyond the current row
	for j in range(row+1,size):
		board[j][col] += change
		if ( col+(j-row) < size ):
			board[j][col+(j-row)] += change
		if( col-(j-row) >= 0):
			board[j][col-(j-row)] += change


def backtracking_search(depth=0):
     
    print("")
    if depth == size:  # Base Step   
        display(board)  
        return True # Success   
    else:  
        display(board)
        for value in range(size):    
            if board[depth][value] == 0:   
                queens[depth] = value
                addToThreats(depth, value, 1)     
                status = backtracking_search(depth + 1)  # Recursion Step     
                if (status):     
                    return True # Success          
                # If you were not successful, back out of the propagation you just tried:    
                addToThreats(depth, value, -1)      
    return False # Failure 

"""
********************************
   MAIN ALGORITHM
********************************
"""
if (not backtracking_search()):
	print("NO SOLUTION!")
