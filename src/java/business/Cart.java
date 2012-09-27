
package business;

import java.io.Serializable;
import java.util.*;

/**
 *
 * @author Rob_Weaver
 */
public class Cart implements Serializable
{
    private ArrayList<LineItem> items;
    
    public Cart()
    {
        items = new ArrayList<LineItem>();
    }
    
    public ArrayList<LineItem> getItems()
    {
        return items;
    }
    
     public void setItems(ArrayList<LineItem> lineItems)
    {
        items = lineItems;
    }
    
    public int getCount()
    {
        return items.size();
    }
    
    public void addItem(LineItem item)
    {
        String code = item.getProduct().getCode();
        int quantity = item.getQuantity();
        for (int i =0; i < items.size(); i++)
        {
            LineItem lineItem = items.get(i);
            if (lineItem.getProduct().getCode().equals(code))
            {
                lineItem.setQuantity(quantity);
                return;
            }
        }
        items.add(item);
    }
    
    public void removeItem(LineItem item)
    {
        String code = item.getProduct().getCode();
        //int quantity = item.getQuantity();
        for (int i =0; i < items.size(); i++)
        {
            LineItem lineItem = items.get(i);
            if (lineItem.getProduct().getCode().equals(code))
            {
                items.remove(i);
                return;
            }
        }
    }
    
    
} //end
