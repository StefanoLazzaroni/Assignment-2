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
    
    @Test
    public void test50PercentDiscount() {
        List<MenuItem> list = new ArrayList<MenuItem>();
        list.add(new MenuItem(ItemType.Bevande, "Birra", 5));
        list.add(new MenuItem(ItemType.Panini, "Paninozzo", 7));
        list.add(new MenuItem(ItemType.Panini, "Paninozzo 2", 6));
        list.add(new MenuItem(ItemType.Panini, "Paninozzo", 3));
        list.add(new MenuItem(ItemType.Panini, "Paninozzo 2", 2));
        list.add(new MenuItem(ItemType.Panini, "Paninozzo 3", 3));
        list.add(new MenuItem(ItemType.Bevande, "Birra", 5));
        list.add(new MenuItem(ItemType.Panini, "Paninozzo 3", 4));
        list.add(new MenuItem(ItemType.Panini, "Paninozzo 2", 2));
        list.add(new MenuItem(ItemType.Bevande, "Birra", 5));        
        try{
            assertEquals(41, tabi.getOrderPrice(list), 0);
        }catch(TakeAwayBillException e) {
            fail("Exception");
        }
    }
    
    @Test
    public void test10PercentDiscount() {
        List<MenuItem> list = new ArrayList<MenuItem>();
        list.add(new MenuItem(ItemType.Panini, "Paninozzo 2", 25));
        list.add(new MenuItem(ItemType.Panini, "Paninozzo 1", 30));
        list.add(new MenuItem(ItemType.Bevande, "Birra", 7));
        try{
            assertEquals(55.8, tabi.getOrderPrice(list), 0);
        }catch(TakeAwayBillException e) {
            fail("Exception");
        }
    }
    
    @Test
    public void test10and50PercentDiscount() {
        List<MenuItem> list = new ArrayList<MenuItem>();
        list.add(new MenuItem(ItemType.Panini, "Paninozzo 2", 9));
        list.add(new MenuItem(ItemType.Panini, "Paninozzo 1", 9));
        list.add(new MenuItem(ItemType.Panini, "Paninozzo 3", 9));
        list.add(new MenuItem(ItemType.Panini, "Paninozzo 1", 9));
        list.add(new MenuItem(ItemType.Panini, "Paninozzo 3", 9));
        list.add(new MenuItem(ItemType.Panini, "Paninozzo 2", 6));
        try{
            assertEquals(43.2, tabi.getOrderPrice(list), 0);
        }catch(TakeAwayBillException e) {
            fail("Exception");
        }
    }
    
    @Test(expected = TakeAwayBillException.class)
    public void testMoreThan30Orders() throws TakeAwayBillException{
        List<MenuItem> list = new ArrayList<MenuItem>();
        for(int i = 0; i < 50; i++) {
            list.add(new MenuItem(ItemType.Panini, "Paninozzo 2", 6));
        }
        tabi.getOrderPrice(list);
    }
    
    @Test
    public void testSupplement() {
        List<MenuItem> list = new ArrayList<MenuItem>();
        
        list.add(new MenuItem(ItemType.Bevande, "Acqua", 2));
        list.add(new MenuItem(ItemType.Bevande, "Vino", 3));
        try{
            assertEquals(5.5, tabi.getOrderPrice(list), 0);
        }catch(TakeAwayBillException e) {
            fail("Exception");
        }
    }
    
    @Test
    public void testSupplement0Items() {
        List<MenuItem> list = new ArrayList<MenuItem>();
        try{
            assertEquals(0, tabi.getOrderPrice(list), 0);
        }catch(TakeAwayBillException e) {
            fail("Exception");
        }
    }
}
