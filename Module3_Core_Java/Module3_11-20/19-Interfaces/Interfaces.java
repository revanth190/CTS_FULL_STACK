interface Plays{
    void play();
}
class Guitar implements Plays{
    public void play() {
        System.out.println("Playing Guitar");
    }
}
class Piano implements Plays{
    public void play() {
        System.out.println("Playing Piano");
    }
}
public class Interfaces{
    public static void main(String[] args){
        Plays g=new Guitar();
        Plays p=new Piano();
        g.play();
        p.play();
    }
}
