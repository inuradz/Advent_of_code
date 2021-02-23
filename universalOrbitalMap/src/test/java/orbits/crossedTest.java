package orbits;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class crossedTest {

    TotalOrbits p;

    @Before
    public void setUp(){
        p = new TotalOrbits();
    }

    @Test
    public void testGiven1Part1(){
        Assert.assertEquals(p.findManhattanCrossingDistanceFromOrigin("R75,D30,R83,U83,L12,D49,R71,U7,L72","U62,R66,U55,R34,D71,R55,D58,R83"),159);
    }

    @Test
    public void testGiven2Part1(){
        Assert.assertEquals(p.findManhattanCrossingDistanceFromOrigin("R98,U47,R26,D63,R33,U87,L62,D20,R33,U53,R51","U98,R91,D20,R16,D67,R40,U7,R15,U6,R7"),135);
    }

    @Test
    public void testGiven1Part2(){
        Assert.assertEquals(p.findWireDistance("R75,D30,R83,U83,L12,D49,R71,U7,L72","U62,R66,U55,R34,D71,R55,D58,R83"),610);
    }

    @Test
    public void testGiven2Part2(){
        Assert.assertEquals(p.findWireDistance("R98,U47,R26,D63,R33,U87,L62,D20,R33,U53,R51","U98,R91,D20,R16,D67,R40,U7,R15,U6,R7"),410);
    }
}
