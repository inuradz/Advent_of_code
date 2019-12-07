package secure;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class PasswordsPart1Test {

    Passwords p;

    @Before
    public void setUP(){
        p = new Passwords();
    }

    @Test
    public void testRepeatingOnes(){
        Assert.assertTrue(p.validPasswordPart1("111111"));
    }

    @Test
    public void testRepeatingOnesWithDifferentEndDigit(){
        Assert.assertTrue(p.validPasswordPart1("111112"));
        Assert.assertTrue(p.validPasswordPart1("111113"));
        Assert.assertTrue(p.validPasswordPart1("111114"));
        Assert.assertTrue(p.validPasswordPart1("111115"));
        Assert.assertTrue(p.validPasswordPart1("111116"));
        Assert.assertTrue(p.validPasswordPart1("111117"));
        Assert.assertTrue(p.validPasswordPart1("111118"));
        Assert.assertTrue(p.validPasswordPart1("111119"));

    }

    @Test
    public void testRepeatingOnesFailEndZero(){
        Assert.assertFalse(p.validPasswordPart1("111110"));
    }

    @Test
    public void testNotValidGivenNotIncreasing(){
        Assert.assertFalse(p.validPasswordPart1("223450"));
    }

    @Test
    public void testNotValidGivenNoDoubles(){
        Assert.assertFalse(p.validPasswordPart1("123789"));
    }


}
