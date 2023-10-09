import java.io.*;
import java.util.*;

// 피보나치 수 3
// DP

public class Bj2749 {
    static Long[] fibonacciSave;
    static Long fibonacci(int n){
        if(fibonacciSave[n]!=-1L){
            return fibonacciSave[n];
        } else{
            return fibonacciSave[n] =  (fibonacci(n-1)+fibonacci(n-2));
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        fibonacciSave = new Long[100];
        Arrays.fill(fibonacciSave,-1L);
        fibonacciSave[0] = 0L;
        fibonacciSave[1] = 1L;

        int N = Integer.parseInt(br.readLine());
        System.out.println(fibonacci(N));
    }
}
