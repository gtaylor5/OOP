package com.chess.piece;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import com.chess.board.Board;
import com.chess.common.Location;
import com.chess.common.LocationFactory;
import com.chess.squares.Square;

public class Rook extends AbstractPiece implements Movable {
  public Rook(PieceColor pieceColor) {
    super(pieceColor);
    this.name = "Rook";
  }

  @Override
  public List<Location> getValidMoves(Board board) {
    List<Location> moveCandidates = new ArrayList<>();
    Map<Location, Square> squareMap = board.getLocationSquareMap();
    Location current = this.getCurrentSquare().getLocation();
    getFileCandidates(moveCandidates, squareMap, current, -1);
    getFileCandidates(moveCandidates, squareMap, current, 1);
    getRankCandidates(moveCandidates, squareMap, current, -1);
    getRankCandidates(moveCandidates, squareMap, current, 1);
    return moveCandidates;
  }

  private void getRankCandidates(
      List<Location> moveCandidates,
      Map<Location, Square> squareMap,
      Location current,
      int offset) {
    try {
      Location next = LocationFactory.build(current, current.getFile().ordinal(), offset);
      while (squareMap.containsKey(next)) {
        if (squareMap.get(next).isOccupied()) {
          if (squareMap.get(next).getCurrentPiece().pieceColor.equals(this.pieceColor)) {
            break;
          }
          moveCandidates.add(next);
          break;
        }
        moveCandidates.add(next);
        next = LocationFactory.build(next, next.getFile().ordinal(), offset);
      }
    } catch (Exception e) {

    }
  }

  private void getFileCandidates(
      List<Location> moveCandidates,
      Map<Location, Square> squareMap,
      Location current,
      int offset) {
    try {
      Location next = LocationFactory.build(current, offset, 0);
      while (squareMap.containsKey(next)) {
        if (squareMap.get(next).isOccupied()) {
          if (squareMap.get(next).getCurrentPiece().pieceColor.equals(this.pieceColor)) {
            break;
          }
          moveCandidates.add(next);
          break;
        }
        moveCandidates.add(next);
        next = LocationFactory.build(next, offset, 0);
      }
    } catch (Exception e) { }
  }

  @Override
  public List<Location> getValidMoves(Board board, Square square) {
    List<Location> moveCandidates = new ArrayList<>();
    Map<Location, Square> squareMap = board.getLocationSquareMap();
    Location current = square.getLocation();
    getFileCandidates(moveCandidates, squareMap, current, -1);
    getFileCandidates(moveCandidates, squareMap, current, 1);
    getRankCandidates(moveCandidates, squareMap, current, -1);
    getRankCandidates(moveCandidates, squareMap, current, 1);
    return moveCandidates;
  }

  @Override
  public void makeMove(Square square) {
    System.out.println(this.getName() + "-> makeMove()");
  }
}
