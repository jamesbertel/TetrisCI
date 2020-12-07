

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import psnbtech.BoardPanel;
import psnbtech.Tetris;
import psnbtech.TileType;

public class BoardPanelTest {
	
	BoardPanel bptest;
	Tetris bptestris = new Tetris();

	@Before
	public void setUp() throws Exception {
		bptest = new BoardPanel(bptestris);
	}

	@After
	public void tearDown() throws Exception {
		bptest = null;
	}

	@Test
	public void testIsValidAndEmpty() {
		TileType tile = TileType.TypeJ;
		bptest = new BoardPanel(bptestris);
		assertEquals(true, bptest.isValidAndEmpty(tile, 4, 6, 0));
	}

	@Test
	public void testAddPiece() {
		TileType tile = TileType.TypeS;
		bptest = new BoardPanel(bptestris);
		bptest.addPiece(tile, 2, 9, 1);
		assertEquals(false, bptest.isValidAndEmpty(tile, 2, 9, 1));
	}

	@Test
	public void testCheckLines() {
		assertEquals(22, bptest.checkLines());
	}
}
