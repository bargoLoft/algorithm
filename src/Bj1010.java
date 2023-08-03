import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// 다리 놓기
// DP 배우고 풀기
// mCn 사실상.
public class Bj1010 {
//    static int N;
//    static int M;
//    static int cnt;
//    static int[] select;
//    static int[] isUsed;
//    static void Bridge(int idx){
//        if(idx==N){
//            cnt++;
//            return;
//        }
//
//        for(int i=0;i<M;i++){
//            if(isUsed[i]==1)
//                continue;
//            select[idx] = i;
//            if(idx!=0&&select[idx-1]>=select[idx])
//                continue;
//            isUsed[i] = 1;
//            Bridge(idx+1);
//            isUsed[i] = 0;
//        }
//    }
//
//    public static void main(String[] args) throws IOException {
//        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        StringTokenizer st = new StringTokenizer(br.readLine());
//
//        int T = Integer.parseInt(st.nextToken());
//
//        for(int i=0;i<T;i++){
//            st = new StringTokenizer(br.readLine());
//             N = Integer.parseInt(st.nextToken());
//             M = Integer.parseInt(st.nextToken());
//             select = new int[N];
//             isUsed = new int[M];
//             cnt = 0;
//
//            Bridge(0);
//            System.out.println(cnt);
//        }
//    }

        public static void main(String[] args) throws IOException {
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            StringTokenizer st = new StringTokenizer(br.readLine());

            int T = Integer.parseInt(st.nextToken());

            for(int t=0;t<T;t++){
                st = new StringTokenizer(br.readLine());

                int N = Integer.parseInt(st.nextToken());
                int M = Integer.parseInt(st.nextToken());

                long ans = 1;

                if(M<N*2){
                    N = M-N;
                }

                for(int i = M;i>M-N;i--){
                    ans*=i;
                }
                for(int i= 1;i<=N;i++){
                    ans/=i;
                }
                System.out.println(ans);
            }

        }
}
