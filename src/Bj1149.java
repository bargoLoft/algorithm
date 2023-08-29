import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// RGB거리
public class Bj1149 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        int N = Integer.parseInt(st.nextToken());
        int[][] dp = new int[N+1][3]; // N번째 집까지에 해당 색을 선택했을 때의 최저 비용.
        int[][] price = new int[N+1][3]; // 비용

        // 입력
        for(int i=1;i<=N;i++){
            st = new StringTokenizer(br.readLine());
            for(int c=0;c<3;c++){
                price[i][c] = Integer.parseInt(st.nextToken());
            }
        }

        // i번째 집의 각 색깔 선택 시의 최저 비용 저장.
        for(int i=1;i<=N;i++){
            for(int c=0;c<3;c++){
                    dp[i][c] = price[i][c] + Math.min(dp[i-1][(c+1)%3],dp[i-1][(c+2)%3]);
            }
        }

        // N번째 집의 3개의 선택 중 최저 비용 출력.
        System.out.println(Math.min(Math.min(dp[N][0],dp[N][1]),dp[N][2]));
    }
}
