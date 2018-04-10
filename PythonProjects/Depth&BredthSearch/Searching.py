import os
import time
from collections import deque
from queue import Queue
from copy import deepcopy

import numpy

# ==============================================================================
# Goal: Traverse a directory structure using Depth-First and Breadth-First
#        Search Algorithms
# ==============================================================================

# ---------------------------------------
# The Path to Search
#  You may need to alter this based on
#   your file location and OS.

path = ".\\treepath"
# ---------------------------------------
# The Goal Filename
#  This is the name of the files you are
#   attempting to find.
#goal = "9Asg7cK.bin"  # 11 directories deep


#goal = "XUB.bin"        #11 directories deep
goal = "yFTPOz.bin"     #4 directories deep

# ===============================================================================
# Method: method_timing
#  Purpose: A timing function that wraps the called method with timing code.
#     Uses: time.time(), used to determine the time before an after a call to
#            func, and then returns the difference.
def method_timing(func):
    def wrapper(*arg):
        t1 = time.time()
        res = func(*arg)
        t2 = time.time()
        # print ('%s took %0.3f ms' % (func, (t2-t1)*1000.0))
        return [res, (t2 - t1) * 1000.0]

    return wrapper


# ===============================================================================
# Method: expand
#  Purpose: Returns the child nodes of the current node in a list
#     Uses: os.listdir, which returns a Python list of children--directories
#           as well as files.
def expand(pathname):
    return os.listdir(pathname)



# ===============================================================================
# Method: breadthFirst
#  Purpose: Conducts a Breadth-First search of the file structure
#  Returns: The location of the file if it was found, an empty string otherwise.
#     Uses: Wrapped by method_timing method

@method_timing
def breadthFirst():
    myDeque = deque()
    myDeque.append(path)
    listToTry = expand(path)

    while not myDeque.__sizeof__() == 0:
        currentList = myDeque.popleft()
        expandedList = expand(currentList)
        for y in expandedList:
            if y == goal:
                myDeque.clear()
                #print(currentList + "\\" + y)
                return currentList + "\\" + y
            else:
                try:
                    expand(currentList + "\\" + y)
                    myDeque.append(currentList + "\\" + y)
                except:
                   y

# ===============================================================================
# Method: depthFirst
#  Purpose: Conducts a Depth-First search of the file structure
#  Returns: The location of the file if it was found, an empty string otherwise.
#     Uses: Wrapped by method_timing method
@method_timing
def depthFirst():
    myDeque = deque()
    myDeque.append(path)
    listToTry = expand(path)

    while not myDeque.__sizeof__() == 0:
        currentList = myDeque.pop()
        expandedList = expand(currentList)
        for y in expandedList:
            if y == goal:
                myDeque.clear()
                print(currentList + "\\" + y)
                return currentList + "\\" + y
            else:
                try:
                    expand(currentList + "\\" + y)
                    myDeque.append(currentList + "\\" + y)
                except:
                    y


# =====================
# TODO: Main Algorithm
#
#  Completing the code above will allow this code to run. Comment or uncomment
#   as necessary, but the final submission should be appear as the original.

bfs = numpy.empty((10))
for x in range(0, 9):
    filelocation = breadthFirst()
    if filelocation[0] != "":
        print("BREADTH-FIRST: Found %s in %0.3f ms" % (goal, filelocation[1]))
        bfs[x] = filelocation[1]

dfs = numpy.empty(10)
for x in range(0, 9):
    filelocation = depthFirst()
    if filelocation[0] != "":
        print("  DEPTH-FIRST: Found %s in %0.3f ms" % (goal, filelocation[1]))
        dfs[x] = filelocation[1]

print("\n FULL PATH: %s" % filelocation[0])

print("\nBREADTH-FIRST SEARCH AVERAGE TIME: %0.3f ms" % bfs.mean())
print(" DEPTH-FIRST SEARCH AVERAGE TIME: %0.3f ms" % dfs.mean())

#recursive method that I didn't use'
#DFS_recur("",path)

#def DFS_recur(name, path):
#    if name == goal:
#        print("Found" + path)
 #       return path
#
 #   if(name.__contains__(".bin")):
  #      if(name == goal):
   #         return path + "\\" + name
    #else:
        #children = expand(path)
        #for x in range(len(expand(path))):
         #   DFS_recur(children[x], path + "\\" + children[x])
          #  if children[x] == goal:
                #return path + "\\" + (expand(path))[x]
           #     return path + "\\" + name
            #    print("Found the answer")
