
Author: Héctor Mauricio Burgos Rosado.

The two programs are develop in JAVA programming language.


Problem 1 Logic.-


  For this program all you need to know if the patron, we know that you have to folllow this patron everytime
  the patron is the facings because it repeates every time R->D->L->U
  knowing this we can make an algorithm to travel around the matrix following this patron.
  If you make a full path around the matrix you will notice that the corners can only be counted one time every path so for that we 
  are walking the matrix using a for cycle; in this way we count the corners 2 times every path so we need to have a compensator for 
  our operations (-2) every round so we get the correct result at the end.
  The program uses states to handle the current facing position that will change every round and at the end will cointain the final position
  we are facing.


Problem 2 Logic.-

   The Romans did not use a system measuring the years before and after Christ, so this data must be taken into account 
   in order to correctly represent the years in their Roman form, the Romans count from year 1 that for us is represented
   as 753 before Christ, so the current year 2019 would be the Roman year 2773.
   The logic that we will use for this program is to detect if the year is AD or BC and convert that year into its
   corresponding in Roman years that is  from year 1 to year 2773 (current 2020).
   if year is AD you new to add 753 in order to get the corresponding roman year if is BC you need to subtract 754.	
   Once we get the roman year from A and B limits we need to get all years between that two years (inclusive) and store it into an array	
   and then be able to make the representation in corresponding Roman letters year for all items in array.		
   after that all we need to do is to store this data in an array and then you can go through the array and get which string is the longest and print the size.	

	


open a IDE that can handle JAVA code and open the file .java in order to see and run the code.