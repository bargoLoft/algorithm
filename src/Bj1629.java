import java.io.*;
import java.util.*;
// 곱셈
// log2 를 활용 하자.
public class Bj1629 {

    static long[] pow;

    static long ABC(long A, int B, long C){
        if(B==0) return 1;

        int b = 1;
        int cnt = 0;

        while(b <= B/2){
            b = b<<1;
            cnt++;
        }

        return (pow[cnt] * ABC(A,B-b,C))  % C ;

    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        long A = Integer.parseInt(st.nextToken());
        int B = Integer.parseInt(st.nextToken());
        long C = Integer.parseInt(st.nextToken());

        // 2의 배수 나머지 구해 두기.
        pow = new long[40];
        pow[0] = A % C;
        for(int i=1;i<32;i++){
            pow[i] = (pow[i-1] * pow[i-1]) % C;
        }

        System.out.println(ABC(A%C,B,C));
    }
}

// A * A * A * A * A * A
// %C
// B == 2 * b
// A^B = A^b * A^b
// 10 10 10 10 10 10 10 10 10 10 10
// 10*10 10*10 10*10 10*10 10*10 10
// 4 4 4 4 4 10
// 16 16 4 10
// 6 6 4 10
// 36  4 10
// 0 4 10