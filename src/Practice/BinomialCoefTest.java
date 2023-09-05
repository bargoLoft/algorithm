package Practice;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BinomialCoefTest {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        int[][] B = new int[N+1][K+1];

        for(int i=0;i<=N;i++){
            for(int j=0,end = Math.min(i,K);j<=end;j++){
                if(j==0 || i==j) B[i][j] = 1;
                else B[i][j] = B[i-1][j-1] + B[i-1][j];
            }
        }

        System.out.println(B[N][K]);
    }
}
