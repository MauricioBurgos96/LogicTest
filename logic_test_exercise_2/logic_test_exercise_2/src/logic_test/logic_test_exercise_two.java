
import java.util.Scanner;
import java.lang.Math; 
import java.util.ArrayList;
/*
 * The Romans did not use a system measuring the years before and after Christ, so this data must be taken into account 
 * in order to correctly represent the years in their Roman form, the Romans count from year 1 that for us is represented
 *  as 753 before Christ, so the current year 2019 would be the Roman year 2773.
 * The logic that we will use for this program is to detect if the year is AD or BC and convert that year into its
 * corresponding in Roman years that is  from year 1 to year 2773 (current 2020) and then be able to make 
 * the representation in corresponding Roman letters year.
 */

public class logic_test_exercise_two {

    private Scanner entry = new Scanner(System.in);
    private String years;
    private String yearA;
    private String yearB;
    private boolean isADYearA;
    private boolean isADYearB;
    private int yearARoman;
    private int yearBRoman;
    private ArrayList<Integer> listOfRomanYears = new ArrayList<Integer>();
    private ArrayList<String> listOfRomanYearsRomanRepresentation = new ArrayList<String>();


   /**
     *  @param entry handle the user input
     *  @param years the string that cointains the input years 
     *  @param yearA the string that cointains the A year 
     *  @param yearB the string that cointains the B year 
     *  @param matrix store matrix data 
     */

    public static void main(String[] args) throws Exception {
        logic_test_exercise_two l = new logic_test_exercise_two();
        
        //Ask for the input years
        l.askForyears();

        //get and print the A and B
        l.getTheAandByear();

        //check if A and B year is AD OR BC
        l.checkIfYearsAreADOrBC();

        //convert A and B in Roman years
        l.representAandBYearInRomanYears();

        //get all years between A and B and save to list also correct if A > B so it does not matter anymore the order the user input the years
        l.getAllYearsBetweenAandB();

        //Convert years to roman representation and save to list
        l.converYearsToRomanRepresentation();

        //Get the minumun characters for represent all years in the list and print the final result
        l.getTheMinumunCharactersForRepresentAllTheYears();



    }


    
    public void print(String toPrint)
    {
        System.out.println(toPrint);
    }


    public void askForyears(){
        print("Please type the years A and B, separated by the - sign");
        String entryN = entry.nextLine();
        years = entryN;
    }

    public void representAandBYearInRomanYears(){
        print("------------------------");
        if(isADYearA){
           yearARoman =  represetRomanYearAD(yearA);

        }
        else{
            yearARoman =    represendRomanYearBC(yearA);

        }

        if(isADYearB){
           yearBRoman = represetRomanYearAD(yearB);

        }
        else{
            yearBRoman = represendRomanYearBC(yearB);

        }

        print("Year A representation in Roman years= "+String.valueOf(yearARoman));
        print("Year B representation in Roman years= "+String.valueOf(yearBRoman));

    }

    public int represetRomanYearAD(String year){
        return Integer.parseInt(getYearWithotEra(year))+753;
    }

    public int represendRomanYearBC(String year){
        return Math.abs(Integer.parseInt(getYearWithotEra(year))-754);

    }


    public void getTheAandByear(){
        print("------------------------");
        String[] split = years.split("-");
        String firstSubString = split[0];
        String secondSubString = split[1];
        yearA = firstSubString;
        yearB = secondSubString;

        print("the first year: " + yearA);
        print("the second year: "+ yearB);
    }

    public String  getYearWithotEra(String year){
        boolean isAD = year.indexOf("AD") !=-1? true: false;
        String returnYear;

        if(isAD){
            String[] split = year.split("AD");
            returnYear  = split[0];
        }
        else{
            String[] split = year.split("BC");
            returnYear  = split[0];
        }

        return returnYear;

    }

    public void checkIfYearsAreADOrBC(){
        isADYearA = yearA.indexOf("AD") !=-1? true: false;

        if(isADYearA){
            print("the first year: " + yearA + " is AD");

        }
        else{
            print("the first year: " + yearA + " is BC");

        }

        isADYearB = yearB.indexOf("AD") !=-1? true: false;

        if(isADYearB){
            print("the second year: " + yearB + " is AD");

        }
        else{
            print("the second year: " + yearB + " is BC");

        }
         
    }


    public void getAllYearsBetweenAandB(){
        int lowNum;
        int highNum;
        if(yearARoman < yearBRoman){
            lowNum = yearARoman;
            highNum= yearBRoman;
        }
        else if(yearARoman > yearBRoman){
            lowNum = yearBRoman;
            highNum= yearARoman;
        }
        else{
            lowNum = yearARoman;
            highNum= yearBRoman;
        }

        for (int i = lowNum ; i <= highNum; i++) {
            listOfRomanYears.add(i);
        }
    }

    public void converYearsToRomanRepresentation(){
        listOfRomanYears.forEach((year) ->
        listOfRomanYearsRomanRepresentation.add(toRoman(year))
        );
        
    }

    public void  getTheMinumunCharactersForRepresentAllTheYears(){
        print("------------------------");

        String longestString= "";
         for (String element : listOfRomanYearsRomanRepresentation) {
             if (element.length() > longestString.length()) {
                 longestString = element;
             }
         }

        print("The longest year representation is: "+ longestString);
        print("The Minumun characters for represent this year are: "+ String.valueOf(longestString.length()));
        print("-------- END --------");

    }


    public static String toRoman(int input)
    {
       
        String s = "";
    
        while (input >= 1000) {
            s += "M";
            input -= 1000;        
        } while (input >= 900) {
            s += "CM";
            input -= 900;
        } while (input >= 500) {
            s += "D";
            input -= 500;
        } while (input >= 400) {
            s += "CD";
            input -= 400;
        } while (input >= 100) {
            s += "C";
            input -= 100;
        } while (input >= 90) {
            s += "XC";
            input -= 90;
        } while (input >= 50) {
            s += "L";
            input -= 50;
        } while (input >= 40) {
            s += "XL";
            input -= 40;
        } while (input >= 10) {
            s += "X";
            input -= 10;
        } while (input >= 9) {
            s += "IX";
            input -= 9;
        } while (input >= 5) {
            s += "V";
            input -= 5;
        } while (input >= 4) {
            s += "IV";
            input -= 4;
        } while (input >= 1) {
            s += "I";
            input -= 1;
        }
    
        return s;
    }



}
