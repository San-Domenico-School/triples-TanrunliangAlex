import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.util.ArrayList;
/**
 * Write a description of class Player here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */



public class Player extends Actor
{
    private Dealer dealer; 
    private Card[] cardsSelected = new Card[3]; 
    private ArrayList<Card> cardsOnBoard; 
    private ArrayList<Integer> selectedCardsIndex; 
    
    public Player(Dealer dealer) 
    {
        this.dealer = dealer;
        this.cardsSelected = new Card[3]; 
        this.cardsOnBoard = new ArrayList<Card>(); 
        this.selectedCardsIndex = new ArrayList<Integer>(); 
    }
    
    public void addedToWorld(World world)
    {
        cardsOnBoard = (ArrayList) getWorld().getObjects(Card.class);
    }
    
    private void selectCards()
    {
        for(int i = 0; i < cardsOnBoard.size(); i++)
        {
            if(Greenfoot.mouseClicked(cardsOnBoard.get(i)))
            {
                 Card card = cardsOnBoard.get(i);
                 
                 if(card.getIsSelected())
                 {
                     card.setIsSelected(false);
                     card.setImage(card.getCardImage());
                     selectedCardsIndex.remove((Integer) i);
                 }
                 else
                 {
                     card.setIsSelected(true);
                     card.setImage("Triplets_0/blank_0_0_0.png");
                     selectedCardsIndex.add(i);
                 }
            }
        }
    }
    
    private void resetCardsSelected()
    {
            for (int i = 0; i < cardsOnBoard.size(); i++) 
            {
                Card card = cardsOnBoard.get(i);
                card.setIsSelected(false);  
                card.setImage(card.getCardImage());
            }
            selectedCardsIndex.clear(); 
    }
    
    private boolean setCardsSelected()
    {
        if (selectedCardsIndex.size() == 3)
        {
            for (int i = 0; i < selectedCardsIndex.size(); i++) 
            {
                int index = selectedCardsIndex.get(i);
                cardsSelected[i] = cardsOnBoard.get(index); 
            }
            return true;
        }
        return false;
    }
    
    public void act() 
    {
        selectCards();
        boolean threeCardsHaveBeenSelected = setCardsSelected();
        
        if (threeCardsHaveBeenSelected) 
        {
            dealer.setCardsSelected(cardsOnBoard, selectedCardsIndex, cardsSelected);
            dealer.checkIfTriple();
            resetCardsSelected();
        }
    }
}
