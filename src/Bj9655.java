import java.io.*;
import java.util.*;

public class Bj9655 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int[] dp = new int[N+4];
        // 수학적 풀이
//        if(N%2==1) System.out.println("SK");
//        else System.out.println("CY");

        // DP
        dp[1] = 'S';
        dp[3] = 'S';
        for(int i=1;i<N;i++){
            if(dp[i]=='S'){
                dp[i+1] = 'C';
                dp[i+3] = 'C';
                dp[i+4] = 'C';
            } else if (dp[i] == 'C'){
                dp[i+1] = 'S';
                dp[i+3] = 'S';
                dp[i+4] = 'S';
            }
        }
        if(dp[])
        System.out.printf(dp[N]);
    }
}
