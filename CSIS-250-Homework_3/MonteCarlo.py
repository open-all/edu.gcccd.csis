"""
Program to calculate pi using random probability

Program: MonteCarlo.py
Author: Elias McCoy
Last date modified: 2/27/19

The program simulates drops inside and outside of a cirlce and approxiamtes the curviture of that cirlce to calculate pi
"""
import math
import time
import random

# round pi to 5 decimal places
PI = round(math.pi, 5)
calculatedPi = 0.0
iterations = 0
totalIterations = 0
totalRuntime = 0
runtime = 0
pointsInside = 0.0
totalDrops = 0
runtime = 0


# calculate pi using a random distribution of numbers
for i in range(10):

    while calculatedPi != PI:
        startTime = int(time.time() * 1000)

        x = random.random()
        y = random.random()
        insideCircle = x * x + y * y <= 1

        if insideCircle:
            pointsInside += 1

        totalDrops += 1
        calculatedPi = round(4 * float(pointsInside/totalDrops), 5)
        iterations +=1
        endTime = int(time.time()*1000)
        runtime += endTime - startTime

    print("\nNumber of iterations: " + str(iterations) + "\nRuntime: " + str(runtime) + " miliseconds\n")
    calculatedPi = 0
    totalIterations += iterations
    iterations = 0
    totalRuntime += runtime
    runtime = 0

avgRuntime = totalRuntime/10
print("\nAverage number of iterations: " + str(totalIterations/10) + " average runtime: " + str(avgRuntime)
      + " miliseconds")
