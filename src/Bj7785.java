import java.io.*;
import java.util.*;
// 회사에 있는 사람

// 트리맵, 역순 -> Collections.reverseOrder()
public class Bj7785 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(st.nextToken());

        TreeSet<String> treeSet = new TreeSet<>(Collections.reverseOrder());

        for(int i=0;i<N;i++){
            st = new StringTokenizer(br.readLine());
            String s = st.nextToken();
            String record = st.nextToken();
            if(record.compareTo("enter") == 0) treeSet.add(s);
            else if(record.compareTo("leave") == 0) treeSet.remove(s);
        }

        for(String s:treeSet){
            sb.append(s+"\n");
        }

        System.out.println(sb);
    }
}
