import static org.mockito.Mockito.*;

import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class GameTest
{
  private Player player;
  private Dice die1, die2, die3;
  
  @Before
  public void setUp() throws Exception
  {
    player = new Player("Fred", 100);
    int bet = 5;
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
    when (die1.roll()).thenReturn(DiceValue.CLUB);
    when (die2.roll()).thenReturn(DiceValue.CLUB);
    when (die3.roll()).thenReturn(DiceValue.ANCHOR);
    when (die1.getValue()).thenReturn(DiceValue.CLUB);
    when (die2.getValue()).thenReturn(DiceValue.CLUB);
    when (die3.getValue()).thenReturn(DiceValue.ANCHOR);
    
    // test
    DiceValue pick = DiceValue.CLUB;
    assertEquals(die1.getValue(), pick);
  }
}
