import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;
// 숨바꼭질.
public class Bj1697 {
    static class Subin{
        int n;
        int time;

        public Subin(int n, int time) {
            this.n = n;
            this.time = time;
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());


        boolean[] isVisited = new boolean[200001];
        Queue<Subin> q = new ArrayDeque<>();
        q.offer(new Subin(N,0));
        isVisited[N] = true;

        if(N>=K){
            System.out.println(N-K);
        } else{
            while (!q.isEmpty()){
                Subin sb = q.poll();
                if(sb.n > 2*K) continue;
                if(sb.n == K){
                    System.out.println(sb.time);
                    break;
                }
                if(sb.n < K && isVisited[sb.n * 2] == false){
                    q.offer(new Subin(sb.n*2,sb.time+1));
                    isVisited[sb.n * 2] = true;
                }
                if(isVisited[sb.n + 1] == false){
                    q.offer(new Subin(sb.n+1,sb.time+1));
                    isVisited[sb.n + 1] = true;
                }
                if(sb.n - 1 >=0 && isVisited[sb.n - 1] == false){
                    q.offer(new Subin(sb.n-1,sb.time+1));
                    isVisited[sb.n -1] = true;
                }
            }
        }

    }
}
