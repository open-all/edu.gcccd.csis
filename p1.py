import p1utils
import time
import os

"""
CSIS 250 Project 1
Functions: 
    def search(file_list -> list
    def report(d) 
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


# find all files in the provided directory
files = p1utils.allFiles("." + os.sep + "smallset")
print("Number of files found: ", len(files))
dups = search(files)
most_dups = max(dups, key=len)

#print the copies of the most often found file
print("The file with the most duplicates is: "  + str(most_dups.pop(0)) + "\n Here are its 7 copies:" )
while most_dups:
    print(str(most_dups.pop(0)))

biggest = max(for l in dups: os.path.getsize())

# measure how long the search and reporting takes:
t0 = time.time()
report(search(files))
print("Runtime: %.2f secs" % (time.time() - t0))


# print(" .. and now w/ a faster search implementation:")
# t0 = time.time()
# report(fasterSearch(files))
# print("Runtime: %.2f secs" % (time.time() - t0))
