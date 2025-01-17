import greenfoot.*; 

/**
 * Game Board for Triples
 * 
 * @Tan
 * @version (a version number or a date)
 */

public class Card extends Actor
{
    private Shape shape;                     
    private Color color;                    
    private boolean isSelected;              
    private GreenfootImage cardImage, selectedCardImage;  
    private int numberOfShapes, shading;    
    
    public enum Shape 
    {
         TRIANGLE, SQUARE, CIRCLE, NO_SHAPE;
    }

    public enum Color 
    {
        RED, GREEN, BLUE, NO_COLOR;
    }
    public Card()
    {
        
    }
    
    public Card(Shape shape, Color color, int numberOfShapes, int shading, GreenfootImage cardImage, GreenfootImage selectedCardImage) 
    {
        this.shape = shape;                    
        this.color = color;                    
        this.numberOfShapes = numberOfShapes;  
        this.shading = shading;                
        this.cardImage = cardImage;            
        this.selectedCardImage = selectedCardImage; 
        this.isSelected = false;               
        
        setImage(cardImage);
    }
    
    public Shape getShape() 
    {
        return shape;
    }

    public Color getColor() 
    {
        return color;
    }

    public int getNumberOfShapes() 
    {
        return numberOfShapes;
    }

    public int getShading() 
    {
        return shading;
    }

    public GreenfootImage getCardImage() 
    {
        return cardImage;
    }

    public GreenfootImage getSelectedCardImage() 
    {
        return selectedCardImage;
    }
    
    public boolean getIsSelected()
    {
        return isSelected;
    }
    
    public boolean isSelected() 
    {
        return isSelected;
    }

    public void setIsSelected(boolean isSelected)
    {
        this.isSelected = isSelected;
    }

    public void setImage(GreenfootImage image) 
    {
        
    }
}

