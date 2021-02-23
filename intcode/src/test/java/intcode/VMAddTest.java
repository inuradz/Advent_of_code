package intcode;

import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;

public class VMAddTest extends VMTest{

    //This is the ADD testing

    @Test
    public void testAddExamplePointer(){
        IntCodeVM s = new IntCodeVM(System.in,System.out, Arrays.asList(1,5,1,0,99,10));
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
}
