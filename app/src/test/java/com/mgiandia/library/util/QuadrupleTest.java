package com.mgiandia.library.util;

import org.junit.Assert;
import org.junit.Test;



public class QuadrupleTest
{
    @Test
    public void memberFunctions()
    {
        Quadruple q = new Quadruple(1, "A", "B", "C");
        Assert.assertEquals(1, q.getUID());
        Assert.assertEquals("A", q.getFirst());
        Assert.assertEquals("B", q.getSecond());
        Assert.assertEquals("C", q.getThird());
    }
}
