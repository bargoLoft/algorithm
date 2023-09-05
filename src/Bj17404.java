import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

// RGB거리2
// 제한 조건 맨 앞과 맨 뒤가 달라야 한다.
// 전체 시도를 다 해보고, 그 조건만 제외하고 최소값 찾기.
public class Bj17404 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int[][] dp = new int[N + 1][3]; // N번째 집까지에 해당 색을 선택했을 때의 최저 비용.
        int[][] price = new int[N + 1][3]; // 비용
        int[][] color = new int[N + 1][3]; // 각 경로의 첫 번째 색을 저장하는 배열.

        // 입력
        for (int i = 1; i <= N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int c = 0; c < 3; c++) {
                price[i][c] = Integer.parseInt(st.nextToken());
            }
        }

        // + 1번과 N번이 같지 않아야 함.
        // R-R,G,B / G-R,G,B / B-R,G,B 의 최저값 각각 구한뒤.
        // R-R, G-G, B-B 만 제외하고 최소값 찾기.

        // R일 때.
        for (int i = 0; i < 3; i++) {
            dp[1][i] = price[1][i];
            color[1][i] = i;
            dp[N][i] = Integer.MAX_VALUE;
        }

        int min = Integer.MAX_VALUE;

        for(int startColor = 0;startColor<3;startColor++){
            dp[1][startColor] = price[1][startColor];
            dp[1][(startColor+1)%3] = 9999999;
            dp[1][(startColor+2)%3] = 9999999;

            // 1번부터 N번째 집의 각 색깔 선택 시의 최저 비용 저장.
            for (int i = 2; i <= N; i++) {
                for (int c = 0; c < 3; c++) {
                    int dif1 = dp[i - 1][(c + 1) % 3];
                    int dif2 = dp[i - 1][(c + 2) % 3];
                    int select = dif1 < dif2 ? (c + 1) % 3 : (c + 2) % 3;
                    color[i][c] = color[i - 1][select];
                    dp[i][c] = price[i][c] + dp[i - 1][select];
                }
            }
            min = Math.min(Math.min(min, dp[N][(startColor+1)%3]), dp[N][(startColor+2)%3]);
//            for(int i=1;i<=N;i++){
//                System.out.println(Arrays.toString(dp[i]));
//            }
        }


//        for(int i=0;i<3;i++){
//            int min = Integer.MAX_VALUE;
//            for(int j=0;j<3;j++){
//                if(color[N-1][j] == i ) continue;
//                if(dp[N-1][j] < min){
//                    min = price[1][i] + dp[N-1][j];
//                    dp[1][i] = min;
//                    color[1][i] = j;
//                }
//            }
//        }
//
//        for(int i=0;i<3;i++){
//            int min = Integer.MAX_VALUE;
//            for(int j=0;j<3;j++){
//                if(i==j) continue;
//                if(color[1][j] == i ) continue;
//                if(dp[1][j] < min){
//                    min = price[N][i] + dp[1][j];
//                    dp[N][i] = min;
//                    color[N][i] = j;
//                }
//            }
//        }


//
        // N번째 집의 3개의 선택 중 최저 비용 출력.
        System.out.println(min);
    }
}
