import java.io.*;
import java.util.*;
// 다음 소수

// FOR문 종료 조건 확인
// 0,1 일 때 확인
public class Bj4134 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int T = Integer.parseInt(st.nextToken());

        for(int t=1;t<=T;t++){
            long N = Long.parseLong(br.readLine());
            if(N==1||N==0){
                System.out.println("2");
                continue;
            }
            for(long i=N;;i++){
                boolean prime = true;
                for(long j=2;j<=Math.sqrt(i);j++){
                    if(i%j == 0){
                        prime = false;
                        break;
                    }
                }
                if(prime == true){
                    System.out.println(i);
                    break;
                }
            }
        }

    }
}
