import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Bj17406 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        int[][] A = new int[N][M]; // 배열 A
        int[][] R = new int[K][3]; // 배열 R  회전정보 저장.
        // 우 하 좌 상 순서 이동.
        int[] dx = {0,1,0,-1};
        int[] dy = {1,0,-1,0};
        for(int i=0;i<N;i++){
            st = new StringTokenizer(br.readLine());
            for(int j=0;j<M;j++){
                A[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        for(int i=0;i<K;i++){
            st = new StringTokenizer(br.readLine());
            for(int j=0;j<3;j++){
                R[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        // 회전.
        for(int i=0;i<K;i++){
            int cX = R[i][0]-1;
            int cY = R[i][1]-1;

            // 회전 수 만큼 회전.
            for(int j=0;j<R[i][2];j++){
                cX--;
                cY--;
                int tmp =A[cX+1][cY];

                // 우 하 좌 상 순서대로 이동.
                for(int l=0;l<4;l++){
                    //
                    for(int k=0;k<(2*(j+1));k++){
                        A[cX+dx[l]][cY+dy[l]] = A[cX][cY];
                        cX+=dx[l];
                        cY+=dy[l];
                    }
                }
                A[cX][cY] = tmp;
            }
        }

        for(int i=0;i<N;i++){
            for(int j=0;j<M;j++){
                System.out.printf("%d ",A[i][j]);
            }
            System.out.println();
        }


    }
}
