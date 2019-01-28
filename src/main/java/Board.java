import java.util.List;

/**
 * Created by HINARI on 2019/01/28.
 */
public class Board {
    public static int dead=0,live=1;

    public static int tate,yoko;

    private static String[] statusicon={"◆","◇"};

    private static int masus[];

    Board(int tate1,int yoko1,int color){
        masus=new int[tate1*yoko1+1];
        tate=tate1;
        yoko=yoko1;
        for(int target=0;target<tate1*yoko1;target++){
            masus[target]=color;
        }
        masus[size()]=dead;
    }

    Board(int tate1,int yoko1){
        masus=new int[tate1*yoko1+1];
        tate=tate1;
        yoko=yoko1;
        masus[size()]=dead;
    }


    public static void initialize(){
        for(int target=0;target<tate*yoko;target++){
            masus[target]=(int)Math.floor(Math.random()*2);
        }
    }

    public static int size(){
        return masus.length-1;
    }

    public static void kill(List<Integer> deads){
        for(int killed:deads){
            masus[killed-1]=dead;
        }
    }

    public static void birth(List<Integer> lives){
        for(int born:lives){
            masus[born-1]=live;
        }
    }

    public static int status(int target){
        return masus[target-1];
    }

    private static int hidari(int target){
        if (target == size()+1) {
            return target;
        }else if (target % yoko == 1){
            return size()+1;
        }else {
            return target - 1;
        }
    }

    private static int ue(int target){
        if (target == size()+1) {
            return target;
        }else if(target>yoko) {
            return target - yoko;
        }else{
            return size()+1;
        }
    }

    private static int migi(int target) {
        if (target == size()+1) {
            return target;
        }else if (target % yoko == 0){
            return size()+1;
        }else {
            return target + 1;
        }
    }

    private static int shita(int target){
        if (target == size()+1) {
            return target;
        }else if(target > size()-yoko){
            return size()+1;
        }else {
            return target + yoko;
        }
    }

    private static int TateYoko2Target(int targettate,int targetyoko){
        return targettate*yoko + targetyoko + 1;
    }

    private static int[] Target2TateYoko(int target){
        int targettate,targetyoko;
        targetyoko=(target+1)%yoko;
        targettate=(target+1-targetyoko)/yoko+1;
        int basho[]={targettate,targetyoko};
        return basho;
    }

    public static int env(int target){
        int sum =0;
        sum+=status(ue(hidari(target)));
        sum+=status(ue(target));
        sum+=status(ue(migi(target)));
        sum+=status(hidari(target));
        sum+=status(migi(target));
        sum+=status(shita(hidari(target)));
        sum+=status(shita(target));
        sum+=status(shita(migi(target)));
        return sum;
    }

    public static void print(){
        for(int targettate=0;targettate<tate;targettate++){
            for(int targetyoko=0;targetyoko<yoko;targetyoko++){
                System.out.print(statusicon[status(TateYoko2Target(targettate,targetyoko))]);
            }
            System.out.println(" ");
        }
        System.out.println(" ");
    }

}
