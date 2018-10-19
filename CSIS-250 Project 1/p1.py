import p1utils
import time
import os

"""
CSIS 250 Project 1
Functions: 
    def search(file_list -> list
    def report(d): prints a report for the project
"""

def search(file_list):
    """Looking for duplicate files"""
    lol = []
    while file_list:
        a = file_list.pop()
        l = []
        for x in range(len(file_list)-1,-1,-1):
            if p1utils.compare(a, file_list[x]):
                l.append(file_list.pop(x))
        if len(l) > 0:
            l.append(a)
            lol.append(l)
    return lol


def fasterSearch(file_list):
    """Looking for duplicate files"""

def report(d):
    """ report seach results"""
# measure how long the search and reporting takes:
t0 = time.time()
# find all files in the provided directory
files = p1utils.allFiles("." + os.sep + "smallset")
print("Number of files found: ", len(files))
dups = search(files)

if dups:
    most_dups = max(dups, key=len)

    #print the copies of the most often found file
    print("The file with the most duplicates is: " + str(most_dups.pop()) + "\n Here are its " + str(len(most_dups)) + " copies:")
    for x in range(len(most_dups)):
        print(str(most_dups[x]))

    #find and print the duplicates occupying the most disk space
    most_space = ""
    max = 0
    max_list = []
    for x in range(len(dups)):
        currentList = dups[x]
        if os.path.getsize(currentList[0]) * len(currentList) > max:
            max = os.path.getsize(currentList[0]) * len(currentList)
            max_list = currentList
            most_space = currentList.pop(0)

    print("\nThe most disk space(" + str(max) + ") could be recovered, by deleting this file:\n" + str(most_space))
    print("Here are its copies:")
    for x in range(len(max_list)):
        print(max_list[x])

    report(search(files))
    t0 = (time.time() - t0)
    print("Runtime: %.2f secs" % t0 )
    print(p1utils.compareCounter)

else:
    print("There are no duplicates")


