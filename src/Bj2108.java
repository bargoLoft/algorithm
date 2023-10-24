import java.io.*;
import java.util.*;

// 통계학

// map.
// keySet 과 comparator 사용, 람다 표현식.
public class Bj2108 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(st.nextToken());

        HashMap<Integer,Integer> map = new HashMap();

        double sum = 0;

        for(int i=0;i<N;i++){
            int n = Integer.parseInt(br.readLine());
            int cnt =  map.getOrDefault(n,0);
            map.put(n,cnt+1);

            sum+=n;
        }

        List<Integer> keySet = new ArrayList<>(map.keySet());


        keySet.sort((o1,o2) ->{
            if(o1 < o2) return -1;
            else return 1;
        });

        int mid = 0;
        int midNum = -4001;
        for(int key : keySet){
            mid+=map.get(key);
            if(mid > N/2 && midNum == -4001){
                midNum = key;
            }
        }

        keySet.sort((o1, o2) -> {
            if(map.get(o1) > map.get(o2)) return -1;
            else if (map.get(o1) == map.get(o2)){
                if(o1 < o2) return -1;
            }
            return 1;
        });

        int manyCnt;
        if(N==1) manyCnt = 0;
        else{
            if(map.get(keySet.get(0)) != map.get(keySet.get(1))){
                manyCnt = 0;
            } else{
                manyCnt = 1;
            }
        }


        Integer maxKey = Collections.max(map.keySet());
        Integer minKey = Collections.min(map.keySet());

        System.out.println(Math.round(sum/N));
        System.out.println(midNum);
        System.out.println(keySet.get(manyCnt));
        System.out.println(maxKey-minKey);

    }
}
