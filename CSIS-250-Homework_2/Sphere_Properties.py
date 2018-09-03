from math import pi
while True:
    try:
        radius = float(input("Enter the radius of a cirlce: "))
        print("You entered " + str(radius))
    except ValueError:
        print("Please enter numeric values only")
    else:
        break

diameter = radius * 2
circumference = 2 * pi * radius
surfaceArea = 4 * pi * radius ** 2
volume = (4 / 3) * (pi * radius ** 3)

print("The diameter is " + str(round(diameter,2)) + " units", "\n" + "The circumference is " +
      str(round(circumference,2)) + " units", "\n" + "The surface area is " + str(round(surfaceArea,2))
      + " units squared","\n" + "The volume is " + str(round(volume,2)) + " units cubed" + "\nbye!")