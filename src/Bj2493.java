import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.time.chrono.MinguoDate;
import java.util.Stack;
import java.util.StringTokenizer;
//탑
public class Bj2493 {
     public static class Tower{
        int index;
        int height;
        Tower( int index,int height){
            this.index = index;
            this.height = height;
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();

        Stack<Tower> tower = new Stack<>();

        int N = Integer.parseInt(st.nextToken());
        int idx = 0;

        st = new StringTokenizer(br.readLine());


        for(int i=1;i<=N;i++){
            int height = Integer.parseInt(st.nextToken());
            if(tower.isEmpty()){
                tower.add(new Tower(i,height));
                sb.append("0 ");;
            } else{
                while(!tower.isEmpty() && tower.peek().height<height){
                    tower.pop();
                }
                if(tower.isEmpty()){
                    sb.append("0 ");
                    tower.add(new Tower(i,height));
                } else{
                    sb.append(tower.peek().index+" ");
                    tower.add(new Tower(i,height));                }
            }
        }
        System.out.println(sb);
    }
}
