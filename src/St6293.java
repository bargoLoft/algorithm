import java.io.*;
import java.util.*;
// 징검다리

// dp 기초. 초기 조건. 최대값 조건 신경쓰기.
public class St6293 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        int[] stone = new int[N];
        int[] dp = new int[N];
        int max = -1;


        for(int i=0;i<N;i++){
            stone[i] = Integer.parseInt(st.nextToken());
            dp[i] = 1;
        }

        for(int i=0;i<N;i++){
            for(int j=i+1;j<N;j++){
                if(stone[i] < stone[j] && dp[i]+1 > dp[j]){
                    dp[j] = dp[i]+1;
                }

            }
        }

        for(int i=0;i<N;i++){
            System.out.print(dp[i]+" ");
            if(dp[i] > max) max = dp[i];
        }

        System.out.println(max);



    }
}
