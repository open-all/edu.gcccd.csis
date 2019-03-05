import random
List = [2]
for i in range(random.randint(4, 7)):
    List.append(random.randint(List[i], List[i] * 2 - 1))
print("List: " + " ".join(map(str, List)) + "  - Sum: " + str(sum(List)) + " - Median: " + (str(((List[len(List) // 2] + List[-(len(List) + 1) // 2]) / 2)) if len(List) % 2 == 0 else str(int(List[len(List) // 2]))) + " - Avg: " + "{0:.2f}".format(sum(List) / len(List)))
