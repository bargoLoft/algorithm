import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Bj2164 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());

        if(N%2 == 0){
            int bit = 1;
            while(bit<=N){
                bit = bit<<1;
            }

            System.out.println(bit>>1);
        } else if (N == 1) {
            System.out.println(1);
        } else {
                int bit = 1;
                while(bit<=N){
                    bit = bit<<1;
                }
                bit = bit>>1;
                System.out.println((N-bit)*2);
        }



    }
}
