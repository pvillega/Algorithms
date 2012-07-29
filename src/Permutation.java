import java.util.ArrayList;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: pvillega
 * Date: 29/07/12
 * Time: 13:11
 * Finds all the permutations of elements from a given list
 */
public class Permutation {

    public static void main(String[] args) {
        List<Integer> list = new ArrayList<Integer>(){
            {
                add(1);
                add(2);
                add(3);
                //add(4);
            }
        };
        List<List<Integer>> perms = printPermutations(list);
        System.out.println("-----------------------------------------------------------");
        for(List<Integer> p : perms) {
            System.out.println(p);
        }
    }

    private static <E> List<List<E>> printPermutations(List<E> list) {
        List<List<E>> result = new ArrayList<List<E>>();
        //empty list case on recursion
        if (list.size() == 0) {
            result.add(new ArrayList<E>());
        } else {
            //we remove element 0 to do a recursive call on permutations of subgroups
            E firstElement = list.remove(0);
            //call subgroup
            List<List<E>> permutations = printPermutations(list);
            System.out.println(">>"+firstElement+" | "+permutations);
            //iterate over permutation
            for (List<E> smallerPermutated : permutations) {
                //insert removed element on all positions of returned permutations, to create permutations
                for (int index=0; index <= smallerPermutated.size(); index++) {
                    List<E> temp = new ArrayList<E>(smallerPermutated);
                    temp.add(index, firstElement);
                    result.add(temp);
                }
            }
        }
        return result;
    }

}
