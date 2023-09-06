import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;
// 말이 되고픈 원숭이.
// 시간초과.. dp로 풀면 좋을 듯?
public class Bj1600 {
    static class Monkey{
        int x;
        int y;
        int move;
        int horse;

        public Monkey(int x, int y, int move, int horse) {
            this.x = x;
            this.y = y;
            this.move = move;
            this.horse = horse;
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int K = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());
        int W = Integer.parseInt(st.nextToken());
        int H = Integer.parseInt(st.nextToken());

        int[][] map = new int[H][W];
        int[][][] visitedMove = new int[H][W][K+1];

        int[] dx = {0,1,0,-1};
        int[] dy = {1,0,-1,0};

        int[] hx = {1,2,2,1,-1,-2,-2,-1};
        int[] hy = {2,1,-1,-2,-2,-1,1,2};

        // 입력
        for(int i=0;i<H;i++){
            st = new StringTokenizer(br.readLine());
            for(int j=0;j<W;j++){
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        Queue<Monkey> q = new ArrayDeque();
        q.add(new Monkey(0,0,0,K));
        for(int i= K-1;i>=0;i--){
            visitedMove[0][0][i] = 1;
        }

        int ans = -1;

        while(!q.isEmpty()){
            Monkey m = q.poll();

            if(m.x == H-1 && m.y == W-1){
                ans = m.move;
                break;
            }

            // 상하좌우 이동.
            for(int d=0;d<4;d++){
                int nx = m.x+dx[d];
                int ny = m.y+dy[d];

                if(nx<0||nx>=H||ny<0||ny>=W) continue;
                if(map[nx][ny] == 1) continue;
                if(visitedMove[nx][ny][m.horse] == 1) continue;

                for(int i= m.horse;i>=0;i--){
                    visitedMove[nx][ny][i] = 1;
                }
                q.add(new Monkey(nx,ny,m.move+1,m.horse));
            }

            if(m.horse>0){
                for(int d=0;d<8;d++){
                    int nx = m.x+hx[d];
                    int ny = m.y+hy[d];

                    if(nx<0||nx>=H||ny<0||ny>=W) continue;
                    if(map[nx][ny] == 1) continue;
                    if(visitedMove[nx][ny][m.horse] == 1) continue;

                    for(int i= m.horse-1;i>=0;i--){
                        visitedMove[nx][ny][i] = 1;
                    }
                    q.add(new Monkey(nx,ny,m.move+1,m.horse-1));
                }
            }
        }

        System.out.println(ans);
    }
}
