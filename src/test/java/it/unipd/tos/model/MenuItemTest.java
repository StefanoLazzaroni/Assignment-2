////////////////////////////////////////////////////////////////////
// [STEFANO] [LAZZARONI] [1170749]
////////////////////////////////////////////////////////////////////
package it.unipd.tos.model;

import static org.junit.Assert.assertEquals;
import org.junit.BeforeClass;
import org.junit.Test;
import it.unipd.tos.model.MenuItem;

public class MenuItemTest {
    private static MenuItem item;
    @BeforeClass
    public static void beforeClass() {
        item = new MenuItem(ItemType.Panini, "Paninozzo", 22);
    }
    @Test
    public void testGetItemType(){
        assertEquals(ItemType.Panini, item.getItemType());
    }
    @Test
    public void testGetName(){
        assertEquals("Paninozzo", item.getName());
    }
    @Test
    public void testGetPrice(){
        assertEquals(22, item.getPrice(), 0);
    }
}
