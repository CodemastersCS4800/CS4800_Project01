package com.javaguides.calculator;

import junit.framework.Assert;
import org.junit.Test;

public class calTest {
    @Test
    public void testMultiply(){
        cal c = new cal();
        int res = c.multiply(10, 20);
        Assert.assertEquals(200, res);
    }
    @Test
    public void testMultiply2(){
        cal c = new cal();
        int res = c.multiply(5, 12);
        Assert.assertEquals(60, res);
    }
    @Test
    public void testMultiply3(){
        cal c = new cal();
        int res = c.multiply(12, 10);
        Assert.assertEquals(120, res);
    }
}
