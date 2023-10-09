import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

// 수영대회 결승전
// bfs
// 소용돌이는 존버.
public class Swea4193 {
    static class Samsung{
        int x;
        int y;
        int time;

        public Samsung(int x, int y, int time) {
            this.x = x;
            this.y = y;
            this.time = time;
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int T = Integer.parseInt(st.nextToken());

        for(int t = 1;t<=T;t++){
            int N = Integer.parseInt(br.readLine());
            int[][] map = new int[N][N];
            int[][] visited = new int[N][N];

            int[] str = new int[2];
            int[] end = new int[2];
            int[] dx = {0,1,0,-1};
            int[] dy = {1,0,-1,0};

            // 입력
            for(int i=0;i<N;i++){
                st = new StringTokenizer(br.readLine());
                for(int j=0;j<N;j++){
                    map[i][j] = Integer.parseInt(st.nextToken());
                }
            }

            st = new StringTokenizer(br.readLine());
            str[0] = Integer.parseInt(st.nextToken());
            str[1] = Integer.parseInt(st.nextToken());
            st = new StringTokenizer(br.readLine());
            end[0] = Integer.parseInt(st.nextToken());
            end[1] = Integer.parseInt(st.nextToken());

            Queue<Samsung> q = new ArrayDeque();
            q.add(new Samsung(str[0], str[1], 0));
            visited[str[0]][str[1]] = 1;

            int clear = 0;

            while(!q.isEmpty()){
                Samsung s = q.poll();

                if(s.x == end[0] && s.y == end[1]){
                    System.out.printf("#%d %d\n",t,s.time);
                    clear = 1;
                    break;
                }

                for(int d=0;d<4;d++){
                    int nx = s.x + dx[d];
                    int ny = s.y + dy[d];

                    if(nx<0||nx>=N||ny<0||ny>=N) continue;
                    if(map[nx][ny] == 1) continue;
                    if(visited[nx][ny] == 1) continue;

                    if(map[nx][ny] == 2){
                        if(s.time % 3 == 2){
                            visited[nx][ny] = 1;
                            q.add(new Samsung(nx,ny,s.time+1));
                        } else{
                            q.add(new Samsung(s.x,s.y,s.time+1));
                        }
                    }
                    if(map[nx][ny] == 0){
                        q.add(new Samsung(nx,ny,s.time+1));
                        visited[nx][ny] = 1;
                    }
                }
            }

            if(clear ==0) System.out.printf("#%d %d",t,-1);
        }
    }
}
