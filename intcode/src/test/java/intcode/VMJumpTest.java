package intcode;

import org.junit.Assert;
import org.junit.Test;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.Arrays;

public class VMJumpTest {
    @Test
    public void testJumpTestPositionZero(){
        ByteArrayInputStream in = new ByteArrayInputStream("0".getBytes());
        ByteArrayOutputStream b = new ByteArrayOutputStream();
        PrintStream out = new PrintStream(b);
        IntCodeVM s = new IntCodeVM(in,out, Arrays.asList(3,12,6,12,15,1,13,14,13,4,13,99,-1,0,1,9));
        Assert.assertArrayEquals(b.toByteArray(),"0".getBytes());
    }

    @Test
    public void testJumpTestPositionLessThanZero(){
        ByteArrayInputStream in = new ByteArrayInputStream("1".getBytes());
        ByteArrayOutputStream b = new ByteArrayOutputStream();
        PrintStream out = new PrintStream(b);
        IntCodeVM s = new IntCodeVM(in,out,Arrays.asList(3,12,6,12,15,1,13,14,13,4,13,99,-1,0,1,9));
        Assert.assertArrayEquals(b.toByteArray(),"1".getBytes());
    }

    @Test
    public void testJumpTestPositionGreaterThanZero(){
        ByteArrayInputStream in = new ByteArrayInputStream("-1".getBytes());
        ByteArrayOutputStream b = new ByteArrayOutputStream();
        PrintStream out = new PrintStream(b);
        IntCodeVM s = new IntCodeVM(in,out,Arrays.asList(3,12,6,12,15,1,13,14,13,4,13,99,-1,0,1,9));
        Assert.assertArrayEquals(b.toByteArray(),"1".getBytes());
    }

    @Test
    public void testJumpTestImmediateZero(){
        ByteArrayInputStream in = new ByteArrayInputStream("0".getBytes());
        ByteArrayOutputStream b = new ByteArrayOutputStream();
        PrintStream out = new PrintStream(b);
        IntCodeVM s = new IntCodeVM(in,out,Arrays.asList(3,3,1105,-1,9,1101,0,0,12,4,12,99,1));
        Assert.assertArrayEquals(b.toByteArray(),"0".getBytes());
    }

    @Test
    public void testJumpTestImmediateLessThanZero(){
        ByteArrayInputStream in = new ByteArrayInputStream("1".getBytes());
        ByteArrayOutputStream b = new ByteArrayOutputStream();
        PrintStream out = new PrintStream(b);
        IntCodeVM s = new IntCodeVM(in,out,Arrays.asList(3,3,1105,-1,9,1101,0,0,12,4,12,99,1));
        Assert.assertArrayEquals(b.toByteArray(),"1".getBytes());
    }

    @Test
    public void testJumpTestImmediateGreaterThanZero(){
        ByteArrayInputStream in = new ByteArrayInputStream("-1".getBytes());
        ByteArrayOutputStream b = new ByteArrayOutputStream();
        PrintStream out = new PrintStream(b);
        IntCodeVM s = new IntCodeVM(in,out,Arrays.asList(3,3,1105,-1,9,1101,0,0,12,4,12,99,1));
        Assert.assertArrayEquals(b.toByteArray(),"1".getBytes());
    }
}
