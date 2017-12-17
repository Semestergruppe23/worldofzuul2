package Acquaintance;

/**
 *
 * @author All
 */
public interface IItem {
    
    /**
     * 
     * @return the name of the item as a string
     */
    String getName();
    
    /**
     * 
     * @return true if the item is carryable and flse if it is not
     */
    boolean getCarryable();
    
    /**
     * 
     * @return teh volume of the IItem
     */
    int getVolume();
    
    /**
     * 
     * @param description that you want to set to the item
     */
    void setText(String description);
    
    /**
     * 
     * @return The desription of the IItem
     */
    String getText();
    
    /**
     * 
     * @return the ID of the IITem
     */
    String getID();
    /**
     * is the use of the item, different for each subclass of Item.java
     */
    void use(IPlayer player);
    
}
