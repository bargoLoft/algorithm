import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;
// 벽 부수고 이동하기.
// Dp로. 벽을 하나씩 없앤 맵을 BFS.
// 상하좌우 이동이 가능하니 BFS로

// 아이템을 쓴 상태의 방문체크.
// 아이템을 안 쓴 상태의 방문체크.
public class Bj2206 {
    static class WallBreaker{
        int x;
        int y;
        int move;
        int item;

        public WallBreaker(int x, int y,int move, int canBreak) {
            this.x = x;
            this.y = y;
            this.move = move;
            this.item = canBreak;
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        int[][] map = new int[N][M];
        int[][] isVisited = new int[N][M];
        int[][] isVisitedUsedItem = new int[N][M];

        int[] dx = {0,1,0,-1};
        int[] dy = {1,0,-1,0};

        for(int i=0;i<N;i++){
            String s = br.readLine();
            for(int j=0;j<M;j++){
                map[i][j] = s.charAt(j) - '0';
            }
        }

        Queue<WallBreaker> q = new ArrayDeque();

        q.add(new WallBreaker(0,0,1,1));
        isVisited[0][0] = 1;
        isVisitedUsedItem[0][0] = 1;


        int ans = -1;

        while(!q.isEmpty()){
            WallBreaker c = q.poll();

            if(c.x == N-1 && c.y == M-1){
                ans = c.move;
                break;
            }

            for(int d=0;d<4;d++){
                int nx = c.x + dx[d];
                int ny = c.y + dy[d];

                if(nx < 0 || nx>=N || ny<0 || ny>=M) continue;
                if(isVisited[nx][ny] == 1) continue;
                if(c.item == 0 && isVisitedUsedItem[nx][ny] == 1) continue;

                if(map[nx][ny] == 1 && c.item == 0) continue;
                if(map[nx][ny] == 1 && c.item == 1){
                    q.add(new WallBreaker(nx,ny,c.move+1,0));
                    isVisitedUsedItem[nx][ny] = 1;
                    continue;
                }

                q.add(new WallBreaker(nx,ny,c.move+1,c.item));
                if(c.item == 1){
                    isVisitedUsedItem[nx][ny] = 1;
                    isVisited[nx][ny] = 1;
                } else{
                    isVisitedUsedItem[nx][ny] = 1;
                }
            }
        }

        System.out.println(ans);
    }
}
