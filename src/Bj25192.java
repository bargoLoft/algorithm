import javax.print.attribute.HashPrintJobAttributeSet;
import java.io.*;
import java.util.*;

public class Bj25192 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(st.nextToken());

        Set<String> s = new HashSet();
        int cnt = 0;
        for(int i=0;i<N;i++){
            String command = br.readLine();

            if(command.equals("ENTER")){
                s.clear();
            } else {
                if(!s.contains(command)){
                    cnt++;
                    s.add(command);
                }
            }
        }

        System.out.println(cnt);
    }
}
