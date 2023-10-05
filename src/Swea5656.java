import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class Swea5656 {
    static int N;
    static int W;
    static int H;
    static int[][] map;
    static int[] arr;
    static int[] dx = {0,1,0,-1};
    static int[] dy = {1,0,-1,0};
    static int min;
    static class Block{
        int x;
        int y;

        public Block(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    static void dfs(int dep){
        if(dep == N){
            // 복제 맵.
            int[][] m = new int[H][W];
            for(int i=0;i<H;i++){
                for(int j=0;j<W;j++){
                    m[i][j] = map[i][j];
                }
            }

            // 벽돌 N번 떨어 뜨리기.
            for(int blk=0;blk<N;blk++){
                int target = arr[blk];
                if(m[H-1][target] == 0) continue; // 맨 아래 벽돌이 비면 -> 빈 칸 -> 패스
                // 타켓 줄의 가장 위 벽돌 찾기
                int top = 0;
                while(m[top][target]==0 && top < H-1) top++;
                Queue<Block> q = new ArrayDeque<>();

                q.add(new Block(top,target));
                while(!q.isEmpty()){
                    while(!q.isEmpty()){
                        Block b = q.poll();

                        for(int i=1;i<=m[b.x][b.y]-1;i++){
                            for(int d=0;d<4;d++){
                                int nx = b.x + dx[d]*i;
                                int ny = b.y + dy[d]*i;
                                if(nx<0||nx>=H||ny<0||ny>=W) continue;
                                if(m[nx][ny] == 0) continue;
                                if(m[nx][ny] == 1){
                                    m[nx][ny] = 0;
                                    continue;
                                }
                                q.add(new Block(nx,ny));
                            }
                        }
                        m[b.x][b.y] = 0;
                    }
                }

                // 벽돌 빈 공간 내리기.
                for(int i=H-1;i>=0;i--){
                    for(int j=0;j<W;j++){
                        int height = i;
                        if(i<H-1 && m[i+1][j] == 0){
                            while(height<H-1 && m[height+1][j]==0) height++;
                            m[height][j] = m[i][j];
                            m[i][j] = 0;
                        }
                    }
                }
            }

            // 최소값 인지 판단.
            int cnt =0;
            for(int i=0;i<H;i++){
                for(int j=0;j<W;j++){
                    if(m[i][j] > 0) cnt++;
                }
            }
            if(cnt < min) min = cnt;
            return;
        }

        // dfs
        for(int i=0;i<W;i++){
            arr[dep] = i;
            dfs(dep+1);
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int T = Integer.parseInt(st.nextToken());

        for(int t = 1;t<=T;t++){
            st = new StringTokenizer(br.readLine());
            N = Integer.parseInt(st.nextToken());
            W = Integer.parseInt(st.nextToken());
            H = Integer.parseInt(st.nextToken());
            map = new int[H][W];
            arr = new int[N];
            min = Integer.MAX_VALUE;

            for(int i=0;i<H;i++){
                st = new StringTokenizer(br.readLine());
                for(int j=0;j<W;j++){
                    map[i][j] = Integer.parseInt(st.nextToken());
                }
            }

            dfs(0);
            System.out.printf("#%d %d\n",t,min);
        }
    }
}
