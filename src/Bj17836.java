import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;
// 공주님을 구해라! (석방하라..)
// 벽 뿌수기 문제와 동일.
// 방문체크를 검 있을 때 없을 때 따로 하면 됨.
public class Bj17836 {
    static class Zelda{
        int x;
        int y;
        int sword;
        int time;

        public Zelda(int x, int y, int sword, int time) {
            this.x = x;
            this.y = y;
            this.sword = sword;
            this.time = time;
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int T = Integer.parseInt(st.nextToken());
        int[][] map = new int[N][M];
        int[][] visited = new int[N][M];
        int[][] visitedSword = new int[N][M];
        int[] dx = {0,1,0,-1};
        int[] dy = {1,0,-1,0};

        for(int i=0;i<N;i++){
            st = new StringTokenizer(br.readLine());
            for(int j=0;j<M;j++){
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        Queue<Zelda> q = new ArrayDeque<>();

        q.add(new Zelda(0,0,0,0));
        visited[0][0] = 1;

        int ans = -1;

        while(!q.isEmpty()){
            Zelda z = q.poll();

            if(z.x == N-1 && z.y == M-1){
                ans = z.time;
                break;
            }
            // 검 발견.
            if(map[z.x][z.y] == 2){
                visitedSword[z.x][z.y] = 1;
                z.sword = 1;
            }

            for(int d=0;d<4;d++){
                int nx = z.x+dx[d];
                int ny = z.y+dy[d];

                if(nx<0||nx>=N||ny<0||ny>=M) continue;

                if(map[nx][ny] == 1){
                    if(z.sword == 0) continue;
                }

                if(z.sword == 0){
                    if(visited[nx][ny] == 1) continue;
                    q.add(new Zelda(nx,ny,z.sword,z.time+1));
                    visited[nx][ny] = 1;
                } else{
                    if(visitedSword[nx][ny] == 1) continue;
                    q.add(new Zelda(nx,ny,z.sword,z.time+1));
                    visitedSword[nx][ny] = 1;
                }
            }
        }

        if(ans == -1 || ans > T){
            System.out.println("Fail");
        } else{
            System.out.println(ans);
        }

    }
}
