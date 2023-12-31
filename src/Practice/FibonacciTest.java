package Practice;

import java.util.Arrays;
import java.util.Scanner;

public class FibonacciTest {

    static long totalCnt1, totalCnt2, callCnt1[], callCnt2[], memo[];

    static long fibo1(int n){
        totalCnt1++;
        callCnt1[n]++;

        if(n<2) return n;
        return fibo1(n-1)+fibo1(n-2);
    }
    static long fibo2(int n){
        totalCnt2++;
        callCnt2[n]++;

        if(memo[n] == -1){
            memo[n] = fibo2(n-1) + fibo2(n-2);
        }
        return memo[n];
    }


    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();

        totalCnt1 = totalCnt2 = 0;
        callCnt1 = new long[N+1];
        callCnt2 = new long[N+1];
        memo = new long[N+1];

        Arrays.fill(memo, -1);
        memo[0] = 0;
        memo[1] = 1;

//        fibo1(N);
//        System.out.println(totalCnt1);
//        for(int i=0;i<N;i++){
//            System.out.println("fibo1["+i+"} : " + callCnt1[i]);
//        }
        fibo2(N);
        System.out.println("-----------------------------------");
        System.out.println(totalCnt2);
        for(int i=0;i<N;i++){
            System.out.println("fibo2["+i+"} : " + callCnt2[i]);
        }


    }
}
