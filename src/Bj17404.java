import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// RGB거리
public class Bj17404 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int[][] dp = new int[N+1][3]; // N번째 집까지에 해당 색을 선택했을 때의 최저 비용.
        int[][] price = new int[N+1][3]; // 비용
        int[][] color = new int[N+1][3]; // 각 경로의 첫 번째 색을 저장하는 배열.

        // 입력
        for(int i=1;i<=N;i++){
            st = new StringTokenizer(br.readLine());
            for(int c=0;c<3;c++){
                price[i][c] = Integer.parseInt(st.nextToken());
            }
        }

        // + 1번과 N번이 같지 않아야 함.
        dp[1][0] = price[1][0];
        dp[1][1] = price[1][1];
        dp[1][2] = price[1][2];

        color[1][0] = 0;
        color[1][1] = 1;
        color[1][2] = 2;

        dp[N][0] = Integer.MAX_VALUE;
        dp[N][1] = Integer.MAX_VALUE;
        dp[N][2] = Integer.MAX_VALUE;

        // i번째 집의 각 색깔 선택 시의 최저 비용 저장.
        for(int i=2;i<=N;i++){
            for(int c=0;c<3;c++){
                if(i==N){
                    if(color[N-1][(c+1)%3] == c && color[N-1][(c+2)%3] == c){
                        continue;
                    }
                    else if (color[N-1][(c+1)%3] == c){
                        dp[i][c] = price[i][c] + dp[i-1][(c+2)%3];
                    } else if (color[N-1][(c+2)%3] == c){
                        dp[i][c] = price[i][c] + dp[i-1][(c+1)%3];
                    } else{
                        dp[i][c] = price[i][c] + Math.min(dp[i-1][(c+1)%3],dp[i-1][(c+2)%3]);
                    }
                } else{
                    int dif1 = dp[i-1][(c+1)%3];
                    int dif2 = dp[i-1][(c+2)%3];
                    int select = dif1 < dif2 ? (c+1)%3 : (c+2)%3;
                    color[i][c] = color[i-1][select];
                    dp[i][c] = price[i][c] + dp[i-1][select];
                }
            }
        }

        // N번째 집의 3개의 선택 중 최저 비용 출력.
        System.out.println(Math.min(Math.min(dp[N][0],dp[N][1]),dp[N][2]));
    }
}
