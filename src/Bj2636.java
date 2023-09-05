import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class Bj2636 {
    static class Cheese{
        int x;
        int y;
        int time;

        public Cheese(int x, int y, int time) {
            this.x = x;
            this.y = y;
            this.time = time;
        }

    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int[][] map = new int[N][M];
        int[] dx = {0,1,0,-1};
        int[] dy = {1,0,-1,0};

        for(int i=0;i<N;i++){
            st = new StringTokenizer(br.readLine());
            for(int j=0;j<M;j++){
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        for(int t=0;;t++){
            Queue<Cheese> q = new ArrayDeque();
            q.add(new Cheese(0,0,0));
            while(q.isEmpty()){
                Cheese n = q.poll();

                for(int d=0;d<4;d++){
                    int nx = n.x+dx[d];
                    int ny = n.y+dy[d];

                    if(nx<0||nx>=N||ny<0||ny>=M) continue;

                    if(map[nx][ny] < n.time) continue;
                    if(map[nx][ny] == 1){
                        map[nx][ny] = n.time - 1;
                    }
                    q.add(new Cheese(nx,ny,n.time-1));
                }
            }
        }
    }
}
