import java.util.ArrayList;
import java.util.List;

/**
 * Created by HINARI on 2019/01/28.
 */
public class Main {
    public static void main(String[] args){
        int tate=10,yoko=20;
        Board world=new Board(tate,yoko);
        Display display=new Display();
        /*List<Integer> bornlist=new ArrayList<Integer>();
        bornlist.add(25);
        bornlist.add(26);
        bornlist.add(27);

        bornlist.add(75);
        bornlist.add(76);
        bornlist.add(95);
        bornlist.add(96);
        bornlist.add(117);
        bornlist.add(118);
        bornlist.add(137);
        bornlist.add(138);
        world.birth(bornlist);*/
        world.initialize();
        display.init(world);
        world.print();
        try{
            Thread.sleep(3000); //3000ミリ秒Sleepする
        }catch(InterruptedException e){
            System.out.println("ERROR");
        }
        while(true){
            lifegame.AdoptRule(world);
            try{
                Thread.sleep(1000); //3000ミリ秒Sleepする
            }catch(InterruptedException e){
                System.out.println("ERROR");
            }
            display.change(world);
            //world.print();
        }

    }
}
