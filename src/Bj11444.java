import java.io.*;
import java.util.*;

// 피보나치 수 6

public class Bj11444 {
    static int[] fibonacciSave;
    static int fibonacci(int n){
        if(fibonacciSave[n]!=-1){
            return fibonacciSave[n];
        } else{
            return fibonacciSave[n] =  (fibonacci(n-1)+fibonacci(n-2));
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        fibonacciSave = new int[46];
        Arrays.fill(fibonacciSave,-1);
        fibonacciSave[0] = 0;
        fibonacciSave[1] = 1;

        int N = Integer.parseInt(br.readLine());
        System.out.printf("%d",fibonacci(N));
    }
}
