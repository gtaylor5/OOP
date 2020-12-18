package com.chess.piece;

import java.util.List;

import com.chess.board.Board;
import com.chess.common.Location;
import com.chess.squares.Square;

public interface Movable {
  List<Location> getValidMoves(Board board);
  List<Location> getValidMoves(Board board, Square square);
  void makeMove(Square square);
}
