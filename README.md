﻿# countrysOfTheWorldHashMap
<h1>Brief:</h1>

School of Architecture, Computing and Engineering (ACE)<br>
CN5121 - Data Structures and Algorithms<br>
Labs Week4 (HashMaps) - Author: Paolo Falcarin

<h3>1. Maps example</h3>
Download the CN5121-maps.zip file from Moodle, unzip it and import the resulting Eclipse project in Eclipse. Run the different
examples and try to understand the code.

<h3>2. World</h3>
Write a program which analyses information about world countries. Download the Eclipse project World.zip from Moodle; all
classes are in package world.

<h3>R1. States</h3>
Every state in the world is identified by different attributes: capital town, border states, population and area (in square-meters);
develop the following methods:
• addState(String state, String capital, long population, double area) in class World to add a State to the system.
• getCapital(String state) returns a string containing the name of the capital town.
• getPopulation(String state) and getArea(String state) return respectively a long and a double value.
• setBorder(String s1, String s2) tells the system that states s1 and s2 share a border, so they are neighbour states.

<h3>R2. Read from File</h3>
The method loadData(String statesFile) loads in memory the data structure from file states.txt
• File states.txt contains information of each single state in the worlds in the following format
"State : capital : area : population", for example:
Italy : Rome : 116305 : 58133509
Jamaica : Kingston : 4244 : 2758124
Japan : Tokyo : 145882 : 127463611
The area is in kms (square-kilometers) and population in units (official United-Nations in 2007). There can be an arbitrary
number of spaces between data in the same line.

<h3>R3: Statistics</h3>
The program will allow calculating some statistics:
• Method populationSort() print on output the list of states sorted in decreasing order of population. Each line of this file
will contain the position number in the ranking, name and population separated by spaces
1. China 1321851888
2. India 1300000000
• Method areaSort() print on output the list of states sorted in decreasing order of area. Each line contains the position
number in the ranking, name and area separated by spaces

<h3>R4: Borders</h3>
• The method loadBorders(String file) loads the file borders.txt that contains information (incomplete) about borders
between some states; each line contains a couple of neighbouring states separated by colon, for example:
Spain : Portugal
Spain : France
Italy :Switzerland
Italy : France
• Method border(String s1, String s2) returns true if these two states are neighbours, false otherwise.
School of Architecture, Computing and Engineering (ACE)
• Method neighbours(String state) returns the number of neighbours of a given state.
• Method getNeighbours(String state), return the comma-separated list of neighbouring states of a given state, for
example: getNeighbours("Italy") returns "France, Switzerland, Austria, Slovenia, Vatican, San Marino". The order in
which they are shown does not count.

<h3>Extra Challenge:</h3><br>
Hello,

I noticed that our World data are a bit obsolete, so I propose an extra-challenge for the bravest of you:

Extend your code to load another input file world17.csv which contains more recent data, in the csv  format.  

First token is the country name, followed by 2016 population and then 2017 population: Italy , 58133509 , 60000000
Try to calculate the up-to-date sorted list by population and add an additional ranking by increment of population as ratio between: the difference between 2017 and 2016 numbers , divided the 2016 number.

Good Luck
Paolo
