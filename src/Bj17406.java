import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// 배열돌리기 4
public class Bj17406 {

    static boolean np(int[] p){
        int N = p.length;
        int i = N-1;
        // 맨 뒤부터 꼭대기 찾기
        while(i>0 && p[i-1]>=p[i]) --i;

        if(i==0) return false; // 다음 순열이 없음. 가장 큰 순열

        //꼭대기 직전 위치에서 교환할 한 단계 큰 수 뒤쪽에서 부터 찾기
        int j = N-1;
        while(p[i-1]>= p[j]) --j;

        // 꼭대기 직전 수와 한 단계 큰 수 교환
        swap(p,i-1,j);

        // 꼭대기 부터 맨 뒤까지 교환.
        int k = N-1;
        while(i<k){
            swap(p,i++,k--);
        }
        return true;
    }

    static void swap(int[] p, int a, int b){
        int tmp = p[a];
        p[a] = p[b];
        p[b] = tmp;
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        int[][] A = new int[N][M]; // 배열 A
        int[][] R = new int[K][3]; // 배열 R  회전정보 저장.
        int[] RP = new int[K]; // 배열 RP, 회전 순서 결정.
        // 하 우 상 좌 순서 이동.
        int[] dx = {1, 0, -1, 0};
        int[] dy = {0, 1, 0, -1};

        int min = 5000; // 한 줄의 이론상 최대값

        // A 입력
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                A[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        // R 입력
        for (int i = 0; i < K; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < 3; j++) {
                R[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        // 초기 RP 입력
        for (int i = 0; i < K; i++) {
            RP[i] = i;
        }

        // 회전.
        do {
            // int[][] copyA = A; 이러면 안 됨.

            // copyA에 A를 복사.
            int[][] copyA = new int[N][M];
            for(int i=0;i<N;i++){
                for(int j=0;j<M;j++){
                    copyA[i][j] = A[i][j];
                }
            }

            for (int i = 0; i < K; i++) {
                // 현재 x,y 값
                int cX = R[RP[i]][0] - 1;
                int cY = R[RP[i]][1] - 1;

                // 회전 크기 만큼 회전.
                for (int j = 0; j < R[RP[i]][2]; j++) {
                    // 좌상단 블럭으로 이동
                    cX--;
                    cY--;
                    int tmp = copyA[cX][cY]; // 처음 블록 저장해두기.

                    // 하 우 상 좌 순서대로 이동.
                    for (int l = 0; l < 4; l++) {
                        // 회전 크기의 2배 만큼 이동
                        for (int k = 0; k < (2 * (j + 1)); k++) {
                            copyA[cX][cY] = copyA[cX + dx[l]][cY + dy[l]];
                            cX += dx[l];
                            cY += dy[l];
                        }
                    }
                    copyA[cX][cY + 1] = tmp; // 기억해 둔 처음 블록 값을 오른쪽 블록에 삽입.
                }

            }
            // 최소값 찾기
            for(int i=0;i<N;i++){
                int sum = 0;
                for(int j=0;j<M;j++){
                    sum+=copyA[i][j];
                }
                if(sum<min)
                    min = sum;
            }
        } while (np(RP)); // Next Permutation 으로 돌릴 순서 바꿔주기.

        System.out.println(min); // 최소값 출력
    }
}
