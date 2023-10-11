import java.io.*;
import java.util.*;

public class Bj22857 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        int[] dp = new int[N];

        st = new StringTokenizer(br.readLine());
        for(int i=0;i<N;i++){
            dp[i] = Integer.parseInt(st.nextToken());
        }

        int str = 0;
        int end = 1;
        int cnt = 0;
        while(true){

        }


    }
}
