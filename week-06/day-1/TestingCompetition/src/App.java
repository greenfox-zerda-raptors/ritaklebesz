/**
 * Created by Rita on 2016-11-21.
 */
public class App {
    public static void main(String[] args) {
        WordToolbox wSource = new WordToolbox ("Tarzan's toenails");
        System.out.println ("countHowMany(\"a\")=" + wSource.countHowMany('a')); // countHowMany("a")=3
        System.out.println ("countHowMany(\"T\")="+ wSource.countHowMany('T')); // countHowMany("T")=2
        System.out.println ("countHowMany(\"t\")="+ wSource.countHowMany('t')); // countHowMany("t")=2
        System.out.println ("countHowMany(\"x\")="+ wSource.countHowMany('x')); // countHowMany("x")=0
        //System.out.println ("countHowMany(\"\")="+ wSource.countHowMany('')); // countHowMany("")=0
        System.out.println ("countHowMany(\" \")="+ wSource.countHowMany(' ')); // countHowMany(" ")=1
    }
}
