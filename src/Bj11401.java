import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
// 이항계수
// 페르마의 소정리.......

public class Bj11401 {
    static long p;
    static long fact(int n) {
        long ans = 1;
        for (int i = 2; i <= n; i++) {
            ans *= i;
            ans %= p;
        }
        return ans;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

            int N = Integer.parseInt(st.nextToken());
            int R = Integer.parseInt(st.nextToken());

            p = (int)1e9+7;
            long e = p-2;

            long A = (fact(N-R)*fact(R)) % p;
            long a = 1;

            while(e>0){
                if(e%2==1) a = (a*A) % p;
                A = (A*A)%p;
                e/=2;
            }

            long ans = (fact(N) * a) % p;

            System.out.println(ans);
    }
}
