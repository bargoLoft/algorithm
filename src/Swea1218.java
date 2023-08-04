import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class Swea1218 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        for(int t=1;t<=10;t++){
            StringTokenizer st = new StringTokenizer(br.readLine());

            int n = Integer.parseInt(st.nextToken());
            char[] arr = br.readLine().toCharArray();
            Stack<Character> s = new Stack<>();

            for(int i=0;i<n;i++){
                if(arr[i]=='{'||arr[i]=='['||arr[i]=='('||arr[i]=='<'){
                    s.add(arr[i]);
                } else {
                    if(s.isEmpty()){
                        s.add('x');
                        break;
                    }
                    if (s.peek() == '{'&&arr[i] == '}') {
                        s.pop();
                    } else if(s.peek() == '('&&arr[i] == ')'){
                        s.pop();
                    } else if(s.peek() == '<'&&arr[i] == '>'){
                        s.pop();
                    } else if(s.peek() == '['&&arr[i] == ']'){
                        s.pop();
                    } else{
                        s.add('x');
                        break;
                    }
                }
            }
            int ans = s.isEmpty() ? 1 : 0;
            System.out.printf("#%d %d\n",t ,ans);
        }

    }
}
