import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
// 1233. [S/W 문제해결 기본] 9일차 - 사칙연산 유효성 검사
public class Swea1233 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = null;

        for(int t=1;t<=10;t++){
            st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());
            int isOK = 1;


            for(int i=0;i<n;i++){
                st = new StringTokenizer(br.readLine());
                int node = Integer.parseInt(st.nextToken());
                String alpha = st.nextToken();
                if(node<=n/2){
                    if(alpha.equals("+")||alpha.equals("-")||alpha.equals("/")||alpha.equals("*")){

                    } else{
                        isOK = 0;

                    }
                } else{
                    if(alpha.equals("+")||alpha.equals("-")||alpha.equals("/")||alpha.equals("*")){
                        isOK = 0;

                    } else{

                    }
                }
            }

            System.out.printf("#%d %d\n",t,isOK);
        }

    }
}
