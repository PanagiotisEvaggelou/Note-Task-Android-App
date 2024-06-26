package com.mgiandia.library.util;

import junit.framework.Assert;

import org.junit.Test;



public class LibraryExceptionTest
{
    @Test
    public void memberFunctions()
    {
        LibraryException ex1 = new LibraryException("message");
        Assert.assertEquals("message", ex1.getMessage());

        LibraryException ex2 = new LibraryException("message", null);
        Assert.assertEquals(null, ex2.getCause());

        LibraryException ex3 = new LibraryException(new Throwable());
        Assert.assertEquals(null, ex3.getCause().getMessage());
    }
}
