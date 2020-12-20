package 常见缓存算法;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import org.omg.PortableInterceptor.INACTIVE;

public class 链表实现LFU算法 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int lines = scanner.nextInt();
        int capacity = scanner.nextInt();
        List<List<Integer>>  numbers=new ArrayList<>();
        for (int i = 0; i < lines; i++) {
            String line = scanner.nextLine();
            numbers.add(Arrays.stream(line.split(" ")).map(s->Integer.valueOf(s)).collect(Collectors.toList()));
        }


        List<Integer> results=lfu(numbers,capacity);



    }

    private static List<Integer> lfu(List<List<Integer>> numbers, int capacity) {
        List<LinkedList<Integer>> lfuList=new ArrayList<>();
        Map<Integer,Integer> data=new HashMap<>();
        List<Integer> result=new ArrayList<>();
        for (int i = 0; i < numbers.size(); i++) {
            List<Integer> line = numbers.get(i);
            if (line != null && line.size() == 2 && line.get(0) == 2){
                Integer key = line.get(1);
                if (data.containsKey(key)){
                    result.add(data.get(key));
                    for (int j = 0; j < lfuList.size(); j++) {

                        LinkedList lfu = lfuList.get(j);
                        if (lfu==null || !lfu.contains(key)){
                            continue;
                        }

                        for (int k = 0; k < lfu.size(); k++) {
                            if (lfu.get(k) == key){
                              lfu.remove(k);
                            }
                        }

                        if (j==capacity-1){
                            lfu.addFirst(key);
                        }else {
                            LinkedList<Integer> lrum = lfuList.get(j + 1);
                            if (lrum==null){
                                LinkedList<Integer> t = new LinkedList<>();
                                lfuList.set(j+1,t);
                                t.addFirst(key);
                            }else {
                                lrum.addFirst(key);
                            }
                        }

                        break;
                    }

                }else {
                    result.add(-1);

                    LinkedList lfu = lfuList.get(0);
                    if (lfu==null){
                        lfu=new LinkedList();
                    }
                    lfu.addFirst(key);
                }
            }else if (line != null && line.size() == 2 && line.get(0) == 1){
                if(data.size() == capacity){
                    for (int j = 0; j < lfuList.size(); j++) {
                        LinkedList lfu = lfuList.get(j);
                        if (lfu!= null){
                            lfu.removeLast();
                            break;
                        }
                    }
                }
                Integer key = line.get(1);
                data.put(key,line.get(2));

                for (int k = 0; k < lfuList.size(); k++) {
                    LinkedList lfu = lfuList.get(k);
                    if (lfu == null || !lfu.contains(key)){
                        continue;
                    }

                    for (int m = 0; m < lfu.size(); m++) {
                        if (lfu.get(m)  == key){
                            lfu.remove(m);

                            if (m==capacity-1){
                                lfu.addFirst(key);
                            }else {
                                LinkedList<Integer> lrum = lfuList.get(m + 1);
                                if (lrum==null){
                                    LinkedList<Integer> t = new LinkedList<>();
                                    lfuList.set(m+1,t);
                                    t.addFirst(key);
                                }else {
                                    lrum.addFirst(key);
                                }
                            }

                            break;
                        }
                    }

                }


            }else {
                throw new IllegalArgumentException();
            }

        }


        return null;
    }
}
