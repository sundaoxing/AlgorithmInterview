package com.util;

import java.lang.reflect.Array;
import java.util.Arrays;

public class Util {
    public static Integer [] generateOrderArray(int n){
        Integer []arr = new Integer [n];
        for(int i=0 ; i<n;i++){
            arr[i]=i;
        }
        return arr;
    }

    public static void swap(int [] arr,int i ,int j){
        int temp = arr[i];
        arr[i]=arr[j];
        arr[j]=temp;
    }
}
