package com.example.demo2;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * @author Wonder7zq
 * @date 2020/10/20 - 21:26
 */
public class ListDeleteTest {
    public static void main(String[] args) {
        listIterator3();
    }
    public static void listIterator3(){
        List<Integer> list = new ArrayList<Integer>();
        list.add(1);
        list.add(2);
        list.add(2);
        list.add(3);
        list.add(4);

        Iterator<Integer> it = list.iterator();
        while (it.hasNext()){
            Integer value = it.next();
            if (2 == value) {
                it.remove();
            }

            System.out.println(value);
        }

        System.out.println("list=" + list.toString());
    }
}
