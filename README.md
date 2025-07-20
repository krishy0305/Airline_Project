# Airline_Project

# Overview

This program is a console that simulates a simplified travel planning system. It reads flight information and travel requests from input files, constructs a graph of cities connected by flights, and determines the top 3 possible travel routes between cities based on either minimum cost or shortest time. 

To run the program, follow the instructions below.

# Requirements

  - Integrated Development Environment (IDE) that can compile Java
  - Java 8 or above

# Input File Formatting

flightData.txt:
  - First line of text must be a number that represents the number of flight paths in the file.
  - Following each line must represent a flight path.
  - The flight path is formatted like:
    
        Format:  Start|Destination|Price|Flight time in minutes
      
        Example: New York|San Diego|80|180

reqFlights.txt:
  - First line of text must be a number that represents the number of flight paths requested in the file.
  - Following each line must represent a requested flight path.
  - The requested flight path is formatted like:
    
        Format:  Start|Destination|Preference of Sort (Cost or Time)
    
                 - "C" for Cost
                 - "T" for Time
      
        Example: San Diego|Hawaii|T

The number in the first line must match the number of flight paths in its corresponding file.

# Usage

1. Make sure you have all the requirements properly installed.
2. The input files must be in the same project folder.
3. Open the project folder in an IDE of choice.
4. Run the main class.
5. The output should display in the output window.
   
Note: The data in the input files can be modified according to the user's choice if needed.






Thank you!

Krishy Nese:
- LinkedIn: www.linkedin.com/in/krishynese

