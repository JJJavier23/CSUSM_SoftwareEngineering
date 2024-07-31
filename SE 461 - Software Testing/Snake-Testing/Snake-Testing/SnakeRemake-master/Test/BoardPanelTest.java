import static org.junit.Assert.*;

import java.awt.image.BufferedImage;
import java.util.LinkedList;
import java.util.Random;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Point;

import org.junit.Before;
import org.junit.Test;
import org.psnbtech.BoardPanel;
import org.psnbtech.Clock;
import org.psnbtech.Direction;
import org.psnbtech.SnakeGame;
import org.psnbtech.TileType;

public class BoardPanelTest {
	private BoardPanel boardPanel;
    private TestSnakeGame game;

    @Before
    public void setUp() {
        game = new TestSnakeGame();
        boardPanel = new BoardPanel(game);
    }

    @Test
    public void testDrawTile_Path_1_2_9() {
        BufferedImage image = new BufferedImage(BoardPanel.COL_COUNT * BoardPanel.TILE_SIZE,
                BoardPanel.ROW_COUNT * BoardPanel.TILE_SIZE, BufferedImage.TYPE_INT_ARGB);
        Graphics graphics = image.getGraphics();
        boardPanel.drawTile(0, 0, TileType.Fruit, graphics);
        assertTrue(isTileColorPresent(image, Color.RED));
    }

    @Test
    public void testDrawTile_Path_1_3_9() {
        BufferedImage image = new BufferedImage(BoardPanel.COL_COUNT * BoardPanel.TILE_SIZE,
                BoardPanel.ROW_COUNT * BoardPanel.TILE_SIZE, BufferedImage.TYPE_INT_ARGB);
        Graphics graphics = image.getGraphics();
        boardPanel.drawTile(0, 0, TileType.SnakeBody, graphics);
        assertTrue(isTileColorPresent(image, Color.GREEN));
    }

    @Test
    public void testDrawTile_Path_1_4_5_9() {
        game.setDirection(Direction.North);
        BufferedImage image = new BufferedImage(BoardPanel.COL_COUNT * BoardPanel.TILE_SIZE,
                BoardPanel.ROW_COUNT * BoardPanel.TILE_SIZE, BufferedImage.TYPE_INT_ARGB);
        Graphics graphics = image.getGraphics();
        boardPanel.drawTile(0, 0, TileType.SnakeHead, graphics);
        assertTrue(isTileColorPresent(image, Color.GREEN));
        assertTrue(isTileColorPresent(image, Color.BLACK));
    }

    @Test
    public void testDrawTile_Path_1_4_6_9() {
        game.setDirection(Direction.South);
        BufferedImage image = new BufferedImage(BoardPanel.COL_COUNT * BoardPanel.TILE_SIZE,
                BoardPanel.ROW_COUNT * BoardPanel.TILE_SIZE, BufferedImage.TYPE_INT_ARGB);
        Graphics graphics = image.getGraphics();
        boardPanel.drawTile(0, 0, TileType.SnakeHead, graphics);
        assertTrue(isTileColorPresent(image, Color.GREEN));
        assertTrue(isTileColorPresent(image, Color.BLACK));
    }

    @Test
    public void testDrawTile_Path_1_4_7_9() {
        game.setDirection(Direction.West);
        BufferedImage image = new BufferedImage(BoardPanel.COL_COUNT * BoardPanel.TILE_SIZE,
                BoardPanel.ROW_COUNT * BoardPanel.TILE_SIZE, BufferedImage.TYPE_INT_ARGB);
        Graphics graphics = image.getGraphics();
        boardPanel.drawTile(0, 0, TileType.SnakeHead, graphics);
        assertTrue(isTileColorPresent(image, Color.GREEN));
        assertTrue(isTileColorPresent(image, Color.BLACK));
    }

    @Test
    public void testDrawTile_Path_1_4_8_9() {
        game.setDirection(Direction.East);
        BufferedImage image = new BufferedImage(BoardPanel.COL_COUNT * BoardPanel.TILE_SIZE,
                BoardPanel.ROW_COUNT * BoardPanel.TILE_SIZE, BufferedImage.TYPE_INT_ARGB);
        Graphics graphics = image.getGraphics();
        boardPanel.drawTile(0, 0, TileType.SnakeHead, graphics);
        assertTrue(isTileColorPresent(image, Color.GREEN));
        assertTrue(isTileColorPresent(image, Color.BLACK));
    }

    private boolean isTileColorPresent(BufferedImage image, Color color) {
        for (int x = 0; x < image.getWidth(); x++) {
            for (int y = 0; y < image.getHeight(); y++) {
                if (image.getRGB(x, y) == color.getRGB()) {
                    return true;
                }
            }
        }
        return false;
    }
    
    @Test
    public void testPaintComponent() {
    	BufferedImage image = new BufferedImage(BoardPanel.COL_COUNT * BoardPanel.TILE_SIZE,
                BoardPanel.ROW_COUNT * BoardPanel.TILE_SIZE, BufferedImage.TYPE_INT_ARGB);
        Graphics graphics = image.getGraphics();
        
        SnakeGame sg = new SnakeGame();
        sg.isGameOver = true;
        sg.isPaused = false;
        sg.isNewGame = false;

        sg.board.paintComponent(graphics);

        assertNotNull(sg.board);
        
        
        sg.board.clearBoard();
        
        sg.isNewGame = true;
        sg.isGameOver = false;
        sg.isPaused = false;

        sg.board.paintComponent(graphics);
        assertNotNull(sg.board);
        
        sg.board.clearBoard();
        
        sg.isNewGame = false;
        sg.isGameOver = false;
        sg.isPaused = true;
        
        sg.board.paintComponent(graphics);
        assertNotNull(sg.board);
        
        sg.board.clearBoard();
        
        sg.isNewGame = false;
        sg.isGameOver = false;
        sg.isPaused = false;
        
        sg.board.paintComponent(graphics);
        assertNotNull(sg.board);
        
        sg.random = new Random();
        sg.snake = new LinkedList<>();
        sg.directions = new LinkedList<>();
        sg.logicTimer = new Clock(9.0f);
        sg.isNewGame = true;

        sg.snake.clear();
        sg.board.clearBoard();
        Point head = new Point(5, 5);
        sg.snake.add(head);
        sg.board.setTile(head.x, head.y, TileType.SnakeHead);
        sg.board.setTile(head.x + 1, head.y, TileType.Fruit);
        
        
    }


    private static class TestSnakeGame extends SnakeGame {
        
		private static final long serialVersionUID = 5413217588135801736L;
		private Direction direction;

        public void setDirection(Direction direction) {
            this.direction = direction;
        }

        @Override
        public Direction getDirection() {
            return direction;
        }
    }
}
