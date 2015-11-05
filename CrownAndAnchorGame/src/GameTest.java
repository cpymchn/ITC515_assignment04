import static org.mockito.Mockito.*;

import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class GameTest
{
  private Player player;
  
  @Before
  public void setUp() throws Exception
  {
    player = new Player("Fred", 100);
  }



  @After
  public void tearDown() throws Exception
  {
    player = null;
  }



  @Test
  public void oneMatch()
  {
    // create mock
    Dice die1 = mock (Dice.class);
    Dice die2 = mock (Dice.class);
    Dice die3 = mock (Dice.class);
    
    // define return value
    when (die1.getValue()).thenReturn(DiceValue.CLUB);
    when (die2.getValue()).thenReturn(DiceValue.CLUB);
    when (die3.getValue()).thenReturn(DiceValue.ANCHOR);
    
    // play round
    Game game = new Game (die1, die2, die3);
    int bet = 5;
    int balance = 100;
    DiceValue pick = DiceValue.ANCHOR;
    
    int result = balance + game.playRound (player, pick, bet);
    
    // test
    assertEquals(result, player.getBalance());
  }
  @Test
  public void twoMatch()
  {
    // create mock
    Dice die1 = mock (Dice.class);
    Dice die2 = mock (Dice.class);
    Dice die3 = mock (Dice.class);
    
    // define return value
    when (die1.getValue()).thenReturn(DiceValue.CLUB);
    when (die2.getValue()).thenReturn(DiceValue.CLUB);
    when (die3.getValue()).thenReturn(DiceValue.ANCHOR);
    
    // play round
    Game game = new Game (die1, die2, die3);
    int bet = 5;
    int balance = 100;
    DiceValue pick = DiceValue.CLUB;
    
    int result = balance + game.playRound (player, pick, bet);
    
    // test
    assertEquals(result, player.getBalance());
  }
  @Test
  public void threeMatch()
  {
    // create mock
    Dice die1 = mock (Dice.class);
    Dice die2 = mock (Dice.class);
    Dice die3 = mock (Dice.class);
    
    // define return value
    when (die1.getValue()).thenReturn(DiceValue.CLUB);
    when (die2.getValue()).thenReturn(DiceValue.CLUB);
    when (die3.getValue()).thenReturn(DiceValue.CLUB);
    
    // play round
    Game game = new Game (die1, die2, die3);
    int bet = 5;
    int balance = 100;
    DiceValue pick = DiceValue.CLUB;
    
    int result = balance + game.playRound (player, pick, bet);
    
    // test
    assertEquals(result, player.getBalance());
  }
  @Test
  public void noMatch()
  {
    // create mock
    Dice die1 = mock (Dice.class);
    Dice die2 = mock (Dice.class);
    Dice die3 = mock (Dice.class);
    
    // define return value
    when (die1.getValue()).thenReturn(DiceValue.CLUB);
    when (die2.getValue()).thenReturn(DiceValue.CLUB);
    when (die3.getValue()).thenReturn(DiceValue.CLUB);
    
    // play round
    Game game = new Game (die1, die2, die3);
    int bet = 5;
    int balance = 100;
    DiceValue pick = DiceValue.HEART;
    
    int result = balance - bet + game.playRound (player, pick, bet);
    
    // test
    assertEquals(result, player.getBalance());
  }
}
