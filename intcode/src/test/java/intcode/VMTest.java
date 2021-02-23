package intcode;

import org.junit.*;
import org.junit.rules.TestName;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.Arrays;

public class VMTest {

    @Rule
    public TestName name= new TestName();

    @BeforeClass
    public static void runOnce(){
        //User to set up the logger beforehand
        IntCodeVM v = new IntCodeVM(System.in,System.out,Arrays.asList(99));
    }

    @Before
    public void setUP(){
        System.out.println("################" + String.format("%25s",name.getMethodName()) + "################");
    }

}
