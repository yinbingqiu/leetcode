package 常见缓存算法;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.IntStream;

public class LinkedHashMap实现LRU {

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
        LinkedHashMap<Integer, Integer> lruCache = new LinkedHashMap<Integer, Integer>(16,0.75f,true) {
            @Override
            protected boolean removeEldestEntry(Map.Entry<Integer, Integer> eldest) {
                return size()>k;
            }
        };
        List<Integer> result=new ArrayList<>();
        for (int[] operator : operators) {
            if (operator.length == 2 && operator[0] == 2){
                result.add(lruCache.containsKey(operator[1])?lruCache.get(operator[1]):-1);
            }else if (operator.length == 3 && operator[0]  == 1){
                lruCache.put(operator[1],operator[2]);
            }else {
                throw new IllegalArgumentException();
            }
        }
        if (result.isEmpty()){
            return new int[0];
        }else {
            int[] r=new int[result.size()];
            IntStream.range(0,result.size()).forEach(i->r[i]=result.get(i));
            return r;
        }
    }
}
