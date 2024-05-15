package com.mgiandia.library.domain;

import org.junit.*;

public class AuthorTest {

    @Test
    public void names() {
        Contact author = new Contact();
        author.setFirstName("First");
        Assert.assertEquals("First", author.getFirstName());

        author.setLastName("Last");
        Assert.assertEquals("Last", author.getLastName());
    }

    @Test
    public void addNullForBook() {
        Contact author = new Contact();
        author.addBook(null);
        Assert.assertEquals(0,author.getBooks().size());
        bookBidirectionalAssociationInvariant(author);        
    }
    
    @Test
    public void addBook() {
        Contact author = new Contact();
        Note book = new Note();
        author.addBook(book);
        Assert.assertEquals(1, author.getBooks().size());
        Assert.assertTrue(author.getBooks().contains(book));
        bookBidirectionalAssociationInvariant(author);        
    }
    
    
    @Test
    public void removeNullForBook() {
        Contact author = new Contact();
        Note book = new Note();
        author.addBook(book);
        author.removeBook(null);
        Assert.assertEquals(1, author.getBooks().size());
        bookBidirectionalAssociationInvariant(author);
    }
    
    @Test
    public void removeBook() {
        Contact author = new Contact();
        Note book = new Note();
        author.addBook(book);
        bookBidirectionalAssociationInvariant(author);
        author.removeBook(book);
        Assert.assertEquals(0, author.getBooks().size());
        bookBidirectionalAssociationInvariant(author);
    }
    
    
    
    private void bookBidirectionalAssociationInvariant(Contact author) {
        for(Note book : author.getBooks()) {
            Assert.assertTrue(book.getAuthors().contains(author));            
        }
    }
}
