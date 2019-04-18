# structures-and-algorithms-coursework 

Students

B00331251 FRASER FEWSTER
B00329768 MIKOLAJ LUKASIK

Github
https://github.com/Pobe16/structures-and-algorithms-coursework



BRIEF
__________


COMP08034 Structures & Algorithms – Coursework Session 2018-19  
This coursework can be carried out either individually or in pairs. Submission should be via Moodle. You are to implement a dynamic data structure to maintain details of stock for a second hand car dealership.  
You are advised to develop the program one step at a time and keep a copy of the version for each step which should then be included in your submission. In addition to the marks at each step, there are 25 marks for programming style.  
A second hand car dealership has many makes of cars (e.g. Ford, Toyota, Volkswagen) on sale at any one time. They would like a system which holds information on all the current makes of cars, as well as details of each of the cars of that make.  
The data to be stored for each make of car is: Make/manufacturer e.g. Ford / Toyota / Volkswagen  
There should also be a link to car data. The data to be stored for each car is:  
Registration Number Model Colour  
e.g. SJ99 XYZ e.g. Fiesta e.g. Red  
The dealership would like to be able to:  
* add new car make/manufacturers  
* remove a make/manufacturer from the system  
* find if a particular make of car is sold by the dealership  
* display all the makes of cars sold by the dealership  
* add car details to each of the makes  
* remove a specific car from the system once it has been sold  
* display the details of the cars for sale for a particular make  
* display all the cars the dealership has on sale for all the make  
* customer requires speedy retrieval of make details, therefore information must be stored in a tree structure  
  
Step 1: Functionality is worth 25 marks  
* create a Dealership class with suitable attributes to represent the make as well as a link to car details.  
* write a DealershipTest class that offers a simple menu to add a new make of car, find if a particular make of car is sold by the dealership, remove a make of cars and to display the details of all the makes of cars currently being sold by the dealership.  
  
Step 2: Functionality is worth 25 marks  
* update your program to include a Car class with suitable attributes  
* write an addCar method that interacts with the user to select a make to add the car details to  
* write a removeCar method to remove a specific car from the system once it has been sold  
* write a displayCars method which interacts with the user to select the make of cars to display and which then displays all the cars for that make  
* write a displayAll method to display the information on all data for the dealership stock  
  
Step 3: Functionality is worth 25 marks  
* modify the necessary methods so that the resulting data structure is a balanced tree by alphabetical order of Makes [Hint: review addMake and addCar methods ]  
* provide a method to display the number of cars available for a specific make and model of car e.g. the number of Ford Fiestas  
* display all the car details in alphabetical order of Make  
* Use appropriate exception handling  

Submission  
Due Date: 4pm on Friday 26th April 2019  
Upload your work via Moodle  
* create a folder based on your banner id e.g. B00123456. If the coursework is done in pairs, then include both banner ids.  
* copy ALL the projects for the different versions of the program into this folder  
* create a compressed zip version of this folder  
  - inWindowsExplorer,selectthefolderwiththerightbuttonthenselectSendTo then Compressed (zip) Folder  
* select the Coursework Submission link in the Coursework tab on Moodle and follow the instructions to upload the zip file
