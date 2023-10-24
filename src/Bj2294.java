import java.io.*;
import java.util.*;
// 동전 2

// 원 마다 종류를 집어 넣는 게 아니라
// 종류마다 한 번 씩 돌기.
// coin(n-1,k) -> coin(n,k)
public class Bj2294 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(st.nextToken()); // 동전 종류
        int K = Integer.parseInt(st.nextToken()); // 구하려는 액수.
        int[] coin = new int[N+1];
        int[] dp = new int[K+1];

        // 입력
        for(int i=0;i<N;i++){
            coin[i] = Integer.parseInt(br.readLine());
        }

        for(int i=1;i<=K;i++){
            dp[i] = (int)2e9;
        }

        // 초기값 입력.
        dp[0] = 0;

        // 1원, 2원, ... , K원 까지.
        for(int i=1;i<=K;i++){
            // 동전 액수 만큼 뒤로 가서 최소값 찾는다.
            for(int j=0;j<N;j++){
                if(i-coin[j] < 0) continue;
                dp[i] = Math.min(dp[i] , dp[i-coin[j]] + 1);
            }
        }

        if(dp[K] != (int)2e9) System.out.print(dp[K]);
        else System.out.println(-1);
    }
}
