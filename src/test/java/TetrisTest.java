import static org.junit.Assert.assertEquals;

import java.util.Random;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import psnbtech.BoardPanel;
import psnbtech.Tetris;
import psnbtech.TileType;
import psnbtech.Clock;

public class TetrisTest {

	private Tetris testris;
	private BoardPanel bptest;

	@Before
	public void setUp() throws Exception {
		testris = new Tetris();
		bptest = new BoardPanel(testris);
		
		testris.board = bptest;
		testris.isNewGame = true;
		testris.random = new Random();
		testris.gameSpeed = 1.0f;
		testris.logicTimer = new Clock(1.0f);
	}

	@After
	public void tearDown() throws Exception {
		testris = null;
		bptest = null;
	}

	@Test
	public void testUpdateGame() throws Exception{
		
		testris.resetGame();
		TileType temptile = TileType.TypeI;
		bptest.addPiece(temptile,  3, 4, 1);
		testris.updateGame();
		assertEquals(0, testris.getScore());
	}
}
