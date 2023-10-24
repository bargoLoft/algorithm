import java.io.*;
import java.util.*;

public class Bj1037 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();

        int cnt = Integer.parseInt(st.nextToken());
        ArrayList<Integer> al = new ArrayList();

        st = new StringTokenizer(br.readLine());

        for(int i=0;i<cnt;i++){
            al.add(Integer.valueOf(st.nextToken()));
        }

        Collections.sort(al);

        if(al.size()%2==1) System.out.println((int)Math.pow(al.get(al.size()/2),2));
        else System.out.println(al.get(0) * al.get(al.size()-1));

    }
}
