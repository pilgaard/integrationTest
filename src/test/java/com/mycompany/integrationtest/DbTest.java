package com.mycompany.integrationtest;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

/**
 *
 * @author Dennis
 */
public class DbTest {
    
    private DbConn db;
    
    public DbTest() {
    }
    
    @Before
    public void setUp() {
        db = mock(DbConn.class);
    }
    
    @Test
    public void testCheckPhone() {
        User userMock = new User("hej");
        userMock.setPhone(12345678);
        when(db.getPhone("emil")).thenReturn(userMock.getPhone());
        
        assertEquals(db.getPhone("emil"), userMock.getPhone());
    }
    @After
    public void tearDown() {
    }
    
}