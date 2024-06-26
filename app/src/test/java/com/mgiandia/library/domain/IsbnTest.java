package com.mgiandia.library.domain;

import org.junit.Assert;
import org.junit.Test;



public class IsbnTest
{
    @Test
    public void memberFunctions()
    {
        ISBN isbn = new ISBN("111");
        Assert.assertEquals(true, isbn.isValid());
        Assert.assertEquals(false, isbn.equals(null));
        Assert.assertEquals(true, isbn.equals(isbn));
        Assert.assertEquals(false, isbn.equals(""));
        Assert.assertEquals(true, isbn.equals(new ISBN("111")));
        Assert.assertEquals(false, isbn.equals(new ISBN("1111")));
        Assert.assertEquals(48657, isbn.hashCode());
        Assert.assertEquals("111", isbn.toString());
    }
}
