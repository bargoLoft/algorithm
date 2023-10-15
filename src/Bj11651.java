import java.io.*;
import java.util.*;
// 좌표 정렬하기

// implements Comparable<Dot>
// public int compareTo(Dot dot){
//
//
// }
public class Bj11651 {
    static class Dot implements Comparable<Dot>{
        int x;
        int y;

        public Dot(int x, int y) {
            this.x = x;
            this.y = y;
        }

        @Override
        public int compareTo(Dot dot){
            if(this.y < dot.y) return -1;
            else if(this.y == dot.y){
                if(this.x < dot.x) return -1;
            }
            return 1;
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(st.nextToken());
        Dot[] dots = new Dot[N];

        for(int i=0;i<N;i++){
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            dots[i] = new Dot(x,y);
        }

        Arrays.sort(dots);

        for(int i=0;i<N;i++){
            sb.append(dots[i].x + " " + dots[i].y + "\n");
        }

        System.out.println(sb);
    }
}
