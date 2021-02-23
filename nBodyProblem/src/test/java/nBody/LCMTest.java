package nBody;

import org.junit.*;

public class LCMTest {

    LCM l;

    @Before
    public void setUP(){
        l = new LCM();
    }

    @Test
    public void testTwoAndFour(){
        Assert.assertEquals(l.getLCM(2,4),new Integer(4));
    }

    @Test
    public void testThreeAndFive(){
        Assert.assertEquals(l.getLCM(3,5),new Integer(15));
    }

    @Test
    public void testTenAndTwelve(){
        Assert.assertEquals(l.getLCM(10,12),new Integer(60));
    }
}
