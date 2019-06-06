package ptv.dojo;

public class Board {

  public static final int FIELDS_IN_ROW = 3;
  public static final int FIELDS_IN_LINE = 3;
  public static final int BOARD_SIZE = FIELDS_IN_ROW * FIELDS_IN_LINE;


  boolean isEmpty = true;
  Mark fields[] = new Mark[BOARD_SIZE + 1];
  Mark lastPlayer = Mark.EMPTY;

  public Board() {
    for (int i = 1; i <= 9; ++i) {
      fields[i] = Mark.EMPTY;
    }
  }

  public boolean allCellsMarked() {
    for (Mark mark : fields) {
      if (mark == Mark.EMPTY) {
        return false;
      }
    }
    return true;
  }

  public Mark getMark(int cellIndex) {
    return fields[cellIndex];
  }

  public boolean allCellsEmpty() {
    return isEmpty;
  }

  public void mark(int cellIndex, Mark mark) {
    if (cellIndex < 1) {
      throw new RuntimeException("Too small cell index to mark");
    }
    if (cellIndex > BOARD_SIZE) {
      throw new RuntimeException("Too big board");
    }
    if (!Mark.EMPTY.equals(fields[cellIndex])) {
      throw new RuntimeException("Can't set field again");
    }
    if (lastPlayer.equals(mark)) {
      throw new RuntimeException("One player can't set field twice.");
    }
    lastPlayer = mark;
    fields[cellIndex] = mark;
    isEmpty = false;
  }
}
