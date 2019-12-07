////////////////////////////////////////////////////////////////////
// [STEFANO] [LAZZARONI] [1170749]
////////////////////////////////////////////////////////////////////
package it.unipd.tos.business;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

import it.unipd.tos.business.exception.TakeAwayBillException;
import it.unipd.tos.model.ItemType;
import it.unipd.tos.model.MenuItem;

public class TakeAwayBillImplementationTest {
    private static TakeAwayBillImplementation tabi;
    
    @Before
    public void BeforeClass() {
        tabi = new TakeAwayBillImplementation();
    }
    
    @Test
    public void testStandardGetPrice() {
        List<MenuItem> list = new ArrayList<MenuItem>();
        list.add(new MenuItem(ItemType.Bevande, "Birra", 5));
        list.add(new MenuItem(ItemType.Panini, "Paninozzo", 7));
        list.add(new MenuItem(ItemType.Fritti, "Fritto Deluxe", 24));
        try{
            assertEquals(36, tabi.getOrderPrice(list), 0);
        }catch(TakeAwayBillException e) {
            fail("Exception");
        }
    }
    
    
}
