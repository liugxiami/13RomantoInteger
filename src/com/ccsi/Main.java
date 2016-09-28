package com.ccsi;

import com.sun.scenario.effect.impl.sw.sse.SSEBlend_SRC_OUTPeer;

import java.util.*;

public class Main {

    public static void main(String[] args) {
	    String s="MMMCDLXXX";
        System.out.println(romanToInt(s));
    }
    //Given a roman numeral,convert it to an integer
    //Input is guaranteed to be within the range from 1 to 3999.
    //从前向后遍历罗马数字，如果某个数比前一个数小，则加上该数。反之，减去前一个数的两倍然后加上该数
    public static int romanToInt(String s){
        if(s==null||s.length()==0)return -1;

        Map<Character,Integer> roma=new HashMap<>();
        roma.put('I',1);
        roma.put('V',5);
        roma.put('X',10);
        roma.put('L',50);
        roma.put('C',100);
        roma.put('D',500);
        roma.put('M',1000);

        int result=roma.get(s.charAt(0)),curr,pre;
        for (int i = 1; i < s.length(); i++) {
            pre=roma.get(s.charAt(i-1));
            curr=roma.get(s.charAt(i));
            if(pre<curr)result=result+curr-2*pre;   //因为前面加过一次pre了。
            else{
                result=curr+result;
            }
        }
        return result;
    }
}
