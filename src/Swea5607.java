import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Swea5607 {
    static long p;
    static long fact(int n){
        long ans = 1;
        for(int i=2;i<=n;i++){
            ans*=i;
            ans%=p;
        }
        return ans;
    }
//    static long nCr(int n, int r){
//        if(dp[n][r]!=0) return dp[n][r];
//        if(r==0||n==r) return dp[n][r] = 1;
//        return dp[n][r] = (nCr(n-1,r-1)+nCr(n-1,r))%1234567891;
//    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int T = Integer.parseInt(st.nextToken());

        for(int t = 1;t<=T;t++){
            st =new StringTokenizer(br.readLine());
            int N = Integer.parseInt(st.nextToken());
            int R = Integer.parseInt(st.nextToken());

            p = 1234567891;
            long e = p-2;

            long A = (fact(N-R)*fact(R)) % p;
            long a = 1;

            while(e>0){
                if(e%2==1) a = (a*A) % p;
                A = (A*A)%p;
                e/=2;
            }

            long ans = (fact(N) * a) % p;

            System.out.printf("#%d %d\n",t,ans);
        }
    }
}
