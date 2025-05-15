package DP;

import java.io.*;
import java.util.*;

// 피보나치 함수
// DP, 배열 넉넉히
public class Bj1003 {
    static int[] fibonacciSave;
    static int fibonacci(int n){
        if(fibonacciSave[n]!=-1){
            return fibonacciSave[n];
        } else{
            return fibonacciSave[n] =  fibonacci(n-1)+fibonacci(n-2);
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int T = Integer.parseInt(st.nextToken());
        fibonacciSave = new int[41];
        Arrays.fill(fibonacciSave,-1);
        fibonacciSave[0] = 0;
        fibonacciSave[1] = 1;

        for(int t=1;t<=T;t++){
            int N = Integer.parseInt(br.readLine());
            if(N == 0){
                System.out.println("1 0");
                continue;
            }
            System.out.printf("%d %d\n",fibonacci(N-1),fibonacci(N));
        }
    }
}
