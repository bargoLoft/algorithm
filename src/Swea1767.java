import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;
// 프로세서 연결하기.
public class Swea1767 {
    static int N;
    static int[][] map;
    static int totalCnt;
    static int max;
    static int min;
    static ArrayList<int[]> list;
    static int[] dr = {0,1,0,-1};
    static int[] dc = {1,0,-1,0};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int T = Integer.parseInt(st.nextToken());

        for(int t = 1;t<=T;t++){
            N = Integer.parseInt(br.readLine());
            map = new int[N][N];
            totalCnt = 0;
            max = 0;
            min = Integer.MAX_VALUE;
            list = new ArrayList();

            //입력
            for(int i=0;i<N;i++){
                st = new StringTokenizer(br.readLine());
                for(int j=0;j<N;j++){
                    map[i][j] = Integer.parseInt(st.nextToken());
                    if((i==0 || i == N-1 || j==0||j==N-1) && map[i][j] == 1) continue;
                    if(map[i][j] == 1){
                        list.add(new int[] {i,j});
                        totalCnt++;
                    }
                }
            }

            go(0,0);
            System.out.printf("#%d %d\n",t,min);
        }
    }

    private static void go(int index, int coreCnt){
        if(coreCnt + (totalCnt-index) < max) return;

        if(index == totalCnt){
            int res = getLength();
            if(max<coreCnt){
                max = coreCnt;
                min = res;
            } else if(max == coreCnt){
                if(min>res){
                    min = res;
                }
            }
            return;
        }

        int[] cur = list.get(index);
        int r = cur[0];
        int c = cur[1];

        //현재코어 선택
        for(int d =0; d<4;d++){
            // 현재 코어의 위치에서 해당 방향으로 전선 놓기가 가능한 지 체크.
            if(!isAvailable(r,c,d)) continue;

            setStatus(r,c,d,2);
            go(index+1, coreCnt+1);
            setStatus(r,c,d,0);
        }
        //코어 비선택
        go(index+1,coreCnt);
    }

    private static boolean isAvailable(int r, int c, int d) {
        int nr = r;
        int nc = c;

        while(true){
            nr +=dr[d];
            nc +=dc[d];

            if(nr<0||nr>=N||nc<0||nc>=N){
                break;
            }
            if(map[nr][nc] !=0) return false;
        }
        return true;
    }

    private static void setStatus(int r, int c, int d, int status) {
        int nr = r;
        int nc = c;

        while(true){
            nr +=dr[d];
            nc +=dc[d];

            if(nr<0||nr>=N||nc<0||nc>=N){
                break;
            }

            map[nr][nc] = status;
        }
    }

    private static int getLength() {
        int lCnt = 0;
        for(int i=0;i<N;i++){
            for(int j=0;j<N;j++){
                if(map[i][j] == 2){
                    lCnt++;
                }
            }
        }
        return lCnt;
    }
}
