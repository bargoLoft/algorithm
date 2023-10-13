import java.io.*;
import java.util.*;

public class Bj9656 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        String[] dp = new String[N+4];
        // 수학적 풀이
//        if(N%2==1) System.out.println("SK");
//        else System.out.println("CY");

        // DP
        dp[1] = "CY";
        dp[3] = "CY";
        for(int i=1;i<N;i++){
            if(dp[i]=="SK"){
                dp[i+1] = "CY";
                dp[i+3] = "CY";
            } else if (dp[i] == "CY"){
                dp[i+1] = "SK";
                dp[i+3] = "SK";
            }
        }

        System.out.printf(dp[N]);
    }
}
