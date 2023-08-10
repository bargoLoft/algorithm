import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Swea6808 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int T = Integer.parseInt(st.nextToken());

        for(int t = 1;t<=T;t++){

            int[] card = new int[9];

            st = new StringTokenizer(br.readLine());
            // 규영이의 카드.
            for(int i=0;i<9;i++){
                card[i] = Integer.parseInt(st.nextToken());
            }
        }
    }
}
