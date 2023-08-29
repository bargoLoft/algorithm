import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;
import java.util.Arrays;
import java.util.StringTokenizer;

// 2* 타일링 1
public class Bj1793 {

//    private static int tiling(int n) {
//        if(n <= 1) return 1;
//        if(dp[n] != -1) return dp[n];
//        return  dp[n] = (tiling(n-1) + 2*tiling(n-2));
//    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        //StringTokenizer st = new StringTokenizer(br.readLine());

        int N;
        String s;

        while((s = br.readLine()) != null){
            N = Integer.parseInt(s);

            if(N == 0){
                System.out.println("0");
                continue;
            }
            BigInteger[] dp = new BigInteger[N+1];

            for(int i=2;i<=N;i++){
                dp[i] = new BigInteger("0");
            }

            dp[0] = dp[1] = new BigInteger("1");

            for(int i=2;i<=N;i++){
                dp[i] = dp[i].add(dp[i-1]);
                dp[i] = dp[i].add(dp[i-2]);
                dp[i] = dp[i].add(dp[i-2]);
            }

            System.out.println(dp[N]);
        }

        //}

    }
}
