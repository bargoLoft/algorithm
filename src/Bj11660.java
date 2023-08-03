import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Bj11660 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        int[][] arr = new int[N][N];
        int[][] arrSum = new int[N][N];
        int[][] arrSumSum = new int[N][N];

        //arr, sum 배열 생성
        for(int i=0;i<N;i++){
            st = new StringTokenizer(br.readLine());
            for(int j=0;j<N;j++){
                arr[i][j] = Integer.parseInt(st.nextToken());
                if(j==0){
                    arrSum[i][j] = arr[i][j];
                } else{
                    arrSum[i][j] = arrSum[i][j-1] + arr[i][j];
                }
            }
        }

        //sumsum 배열 생성.
        for(int j=0;j<N;j++){
            for(int i=0;i<N;i++){
                if(i==0){
                    arrSumSum[i][j] = arrSum[i][j];
                } else{
                    arrSumSum[i][j] = arrSumSum[i-1][j] + arrSum[i][j];
                }
            }
        }

        for(int i=0;i<M;i++){
            st = new StringTokenizer(br.readLine());
            int x1 = Integer.parseInt(st.nextToken());
            int y1 = Integer.parseInt(st.nextToken());
            int x2 = Integer.parseInt(st.nextToken());
            int y2 = Integer.parseInt(st.nextToken());

            int sum = 0;

            sum += arrSumSum[x2-1][y2-1];
            if(x1-2>=0) sum-=arrSumSum[x1-2][y2-1];
            if(y1-2>=0) sum-=arrSumSum[x2-1][y1-2];
            if(x1-2>=0&&y1-2>=0)sum+=arrSumSum[x1-2][y1-2];
            System.out.println(sum);
        }
    }
}
