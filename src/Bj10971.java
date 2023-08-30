import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Bj10971 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int[][] map = new int[N][N];

        // 입력.
        for(int i=0;i<N;i++){
            st = new StringTokenizer(br.readLine());
            for(int j=0;j<N;j++){
                map[i][j]= Integer.parseInt(st.nextToken());
            }
        }

        ArrayList<Integer> al = new ArrayList();

        al.add(0);
        int expense = 0;

        while (al.size()!=N){
            int size = al.size();
            int minx = -1;
            int miny = -1;
            int min = Integer.MAX_VALUE;

            for(int i=0;i<size;i++){
                int now = al.get(i);
                for(int j=0;j<N;j++){
                    if(al.contains(j)) continue;
                    if(map[now][j]==0) continue;
                    if(map[now][j] < min){
                        min = map[now][j];
                        minx = now;
                        miny = j;
                    }
                    if(map[j][now] < min){
                        min = map[j][now];
                        minx = now;
                        miny = j;
                    }

                }
            }
            al.add(miny);
            expense+=min;
        }

        System.out.println(expense);


    }
}
