import java.math.BigInteger;
import java.util.*;

/**
 * Created with IntelliJ IDEA.
 * User: pvillega
 * Date: 29/07/12
 * Time: 13:11
 * Solves the n Queens Problems (see http://en.wikipedia.org/wiki/Eight_queens_puzzle)
 */
public class Queens {

    public static void main(String[] args) {
        //number of rows in the table
        int N = 4;
        //we use a linear array to store the results. The position is the row, the value is the column
        int[] table = new int[N];
        //start calculating from row 0
        List<int[]> results = findQueens(table, 0);
        //print results
        System.out.println("-----------------------------------------------------------");
        System.out.println(results.size() + " SOLUTIONS");
        System.out.println("-----------------------------------------------------------");
        for(int[] t : results) {
            for (int i = 0; i < t.length; i++) {
                for (int j = 0; j < t.length; j++) {
                    if (t[i] == j) {
                        System.out.print("Q ");
                    } else {
                        System.out.print("* ");
                    }
                }
                System.out.println();
            }
            System.out.println();
        }
    }

    /**
     * Recursive way of generating all the possibilities
     * @param table the table that contains the values
     * @param row current row we are generating
     * @return the valid combinations found
     */
    private static List<int[]> findQueens(int[] table, int row) {
        List<int[]> result = new ArrayList<int[]>();
        //simple case on recursion: we have checked all rows for this table
        if (row == table.length){
            result.add(table.clone());
        }
        else {
            //we try all possible columns for this row, and for each valid column we proceed to next row
            for (int i = 0; i < table.length; i++) {
                table[row] = i;
                //check if that column has a conflict
                boolean conflict = false;
                for (int h = 0; h < row && !conflict; h++) {
                    if ( (table[h] == table[row]) || // same column
                         ((table[h] - table[row]) == (row - h)) ||   // same major diagonal
                         ((table[row] - table[h]) == (row - h)) // same minor diagonal
                    ) {
                        conflict = true;
                    }
                }
                //if no conflict, proceed with next column
                if (!conflict) {
                    result.addAll(findQueens(table, row + 1));
                }
            }
        }
        return result;
    }


}
