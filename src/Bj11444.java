import java.io.*;

// 피보나치 수 6
// 행렬의 거듭제곱을 이용한 logN 의 풀이.
// while문 이용 학습

public class Bj11444 {

    static long[][] multiply(long[][] A, long[][] B){
        long[][] C = new long[2][2];

        for(int i=0;i<2;i++){
            for(int j=0;j<2;j++){
                for(int k=0;k<2;k++){
                    C[i][j] += (A[i][k] * B[k][j]) % 1000000007;
                }
            }
        }

        return C;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        long N = Long.parseLong(br.readLine());

        long[][] ans = {
                {1,0},
                {0,1}
        };

        long[][] fibo = {
                {1,1},
                {1,0}
        };

        while(N>0){
            if(N%2==1){
                ans = multiply(ans,fibo);
            }
            fibo = multiply(fibo,fibo);
            N/=2;
        }

        System.out.println(ans[0][1] % 1000000007);
    }
}
