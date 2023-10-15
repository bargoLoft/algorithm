import java.io.*;
import java.util.*;
// 좌표 압축

// 맵 사용하기. key, value 를 이용하기.
public class Bj18870 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(st.nextToken());

        int[] origin = new int[N];
        int[] sort = new int[N];

        HashMap<Integer, Integer> map = new HashMap<>();

        st = new StringTokenizer(br.readLine());
        for(int i=0;i<N;i++){
            sort[i] = origin[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(sort);

        int rank = 0;
        for(int k : sort){
            if(!map.containsKey(k)) map.put(k,rank++);
        }

        for(int k : origin){
            sb.append(map.get(k)+" ");
        }

        System.out.println(sb);


    }
}
