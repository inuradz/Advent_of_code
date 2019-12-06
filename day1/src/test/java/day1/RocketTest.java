package day1;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.Assert.*;

public class RocketTest {

    private Rocket r;

    @Before
    public void setUp(){
        r = new Rocket();
    }

    @Test
    public void testDefaultValues(){
        Assert.assertEquals(r.getFuelRequired(),0);
    }

    @Test
    public void testNoRoundingGivenExample(){
        r.addModule(12);
        Assert.assertEquals(r.getFuelRequired(),2);
    }

    @Test
    public void testRoundingGivenExample(){
        r.addModule(14);
        Assert.assertEquals(r.getFuelRequired(),2);
    }

    @Test
    public void testGivenExample1(){
        r.addModule(1969);
        Assert.assertEquals(r.getFuelRequired(),654);
    }

    @Test
    public void testGivenExample2(){
        r.addModule(100756);
        Assert.assertEquals(r.getFuelRequired(),33583);
    }

    @Test
    public void testTwoModulesNoRounding(){
        r.addModule(12);
        r.addModule(12);
        Assert.assertEquals(r.getFuelRequired(),4);
    }

    @Test
    public void testTwoModulesOnlyRounding(){
        r.addModule(14);
        r.addModule(14);
        Assert.assertEquals(r.getFuelRequired(),4);
    }

    @Test
    public void testTwoModulesMixedRounding(){
        r.addModule(12);
        r.addModule(14);
        Assert.assertEquals(r.getFuelRequired(),4);
    }

    @Test
    public void testMultipleModules(){
        r.addModule(12);
        r.addModule(14);
        r.addModule(15);
        Assert.assertEquals(r.getFuelRequired(),7);
    }

    @Test
    public void testRecurseNoneNeededGIven(){
        r.addModuleRecurse(14);
        Assert.assertEquals(r.getFuelRequired(),2);
    }

    @Test
    public void testRecurseNeededGiven1(){
        r.addModuleRecurse(1969);
        Assert.assertEquals(r.getFuelRequired(),966);
    }

    @Test
    public void testRecurseNeededGiven2(){
        r.addModuleRecurse(100756);
        Assert.assertEquals(r.getFuelRequired(),50346);
    }


}
