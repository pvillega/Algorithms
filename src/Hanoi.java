import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * Created with IntelliJ IDEA.
 * User: pvillega
 * Date: 29/07/12
 * Time: 13:11
 * Solves the Towers of Hanoi problem for n disks (see http://en.wikipedia.org/wiki/Tower_of_Hanoi)
 */
public class Hanoi {

    public static void main(String[] args) {
        //number of disks
        int N = 23;

        //generate the initial state
        Stack<Integer> left = new Stack<Integer>();
        Stack<Integer> middle = new Stack<Integer>();
        Stack<Integer> right = new Stack<Integer>();

        //add all pieces in left stack in order
        for (int i = N; i > 0; i--) {
            left.add(i);
        }

        //start calculating
        List<String> moves = hanoi(N, left, right, middle,"Left", "Right", "Middle");

        //print results
        System.out.println("-----------------------------------------------------------");
        System.out.println(moves.size() + " MOVES");
        System.out.println("-----------------------------------------------------------");
        /*int i = 0;
        for (String s : moves) {
            System.out.println(i + ") " + s);
            i++;
        } */
    }

    /**
     * Recursive way of generating all the moves. Steps to move all disks from A to C:
     *
     * 1) move n−1 discs from A to B. This leaves disc n alone on peg A
     * 2) move disc n from A to C
     * 3) move n−1 discs from B to C so they sit on disc n
     *
     *
     * @param pieces number of pieces to move
     * @param a origin of the disks
     * @param c destination of the disks
     * @param b the support pole (which may change per each step)
     * @param from name of the origin Stack
     * @param to name of the destination Stack
     * @param support name of the Support stack
     * @return the moves of the solution
     */
    private static List<String> hanoi(int pieces, Stack<Integer> a, Stack<Integer> c, Stack<Integer> b, String from, String to, String support) {
        List<String> result = new ArrayList<String>();
        if(pieces > 0) {
            // move n−1 discs from A to B. This leaves disc n alone on peg A
            result.addAll(hanoi(pieces - 1, a, b, c, from, support, to));

            // move disc n from A to C
            Integer l = a.pop();
            c.push(l);
            result.add("(" + l + ") "+ from +" to "+ to);

            // move n−1 discs from B to C so they sit on disc n
            result.addAll(hanoi(pieces - 1, b, c, a, support, to, from));

        }
        return result;
    }
}
