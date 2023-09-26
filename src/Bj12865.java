import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
// 0-1 napSack
// 1차원 배열 시 뒤에서 부터
// 앞에서 부터하면 중복이렁남.
//
public class Bj12865 {
    static class Thing implements Comparable<Thing>{
        int weight;
        int value;

        public Thing(int weight, int value) {
            this.weight = weight;
            this.value = value;
        }

        @Override
        public int compareTo(Thing o){
            return this.weight - o.weight;
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        Thing[] bag = new Thing[N];
        int[] weightBag = new int[K+1];

        for(int i=0;i<N;i++){
            st= new StringTokenizer(br.readLine());
            int W = Integer.parseInt(st.nextToken());
            int V = Integer.parseInt(st.nextToken());
            bag[i] = new Thing(W,V);
        }

        for(int i=0;i<N;i++){
            for(int j = K; j>=0; j--){
                Thing t = bag[i];
                if(t.weight+j > K) continue;
                if(weightBag[j]+t.value > weightBag[j+t.weight]){
                    weightBag[j+t.weight] = weightBag[j] + t.value;
                }
            }
        }

        int max = 0;
        for(int i=1;i<=K;i++){
            if(weightBag[i] > max) max = weightBag[i];
        }
        System.out.println(max);
    }
}
