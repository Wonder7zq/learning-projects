package com.example.demo2;

import java.util.*;

/**
 * @author Wonder7zq
 * @date 2020/10/11 - 20:28
 */
public class CharacterCountTest {
    public static void test(){
        String s="abdc2223333ddd";
        Map<Character, Integer> map=new HashMap<Character, Integer>();
        char[] arr=s.toCharArray();
        for(char c:arr){
            if(map.containsKey(c)){
                int i=map.get(c);
                i++;
                map.put(c, i);
            }else{
                map.put(c, 1);
            }
        }
        List<Map.Entry<Character, Integer>> list=new ArrayList<Map.Entry<Character,Integer>>();
        for(Map.Entry<Character, Integer> me:map.entrySet()){
            list.add(me);
        }
 //       Collections.sort(list,new MyComparator());
        for(Map.Entry<Character, Integer> me:list){
            System.out.println(me.getKey()+"="+me.getValue());
        }
    }
    public static void main(String[] args) {
        test();
    }
}

