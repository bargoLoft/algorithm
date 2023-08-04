import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class Bj1935 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int[] arr = new int[N];
        Stack<Double> stack = new Stack<>();

        st = new StringTokenizer(br.readLine());
        String s = st.nextToken();

        for(int i=0;i<N;i++){
            st = new StringTokenizer(br.readLine());
            arr[i] = Integer.parseInt(st.nextToken());
        }



        for(int i=0;i<s.length();i++){
            double ans=0;
            char c = s.charAt(i);
            if(c>='A' && c<='Z'){
                double n = arr[c-'A'];
                stack.add(n);
            } else{
                double b = stack.peek();
                stack.pop();
                double a = stack.peek();
                stack.pop();
               if(c=='*'){
                   ans = a*b;
               } else if(c=='/'){
                   ans = a/b;
               } else if(c=='+'){
                   ans = a+b;
               } else if(c=='-'){
                   ans = a-b;
               }
               stack.add(ans);
            }
        }

        System.out.printf("%.2f",stack.peek());
    }
}
