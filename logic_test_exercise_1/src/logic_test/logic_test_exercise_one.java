
/*
 * For this program all you need to know if the patron, we know that you have to folllow this patron everytime
 * the patron is the facings because it repeates every time R->D->L->U
 * knowing this we can make an algorithm to travel around the matrix following this patron.
 */

package logic_test;
import java.io.Console;
import java.util.ArrayList;
import java.util.Scanner;
/**
 *
 * @author Mauricio Burgos
 */
public class logic_test_exercise_one {

    private int tests;
   private ArrayList<int[][]> matrix = new ArrayList<>();
   
    /**
     * @param test number on cases 
     * @param matrix m and n size for every matrix, store matrix data 
     */
    public static void main(String[] args) {
        logic_test_exercise_one l = new logic_test_exercise_one();
       
       //Ask for the quantity of cases
       System.out.print("Number of test cases: ");
       int cases =0;
       Scanner entry = new Scanner(System.in);
       String entryN = entry.nextLine();
       cases = Integer.parseInt(entryN);
       l.tests = cases;
       
       //Create the matrix
       for(int i=0;i<l.tests;i++)
        {          
           int columns; int rows;
           System.out.print("Matrix #"+Integer.toString(i+1)+" rows: ");
           columns = Integer.parseInt(entry.nextLine());
           System.out.print("Matrix #"+Integer.toString(i+1)+" colums: ");
           rows = Integer.parseInt(entry.nextLine());
           int newMatrix[][] = new int[columns][rows];
           l.matrix.add(newMatrix);
        }
       
       //Logic for get the facing
        System.out.println("Facings: ");
        for(int newMatrix[][] :l.matrix)
        {
          String facing = "";
          int rows =0;    
          int columns =0;    
          int state = 0; 
          int matrixElement = 0;
          int compensator=2;
          
          
          while(matrixElement < newMatrix.length*newMatrix[0].length)
          { 
              int MatrixCompensatorRows=newMatrix.length-rows;
              int MatrixCompensatorColumns=newMatrix[0].length-columns;
        
              if(state==0)
              {
              for(int newMat=rows;newMat<MatrixCompensatorColumns;newMat++)
                      {
                          matrixElement++;
                          facing = "R";
                      }
                      state++;      
              }
              else if(state==1)
              {
                  for(int newMat=rows+1;newMat<MatrixCompensatorRows;newMat++)
                      {
                          matrixElement++;   
                          facing = "D";
                      }
                      state++;
                       
                      
              }
              else if(state==2)
              {
              for(int newMat = MatrixCompensatorColumns-compensator; newMat >= columns; newMat--)
                      {
                          matrixElement++;
                          facing = "L";
                      }
                      state++;       
              }
              else if(state==3)
              {
              for (int newMat = MatrixCompensatorRows - compensator; newMat >= rows + 1; newMat--)
                      {
                          matrixElement++;
                          facing = "U";
                      }
                      state = 0;
                      rows++;
                      columns++;       
              }
         
          } 
          System.out.println(facing);
          
        }
        System.out.println("-----END-----");
   
    }
   
    
}
