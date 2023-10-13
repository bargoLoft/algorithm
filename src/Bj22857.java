import java.io.*;
import java.util.*;
// 가장 긴 짝수 연속한 부분 수열
// 투 포인터
// DP..? LIS 학습.
public class Bj22857 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        int[] dp = new int[N];

        st = new StringTokenizer(br.readLine());
        for(int i=0;i<N;i++){
            dp[i] = Integer.parseInt(st.nextToken());
            if(dp[i]%2==0) dp[i] = 1;
            else dp[i] = 0;
        }

        int str = 0;
        int end = 0;
        int even = 0;
        int odd = 0;

        int max = 0;

        while(str<N){
            while(odd<=K && end < N){
                if(dp[end]==0) odd++;
                else even++;
                end++;
            }
            if(even>max) max = even;
            while(odd>K){
                if(dp[str]==0) odd--;
                else even--;
                str++;
            }
            if(end == N) break;
        }

        System.out.println(max);
    }
}
