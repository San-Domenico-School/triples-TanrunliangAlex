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
    
    public void setUI() 
    {
        Integer numCardsRemaining = new Integer(numCardsInDeck - cardsOnBoard.size());
        Integer score = new Integer(triplesRemaining);
    
        GreenfootImage remainingCardsImage = new GreenfootImage(numCardsRemaining.toString(), 20, Color.BLACK, Color.WHITE);
        GreenfootImage scoreImage = new GreenfootImage(score.toString(), 20, Color.BLACK, Color.WHITE);
    
        Actor remainingCardsLabel = new Actor(){}; 
        remainingCardsLabel.setImage(remainingCardsImage);
        getWorld().addObject(remainingCardsLabel, 310, 465);  
    
        Actor scoreLabel = new Actor(){};
        scoreLabel.setImage(scoreImage);
        getWorld().addObject(scoreLabel, 310, 505);
    }
    
    public void endGame() 
    {
        
    }
    
    public void checkIfTriple() 
    {
        
    }
    
    public void actionIfTriple() 
    {
        
    }
    
    public void setCardsSelected(ArrayList<Card> cardsOnBoard, ArrayList<Integer> selectedCardsIndex, Card[] cardsSelected) 
    {
        
    }

}
