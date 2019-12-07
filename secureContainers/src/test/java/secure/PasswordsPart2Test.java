package secure;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class PasswordsPart2Test {

    Passwords p;

    @Before
    public void setUP(){
        p = new Passwords();
    }

    @Test
    public void testRepeatingOnesFail(){
        Assert.assertFalse(p.validPasswordPart2("111111"));
    }

    @Test
    public void testRepeatingOnesWithDifferentEndDigitFail(){
        Assert.assertFalse(p.validPasswordPart2("111112"));
        Assert.assertFalse(p.validPasswordPart2("111113"));
        Assert.assertFalse(p.validPasswordPart2("111114"));
        Assert.assertFalse(p.validPasswordPart2("111115"));
        Assert.assertFalse(p.validPasswordPart2("111116"));
        Assert.assertFalse(p.validPasswordPart2("111117"));
        Assert.assertFalse(p.validPasswordPart2("111118"));
        Assert.assertFalse(p.validPasswordPart2("111119"));

    }

    @Test
    public void testRepeatingOnesFailEndZero(){
        Assert.assertFalse(p.validPasswordPart2("111110"));
    }

    @Test
    public void testNotValidGivenNotIncreasing(){
        Assert.assertFalse(p.validPasswordPart2("223450"));
    }

    @Test
    public void testNotValidGivenNoDoubles(){
        Assert.assertFalse(p.validPasswordPart2("123789"));
    }


    @Test
    public void testGivenValid(){
        Assert.assertTrue(p.validPasswordPart2("112233"));
    }

    @Test
    public void testGivenTripleIncluded(){
        Assert.assertFalse(p.validPasswordPart2("123789"));
    }

    @Test
    public void testGivenQuadrippleAndDouble(){
        boolean correct = p.validPasswordPart2("111122");
        Assert.assertTrue(p.validPasswordPart2("111122"));
    }

    @Test
    public void testGivenQuadrippleAndDoubleReversed(){
        boolean correct = p.validPasswordPart2("224444");
        Assert.assertTrue(correct);
    }




}
