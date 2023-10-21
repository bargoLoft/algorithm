import java.io.*;
import java.util.*;
// 팩토리얼

// 재귀
public class Bj27433 {
    static long[] recursion;

    static long factorial(int N){
        if(recursion[N]!=0) return recursion[N];
        if(N==1 || N==0) return 1;
        return recursion[N] = factorial(N-1) * N;
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(st.nextToken());
        recursion = new long[N+1];

        System.out.println(factorial(N));
    }
}
