import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

// 2* 타일링 1
public class Bj11726 {
    static int[] dp;
    private static int tiling(int n) {
        if(n <= 1) return 1;
        if(dp[n] != -1) return dp[n];
        return  dp[n] = (tiling(n-1) + tiling(n-2)) % 10007;
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());

        dp = new int[N+1];
        Arrays.fill(dp,-1);
        int ans = tiling(N);
        System.out.println(ans);
    }
}
