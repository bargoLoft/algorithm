package Btype;

import java.util.Collections;
import java.util.*;
import java.util.PriorityQueue;

public class test {

    public int BinarySearch(int[] arr, int x){
        int str = 0;
        int end = arr.length - 1;
        while(str <= end){
            int m = (str + end) / 2;
            if(arr[m] == x) return m;
            if(arr[m] < x) str = m + 1;
            else end = m - 1;
        }
        return -1;
    }
    public static void main(String[] args) {
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        PriorityQueue<Integer> rpq = new PriorityQueue<>(Collections.reverseOrder());

        HashSet<Integer> set = new HashSet<>();

        HashMap<Integer, String> map = new HashMap<>();


    }
}
