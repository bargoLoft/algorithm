import java.io.*;
import java.util.*;

public class Bj2447 {
//    static void printBlank(int N){
//        for(int i=0;i<)
//    }
    static void star(int N){
        for(int i=0;i<3;i++){
            for(int j=0;j<3;j++){
                if(N==3){
                    if(i==1 && j==1) System.out.print(" ");
                    else System.out.print("*");
                } else star(N/3);
            }
        }
        if(N==3) System.out.println();
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(st.nextToken());

        star(N);

    }
}
