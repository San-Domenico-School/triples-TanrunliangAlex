import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.util.ArrayList;
import java.util.Arrays;
/**
 * Write a description of class player here.
 * 
 * @author (Alex) 
 * @version (1/30/2025)
 */
public class Player extends Actor
{
    /**
     * Act - do whatever the Player wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    
    private Dealer dealer;
    private Card[] cardsSelected; 
    private ArrayList<Card> cardsOnBoard; 
    private ArrayList<Integer> selectedCardsIndex; 
    
    public Player(Dealer dealer)
    {
        this.dealer = dealer; 
        cardsOnBoard = new ArrayList<Card>(); 
        selectedCardsIndex = new ArrayList<Integer>(); 
        cardsSelected = new Card[3];
    }
    
    public void act()
    {
        selectCards(); 
        if(threeCardsSelected())
        {
            dealer.checkIfTriple(cardsOnBoard, cardsSelected, selectedCardsIndex);
            resetCardsSelected();
        }
    }
    
    public void addedToWorld(World world)
    {
        cardsOnBoard = (ArrayList) world.getObjects(Card.class);
    }
    
    private void resetCardsSelected()
    {
          for(int i = 0; i < cardsOnBoard.size(); i++)
          {
                cardsOnBoard.get(i).setImage(cardsOnBoard.get(i).getCardImage());
                cardsOnBoard.get(i).setIsSelected(false);
          }
          selectedCardsIndex.clear();
    }    
    
    private boolean threeCardsSelected()
    {
         if(selectedCardsIndex.size() == 3)
         {
               cardsSelected[0] = cardsOnBoard.get(selectedCardsIndex.get(0));
               cardsSelected[1] = cardsOnBoard.get(selectedCardsIndex.get(1)); 
               cardsSelected[2] = cardsOnBoard.get(selectedCardsIndex.get(2));
               return true;
         }
         else
         {
              return false;
         }
    }    
    
    private void selectCards()
    {
           for(int i = 0; i < cardsOnBoard.size(); i++)
           {
                  if(Greenfoot.mouseClicked(cardsOnBoard.get(i)))
                 {
                         if(cardsOnBoard.get(i).getIsSelected())
                         {
                              cardsOnBoard.get(i).setIsSelected(false);
                              cardsOnBoard.get(i).setImage(cardsOnBoard.get(i).getCardImage());
                              selectedCardsIndex.remove(new Integer(i));
                         }
                         else
                         {
                               cardsOnBoard.get(i).setIsSelected(true);
                               cardsOnBoard.get(i).setImage(cardsOnBoard.get(i).getSelectedCardImage());
                               selectedCardsIndex.add(new Integer(i));
                         }
                  }
            }
    }
    
}