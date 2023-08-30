import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
// 이동하기
// 재귀로 짜면 터짐.
// 이전의 열심히 하시잖아. + 현재 -> 상향식.
public class Bj11048 {
    static int N;
    static int M;
    static int[][] map;
    static int[][] dp;
    static  int[] dx;
    static  int[] dy;
//    static void miro(int x, int y, int candy){
//        if(candy > candyMap[x][y]){
//            candyMap[x][y] = candy;
//        } else{
//            return;
//        }
//
//        if(x==N-1 && y == M-1){
//            //종료
//            return;
//        }
//
//        for(int i=0;i<=1;i++){
//            int nx = x + dx[i];
//            int ny = y + dy[i];
//
//            if(nx<0||nx>=N||ny<0||ny>=M){
//                continue;
//            }
//
//            miro(nx,ny,candy+map[nx][ny]);
//        }
//    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        map = new int[N][M];
        dp = new int[N][M];

        dx = new int[] {0,1};
        dy = new int[] {1,0};

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        dp[0][0] = map[0][0];

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                for(int d=0;d<2;d++){
                    int bx = i - dx[d];
                    int by = j - dy[d];

                    if(bx<0||bx>=N||by<0||by>=M) continue;
                    dp[i][j] = Math.max(dp[i][j], dp[bx][by]+map[i][j]);
                }
            }
        }
//
//        miro(0,0,map[0][0]);

//        for (int i = 0; i < N; i++) {
//            for (int j = 0; j < M; j++) {
//                System.out.print(candyMap[i][j]+ " ");
//            }
//            System.out.println();
//        }

        System.out.println(dp[N-1][M-1]);
    }
}
