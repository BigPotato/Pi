package bigpotato.playground.algo;

import org.testng.Assert;

/**
 * Created by wujin on 4/27/14.
 */
public class HelloTest {
    @org.testng.annotations.Test
    public void helloTest() throws Exception {
        Hello hello = new Hello();
        Assert.assertEquals("test()", hello.test());
    }
}
