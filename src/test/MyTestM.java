import org.junit.*;
import static org.junit.Assert.*;

import java.io.PrintStream;
import java.io.OutputStream;
import java.io.ByteArrayOutputStream;

public class TestM {

    /* add your test code here */
    private M testm;

    @Before
    public void setUp() throws Exception{
        testm = new M();
    }

    @After
    public void tearDown() throws Exception{
        testm = null;
    }

    @Test
    public void nodeCoverage() {
        testm.m("", 2); //0, 2, 3, 7, 8, 10
        testm.m("A", 3); //0, 2, 4, 7, 9, 10
        testm.m("AB", 0); //0, 1, 2, 5, 6, 7, 9, 10
    }

    @Test
    public void edgeCoverage() {
        testm.m("", 2); //0, 2, 3, 7, 8, 10
        testm.m("J", 3); //0, 2, 4, 7, 9, 10
        testm.m("JB", 0); //0, 1, 2, 5, 6, 7, 9 ,10
        testm.m("James", 4); //0, 2, 6, 7, 9, 10
    }

    @Test
    public void edgePairCoverage() {
        testm.m("", 2); //0, 2, 3, 7, 8, 10
        testm.m("F", 3); //0, 2, 4, 7, 9, 10
        testm.m("Fa", 0); //0, 1, 2, 5, 6, 7, 9 ,10
        testm.m("Fan", 4); //0, 2, 6, 7, 9, 10

        testm.m("", 0); //0, 1, 2, 3, 7, 8, 10
        testm.m("Z", 0); //0, 1, 2, 4, 7, 9, 10
        testm.m("Zh", 1); //0, 2, 5, 6, 7, 9 ,10
        testm.m("Zhe", 0); //0, 1, 2, 6, 7, 9, 10
    }

    @Test
    public void primePathCoverage() {
        testm.m("", 1); //0, 2, 3, 7, 8, 10
        testm.m("S", 3); //0, 2, 4, 7, 9, 10
        testm.m("SE", 0); //0, 1, 2, 5, 6, 7, 9 ,10
        testm.m("SE461", 4); //0, 2, 6, 7, 9, 10

        testm.m("", 0); //0, 1, 2, 3, 7, 8, 10
        testm.m("N", 0); //0, 1, 2, 4, 7, 9, 10
        testm.m("Ni", 1); //0, 2, 5, 6, 7, 9 ,10
        testm.m("Nintendo", 0); //0, 1, 2, 6, 7, 9, 10
    }
}

class M {

    public static void main(String [] argv){
        M obj = new M();
        if (argv.length > 0)
            obj.m(argv[0], argv.length);
    }

    public void m(String arg, int i) {
        int q = 1;
        A o = null;
        Impossible nothing = new Impossible();
        if (i == 0)
            q = 4;
        q++;
        switch (arg.length()) {
            case 0: q /= 2; break;
            case 1: o = new A(); new B(); q = 25; break;
            case 2: o = new A(); q = q * 100;
            default: o = new B(); break;
        }
        if (arg.length() > 0) {
            o.m();
        } else {
            System.out.println("zero");
        }
        nothing.happened();
    }
}

class A {
    public void m() {
        System.out.println("a");
    }
}

class B extends A {
    public void m() {
        System.out.println("b");
    }
}

class Impossible{
    public void happened() {
        // "2b||!2b?", whatever the answer nothing happens here
    }
}
