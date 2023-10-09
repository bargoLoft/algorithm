import java.io.*;
import java.util.*;

// 정수 삼각형
// 왼쪽 or 오른쪽 이지선다.
// N-1 까지인지 N 까지인지 떠올리자.
public class Bj1932{
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int[][] tri = new int[501][501];
        int[][] triSum = new int[501][501];



        // 입력
        for(int i=0;i<N;i++){
            st = new StringTokenizer(br.readLine());
            for(int j=0;j<=i;j++){
                tri[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        triSum[0][0] = tri[0][0];

        for(int i=1;i<N;i++){
            for(int j=0;j<=i;j++){
                if(j==0){
                    triSum[i][j] = triSum[i-1][j];
                } else if(j==i){
                    triSum[i][j] = triSum[i-1][j-1];
                } else{
                    triSum[i][j] = Math.max(triSum[i-1][j-1],triSum[i-1][j]);
                }
                triSum[i][j] += tri[i][j];
            }
        }

        int max = 0;

        for(int i=0;i<N;i++){
            max = Math.max(max,triSum[N-1][i]);
        }

        System.out.println(max);
    }
}