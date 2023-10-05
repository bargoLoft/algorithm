import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;
// 녹색 옷 입은 애가 젤다지?
// bfs? 메모이제이션 dp로 풀면 더 빠를 듯.
public class Bj4485 {
    static class Zelda{
        int x;
        int y;

        public Zelda(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
    static int[] dx = {0,1,0,-1};
    static int[] dy = {1,0,-1,0};
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int tc = 1;
        while(true){
            st = new StringTokenizer(br.readLine());
            int N = Integer.parseInt(st.nextToken());
            if(N == 0) break;

            int[][] map = new int[N][N];
            int[][] coin = new int[N][N];

            for(int i=0;i<N;i++){
                st=new StringTokenizer(br.readLine());
                for(int j=0;j<N;j++){
                    map[i][j] = Integer.parseInt(st.nextToken());
                }
            }

            for(int i=0;i<N;i++){
                for(int j=0;j<N;j++){
                    coin[i][j] = 99999999;
                }
            }

            Queue<Zelda> q = new ArrayDeque();
            q.add(new Zelda(0,0));
            coin[0][0] = map[0][0];

            while(!q.isEmpty()){
                Zelda z = q.poll();

                for(int d=0;d<4;d++){
                    int nx = z.x+dx[d];
                    int ny = z.y+dy[d];

                    if(nx<0||nx>=N||ny<0||ny>=N) continue;
                    if(coin[nx][ny]>coin[z.x][z.y]+map[nx][ny]){
                        q.add(new Zelda(nx,ny));
                        coin[nx][ny] = coin[z.x][z.y]+map[nx][ny];
                    }
                }
            }

            System.out.println("Problem " + tc++ + ": " + coin[N-1][N-1]);
        }
    }
}
