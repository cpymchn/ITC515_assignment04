import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class TestBug03
{
  private Player player;
  
  @Before
  public void setUp() throws Exception
  {
    player = new Player("Fred", 1000);
  }



  @After
  public void tearDown() throws Exception
  {
    player = null;
  }



  @Test
  public void weirdOdds()

  {    
    //setup
    int bet = 1;
    int winCount = 0;
    int loseCount = 0;
    
    // play round

      Dice d1 = new Dice();
      Dice d2 = new Dice();
      Dice d3 = new Dice();
      Game game = new Game (d1, d2, d3);
      
      for (int round=0; round < 1000; round++)
      {
        DiceValue pick = DiceValue.getRandom();
        int win = game.playRound(player,pick, bet);
        if (win > 0) {
        winCount++;
        }
        else {loseCount++;}
      }
    
    
    float ratio = (float) winCount / (winCount + loseCount);
    
    // test
    assertTrue (ratio == 0.42);
  }
}
