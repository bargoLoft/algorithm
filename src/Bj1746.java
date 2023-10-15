import java.io.*;
import java.util.*;
// 듣보잡

// 맵, 셋..
public class Bj1746 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        TreeMap<String, Integer> tm = new TreeMap();
        TreeMap<String, Integer> ans = new TreeMap();

        for(int i=0;i<N;i++){
            String s = br.readLine();
            tm.put(s,1);
        }

        for(int i=0;i<M;i++){
            String s = br.readLine();
            if(tm.containsKey(s)) ans.put(s,1);
        }

        System.out.println(ans.size());
        Set<String> set = ans.keySet();
        for(String s:set){
            sb.append(s+"\n");
        }

        System.out.println(sb);
    }
}
