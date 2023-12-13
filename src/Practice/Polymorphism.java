package Practice;

public class Polymorphism {
    interface Rifle{
        void shot();
    }

    static class Shotgun implements Rifle{
        @Override
        public void shot(){
            System.out.println("샷건은 공평합니다");
        }
    }

    static class SniperRifle implements Rifle{
        @Override
        public void shot(){
            System.out.println("스나는 한방입니다");
        }
    }
    public static void main(String[] args) {
        Shotgun s = new Shotgun();
        SniperRifle sni = new SniperRifle();

        s.shot();
        sni.shot();
    }
}
