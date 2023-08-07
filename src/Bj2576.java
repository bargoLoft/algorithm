import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
//홀수
public class Bj2576 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int[] num = new int[7];

        for(int i=0;i<7;i++){
            st = new StringTokenizer(br.readLine());
            num[i] = Integer.parseInt(st.nextToken());
        }

        int min = 100;
        int sum = 0;

        for(int i=0;i<7;i++){
            if(num[i]%2==1){
                sum+=num[i];
                if(num[i]<min){
                    min = num[i];
                }
            }
        }

        if(min == 100){
            System.out.println("-1");
        } else{

            System.out.println(sum);
            System.out.println(min);

        }
    }
}
