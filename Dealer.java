import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.util.ArrayList; 

/**
 * Write a description of class Dealer here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Dealer extends Actor
{
    private Deck deck;
    private ArrayList<Card> cardsOnBoard;
    private ArrayList<Integer> selectedCardsIndex;
    private Card[] cardsSelected;
    private int numCardsInDeck;
    private int triplesRemaining;
    
    public Dealer(int numCardsInDeck)
    {
        this.numCardsInDeck = numCardsInDeck;
        triplesRemaining = numCardsInDeck / 3;
        deck = new Deck(numCardsInDeck);  
        this.cardsSelected = new Card[3];
        this.cardsOnBoard = new ArrayList<Card>();
        this.selectedCardsIndex = new ArrayList<Integer>();
    }
    
    public void addedToWorld(World world) 
    {
        dealBoard();
        setUI();
    }
    
    public void dealBoard() 
    {
        Greenfoot.playSound("shuffle.wav");

        for (int i = 0; i < 5; i++) 
        {
            for (int j = 0; j < 3; j++) 
            { 
                if (deck.getNumCardsInDeck() == 0)
                {
                    break;
                }
                else
                {
                    getWorld().addObject(deck.getTopCard(), 80 + j * 130, 60 + i * 80); 
                }
            }
        }
    }
    
    
    public void checkIfTriple() 
    {
        
    }
    
    public void actionIfTriple() 
    {
        
    }

    
    private void setUI()
    {
        String cardsRemainingText = new Integer(triplesRemaining * 3).toString();
        String scoreText = new Integer(Scorekeeper.getScore()).toString();
        getWorld().showText(cardsRemainingText, 310, 470);
        getWorld().showText(scoreText, 310, 504); 
    } 
    
    protected void checkIfEndGame()
    {
        if(triplesRemaining == 0)
        {
            Greenfoot.stop();
            getWorld().showText("You won!", 215, 300);
        }
    }
    
    protected void checkIfTriple(ArrayList<Card> cardsOnBoard, Card[]cardsSelected, ArrayList<Integer> selectedCardsIndex)
    {
        int shapes = cardsSelected[0].getShape().ordinal() + cardsSelected[1].getShape().ordinal() + cardsSelected[2].getShape().ordinal();
        
        int shadings = cardsSelected[0].getShading() + cardsSelected[1].getShading() + cardsSelected[2].getShading();
        
        int colors = cardsSelected[0].getColor().ordinal() + cardsSelected[1].getColor().ordinal() + cardsSelected[2].getColor().ordinal();
        
        int numberOfShapes = cardsSelected[0].getNumberOfShapes() + cardsSelected[1].getNumberOfShapes() + cardsSelected[2].getNumberOfShapes();
        
        
        if(shapes % 3 == 0 && shadings % 3 == 0 && colors % 3 == 0)
        {
            removeAndReplaceTriple(cardsOnBoard, cardsSelected, selectedCardsIndex);
        }
        else
        {
            Animations.wobble(cardsSelected);
        }
    }
    
    private void removeAndReplaceTriple(ArrayList<Card> cardsOnBoard, Card[] cardsSelected, 
                                    ArrayList<Integer> selectedCardsIndex)
    {
       int[][] cardsXYCoordinate = new int[3][2];  
       for(int card = 0; card < 3; card++)
       {
            cardsXYCoordinate[card][0] = cardsSelected[card].getX();
            cardsXYCoordinate[card][1] = cardsSelected[card].getY();
       }    
       Animations.slideAndTurn(cardsSelected);     
       for(int card = 0; card < 3; card++)
       { 
           getWorld().removeObject(cardsSelected[card]);
           if(deck.getNumCardsInDeck() > 0)
           {
               cardsOnBoard.set(selectedCardsIndex.get(card),deck.getTopCard());
               getWorld().addObject(cardsOnBoard.get(selectedCardsIndex.get(card)), 
                                                     cardsXYCoordinate[card][0], 
                                                     cardsXYCoordinate[card][1]);
           }
       }
       
       triplesRemaining--;
       Scorekeeper.updateScore();
       setUI();
       checkIfEndGame(); 

    }
}
