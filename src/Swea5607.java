import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Swea5607 {
    static long[][] dp;
    static long nCr(int n, int r){
        if(dp[n][r]!=0) return dp[n][r];
        if(r==0||n==r) return dp[n][r] = 1;
        return dp[n][r] = (nCr(n-1,r-1)+nCr(n-1,r))%1234567891;
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int T = Integer.parseInt(st.nextToken());

        for(int t = 1;t<=T;t++){
            st =new StringTokenizer(br.readLine());
            int N = Integer.parseInt(st.nextToken());
            int R = Integer.parseInt(st.nextToken());
            dp = new long[N+1][R+1];

            System.out.printf("#%d %d",t,nCr(N,R));
        }
    }
}
