import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Queue;
import java.util.StringTokenizer;

public class Bj12852 {
    static int N;
    //    static int res = Integer.MAX_VALUE;
    static int[] dp;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
//
        N = Integer.parseInt(st.nextToken());
//
//
//        dp = new int[N+1];10
//        Arrays.fill(dp,-1);
//        res = find1(N);
//
//        System.out.println(res);

        // 시간초과.

        dp = new int[N+1];
        dp[1] = 0;

        for(int i=2;i<=N;i++){
            dp[i] = dp[i-1] + 1;
            if(i%2 == 0){
                dp[i] = Math.min(dp[i],dp[i/2]+1);
            }
            if(i%3 == 0){
                dp[i] = Math.min(dp[i],dp[i/3]+1);
            }
        }

        //System.out.println(Arrays.toString(dp));

        int ans = dp[N];
        System.out.println(ans);

        for(int i=0;i<=ans;i++){
            System.out.print(N + " ");
            if(N%3==0 && dp[N/3] == dp[N]-1)
                N /=3;
            else if(N%2==0 && dp[N/2] == dp[N]-1)
                N /=2;
            else
                N -=1;
        }


//        memo = new int[1000001];
//        Arrays.fill(memo,0);
//
////        find1(1,0);
//
//        Queue<Integer> q = new ArrayDeque();
//        Queue<Integer> tmp = new ArrayDeque();
//
//        q.add(1);
//        loop : for(int i=0;i<10000001;i++){
//            while(!q.isEmpty()) {
//                int now = q.poll();
//
//                if (now == N) {
//                    System.out.println(i);
//                    break loop;
//                }
//                if (now >1000000) continue;
//                if (memo[now] == 1) continue;
//
//                memo[now] = 1;
//                tmp.add(now + 1);
//                tmp.add(now * 2);
//                tmp.add(now * 3);
//            }
//
//            while(!tmp.isEmpty()){
//                q.add(tmp.poll());
//            }
//        }
    }
}
