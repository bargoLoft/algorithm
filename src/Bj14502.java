import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;
// 연구소
// dfs + bfs
public class Bj14502 {
    static class Wall{
        int x;
        int y;

        public Wall(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
    static class Virus{
        int x;
        int y;

        public Virus(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
    static int[][] map;
    static int[][] isVisited;
    static Wall[] wall;
    static Virus[] virus;
    static int N;
    static int M;

    static int[] dx = {0,1,0,-1};
    static int[] dy = {1,0,-1,0};
    static int max;
    static int virusCnt;

    static void makeWall(int dep){
        if(dep==3){
            Queue<Virus> q = new ArrayDeque();
            int[][] copyMap = new int[N][M];
            int[][] visited = new int[N][M];

            for(int i=0;i<N;i++){
                for(int j=0;j<M;j++){
                    copyMap[i][j] = map[i][j];
                }
            }

            // 벽 추가, 바이러스 추가.
            for(int i=0;i<3;i++){
                copyMap[wall[i].x][wall[i].y] = 1;
            }

            for(int i=0;i<virusCnt;i++){
                q.add(virus[i]);
            }
            // BFS
            while(!q.isEmpty()){
                Virus v = q.poll();

                for(int d=0;d<4;d++){
                    int nx = v.x + dx[d];
                    int ny = v.y + dy[d];

                    if(nx<0||nx>=N||ny<0||ny>=M) continue;
                    if(visited[nx][ny]==1) continue;
                    if(copyMap[nx][ny]==1) continue;
                    if(copyMap[nx][ny] == 0){
                        visited[nx][ny] = 1;
                        q.add(new Virus(nx,ny));
                        copyMap[nx][ny] = 2;
                    }
                }
            }

            int cnt = 0;

            for(int i=0;i<N;i++){
                for(int j=0;j<M;j++){
                    if(copyMap[i][j] ==0){
                        cnt++;
                    }
                }
            }
            if(cnt > max) max = cnt;
            //종료 너비우선 탐색으로 0인 공간 리턴.
            return;
        }

        for(int i=0;i<N;i++){
            for(int j=0;j<M;j++){
                if(isVisited[i][j] == 1) continue;
                if(map[i][j] == 1 || map[i][j] == 2) continue;
                isVisited[i][j] = 1;
                wall[dep] = new Wall(i,j);
                makeWall(dep+1);
                isVisited[i][j] = 0;
            }
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        map = new int[N][M];
        isVisited = new int[N][M];
        wall = new Wall[3];
        virus = new Virus[10];
        max = 0;
        virusCnt =0;

        for(int i=0;i<N;i++){
            st = new StringTokenizer(br.readLine());
            for(int j=0;j<M;j++){
                map[i][j] = Integer.parseInt(st.nextToken());
                if(map[i][j] == 2){
                    virus[virusCnt++] = new Virus(i,j);
                }
            }
        }

        makeWall(0);
        System.out.println(max);
    }
}
