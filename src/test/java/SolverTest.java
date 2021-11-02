import org.junit.Assert;
import org.junit.Test;

public class SolverTest {
    @Test
    public void isThisWordAPalindrome() {
        Assert.assertFalse(Solver.isThisWordAPalindromeOrderN(null));
        Assert.assertTrue(Solver.isThisWordAPalindromeOrderN(""));
        Assert.assertTrue(Solver.isThisWordAPalindromeOrderN("a"));
        Assert.assertTrue(Solver.isThisWordAPalindromeOrderN("aa"));
        Assert.assertTrue(Solver.isThisWordAPalindromeOrderN("aba"));
        Assert.assertTrue(Solver.isThisWordAPalindromeOrderN("abba"));
        Assert.assertFalse(Solver.isThisWordAPalindromeOrderN("abca"));
    }

    @Test
    public void isThisSentenceAPalindrome() {
        Assert.assertFalse(Character.isAlphabetic('\''));
        Assert.assertFalse(Character.isAlphabetic('\"'));
        Assert.assertFalse(Character.isAlphabetic(' '));

        Assert.assertTrue(Solver.isThisSentenceAPalindromeOrderN("Dammit    Im Mad"));

    }
}
