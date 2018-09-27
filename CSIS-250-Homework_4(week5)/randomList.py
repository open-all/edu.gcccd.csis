import random
LI = [2]
for i in range(random.randint(4, 7)):
    LI.append(random.randint(LI[i], LI[i]*2 - 1))
print("List: " + " ".join(map(str, LI)) + "  - Sum: " + str(sum(LI)) + " - Median: " + (str(((LI[len(LI)//2] + LI[-(len(LI)+1)//2])/2)) if len(LI) % 2 == 0 else str(int(LI[len(LI)//2]))) + " - Average: " + "{0:.2f}".format(sum(LI)/len(LI)))