import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
// 새
public class Bj1568 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());


        int N = Integer.parseInt(st.nextToken());

        int sing = 1;
        int time = 0;
        while(N!=0){
            if (N < sing) {
                sing = 1;
            }
            N-=sing++;
            time++;
        }

        System.out.println(time);
    }
}
