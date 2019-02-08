"""
Program to perform calculations of spherical geometry

Program: Sphere.py
Author: Elias McCoy
Last date modified: 2/7/19

When given a valid value for a radius, the purpose of this program is to compute the diameter, circumference,
surface area, and volume of a sphere. It uses the absolute value of the input to ensure it can also handle negative
numbers. It also uses a try catch statement to handle unexpected inputs such as strings
"""

from math import pi

while True:
    try:
        radius = abs(float(input("Enter the radius of a cirlce: ")))
        print("You entered " + str(radius))
    except ValueError:
        print("Please enter numeric values only!")
    else:
        break

diameter = radius * 2
circumference = 2 * pi * radius
surfaceArea = 4 * pi * radius ** 2
volume = (4 / 3) * (pi * radius ** 3)

print("The diameter is " + str(round(diameter,2)) + " units", "\n" + "The circumference is " +
      str(round(circumference,2)) + " units", "\n" + "The surface area is " + str(round(surfaceArea,2))
      + " units squared","\n" + "The volume is " + str(round(volume,2)) + " units cubed" + "\nbye!")
