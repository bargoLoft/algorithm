import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;
// 외판원 순회2
public class Bj10971 {
    static int N;
    static int[][] map;
    static int[] isVisited;
    static int min;

    static void salesman(int dep,int start,int city,int cost){
        if(dep == N-1){
            // 모든 도시를 방문 했을 때 출발지로 갈 도로가 없으면 종료.
            if(map[city][start] == 0) return;

            // 출발지로 가는 비용 합해서 최소면 갱신.
            cost += map[city][start];
            if(cost < min) min = cost;
            return;
        }

        //dfs
        for(int i=0;i<N;i++){
            if(isVisited[i]==0 && map[city][i] != 0){
                isVisited[i] = 1;
                salesman(dep+1,start,i,cost+map[city][i]);
                isVisited[i] = 0;
            }
        }

    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        map = new int[N][N];
        isVisited = new int[N];
        min = Integer.MAX_VALUE;

        // 입력.
        for(int i=0;i<N;i++){
            st = new StringTokenizer(br.readLine());
            for(int j=0;j<N;j++){
                map[i][j]= Integer.parseInt(st.nextToken());
            }
        }

        // 출발지를 모두 체크. dfs.
        for(int i=0;i<N;i++){
            Arrays.fill(isVisited,0);
            isVisited[i] = 1;
            salesman(0,i,i,0);
        }

        System.out.println(min);
    }
}
