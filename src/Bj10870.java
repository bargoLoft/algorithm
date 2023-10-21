import java.io.*;
import java.math.BigInteger;
import java.util.*;
// 피보나치 4,5

// 재귀
// 와 BigInteger
public class Bj10870 {
    static BigInteger[] recursion;

    static BigInteger fibonacci(int N){
        if(recursion[N]!=BigInteger.valueOf(0)) return recursion[N];
        if(N==0) return BigInteger.valueOf(0);
        if(N==1) return BigInteger.valueOf(1);
        return recursion[N] = fibonacci(N-1).add(fibonacci(N-2));
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(st.nextToken());
        recursion = new BigInteger[N+1];
        for(int i=0;i<=N;i++){
            recursion[i] = BigInteger.valueOf(0);
        }

        System.out.println(fibonacci(N));
    }
}
