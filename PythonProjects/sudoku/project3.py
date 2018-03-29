import sys
from operator import itemgetter
from copy import deepcopy
class PriorityQueue:
    def __init__(self):
        self.queue = []
    def set_priority(self, item, priority):
        for node in self.queue:
            if node[0] == item:
                self.queue.remove(node)
                break
        self.put(item, priority)
    def put(self, item, priority):
        node = [item, priority]
        self.queue.append(node)
        self.queue.sort(key=itemgetter(1))
    def get(self):
        if len(self.queue) == 0:
            return None
        node = self.queue.pop(0)
        return node[0]
    def empty(self):
        return len(self.queue) == 0
    def update(self, _dict):
        tempCell = []
        tempQueue = []
        temp = 5
        try:
            node = self.queue.pop(0)
        except:
            None
        while self.queue.__len__ is not 0:
            try:
                tempCell = node[0], len(_dict[node[0]])
                tempQueue.append(tempCell)
                node = self.queue.pop(0)
            except:
                break
        for i in tempQueue:
            if i[1] is not "":
                self.put(i[0], i[1])
class Sudoku:
    """
        Sudoku class, which models a Sudoku game.
        Based on Peter Norvig's Suggested Sudoku setup
    """
    def __init__(self):
        """
            Initialize digits, rows, columns, the grid, squares, units, peers, and values.
        """
        self.digits = '123456789'
        self.rows = 'ABCDEFGHI'
        self.cols = self.digits
        self.grid = dict()
        self.priorityQueueValues = PriorityQueue()
        self.squares = self.cross_product(self.rows, self.cols)
        unitlist = ([self.cross_product(self.rows, c) for c in self.cols] +
                    [self.cross_product(r, self.cols) for r in self.rows] +
                    [self.cross_product(rs, cs) for rs in ('ABC', 'DEF', 'GHI') for cs in ('123', '456', '789')])
        self.units = dict((s, [u for u in unitlist if s in u]) for s in self.squares)
        self.peers = dict((s, set(sum(self.units[s], [])) - set([s])) for s in self.squares)
        self.values = dict((s, self.digits) for s in self.squares)
        self.count = 0
    @staticmethod
    def cross_product(A, B):
        """
            Return the cross product of A and B
        """
        return [a + b for a in A for b in B]
    def __str__(self):
        """
            Convert the grid into a human-readable string
        """
        output = ''
        width = 2 + max(len(self.grid[s]) for s in self.squares)
        line = '+'.join(['-' * (width * 3)] * 3)
        for r in self.rows:
            output += (''.join(
                (self.grid[r + c] if self.grid[r + c] not in '0.' else '').center(width) + ('|' if c in '36' else '')
                for c in self.digits)) + "\n"
            if r in 'CF': output += line + "\n"
        return output
    def load_file(self, filename):
        """
            Load the file into the grid dictionary. Note that keys
            are in the form '[A-I][1-9]' (e.g., 'E5').
        """
        grid = ''
        with open(filename) as f:
            grid = ''.join(f.readlines())
        grid_values = self.grid_values(grid)
        self.grid = grid_values
    def grid_values(self, grid):
        """
            Convert grid into a dict of {square: char} with '0' or '.' for empties.
        """
        chars = [c for c in grid if c in self.digits or c in '0.']
        """assert len(chars) == 81 """
        return dict(zip(self.squares, chars))
    def solve(self):
        """
            Solve the problem by propagation and backtracking.
        """
        self.search(self.propagate())

    def propagate(self):
        """
           This part of the code allows the program to propagate a constraint based on the values that are
           set on the grid.  When the grid value is set the method calls the peers method so that it can
           reduce the possibilities for the given cell using the values data structure.
        """

        '''
        Makes sure that the priority queue is empty 
        '''
        self.priorityQueueValues = PriorityQueue()

        '''
        This does not take into account the values that the domain can take it either sets the domain to 
        nothing or populates it with all a all numbers between 1 and 9 inclusively 
        '''
        for i in self.values:   #sets the values for the domain of the cell
            if self.grid[i] is '0': #this is if the value of the cell has not been set
                self.priorityQueueValues.put(i, len(self.values[i]))
            else:
                self.priorityQueueValues.put(i, 0)
                self.values[i] = ""
        '''
        Infinite loop that interates until the priority queue is empty.  When it is empty it and the count is 
        81 then it will return the true.  If the count is under 81, but the queue is empty the loop will return 
        false letting the previous caller know that the value was not found.  The loop also decrements the domain 
        so that it only represents the values that the cell can take.        
        '''
        count = 0
        while True:
            if self.priorityQueueValues.empty() == True and count < 81:
                return False
            elif self.priorityQueueValues.empty() == True:
                return True

            setValue = self.priorityQueueValues.get()
            if self.values[setValue] == '':
                for p in self.peers[setValue]:
                    temp2 = ""
                    temp2 = deepcopy(self.values[p])
                    temp2 = temp2.replace(self.grid[setValue], "")
                    if len(temp2) == 1:
                        self.grid[p] = temp2
                        self.values[p] = ''
                        self.values[p] = ''
                        for j in self.peers[p]:
                            temp3 = ""
                            temp3 = deepcopy(self.values[j])
                            temp3 = temp3.replace(self.grid[p], "")
                            self.values[j] = temp3
                        self.priorityQueueValues.update(self.values)

                        count = 0
                        for a in self.values:
                            if self.grid[a] is not '0':
                                count = count + 1
                        if count == 81:
                            self.grid = deepcopy(self.grid)
                            print(self) #prints the completed puzzle
                            return True
                    else:
                        self.values[p] = temp2
    '''
    This part of the program takes in a propagate argument.  The seach method does all the work so that 
    the propagate method can be called.  It keeps a copy of the current grid so that if the propagate method
    returns a method that is not correct it will reset the value back to the original grid.  It also iterates 
    over the possibilities that each domain can take when guessing is necissary.  If the guess did not 
    result in the correct answer the program backtracks and tries a new possible value. 
    '''
    def search(self, propagate):
        valueFound = self.propagate()
        temp = ""
        tempGrid = deepcopy(self.grid)
        tempValuesSet = deepcopy(self.values)
        guessValues = []

        if valueFound == False:
            for i in self.values:
                if self.values[i] != '':
                    self.priorityQueueValues.put(i, len(self.values[i]))

            guessValues = self.priorityQueueValues.get()

            if guessValues == None:
                return False
            else:
                tempValues = self.values[guessValues]
                numTempValues = len(tempValues)

            for k in range(0, numTempValues):
                self.grid = deepcopy(tempGrid)
                self.grid[guessValues] = tempValues[k]
                self.values[guessValues] = ""
                self.priorityQueueValues = PriorityQueue()
                valueFound = self.search(self.propagate())
                count = 0
                for i in self.values:
                    if self.grid[i] != '0':
                        count = count + 1
                if valueFound == True:
                    return valueFound
                else:
                    self.grid = deepcopy(tempGrid)
                    self.values = deepcopy(tempValuesSet)
                    self.values[guessValues] = ""
                    self.priorityQueueValues = PriorityQueue()
                    for l in self.values:  # sets the values for the domain of the cell
                        if self.grid[l] is '0':  # this is if the value of the cell has not been set
                            self.priorityQueueValues.put(l, len(self.values[l]))
                    self.priorityQueueValues.update(self.values)
                    k = k + 1
        else:
            print(self)


def main():
    s = Sudoku()
    '''
        The loop reads in as many files as you've passed on the command line.
        Example to read two easy files from the command line:
            python project3.py sudoku_easy1.txt sudoku_easy2.txt
    '''
    for x in range(1, len(sys.argv)):
        s.load_file(sys.argv[x])
        print("\n==============================================")
        print(sys.argv[x].center(46))
        print("==============================================\n")
        print(s)
        print("\n----------------------------------------------\n")
        s.solve()
        print(s)

main()
