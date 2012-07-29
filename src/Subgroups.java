import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: pvillega
 * Date: 29/07/12
 * Time: 13:11
 * Finds all the subgroups of elements from a given list
 */
public class Subgroups {

    public static void main(String[] args) {
        List<Integer> list = new ArrayList<Integer>(){
            {
                add(1);
                add(2);
                add(3);
                //add(4);
            }
        };
        List<List<Integer>> perms = printSugbroups(list);
        System.out.println("-----------------------------------------------------------");
        for(List<Integer> p : perms) {
            System.out.println(p);
        }
    }

    private static <E> List<List<E>> printSugbroups(List<E> list) {
        List<List<E>> result = new ArrayList<List<E>>();
        //we have 2^^n subgroups, we try the binary counting
        for(BigInteger i = BigInteger.ZERO; i.longValue() < Math.pow(2,list.size()); i = i.add(BigInteger.ONE)){
            List<E> permutation = new ArrayList<E>();
            for(int j = 0; j < i.bitLength(); j++) {
                if(i.testBit(j)){
                    permutation.add(list.get(j));
                }
            }
            System.out.println(">> "+ i +"("+i.bitCount()+") | " + permutation);
            result.add(permutation);
        }
        return result;
    }

}
