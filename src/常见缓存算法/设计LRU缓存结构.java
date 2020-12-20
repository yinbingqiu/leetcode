package 常见缓存算法;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.stream.IntStream;

public class 设计LRU缓存结构 {
    public static void main(String[] args) {
        int[][] arr=new int[6][];
        arr[0]=new int[]{1,1,1};
        arr[1]=new int[]{1,2,2};
        arr[2]=new int[]{1,3,2};
        arr[3]=new int[]{2,1};
        arr[4]=new int[]{1,4,4};
        arr[5]=new int[]{2,2};
        int[] lru = LRU(arr, 3);
        for (int i : lru) {
            System.out.print(i + " ");
        }

    }

    /**
     * lru design
     * @param operators int整型二维数组 the ops
     * @param k int整型 the k
     * @return int整型一维数组
     */
    public  static  int[] LRU (int[][] operators, int k) {
        LinkedList<Integer> lruList=new LinkedList<>();
        Map<Integer,Integer> data=new HashMap<>(k);
        List<Integer> list=new ArrayList();
        for (int[] operator : operators) {
            int key = operator[1];
            int op = operator[0];
            if (operator.length == 2 && op ==2){
                list.add(data.containsKey(key)?data.get(key):-1);
                for (int i = 0; i < lruList.size(); i++) {
                    Integer integer = lruList.get(i);
                    if (integer == key){
                        lruList.remove(i);
                        lruList.addFirst(key);
                        break;
                    }
                }

            }else if (operator.length == 3 && op ==1){
                if (lruList.size() == k){
                    Integer l = lruList.removeLast();
                    data.remove(l);
                }

                lruList.addFirst(key);
                data.put(key,operator[2]);
            }else {
                throw  new IllegalArgumentException();
            }
        }
        if (list.isEmpty()){
            return new int[0];
        }else {
            int[] ints = new int[list.size()];
            IntStream.range(0, list.size())
                    .forEach(i -> ints[i] = list.get(i));
            return ints;
        }
    }


}
