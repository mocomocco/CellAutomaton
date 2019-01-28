import java.util.ArrayList;
import java.util.List;

/**
 * Created by HINARI on 2019/01/28.
 */
public class lifegame {
    private static List<Integer> killlist=new ArrayList<Integer>();
    private static List<Integer> bornlist=new ArrayList<Integer>();

    public static void AdoptRule(Board world){
        int env;
        killlist=new ArrayList<Integer>();
        bornlist=new ArrayList<Integer>();
        for(int target=1;target<=world.size();target++){
            env=world.env(target);
            if (world.status(target)== world.live){
                if(env<=1){
                    killlist.add(target);
                }else if(env>=4){
                    killlist.add(target);
                }
            }else{
                if(env==3){
                    bornlist.add(target);
                }
            }
        }
        world.kill(killlist);
        world.birth(bornlist);

    }

}
