package intcode;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.Assert.*;

import javax.swing.plaf.nimbus.State;
import java.util.Arrays;

public class StateMachineTest {

    @Test
    public void testAddExample(){
        StateMachine s = new StateMachine(Arrays.asList(1,0,0,0,99));
        Assert.assertEquals(s.getState(),Arrays.asList(2,0,0,0,99));
    }

    @Test
    public void testMultiplyExample(){
        StateMachine s = new StateMachine(Arrays.asList(2,3,0,3,99));
        Assert.assertEquals(s.getState(),Arrays.asList(2,3,0,6,99));
    }


    @Test
    public void testGivenExample1(){
        StateMachine s = new StateMachine(Arrays.asList(2,4,4,5,99,0));
        Assert.assertEquals(s.getState(),Arrays.asList(2,4,4,5,99,9801));
    }

    @Test
    public void testGivenExample2(){
        StateMachine s = new StateMachine(Arrays.asList(1,1,1,4,99,5,6,0,99));
        Assert.assertEquals(s.getState(),Arrays.asList(30,1,1,4,2,5,6,0,99));
    }
}
