import java.util.*;
import java.util.stream.Collectors;

/**
 * @author: Xingweicheng
 * @description:最好的扑克手牌
 *
 * @date: 2023/2/20 22:28
 */
public class Solution2347 {

    public  String bestHand(int[] ranks, char[] suits){
        //首先判断是不是Flush
        List<Character> charList=new String(suits).chars().
                mapToObj(c->(char) c).collect(Collectors.toList());
        Set<Character> charSet=new HashSet<>(charList);
        if(charSet.size()==1)
            return "Flush";
        //判断对子和三条
        Map<Integer, Integer> h = new HashMap<Integer, Integer>();
        for (int rank : ranks) {
            h.put(rank, h.getOrDefault(rank, 0) + 1);
        }
        if (h.size() == 5) {
            return "High Card";
        }
        for (Map.Entry<Integer, Integer> entry : h.entrySet()) {
            if (entry.getValue() > 2) {
                return "Three of a Kind";
            }
        }
        return "Pair";

    }
    public static void main(String[] args) {
        int[] ranks=new int[]{13,2,3,1,9};
        char[] suits=new char[]{'a','a','a','a','a'};
        System.out.println(new Solution2347().bestHand(ranks,suits));
    }
}
