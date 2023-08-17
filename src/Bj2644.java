import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Bj2644 {
    static ArrayList<Data> [] list;

    static class Data{
        int y;
        int w;

        public Data(int y, int w) {
            this.y = y;
            this.w = w;
        }

//        @Override
//        public void toString(){
//
//        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        list = new ArrayList[n+1];
        for(int i=0;i<=n;i++){
            list[i] = new ArrayList();
        }

        st = new StringTokenizer(br.readLine());
        int a = Integer.parseInt(st.nextToken());
        int b = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        int m = Integer.parseInt(st.nextToken());

        for(int i=0;i<m;i++){
            st = new StringTokenizer(br.readLine());
            // 그래프 저장.
            int x= Integer.parseInt(st.nextToken());
            int y= Integer.parseInt(st.nextToken());
            list[x].add(new Data(x,y));
            list[y].add(new Data(y,x));
        }

        for(ArrayList l : list){
            System.out.println(l.toString());
        }

    }
}
