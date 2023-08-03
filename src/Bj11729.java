import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;


public class Bj11729 {
    static StringBuilder s = new StringBuilder();

    // 2의 100승을 출력해야한다.
    // string에 저장.?
    // bigInteger로 출력.

    static int hanoi(long n,int start,int tmp, int end){
        if(n==1){
           s.append(start+" "+end+"\n");
            return 1;
        }

        return hanoi(n-1,start,end,tmp)+hanoi(1,start,tmp,end)+hanoi(n-1,tmp,start,end);
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        BigInteger bi = new BigInteger("1048576"); // 2의 20승

        if(N>20){
            for(int i=0;i<N-20;i++){
                bi =  bi.multiply(new BigInteger("2"));
            }

            String ans = bi.toString();


            System.out.println(ans.substring(0,ans.length()-1) + (Integer.parseInt(ans.substring(ans.length()-1))-1));
        } else {
            int move = hanoi(N,1,2,3);
            System.out.println(move);
            System.out.println(s);
        }
    }
}
