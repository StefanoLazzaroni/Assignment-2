////////////////////////////////////////////////////////////////////
// [STEFANO] [LAZZARONI] [1170749]
////////////////////////////////////////////////////////////////////
package it.unipd.tos.business;

import java.util.List;

import it.unipd.tos.business.exception.TakeAwayBillException;
import it.unipd.tos.model.ItemType;
import it.unipd.tos.model.MenuItem;

public class TakeAwayBillImplementation implements TakeAwayBill {
    
    public double getOrderPrice(List<MenuItem> itemsOrdered) 
            throws TakeAwayBillException {
        double totale = 0;
        double min = 0;
        double sandwichNum = 0;
        for(int i = 0; i < itemsOrdered.size(); i++) {
            if(itemsOrdered.get(i).getItemType()==ItemType.Panini) {
                if(sandwichNum==0) {
                    min = itemsOrdered.get(i).getPrice();
                }else {
                    if(itemsOrdered.get(i).getPrice()<min) {
                        min = itemsOrdered.get(i).getPrice();
                    }
                }
                sandwichNum++;
            }
            totale += itemsOrdered.get(i).getPrice();
        }
        if(sandwichNum>5) {
            totale-=min/2;
        }
        return totale;
    }
    
}
