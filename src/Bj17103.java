import java.io.*;
import java.util.*;
// 골드바흐 파티션

// 에라토스테네스의 체
public class Bj17103 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int T = Integer.parseInt(st.nextToken());
        int[] eratos = new int[1000001];

        for(int i=2;i<1000001;i++){
            eratos[i] = 1;
            for(int j=2;j<=Math.sqrt(i);j++) {
                if(i%j==0){
                    eratos[i] = 0;
                    break;
                }
            }
        }

        for(int t=1;t<=T;t++){
            int N = Integer.parseInt((br.readLine()));
            int cnt =0;

            for(int i=2;i<=N/2;i++){
                if(eratos[i]==1 && eratos[N-i]==1)
                    cnt++;
            }
            System.out.println(cnt);
        }
    }
}
