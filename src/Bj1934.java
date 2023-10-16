import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Bj1934 {
    static long GCD(long A,long B){
        if(A==B) return A;
        if(B % Math.abs(A-B)==0) return Math.abs(A-B);
        else return GCD(B,Math.abs(A-B));
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();

        long A = Long.parseLong(st.nextToken());
        long B = Long.parseLong(st.nextToken());

        st = new StringTokenizer(br.readLine());
        long C = Long.parseLong(st.nextToken());
        long D = Long.parseLong(st.nextToken());

        long son = A*D + B*C;
        long mom = B    *D;
        long gcd = GCD(son,mom);
        son/=gcd;
        mom/=gcd;
        sb.append(son+" "+mom);

        System.out.println(sb);
    }
}
