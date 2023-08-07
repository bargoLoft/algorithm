import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
//윷놀이
public class Bj2490 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        for(int i=0;i<3;i++){
            st = new StringTokenizer(br.readLine());
            int sum = 0;
            for(int j=0;j<4;j++){
                sum+= Integer.parseInt(st.nextToken());
            }

            switch (sum){
                case 0:
                    System.out.println("D");
                    break;
                case 1:
                    System.out.println("C");
                    break;
                case 2:
                    System.out.println("B");
                    break;
                case 3:
                    System.out.println("A");
                    break;
                case 4:
                    System.out.println("E");
                    break;

            }
        }

    }

}
