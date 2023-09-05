import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;
// 쉬운 최단거리.
public class Bj14940 {
    static class Crd{
        int x;
        int y;
        int dis;

        public Crd(int x, int y, int dis) {
            this.x = x;
            this.y = y;
            this.dis = dis;
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int[][] map = new int[n][m];

        int[] dx = {0,1,0,-1};
        int[] dy = {1,0,-1,0};

        Crd start = new Crd(0,0,0);

        for(int i=0;i<n;i++){
            st = new StringTokenizer(br.readLine());
            for(int j=0;j<m;j++){
                int tmp = Integer.parseInt(st.nextToken());
                if(tmp == 1){
                    map[i][j] = -1;
                } else if (tmp == 2){
                    start = new Crd(i,j,0);
                } else {
                    map[i][j] = tmp;
                }
            }
        }

        Queue<Crd> q = new ArrayDeque<>();

        q.add(start);
        map[start.x][start.y] = 0;

        while(!q.isEmpty()){
            Crd now = q.poll();

            for(int d=0;d<4;d++){
                int nx = now.x + dx[d];
                int ny = now.y + dy[d];

                if(nx<0||nx>=n||ny<0||ny>=m) continue;
                if(map[nx][ny] == -1){
                    map[nx][ny] = now.dis+1;
                    q.add(new Crd(nx,ny,now.dis+1));
                }
            }
        }

        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                System.out.print(map[i][j] + " ");
            }
            System.out.println();
        }

    }
}
