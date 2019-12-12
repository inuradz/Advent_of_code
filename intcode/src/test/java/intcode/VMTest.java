package intcode;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.TestName;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.Arrays;

public class VMTest {

    @Rule
    public TestName name= new TestName();

    @Before
    public void setUP(){
        System.out.println("################" + String.format("%25s",name.getMethodName()) + "################");
    }




    //This is the ADD testing

    @Test
    public void testAddExamplePointer(){
        IntCodeVM s = new IntCodeVM(System.in,System.out,Arrays.asList(1,5,1,0,99,10));
        Assert.assertEquals(s.getState(),Arrays.asList(15,5,1,0,99,10));
    }

    @Test
    public void testAddDirect(){
        IntCodeVM s = new IntCodeVM(System.in,System.out,Arrays.asList(1101,3,8,0,99,20));
        Assert.assertEquals(s.getState(),Arrays.asList(11,3,8,0,99,20));
    }

    @Test
    public void testAddDirectNegatives(){

        IntCodeVM s = new IntCodeVM(System.in,System.out,Arrays.asList(1101,100,-1,4,0));
        Assert.assertEquals(s.getState(),Arrays.asList(1101,100,-1,4,99));
    }

    @Test
    public void testAddMixed(){
        IntCodeVM s = new IntCodeVM(System.in,System.out,Arrays.asList(1001,3,4,3,99));
        Assert.assertEquals(s.getState(),Arrays.asList(1001,3,4,7,99));
    }

    @Test
    public void testAddMixedReversedParam(){
        IntCodeVM s = new IntCodeVM(System.in,System.out,Arrays.asList(101,5,5,3,99,10));
        Assert.assertEquals(s.getState(),Arrays.asList(101,5,5,15,99,10));
    }


    //This is MULTIPLY TEST

    @Test
    public void testMultiplyPointer(){
        IntCodeVM s = new IntCodeVM(System.in,System.out,Arrays.asList(2,3,0,3,99));
        Assert.assertEquals(s.getState(),Arrays.asList(2,3,0,6,99));
    }

    @Test
    public void testMultiplyDirect(){
        IntCodeVM s = new IntCodeVM(System.in,System.out,Arrays.asList(1102,3,23,3,99));
        Assert.assertEquals(s.getState(),Arrays.asList(1102,3,23,69,99));
    }

    @Test
    public void testMultiplyDirectReversed(){
        IntCodeVM s = new IntCodeVM(System.in,System.out,Arrays.asList(1102,23,3,3,99));
        Assert.assertEquals(s.getState(),Arrays.asList(1102,23,3,69,99));
    }

    @Test
    public void testMultiplyMixed(){
        IntCodeVM s = new IntCodeVM(System.in,System.out,Arrays.asList(102,10,5,3,99,8));
        Assert.assertEquals(s.getState(),Arrays.asList(102,10,5,80,99,8));
    }

    @Test
    public void testMultipleMixedReverseParam(){
        IntCodeVM s = new IntCodeVM(System.in,System.out,Arrays.asList(1002,5,10,3,99,8));
        Assert.assertEquals(s.getState(),Arrays.asList(1002,5,10,80,99,8));
    }


    @Test
    public void testGivenExample1(){
        IntCodeVM s = new IntCodeVM(System.in,System.out,Arrays.asList(2,4,4,5,99,0));
        Assert.assertEquals(s.getState(),Arrays.asList(2,4,4,5,99,9801));
    }

    @Test
    public void testGivenExample2(){
        IntCodeVM s = new IntCodeVM(System.in,System.out,Arrays.asList(1,1,1,4,99,5,6,0,99));
        Assert.assertEquals(s.getState(),Arrays.asList(30,1,1,4,2,5,6,0,99));
    }

    @Test
    public void testReading(){
        ByteArrayInputStream b = new ByteArrayInputStream("5".getBytes());
        IntCodeVM s = new IntCodeVM(b,System.out,Arrays.asList(3,0,99));
        Assert.assertEquals(s.getState(),Arrays.asList(5,0,99));
    }

    @Test
    public void testReadingAdd(){
        ByteArrayInputStream b = new ByteArrayInputStream("5".getBytes());
        IntCodeVM s = new IntCodeVM(b,System.out,Arrays.asList(3,0,1,0,0,0,99));
        Assert.assertEquals(s.getState(),Arrays.asList(10,0,1,0,0,0,99));
    }

    @Test
    public void testReadingAddMixed(){
        ByteArrayInputStream b = new ByteArrayInputStream("5".getBytes());
        IntCodeVM s = new IntCodeVM(b,System.out,Arrays.asList(3,0,101,25,0,0,99));
        Assert.assertEquals(s.getState(),Arrays.asList(30,0,101,25,0,0,99));
    }

    @Test
    public void testWriting(){
        ByteArrayOutputStream b = new ByteArrayOutputStream();
        PrintStream p = new PrintStream(b);
        IntCodeVM s = new IntCodeVM(System.in,p,Arrays.asList(4,0,99));
        Assert.assertEquals(s.getState(),Arrays.asList(4,0,99));
        Assert.assertArrayEquals(b.toByteArray(),"4".getBytes());
    }

