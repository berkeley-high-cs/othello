import java.awt.Color;
import java.awt.Graphics2D;

public class Othello extends GridGame {

  private static final Color BOARD_COLOR = new Color(0, 0x9e, 0x0d);
  private static final Color[] PIECE_COLORS = new Color[] { Color.BLACK, Color.WHITE };

  private static final int EMPTY = 0;
  private static final int BLACK = 1;
  private static final int WHITE = 2;

  private int[][] board = new int[8][8];
  private int player = BLACK;

  public Othello() {
    super(8, 8, 3);
    setBackground(Color.BLACK);

    // Starting position or Othello
    board[3][3] = WHITE;
    board[3][4] = BLACK;
    board[4][4] = WHITE;
    board[4][3] = BLACK;
  }

  /*
   * This method will be called whenever you need to draw a cell. The Graphics2D
   * object is essentially the same one you used in the Flag but with a few more
   * methods. See:
   *
   * https://docs.oracle.com/en/java/javase/21/docs/api/java.desktop/java/awt/Graphics2D.html
   */
  public void paintCell(int row, int col, Graphics2D g) {
    g.setColor(BOARD_COLOR);
    g.fillRect(0, 0, cellWidth(), cellHeight());

    int piece = board[row][col];
    if (piece != EMPTY) {
      g.setColor(PIECE_COLORS[piece - 1]);
      int w = (int)(cellWidth() * 0.9);
      int h = (int)(cellHeight() * 0.9);
      int px = cellWidth() - w;
      int py = cellHeight() - h;
      g.fillOval(px/2, py/2, w, h);
    }
  }

  /*
   * This method will be called for you when the user clicks a cell in the grid.
   */
  public void cellClicked(int row, int col) {
    board[row][col] = player;
    reverse(row, col, player);
    player = opposite(player);
    repaint();
  }

  /*
   * Given a move at r,c of color make all reversals.
   */
  private void reverse(int r, int c, int color) {
    // In each of eight directions, walk until you find a anchor and reverse all
    // opposite color stones on the way.
    for (int dx = -1; dx <= 1; dx++) {
      for (int dy = -1; dy <= 1; dy++) {
        if (dx != 0 || dy != 0) {
          if (isAnchored(r, c, color, dx, dy)) {
            reverseInDirection(r, c, color, dx, dy);
          }
        }
      }
    }
  }

  private boolean isAnchored(int r, int c, int color, int dx, int dy) {
    int other = opposite(color);
    r += dx;
    c += dy;
    while (inBounds(r, c) && board[r][c] == other)  {
      r += dx;
      c += dy;
    }
    return inBounds(r, c) && board[r][c] == color;
  }

  private void reverseInDirection(int r, int c, int color, int dx, int dy) {
    int other = opposite(color);
    r += dx;
    c += dy;
    while (inBounds(r, c) && board[r][c] == other)  {
      board[r][c] = color;
      r += dx;
      c += dy;
    }
  }

  private boolean inBounds(int r, int c) {
    return 0 <= r && r < 8 && 0 <= c && c < 8;
  }

  private int opposite(int player) {
    return player % 2 + 1;
  }

}
