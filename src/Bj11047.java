import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
// 동전0
public class Bj11047 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        int[] coins = new int[N]; // 동전 단위 배열
        int coin = 0; // 모은 동전 개수


        for(int i=0;i<N;i++){
            st = new StringTokenizer(br.readLine());
            coins[i] = Integer.parseInt(st.nextToken());
        }

        for(int i=N-1;i>=0;i--){
            // 동전을 뺄 수 있으면 빼고 개수 더하기
            if(coins[i]<=K){
                coin += K/coins[i];
                K%=coins[i];
            }
            // 남은 돈 없으면 종료.
            if(K==0)
                break;
        }

        System.out.println(coin);
    }
}
