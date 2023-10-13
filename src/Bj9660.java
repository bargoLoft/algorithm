import java.io.*;
import java.util.*;

public class Bj9660 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        long N = Long.parseLong(st.nextToken());

        //수학적 풀이
        if(N%7==0 || N%7==2) System.out.println("CY");
        else System.out.println("SK");
    }
}
