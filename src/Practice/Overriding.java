package Practice;

public class Overriding {
    static class Phone{
        public void call(){
            System.out.println("call");
        }
    }

    static class SmartPhone extends Phone{
        public void call(){
            System.out.println("Smart call");
        }

        public void internet(){
            System.out.println("can internet");
        }
    }
    public static void main(String[] args) {
       Phone p = new Phone();
       p.call();
       Phone sp = new SmartPhone();
       sp.call();

    }
}
