import org.junit.Test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.*;

/**
 * Created by HINARI on 2019/01/28.
 */
public class BoardTest {
    @Test
    public void CallBoard() throws Exception {
        Board a;
        a= new Board(4,5,0);
        assertThat(a.size() ,is(20));
        assertThat(a.status(3),is(0));
    }

    @Test
    public void kill() throws Exception {
        Board a;
        a= new Board(4,5,1);
        List<Integer>  killlist= new ArrayList<Integer>();
        Collections.addAll(killlist, 1,5,7);
        a.kill(killlist);
        assertThat(a.status(3),is(1));
        assertThat(a.status(5),is(0));
    }

    @Test
    public void birth() throws Exception {
        Board a;
        a= new Board(4,5,0);
        List<Integer> birthlist=new ArrayList<Integer>();
        Collections.addAll(birthlist, 1,5,7);
        a.birth(birthlist);
        assertThat(a.status(3),is(0));
        assertThat(a.status(5),is(1));
    }

    @Test
    public void env() throws Exception {
        Board a;
        a= new Board(4,5,1);
        List<Integer>  killlist= new ArrayList<Integer>();
        Collections.addAll(killlist, 1,3,7,8,13);
        a.kill(killlist);
        assertThat(a.env(7),is(4));
        assertThat(a.env(5),is(3));
    }

}