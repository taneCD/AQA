package org.example;

import java.util.ArrayList;

public class Zadatak {
    public static void main(String[] args) {
        String str = "1 9 3 4 -5 15 -47";
        System.out.println(highAndLow(str));
    }
    public static String highAndLow(String numbers) {
        int min=Integer.MAX_VALUE;
        int max=Integer.MIN_VALUE;
        String[]ovo=numbers.split(" ");
        ArrayList<Integer>listInt=new ArrayList<>();
        for(int i=0;i<ovo.length;i++){
            listInt.add(Integer.valueOf(ovo[i]));
        }

        for(int i=0;i< listInt.size();i++){
            if(listInt.get(i)<min){
                min=listInt.get(i);
            }
        }
        for(int i=0;i< listInt.size();i++){
            if(listInt.get(i)>max){
                max=listInt.get(i);
            }
        }
        return max+" "+min;
    }
}
