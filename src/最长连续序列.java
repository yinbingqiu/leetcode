import java.util.*;
import java.util.stream.Collectors;

/**
 * 输入一组未排序的整数，找出其中最长的连续数字的长度。例如输入为[3,1,2,5,7,4,8,9] ，其中连续的数据为1,2,3,4,5，长度为5 。要求算法时间复杂度为O(n).本题会人工判卷,请严格按照复杂度完成算法。
 * https://www.nowcoder.com/practice/ec7770f3a4324ded8e105c0054af066b?sourceQid=25269&sourceTpId=190
 */
public class 最长连续序列 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String str = scanner.nextLine();
        if (str==null){
            System.out.println(0);
        }


        List<Integer> list = Arrays.stream(str.split(",")).map(Integer::new).collect(Collectors.toList());
        if (list.isEmpty()){
            System.out.println(0);
        }

         Map<Integer,Integer> map=new HashMap<>();
        for (Integer k : list) {
            int left=0;
            if (map.containsKey(k-1)){
                left=map.get(k-1);
            }

            int right=0;
            if (map.containsKey(k+1)){
                right=map.get(k+1);
            }




        }
    }
}
