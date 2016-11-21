import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by Rita on 2016-11-21.
 */
public class TestRitaKlebesz {
    WordToolbox wSource = new WordToolbox ("Tarzan's toenails");
    WordToolbox empty = new WordToolbox("");

    @Test
    public void countHowMany() throws Exception {
        assertEquals(3, wSource.countHowMany('a'));
        assertEquals(0, wSource.countHowMany('x'));
        assertEquals(1, wSource.countHowMany('\''));
        assertEquals(2, wSource.countHowMany('T'));
        assertEquals(0, empty.countHowMany('a'));
    }

}