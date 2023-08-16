import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
// n-queen
public class Bj9663 {
    static int N;
    static int cnt;
    static int[] isUsed;
    static int[] plus;
    static int[] minus;
    static int[] queen;
    static StringBuilder sb = new StringBuilder();

    private static void nQueen(int dep) {
        if(dep==N){
            cnt++;
            for(int n: queen){
                sb.append(n+" ");
            }
            sb.append("\n");
            return;
        }
        //dep -> i, i-> j
        for(int i=0;i<N;i++){
            if(isUsed[i]==1 || plus[dep+i]==1||minus[dep-i+(N-1)]==1)
                continue;
            queen[dep] = i;
            isUsed[i] = 1;
            plus[dep+i] = 1;
            minus[dep-i+(N-1)] = 1;
            nQueen(dep+1);
            isUsed[i] = 0;
            plus[dep+i] = 0;
            minus[dep-i+(N-1)] = 0;
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        cnt = 0;
        queen = new int[N];
        isUsed = new int[N];
        plus = new int[2*N-1];
        minus = new int[2*N-1];

        nQueen(0);
        System.out.println(sb);
        System.out.println(cnt);
    }

}
