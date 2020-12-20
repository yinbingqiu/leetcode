package 代码复习目录;

import java.util.LinkedHashMap;
import java.util.Map;

public class linkedHashMap实现lru {

    public static void main(String[] args) {

        int k = 10;

        LinkedHashMap<Integer,Integer> lruCache = new LinkedHashMap<Integer,Integer>(16,0.75F,true) {
            @Override
            protected boolean removeEldestEntry(Map.Entry eldest) {
                return size() > k;
            }
        };





    }
}
