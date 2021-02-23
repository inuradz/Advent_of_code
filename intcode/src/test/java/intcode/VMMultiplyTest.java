package intcode;

import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;

public class VMMultiplyTest {

    //This is MULTIPLY TEST

    @Test
    public void testMultiplyPointer(){
        IntCodeVM s = new IntCodeVM(System.in,System.out, Arrays.asList(2,3,0,3,99));
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
}
