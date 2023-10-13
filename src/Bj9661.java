import java.io.*;
import java.util.*;

public class Bj9661 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        long N = Long.parseLong(st.nextToken());

        if(N%5==2||N%5==0) System.out.println("CY");
        else System.out.println("SK");

//        DP로 공식 계산.
//        int[] dp = new int[N+4];
//
//        // DP
//        dp[0] = 'C';
//        dp[1] = 'S';
//        dp[2] = 'C';
//        dp[3] = 'S';
//        dp[4] = 'S';
//
//        for(int i=5;i<=N;i++){
//            int four = 1;
//            while(i-four>0){
//                if(dp[i-four]=='C'){
//                    dp[i] = 'S';
//                    break;
//                } else if(dp[i-four] =='S') {
//                    dp[i] = 'C';
//                }
//                four*=4;
//            }
//        }
//
//        for(int i=1;i<N;i++){
//            if(dp[i]=='S') System.out.print("S ");
//            else System.out.println("C ");
//        }

    }
}
