import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.invoke.MutableCallSite;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;
// 미생물 격리
// 큐에 넣고, 맵에 표시 후 다시 큐에 넣는다.
public class Swea2382 {
    static class Micro{
        int x;
        int y;
        int size;
        int d;

        public Micro(int x, int y, int size, int d) {
            this.x = x;
            this.y = y;
            this.size = size;
            this.d = d;
        }
    }

    static int[] dx = {0,-1,1,0,0};
    static int[] dy = {0,0,0,-1,1};
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int T = Integer.parseInt(st.nextToken());

        for(int tc = 1;tc<=T;tc++){
            st = new StringTokenizer(br.readLine());

            int N = Integer.parseInt(st.nextToken()); // 한 변의 길이
            int M = Integer.parseInt(st.nextToken()); // 격리 시간
            int K = Integer.parseInt(st.nextToken()); // 군집의 수

            Queue<Micro> q = new ArrayDeque();

            // 군집 입력
            for(int i=0;i<K;i++){
                st = new StringTokenizer(br.readLine());
                int x = Integer.parseInt(st.nextToken());
                int y = Integer.parseInt(st.nextToken());
                int size = Integer.parseInt(st.nextToken());
                int d = Integer.parseInt(st.nextToken());
                q.add(new Micro(x,y,size,d));
            }

            for(int t=1;t<=M;t++){
                int[][][] map = new int[N][N][3];
                while(!q.isEmpty()){
                    Micro m = q.poll();
                    int nx = m.x+dx[m.d];
                    int ny = m.y+dy[m.d];

                    if(nx%(N-1) == 0 || ny%(N-1) ==0){ // 가장자리이면.
                        //if(m.size / 2 == 0) continue;
                        if(m.d%2 == 1) m.d+=1;
                        else m.d-=1;

                        map[nx][ny][0] = m.size / 2;
                        map[nx][ny][1] += m.size / 2;
                        map[nx][ny][2] = m.d;
                    } else{
                        if(m.size > map[nx][ny][0]){
                            map[nx][ny][0] = m.size;
                            map[nx][ny][2] = m.d;
                        }
                        map[nx][ny][1] += m.size; // 합
                    }
                }
                // 맵의 값 -> 큐 추가
                for(int i=0;i<N;i++){
                    for(int j=0;j<N;j++){
                        if(map[i][j][2] != 0){
                            q.add(new Micro(i,j,map[i][j][1],map[i][j][2]));
                        }
                    }
                }
            }


            int cnt =0;
            while(!q.isEmpty()){
                Micro m = q.poll();
                cnt+= m.size;
            }
            System.out.println("#"+tc+" " + cnt);
        }
    }
}
