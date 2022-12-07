package com.example.demo2;

import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;

/**
 * @author Wonder7zq
 * @date 2020/10/20 - 21:36
 */
public class ArrayListDelTest {
    public static void main(String[] args) {
        ArrayList al=new ArrayList();
        al.add("12");
        al.add("abc");
        al.add("abc");
        al.add("aa");
        al.add("abc");
        al.add(new Date());

        ArrayList al1=new ArrayList();//用来装需要删除的元素
        Iterator iterator=al.iterator();

        while(iterator.hasNext()){
            Object obj=iterator.next();
            if(obj.equals("abc")){
//                al1.add(obj);//遍历集合，把所有字符串"abc"放到另一个字符串
                iterator.remove();
            }
        }

        al.removeAll(al1);//遍历完成后执行删除
        System.out.println(al);
    }

    public static String compressString(String s) {
        StringBuilder sb = new StringBuilder();
        int sum = 1;
        char c1 = s.charAt(0);
        for (int i=1;i<s.length();i++){
            char c2  = s.charAt(i);
            if(c1==c2){
                sum++;
                continue;
            }
            if(sum>1){
                sb.append(c1).append(sum);
            }else{
                sb.append(c1);
            }
            c1=c2;
            sum=1;
        }
        if(sum>1){
            sb.append(c1).append(sum);
        }else{
            sb.append(c1);
        }
        return sb.toString();
    }
}

