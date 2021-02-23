package intcode;

import org.junit.Assert;
import org.junit.Test;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.Arrays;

public class VMEqualTest {
    @Test
    public void testEqualEightPosition(){
        ByteArrayInputStream in = new ByteArrayInputStream("8".getBytes());
        ByteArrayOutputStream b = new ByteArrayOutputStream();
        PrintStream out = new PrintStream(b);
        IntCodeVM s = new IntCodeVM(in,out, Arrays.asList(3,9,8,9,10,9,4,9,99,-1,8));
        Assert.assertArrayEquals(b.toByteArray(),"1".getBytes());
    }

    @Test
    public void testNotEqualEightPositionLess(){
        ByteArrayInputStream in = new ByteArrayInputStream("7".getBytes());
        ByteArrayOutputStream b = new ByteArrayOutputStream();
        PrintStream out = new PrintStream(b);
        IntCodeVM s = new IntCodeVM(in,out,Arrays.asList(3,9,8,9,10,9,4,9,99,-1,8));
        Assert.assertArrayEquals(b.toByteArray(),"0".getBytes());
    }

    @Test
    public void testNotEqualEightPositionGreater(){
        ByteArrayInputStream in = new ByteArrayInputStream("9".getBytes());
        ByteArrayOutputStream b = new ByteArrayOutputStream();
        PrintStream out = new PrintStream(b);
        IntCodeVM s = new IntCodeVM(in,out,Arrays.asList(3,9,8,9,10,9,4,9,99,-1,8));
        Assert.assertArrayEquals(b.toByteArray(),"0".getBytes());
    }

    @Test
    public void testEqualEightImmediate(){
        ByteArrayInputStream in = new ByteArrayInputStream("8".getBytes());
        ByteArrayOutputStream b = new ByteArrayOutputStream();
        PrintStream out = new PrintStream(b);
        IntCodeVM s = new IntCodeVM(in,out,Arrays.asList(3,3,1108,-1,8,3,4,3,99));
        Assert.assertArrayEquals(b.toByteArray(),"1".getBytes());
    }

    @Test
    public void testNotEqualEightImmediateLess(){
        ByteArrayInputStream in = new ByteArrayInputStream("7".getBytes());
        ByteArrayOutputStream b = new ByteArrayOutputStream();
        PrintStream out = new PrintStream(b);
        IntCodeVM s = new IntCodeVM(in,out,Arrays.asList(3,3,1108,-1,8,3,4,3,99));
        Assert.assertArrayEquals(b.toByteArray(),"0".getBytes());
    }

    @Test
    public void testNotEqualEightImmediateGreater(){
        ByteArrayInputStream in = new ByteArrayInputStream("9".getBytes());
        ByteArrayOutputStream b = new ByteArrayOutputStream();
        PrintStream out = new PrintStream(b);
        IntCodeVM s = new IntCodeVM(in,out,Arrays.asList(3,3,1108,-1,8,3,4,3,99));
        Assert.assertArrayEquals(b.toByteArray(),"0".getBytes());
    }
}
