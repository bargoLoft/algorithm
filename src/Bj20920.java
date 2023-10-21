import java.io.*;
import java.util.*;

// 영단어 암기는 괴로워.

// keySet 람다식으로 정렬.
public class Bj20920 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        Map<String,Integer> map = new HashMap<>();

        for(int i=0;i<N;i++){
            String s = br.readLine();
            if(s.length()<M) continue;
            int cnt = map.getOrDefault(s,0);
            map.put(s,cnt+1);
        }

        List<String> keySet = new ArrayList(map.keySet());

        keySet.sort((o1, o2) -> {
            if(map.get(o1) > map.get(o2)) return -1;
            else if(map.get(o1) == map.get(o2)){
                if(o1.length() > o2.length()) return -1;
                else if (o1.length() == o2.length()){
                    return o1.compareTo(o2);
                }
            }
            return 1;
        });

        for(String key:keySet){
            sb.append(key+"\n");
        }

        System.out.println(sb);
    }
}
