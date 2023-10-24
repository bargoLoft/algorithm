import java.io.*;
import java.util.*;
// 붙임성 좋은 총총이

// Set
public class Bj26069 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(st.nextToken());

        Set dance = new HashSet();

        dance.add("ChongChong");

        for(int i=0;i<N;i++){
            st = new StringTokenizer(br.readLine());
            String a = st.nextToken();
            String b = st.nextToken();

            if(dance.contains(a)) dance.add(b);
            if(dance.contains(b)) dance.add(a);
        }

        System.out.println(dance.size());


    }
}
