import greenfoot.*; 

/**
 * Game Board for Triples
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */

public class Card extends Actor
{
    protected enum Shape{TRIANGLE, SQUARE, CIRCLE, NO_SHAPE}
    protected enum Color{RED, GREEN, BLUE, NO_COLOR}
    private Shape shape;
    private Color color;
    private GreenfootImage cardImage, selectedCardImage;
    private int numberOfShapes, shading;
    private boolean isSelected;

    Card(Shape shape, Color color, int numberOfShapes, int shading, 
        GreenfootImage cardImage, GreenfootImage selectedCardImage){
        this.numberOfShapes = numberOfShapes;
        this.shading = shading;
        this.shape = shape;
        this.color = color;
        this.cardImage = cardImage;
        this.selectedCardImage = selectedCardImage;
        setImage(cardImage);
    }

    protected Shape getShape()
    {
        return shape;
    }

    protected Color getColor()
    {
        return color;
    }
    protected int getNumberOfShapes()
    {
        return numberOfShapes;
    }

    protected int getShading()
    {
        return shading;
    }

    protected GreenfootImage getCardImage()
    {
        return cardImage;
    }

    protected GreenfootImage getSelectedCardImage()
    {
        return selectedCardImage;
    }

    protected boolean getIsSelected()
    {
        return isSelected;
    }

    protected void setIsSelected(boolean select)
    {
        isSelected = select;
    }
}

