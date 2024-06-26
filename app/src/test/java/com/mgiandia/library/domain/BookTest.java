package com.mgiandia.library.domain;

import org.junit.*;

public class BookTest {

    Note book;
    Item item;
    
    @Before
    public void setUp() {
        book = new Note();
        item = new Item();
        item.setItemNumber(1);
        item.available();
        book.addItem(item);
    }

    @Test
    public void succefulSetUp() {
        itemBidirectionalAssociationInvariant(book);
        expectedItemsSize(book,1);
        Assert.assertEquals(ItemState.AVAILABLE, item.getState());
        successfullAdditionofItem(book,item);
    }

    @Test
    public void addNullAsItem() {
        expectedItemsSize(book,1);
        book.addItem(null);
        expectedItemsSize(book,1);
        itemBidirectionalAssociationInvariant(book);
    }
        
    @Test
    public void addNullAsAuthor() {
        book.addAuthor(null);
        Assert.assertEquals(0, book.getAuthors().size());
        authorBidirectionalAssociationInvariant(book);
    }
    
    
    @Test
    public void addItem() {        
        expectedItemsSize(book,1);        
        item = new Item();
        item.setItemNumber(2);
        book.addItem(item);
        successfullAdditionofItem(book,item);
        expectedItemsSize(book,2);
        itemBidirectionalAssociationInvariant(book);
    }

    @Test
    public void addAuthor() {
        Contact author = new Contact();
        book.addAuthor(author);
        Assert.assertEquals(1,book.getAuthors().size());
        authorBidirectionalAssociationInvariant(book);
    }
    
    
    @Test
    public void removeNullAsItem() {
        expectedItemsSize(book,1);
        book.removeItem(null);
        expectedItemsSize(book,1);
        itemBidirectionalAssociationInvariant(book);        
    }
    
    @Test
    public void removeNullAsAuthor() {
        Contact author = new Contact();
        book.addAuthor(author);
        book.removeAuthor(null);
        Assert.assertEquals(1, book.getAuthors().size());
        authorBidirectionalAssociationInvariant(book);
    }
    
    
    @Test
    public void removeItem() {
        itemBidirectionalAssociationInvariant(book);
        expectedItemsSize(book,1);
        book.removeItem(item);
        successfullRemovalofItem(book,item);
        expectedItemsSize(book,0);        
        itemBidirectionalAssociationInvariant(book);
    }

    @Test
    public void removeAuthor() {
        Contact author = new Contact();
        book.addAuthor(author);
        authorBidirectionalAssociationInvariant(book);
        Assert.assertEquals(1, book.getAuthors().size());
        book.removeAuthor(author);
        authorBidirectionalAssociationInvariant(book);
        Assert.assertEquals(0, book.getAuthors().size());
    }
    
    
    @Test
    public void addingSameItemIntoTwoBooks() {
        Note book2 = new Note();
        book2.addItem(item);
        successfullAdditionofItem(book2,item);
        itemBidirectionalAssociationInvariant(book);
        itemBidirectionalAssociationInvariant(book2);        
    }

    @Test
    public void memberFunctions() {
        Note book = new Note();

        book.setTitle("Title");
        Assert.assertEquals("Title", book.getTitle());

        book.setIsbn(new ISBN("Isbn"));
        Assert.assertEquals("Isbn", book.getIsbn().getValue());

        book.setPublication("publication");
        Assert.assertEquals("publication", book.getPublication());

        book.setPublicationYear(1234);
        Assert.assertEquals(1234, book.getPublicationYear());

        Assert.assertEquals(null, book.getPublisher());
    }

    private void itemBidirectionalAssociationInvariant(Note book) {
        for(Item item : book.getItems()) {
            Assert.assertSame(book, item.getBook());
        }
    }
    
    private void successfullAdditionofItem(Note book, Item item){
        Assert.assertTrue(book.getItems().contains(item));
        Assert.assertSame(book, item.getBook());
    }
    
    private void successfullRemovalofItem(Note book, Item item) {
        Assert.assertFalse(book.getItems().contains(item));
        Assert.assertNull(item.getBook());
    }
    
    private void expectedItemsSize(Note book, int expectedSize) {
        Assert.assertEquals(expectedSize, book.getItems().size());
    }
    
    private void authorBidirectionalAssociationInvariant(Note book) {
        for(Contact author : book.getAuthors()) {
            Assert.assertTrue(author.getBooks().contains(book));            
        }    
    }

    @Test
    public void denyReservationRequestToCurrentBorrower(){
        Borrower b = new Borrower(1, "Nikos", "Diamantidis", null, null, null,
                new BorrowerCategory(1, "Faculty", 10, 10, null));
        Loan loan = item.borrow(b, 1);
        Assert.assertNotNull(loan);

        ReservationRequest reservationRequest = book.reserve(b);
        Assert.assertNull(reservationRequest);

    }

    @Test
    public void denyReservationWhenAvailableItems(){
        BorrowerCategory borrowerCategory = new BorrowerCategory(1, "Faculty", 10, 10, null);
        Borrower b = new Borrower(1, "Nikos", "Diamantidis", null, null,
                null, borrowerCategory);

        ReservationRequest reservationRequest = book.reserve(b);
        Assert.assertNull(reservationRequest);

    }

    @Test
    public void successfulReservationRequest(){
        BorrowerCategory borrowerCategory = new BorrowerCategory(1, "Faculty", 10, 10, null);

        Borrower b = new Borrower(1, "Nikos", "Diamantidis", null, null,
                null, borrowerCategory);
        Loan loan = item.borrow(b, 1);
        Assert.assertNotNull(loan);

        Borrower b2 = new Borrower(1, "Manolis", "Giakoumakis", null, null,
                null, borrowerCategory);
        ReservationRequest reservationRequest = book.reserve(b2);
        Assert.assertNotNull(reservationRequest);

    }
}
