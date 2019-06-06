package ptv.dojo;

public class Game {
  private final Board board;

  public Game(Board board) {
    this.board = board;
  }

  public Mark whichPlayerWon() {
    if (board.getMark(1).equals(board.getMark(4)) &&
        board.getMark(1).equals(board.getMark(7))
    ) {
      return board.getMark(1);
    }
    return Mark.EMPTY;
  }

  public boolean isEnded() {
    return !Mark.EMPTY.equals(whichPlayerWon()) || (Mark.EMPTY.equals(whichPlayerWon()) && board.allCellsMarked());
  }
}
