import java.io.*;
import java.util.*;

// 내려가기
// 최대, 최소 각각 DP로 저장.
// 메모리 절약하려면 prev, current[2][3] 만 만들어서 재활용. 입력 한 줄씩 받으면서
public class Bj2096 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int[][] map = new int[N][3];
        int[][] HighS = new int[N][3];
        int[][] LowS = new int[N][3];

        for(int i=0;i<N;i++){
            st = new StringTokenizer(br.readLine());
            for(int j=0;j<3;j++){
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        for(int i=0;i<3;i++){
            HighS[0][i] = map[0][i];
            LowS[0][i] = map[0][i];
        }

        for(int i=1;i<N;i++){
            for(int j=0;j<3;j++){
                if(j==0){
                    HighS[i][j] = Math.max(HighS[i-1][0],HighS[i-1][1]);
                    HighS[i][j] += map[i][j];
                } else if(j==1){
                    HighS[i][j] = Math.max(HighS[i-1][0],Math.max(HighS[i-1][1],HighS[i-1][2]));
                    HighS[i][j] += map[i][j];
                } else{
                    HighS[i][j] = Math.max(HighS[i-1][1],HighS[i-1][2]);
                    HighS[i][j] += map[i][j];
                }
            }
        }

        for(int i=1;i<N;i++){
            for(int j=0;j<3;j++){
                if(j==0){
                    LowS[i][j] = Math.min(LowS[i-1][0],LowS[i-1][1]);
                    LowS[i][j] += map[i][j];
                } else if(j==1){
                    LowS[i][j] = Math.min(LowS[i-1][0],Math.min(LowS[i-1][1],LowS[i-1][2]));
                    LowS[i][j] += map[i][j];
                } else{
                    LowS[i][j] = Math.min(LowS[i-1][1],LowS[i-1][2]);
                    LowS[i][j] += map[i][j];
                }
            }
        }
        int max = Integer.MIN_VALUE;
        int min = Integer.MAX_VALUE;

        for(int i=0;i<3;i++){
            max = Math.max(max,HighS[N-1][i]);
            min = Math.min(min,LowS[N-1][i]);
        }

        System.out.printf("%d %d",max,min);
    }
}
