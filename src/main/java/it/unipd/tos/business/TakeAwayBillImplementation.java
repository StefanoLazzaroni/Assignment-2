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
        double min = Double.MAX_VALUE;
        double sandwichNum = 0;
        double costoPaniniFritti = 0;
        if(itemsOrdered.size()>30) {
            throw new TakeAwayBillException("Ordine troppo grande");
        }
        for(int i = 0; i < itemsOrdered.size(); i++) {
            if(itemsOrdered.get(i).getItemType()==ItemType.Panini) {
                if(itemsOrdered.get(i).getPrice()<min) {
                    min = itemsOrdered.get(i).getPrice();
                }
                sandwichNum++;
                costoPaniniFritti+=itemsOrdered.get(i).getPrice();
            }else {
                if(itemsOrdered.get(i).getItemType()!=ItemType.Bevande) {
                    costoPaniniFritti+=itemsOrdered.get(i).getPrice();
                }
            }
            totale += itemsOrdered.get(i).getPrice();
        }
        if(sandwichNum>5) {
            totale-=min/2;
        }
        if(costoPaniniFritti>50) {
            totale-=totale*0.1;
        }else {
            if(totale != 0 && totale<10) {
                totale+=0.5;
            }
        }
        return totale;
    }
    
}
