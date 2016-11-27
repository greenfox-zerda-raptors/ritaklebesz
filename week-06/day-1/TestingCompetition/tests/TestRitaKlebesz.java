import org.junit.Ignore;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by Rita on 2016-11-21.
 */
public class TestRitaKlebesz {
    WordToolbox wSource = new WordToolbox ("Tarzan's toenails");
    WordToolbox empty = new WordToolbox("");
    WordToolbox word = new WordToolbox("Me Tarzan, You Jane");
    WordToolbox word2 = new WordToolbox("folate");
    WordToolbox word3 = null;

    @Test
    public void countHowManyTest() throws Exception {
        assertEquals(3, wSource.countHowMany('a'));
        assertEquals(0, wSource.countHowMany('x'));
        assertEquals(1, wSource.countHowMany('\''));
        assertEquals(2, wSource.countHowMany('T'));
        assertEquals(0, empty.countHowMany('a'));
    }

    @Test
    public void secondCountHowManyTest() throws Exception {
        assertEquals(1, word.countHowMany('y'));
        assertEquals(1, word.countHowMany('Y'));
    }

    @Test
    public void isAnAnagram() throws Exception {
        assertFalse(word2.isAnAnagram("falsetto"));
        assertFalse(word2.isAnAnagram("latest"));
        assertFalse(word2.isAnAnagram("aloft"));
        assertFalse(word2.isAnAnagram("float"));
        assertFalse(word2.isAnAnagram("flota"));
        assertTrue(word2.isAnAnagram("foetal"));
    }

    @Test
    public void isAnAnagramUpperCase() throws Exception {
        assertFalse(word2.isAnAnagram("fLoTa"));
        assertTrue(word2.isAnAnagram("FOETAL"));
    }

    @Test
    public void isAnAnagramEmpty() throws Exception {
        assertFalse(word2.isAnAnagram(""));
        assertFalse(word2.isAnAnagram(" "));
        assertTrue(empty.isAnAnagram(""));
        assertFalse(empty.isAnAnagram("float"));
    }

    @Test (expected = NullPointerException.class)
    public void isAnAnagramNullOne() throws Exception {
        assertFalse(word2.isAnAnagram(null));
    }

    @Test (expected = NullPointerException.class)
    public void isAnAnagramNullTwo() throws Exception {
        assertTrue(word3.isAnAnagram(null));
    }

    @Test (expected = NullPointerException.class)
    public void isAnAnagramNullThree() throws Exception {
        assertFalse(word3.isAnAnagram("float"));
    }
}