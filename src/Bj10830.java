import java.io.*;
import java.util.*;
// 행렬 곱셈
// 분할 정복
// 단위 행렬..
public class Bj10830 {
    static int N;

    static int[][] multi(int[][] a, int[][] b){
        int c[][] = new int[N][N];
        for(int i=0;i<N;i++){
            for(int j=0;j<N;j++){
                for(int k=0;k<N;k++){
                    c[i][j] += a[i][k] * b[k][j];
                }
            }
        }

        for(int i=0;i<N;i++){
            for(int j=0;j<N;j++){
                c[i][j]%=1000;
            }
        }

        return c;
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        long B = Long.parseLong(st.nextToken());
        int[][] A = new int[N][N];

        for(int i=0;i<N;i++){
            st =new StringTokenizer(br.readLine());
            for(int j=0;j<N;j++){
                A[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int[][] ans = new int[N][N];

        for(int i=0;i<N;i++){
            for(int j=0;j<N;j++){
                if(i==j) ans[i][j] = 1;
            }
        }

        while(B>0){
            if(B%2==1) ans = multi(ans,A);
            A = multi(A,A);
            B/=2;
        }

        for(int i=0;i<N;i++){
            for(int j=0;j<N;j++){
                System.out.printf("%d ",ans[i][j]);
            }
            System.out.println();
        }

    }
}
