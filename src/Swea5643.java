import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
// D4 키순서
public class Swea5643 {

    static int N;
    static int M;
    static int[][] adj;
    static int[][] radj;
    static int Cnt = 0;

    private static void gtDFS(int k) {
        for (int i = 1; i <= N; i++) {
            if (adj[k][i] == 1) { // 나보다 크고
                if (adj[i][0] == -1) { // 미탐색 상태
                    gtDFS(i);
                }

                if (adj[i][0] > 0) {
                    for (int j = 1; j <= N; j++) {
                        if (adj[i][j] == 1) {
                            adj[k][j] = 1;
                        }
                    }
                }
            }
        }
        int cnt = 0;
        for(int i=1;i<=N;i++){
            if(adj[k][i]==1) cnt++;
        }
        adj[k][0] = cnt;
    }

    private static void ltDFS(int cur, boolean[] visited){
        visited[cur] = true;
        for(int i=1;i<=N;i++){
            if(radj[cur][i] == 1 && !visited[i]){
                Cnt++;
                ltDFS(i,visited);
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int T = Integer.parseInt(st.nextToken());

        for(int t = 1;t<=T;t++){
            N = Integer.parseInt(br.readLine());
            M = Integer.parseInt(br.readLine());
            adj = new int[N+1][N+1];
            radj = new int[N+1][N+1];

            for(int i=0;i<=N;i++) adj[i][0] = -1;

            for(int i=0;i<M;i++){
                st = new StringTokenizer(br.readLine());
                int p = Integer.parseInt(st.nextToken());
                int q = Integer.parseInt(st.nextToken());
                adj[p][q] = 1;
                radj[q][p] = 1;
            }

            int ans = 0;

            for(int k=1;k<=N;k++){
                if(adj[k][0] == -1) gtDFS(k);
            }

            for(int i=1;i<=N;i++){
                for(int j=1;j<=N;j++){
                    adj[0][j] += adj[i][j];
                }
            }

            for(int i=1;i<=N;i++){
                if(adj[i][0] + adj[0][i] == N-1) ans++;
            }
            System.out.println("#"+t+" "+ans);
        }
    }
}
