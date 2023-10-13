import java.io.*;
import java.util.*;

public class Bj9657 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int[] dp = new int[N+4];
        int[] stone = {1,3,4};

        // DP
        for(int i=0;i<stone.length;i++){
            dp[stone[i]] = 'S';
        }

        for(int i=1;i<N;i++){
            for(int j=0;j<stone.length;j++){
                if(dp[i+stone[j]]!='S'){
                    if(dp[i]=='S'){
                        dp[i+stone[j]] = 'C';
                    } else if (dp[i] == 'C'){
                        dp[i+stone[j]] = 'S';
                    }
                }
            }
        }

        if(dp[N]=='S') System.out.println("SK");
        else System.out.println("CY");
    }
}
