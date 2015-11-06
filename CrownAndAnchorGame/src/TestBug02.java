import static org.mockito.Mockito.*;
import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class TestBug02
{
  private Player player;
  
  @Before
  public void setUp() throws Exception
  {
    player = new Player("Fred", 5);
  }



  @After
  public void tearDown() throws Exception
  {
    player = null;
  }



  @Test
  public void testBetEqualsBalance()
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
    int balance = 5;    
    DiceValue pick = DiceValue.HEART;
    
    boolean outcome = player.balanceExceedsLimitBy(bet);
    
    // test
    assertTrue(outcome);
  }
}