    @Test
    public void testWritingMultiDigit(){
        ByteArrayOutputStream b = new ByteArrayOutputStream();
        PrintStream p = new PrintStream(b);
        IntCodeVM s = new IntCodeVM(System.in,p,Arrays.asList(4,2,99));
        Assert.assertEquals(s.getState(),Arrays.asList(4,2,99));
        Assert.assertArrayEquals(b.toByteArray(),"99".getBytes());
    }

    @Test
    public void testReadingAndWriting(){
        ByteArrayInputStream in = new ByteArrayInputStream("5".getBytes());
        ByteArrayOutputStream b = new ByteArrayOutputStream();
        PrintStream out = new PrintStream(b);
        IntCodeVM s = new IntCodeVM(in,out,Arrays.asList(3,1,4,1,99));
        Assert.assertEquals(s.getState(),Arrays.asList(3,5,4,1,99));
        Assert.assertArrayEquals(b.toByteArray(),"5".getBytes());
    }

    @Test
    public void testTEST(){
        ByteArrayInputStream in = new ByteArrayInputStream("1".getBytes());
        ByteArrayOutputStream b = new ByteArrayOutputStream();
        PrintStream out = new PrintStream(b);
        IntCodeVM s = new IntCodeVM(in,out,Arrays.asList(3,225,1,225,6,6,1100,1,238,225,104,0,1002,114,19,224,1001,224,-646,224,4,224,102,8,223,223,1001,224,7,224,1,223,224,223,1101,40,62,225,1101,60,38,225,1101,30,29,225,2,195,148,224,1001,224,-40,224,4,224,1002,223,8,223,101,2,224,224,1,224,223,223,1001,143,40,224,101,-125,224,224,4,224,1002,223,8,223,1001,224,3,224,1,224,223,223,101,29,139,224,1001,224,-99,224,4,224,1002,223,8,223,1001,224,2,224,1,224,223,223,1101,14,34,225,102,57,39,224,101,-3420,224,224,4,224,102,8,223,223,1001,224,7,224,1,223,224,223,1101,70,40,225,1102,85,69,225,1102,94,5,225,1,36,43,224,101,-92,224,224,4,224,1002,223,8,223,101,1,224,224,1,224,223,223,1102,94,24,224,1001,224,-2256,224,4,224,102,8,223,223,1001,224,1,224,1,223,224,223,1102,8,13,225,1101,36,65,224,1001,224,-101,224,4,224,102,8,223,223,101,3,224,224,1,223,224,223,4,223,99,0,0,0,677,0,0,0,0,0,0,0,0,0,0,0,1105,0,99999,1105,227,247,1105,1,99999,1005,227,99999,1005,0,256,1105,1,99999,1106,227,99999,1106,0,265,1105,1,99999,1006,0,99999,1006,227,274,1105,1,99999,1105,1,280,1105,1,99999,1,225,225,225,1101,294,0,0,105,1,0,1105,1,99999,1106,0,300,1105,1,99999,1,225,225,225,1101,314,0,0,106,0,0,1105,1,99999,8,677,226,224,1002,223,2,223,1006,224,329,1001,223,1,223,1108,226,226,224,1002,223,2,223,1005,224,344,101,1,223,223,1108,226,677,224,1002,223,2,223,1006,224,359,101,1,223,223,107,226,226,224,1002,223,2,223,1005,224,374,101,1,223,223,1107,226,226,224,1002,223,2,223,1005,224,389,101,1,223,223,107,677,677,224,102,2,223,223,1006,224,404,101,1,223,223,1008,226,226,224,1002,223,2,223,1006,224,419,101,1,223,223,108,677,226,224,1002,223,2,223,1006,224,434,101,1,223,223,1108,677,226,224,102,2,223,223,1005,224,449,101,1,223,223,1008,677,226,224,102,2,223,223,1006,224,464,1001,223,1,223,108,677,677,224,102,2,223,223,1005,224,479,101,1,223,223,7,677,677,224,102,2,223,223,1005,224,494,1001,223,1,223,8,226,677,224,102,2,223,223,1006,224,509,101,1,223,223,107,677,226,224,1002,223,2,223,1005,224,524,1001,223,1,223,7,677,226,224,1002,223,2,223,1005,224,539,1001,223,1,223,1007,226,677,224,1002,223,2,223,1005,224,554,1001,223,1,223,8,677,677,224,102,2,223,223,1006,224,569,101,1,223,223,7,226,677,224,102,2,223,223,1006,224,584,1001,223,1,223,1008,677,677,224,102,2,223,223,1005,224,599,101,1,223,223,1007,677,677,224,1002,223,2,223,1006,224,614,101,1,223,223,1107,677,226,224,1002,223,2,223,1006,224,629,101,1,223,223,1107,226,677,224,1002,223,2,223,1006,224,644,101,1,223,223,1007,226,226,224,102,2,223,223,1005,224,659,1001,223,1,223,108,226,226,224,102,2,223,223,1006,224,674,101,1,223,223,4,223,99,226));
        byte[] output = b.toByteArray();
        int i;
        System.out.println(b.toString());
        for(i=0;i<output.length-2;i++){
            Assert.assertEquals(output[i],'0');
        }
    }
}
