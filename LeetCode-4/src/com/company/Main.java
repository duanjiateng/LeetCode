package com.company;


import java.util.ArrayList;



public class Main {

    public static double findMedianSortedArrays(int[] nums1, int[] nums2) {

        int i = 0, j = 0 , a = 0, b = 0, x=0;
        ArrayList<Integer> array = new ArrayList<>();

        while( i<nums1.length || j<nums2.length ) {
            a = (i < nums1.length) ? nums1[i] : Integer.MAX_VALUE;
            //System.out.println("a:" + a);
            b = (j < nums2.length) ? nums2[j] : Integer.MAX_VALUE;
            //System.out.println("b:" + b);


            if ( a <= b ){
                x = a;
                i++;
            }else if ( a > b) {
                x = b;
                j++;
            }

            System.out.println("x:" + x);

            array.add(x);
        }


        if((array.size() - 1) % 2 == 0){
            return (double)array.get((array.size() - 1) / 2);
        }else{
            return (array.get((array.size() - 1) / 2) + array.get(array.size() / 2) ) / 2.0;
        }

    }

    public static void main(String[] args) {
	    int[] nums1 = new int[]{1, 1};
	    int[] nums2 = new int[]{1, 2};
        System.out.println(findMedianSortedArrays(nums1, nums2));

    }
}
