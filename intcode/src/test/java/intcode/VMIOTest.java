package intcode;

import org.junit.Assert;
import org.junit.Test;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.Arrays;

public class VMIOTest {

    @Test
    public void testReading(){
        ByteArrayInputStream b = new ByteArrayInputStream("5".getBytes());
        IntCodeVM s = new IntCodeVM(b,System.out, Arrays.asList(3,0,99));
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
    public void testWritingDirect(){
        ByteArrayOutputStream b = new ByteArrayOutputStream();
        PrintStream p = new PrintStream(b);
        IntCodeVM s = new IntCodeVM(System.in,p,Arrays.asList(104,6,99));
        Assert.assertEquals(s.getState(),Arrays.asList(104,6,99));
        Assert.assertArrayEquals(b.toByteArray(),"6".getBytes());
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
}
