package com.javaguides.calculator;

import junit.framework.Assert;
import org.junit.Test;

public class calTest {
    @Test
    public void testAdd(){
        cal c = new cal();
        int res = c.add(10, 20);
        Assert.assertEquals(200, res);
    }
    @Test
    public void testAdd2(){
        cal c = new cal();
        int res = c.add(5, 12);
        Assert.assertEquals(60, res);
    }
    @Test
    public void testAdd3(){
        cal c = new cal();
        int res = c.add(12, 10);
        Assert.assertEquals(120, res);
    }
}
