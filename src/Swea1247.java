import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Swea1247 {
    static int n;
    static int[] company;
    static int[] home;
    static int[][] customer;
    static int[] deliveryArr;
    static int[] isVisited;
    static int min;

    private static void delivery(int dep){
        if(dep == n){
//            for(int d:deliveryArr){
//                System.out.print(d+" ");
//            }
//            System.out.println();
            int move = 0;
            int currentX = company[0];
            int currentY = company[1];
            // 종료
            for(int i=0;i<n;i++){
                int visit = deliveryArr[i];
                int visitX = customer[visit][0];
                int visitY = customer[visit][1];
                move+= Math.abs(currentX-visitX)+Math.abs(currentY-visitY);
                currentX = visitX;
                currentY = visitY;
            }
            move+= Math.abs(currentX-home[0])+Math.abs(currentY-home[1]);

            if(move < min) min = move;

            return;
        }

        for(int i=0;i<n;i++){
            if(isVisited[i]==1){
                continue;
            }
            isVisited[i] = 1;
            deliveryArr[dep] = i;
            delivery(dep+1);
            isVisited[i] = 0;
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int T = Integer.parseInt(st.nextToken());

        for(int t = 1;t<=T;t++){
            n = Integer.parseInt(br.readLine());
            company = new int[2];
            home = new int[2];
            customer = new int[n][2];
            deliveryArr = new int[n];
            isVisited = new int[n];
            min = 2400;

            st = new StringTokenizer(br.readLine());
            company[0] = Integer.parseInt(st.nextToken());
            company[1] = Integer.parseInt(st.nextToken());
            home[0] = Integer.parseInt(st.nextToken());
            home[1] = Integer.parseInt(st.nextToken());

            for(int i=0;i<n;i++){
                customer[i][0] = Integer.parseInt(st.nextToken());
                customer[i][1] = Integer.parseInt(st.nextToken());
            }

            delivery(0);

            System.out.println(min);
        }
    }
}
