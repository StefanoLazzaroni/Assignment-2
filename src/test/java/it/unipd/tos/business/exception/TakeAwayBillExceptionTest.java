////////////////////////////////////////////////////////////////////
// [STEFANO] [LAZZARONI] [1170749]
////////////////////////////////////////////////////////////////////
package it.unipd.tos.business.exception;

import static org.junit.Assert.assertEquals;
import org.junit.BeforeClass;
import org.junit.Test;

public class TakeAwayBillExceptionTest {
    private static TakeAwayBillException tabe;  
    @BeforeClass
    public static void beforeClass() {
        tabe = new TakeAwayBillException("Messaggio errante");
    }  
    @Test
    public void testGetMessage() {
        assertEquals("Messaggio errante", tabe.getMessage());
    }   
}
