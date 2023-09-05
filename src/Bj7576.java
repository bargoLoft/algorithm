import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;
// 토마토
// 못생긴
//
public class Bj7576 {
    static class Tomato{
        int x;
        int y;

        int day;

        public Tomato(int x, int y,  int day) {
            this.x = x;
            this.y = y;
            this.day = day;
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int M = Integer.parseInt(st.nextToken());
        int N = Integer.parseInt(st.nextToken());

        int[][] box = new int [N][M];
        int[] dx = {0,1,0,-1};
        int[] dy = {1,0,-1,0};

        Queue<Tomato> q = new ArrayDeque();

        int greenTomato = 0;

            for(int i=0;i<N;i++){
                st = new StringTokenizer(br.readLine());
                for(int j=0;j<M;j++){
                    box[i][j] = Integer.parseInt(st.nextToken());
                    if(box[i][j] == 0) greenTomato = 1;
                    if(box[i][j] == 1) q.add(new Tomato(i,j,0));
                }
            }

        if(greenTomato == 0) System.out.println(0);
        else {
            while(!q.isEmpty()){
                Tomato now = q.poll();

                for(int d=0;d<4;d++){
                    int nx= now.x + dx[d];
                    int ny= now.y + dy[d];

                    if(nx<0||nx>=N||ny<0||ny>=M) continue;
                    if(box[nx][ny] == 0){
                        box[nx][ny] = now.day+1;
                        q.add(new Tomato(nx,ny,now.day+1));
                    }
                }
            }

            int ans = 0;

            loop : for(int i=0;i<N;i++){
                    for(int j=0;j<M;j++){
                        if(box[i][j] == 0){
                            ans = -1;
                            break loop;
                        }
                        if(box[i][j] > ans) ans = box[i][j];
                    }
            }
            System.out.println(ans);
        }
    }
}
