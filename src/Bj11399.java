import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;
//ATM
public class Bj11399 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        Integer[] p = new Integer[N];

        st = new StringTokenizer(br.readLine());
        for(int i=0;i<N;i++){
            p[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(p); // 오름차순
        //Arrays.sort(p, Collections.reverseOrder()); 내림차순, 래퍼클래스 써야함.

        int time = 0;
        int sum = 0;

        for(int t:p){
            time=time+t;
            sum+=time;
        }

        System.out.println(sum);
    }
}
