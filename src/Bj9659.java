import java.io.*;
import java.util.*;

public class Bj9659 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        long N = Long.parseLong(st.nextToken());

        //수학적 풀이
        if(N%2==1) System.out.println("SK");
        else System.out.println("CY");
    }
}
