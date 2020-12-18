package com.chess.piece;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

import com.chess.board.Board;
import com.chess.common.Location;
import com.chess.squares.Square;

public class King extends AbstractPiece implements Movable {

  private final Movable rook;
  private final Movable bishop;

  public King(PieceColor pieceColor, Movable bishop, Movable rook) {
    super(pieceColor);
    this.name = "King";
    this.bishop = bishop;
    this.rook = rook;
  }

  public King(PieceColor pieceColor) {
    this(pieceColor, new Bishop(pieceColor), new Rook(pieceColor));
  }

  @Override
  public List<Location> getValidMoves(Board board) {
    List<Location> moveCandidates = new ArrayList<>();
    moveCandidates.addAll(rook.getValidMoves(board, this.getCurrentSquare()));
    moveCandidates.addAll(bishop.getValidMoves(board, this.getCurrentSquare()));
    Location current = this.getCurrentSquare().getLocation();
    return moveCandidates.stream()
        .filter(candidate -> (
            Math.abs(candidate.getFile().ordinal() - current.getFile().ordinal()) == 1 &&
                Math.abs(candidate.getRank() - current.getRank()) == 1))
        .collect(Collectors.toList());
  }

  @Override
  public List<Location> getValidMoves(Board board, Square square) {
    return null;
  }

  @Override
  public void makeMove(Square square) {
    System.out.println(this.getName() + "-> makeMove()");
  }
}
