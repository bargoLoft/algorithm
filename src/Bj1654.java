import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
// 랜선 자르기
public class Bj1654 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int K = Integer.parseInt(st.nextToken());
        int N = Integer.parseInt(st.nextToken());
        int[] lan = new int[K];

        for(int i=0;i<K;i++){
            st = new StringTokenizer(br.readLine());
            lan[i] = Integer.parseInt(st.nextToken());
        }


    }
}
