import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

// 연구소 2
// dfs + bfs
// 순열로 하면 시간 초과.
public class Bj17141 {
    static class Virus{
        int x;
        int y;
        int time;

        public Virus(int x, int y, int time) {
            this.x = x;
            this.y = y;
            this.time = time;
        }
    }
    static int[][] map;
    static int[][] isVisited;
    static ArrayList<Virus> virus;
    static Virus[] virusSelect;
    static int N;
    static int M;

    static int[] dx = {0,1,0,-1};
    static int[] dy = {1,0,-1,0};
    static int min;


    static void select(int dep,int lastIndex){
        if(dep==M){
            Queue<Virus> q = new ArrayDeque();
            int[][] copyMap = new int[N][N];
            int[][] visited = new int[N][N];

            for(int i=0;i<N;i++){
                for(int j=0;j<N;j++){
                    copyMap[i][j] = map[i][j];
                }
            }

            //바이러스 추가.
            for(int i=0;i<M;i++){
                copyMap[virusSelect[i].x][virusSelect[i].y] = 2;
                isVisited[virusSelect[i].x][virusSelect[i].y] = 1;
                q.add(virusSelect[i]);
            }
            int maxTime = 0;
            // BFS
            while(!q.isEmpty()){
                Virus v = q.poll();
                maxTime = v.time;

                for(int d=0;d<4;d++){
                    int nx = v.x + dx[d];
                    int ny = v.y + dy[d];

                    if(nx<0||nx>=N||ny<0||ny>=N) continue;
                    if(visited[nx][ny]==1) continue;
                    if(copyMap[nx][ny]==1) continue;
                    if(copyMap[nx][ny] == 0){
                        visited[nx][ny] = 1;
                        q.add(new Virus(nx,ny,v.time+1));
                        copyMap[nx][ny] = v.time+1;
                    }
                }
            }



            for(int i=0;i<N;i++){
                for(int j=0;j<N;j++){
                    if(copyMap[i][j] ==0) return;
                }
            }
//            for(int i=0;i<N;i++){
//                for(int j=0;j<N;j++){
//                    System.out.print(copyMap[i][j]);
//                }
//                System.out.println();
//            }
//            System.out.println();
            if(maxTime < min) min = maxTime;
            //종료 너비우선 탐색으로 0인 공간 리턴.
            return;
        }

        for(int i=0;i<virus.size();i++){
            Virus v = virus.get(i);
            if(isVisited[v.x][v.y] == 1) continue;
            if(dep!=0&&i<lastIndex) continue;
            isVisited[v.x][v.y] = 1;
            virusSelect[dep] = new Virus(v.x,v.y,2);
            select(dep+1,i);
            isVisited[v.x][v.y] = 0;
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        map = new int[N][N];
        isVisited = new int[N][N];

        virusSelect = new Virus[M];
        virus = new ArrayList<Virus>();
        min = 2500;

        for(int i=0;i<N;i++){
            st = new StringTokenizer(br.readLine());
            for(int j=0;j<N;j++){
                map[i][j] = Integer.parseInt(st.nextToken());
                if(map[i][j] == 2){
                    virus.add(new Virus(i,j,2));
                    map[i][j] = 0;
                }
            }
        }

        select(0,0);
        if(min == 2500) System.out.println(-1);
        else {
            System.out.println(min-2);
        }
    }
}
