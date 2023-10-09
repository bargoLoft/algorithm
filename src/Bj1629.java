import java.io.*;
import java.util.*;

public class Bj1629 {
    static int ABC(int A, int B, int C){
        if(B==1){
            return A%C;
        }
        if(B%2==0){
            return (ABC(A,B/2,C) * ABC(A,B/2,C))%C;
        } else{
            return (ABC(A,B/2,C) * ABC(A,B/2,C) * (A%C))%C;
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int A = Integer.parseInt(st.nextToken());
        int B = Integer.parseInt(st.nextToken());
        int C = Integer.parseInt(st.nextToken());

        System.out.println(ABC(A,B,C));

    }
}
