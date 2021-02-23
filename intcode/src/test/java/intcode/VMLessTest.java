package intcode;

import org.junit.Assert;
import org.junit.Test;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.Arrays;

public class VMLessTest {
    @Test
    public void testLessThanEightPosition(){
        ByteArrayInputStream in = new ByteArrayInputStream("7".getBytes());
        ByteArrayOutputStream b = new ByteArrayOutputStream();
        PrintStream out = new PrintStream(b);
        IntCodeVM s = new IntCodeVM(in,out, Arrays.asList(3,9,7,9,10,9,4,9,99,-1,8));
        Assert.assertArrayEquals(b.toByteArray(),"1".getBytes());
    }

    @Test
    public void testGreaterThanEightPosition(){
        ByteArrayInputStream in = new ByteArrayInputStream("9".getBytes());
        ByteArrayOutputStream b = new ByteArrayOutputStream();
        PrintStream out = new PrintStream(b);
        IntCodeVM s = new IntCodeVM(in,out,Arrays.asList(3,9,7,9,10,9,4,9,99,-1,8));
        Assert.assertArrayEquals(b.toByteArray(),"0".getBytes());
    }

    @Test
    public void testEqualEightLessPosition(){
        ByteArrayInputStream in = new ByteArrayInputStream("8".getBytes());
        ByteArrayOutputStream b = new ByteArrayOutputStream();
        PrintStream out = new PrintStream(b);
        IntCodeVM s = new IntCodeVM(in,out,Arrays.asList(3,9,7,9,10,9,4,9,99,-1,8));
        Assert.assertArrayEquals(b.toByteArray(),"0".getBytes());
    }

    @Test
    public void testLessThanEightImmediate(){
        ByteArrayInputStream in = new ByteArrayInputStream("7".getBytes());
        ByteArrayOutputStream b = new ByteArrayOutputStream();
        PrintStream out = new PrintStream(b);
        IntCodeVM s = new IntCodeVM(in,out,Arrays.asList(3,3,1107,-1,8,3,4,3,99));
        Assert.assertArrayEquals(b.toByteArray(),"1".getBytes());
    }

    @Test
    public void testGreaterThanEightImmediate(){
        ByteArrayInputStream in = new ByteArrayInputStream("9".getBytes());
        ByteArrayOutputStream b = new ByteArrayOutputStream();
        PrintStream out = new PrintStream(b);
        IntCodeVM s = new IntCodeVM(in,out,Arrays.asList(3,3,1107,-1,8,3,4,3,99));
        Assert.assertArrayEquals(b.toByteArray(),"0".getBytes());
    }

    @Test
    public void testEqualEightLessImmediate(){
        ByteArrayInputStream in = new ByteArrayInputStream("8".getBytes());
        ByteArrayOutputStream b = new ByteArrayOutputStream();
        PrintStream out = new PrintStream(b);
        IntCodeVM s = new IntCodeVM(in,out,Arrays.asList(3,3,1107,-1,8,3,4,3,99));
        Assert.assertArrayEquals(b.toByteArray(),"0".getBytes());
    }
}
