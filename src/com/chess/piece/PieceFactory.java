package com.chess.piece;

import java.util.HashMap;
import java.util.Map;

import com.chess.common.File;
import com.chess.common.Location;

public final class PieceFactory {

  private PieceFactory() { }

  public static Map<Location, AbstractPiece> getPieces() {
    Map<Location, AbstractPiece> pieces = new HashMap<>();

    // rooks
    pieces.put(new Location(File.A, 1), new Rook(PieceColor.LIGHT));
    pieces.put(new Location(File.H, 1), new Rook(PieceColor.LIGHT));
    pieces.put(new Location(File.A, 8), new Rook(PieceColor.DARK));
    pieces.put(new Location(File.H, 8), new Rook(PieceColor.DARK));

    // Knights
    pieces.put(new Location(File.B, 1), new Knight(PieceColor.LIGHT));
    pieces.put(new Location(File.G, 1), new Knight(PieceColor.LIGHT));
    pieces.put(new Location(File.B, 8), new Knight(PieceColor.DARK));
    pieces.put(new Location(File.G, 8), new Knight(PieceColor.DARK));

    // Bishops
    pieces.put(new Location(File.C, 1), new Bishop(PieceColor.LIGHT));
    pieces.put(new Location(File.F, 1), new Bishop(PieceColor.LIGHT));
    pieces.put(new Location(File.C, 8), new Bishop(PieceColor.DARK));
    pieces.put(new Location(File.F, 8), new Bishop(PieceColor.DARK));

    // Queen
    pieces.put(new Location(File.D, 1), new Queen(PieceColor.LIGHT));
    pieces.put(new Location(File.D, 8), new Queen(PieceColor.DARK));

    // King
    pieces.put(new Location(File.E, 1), new King(PieceColor.LIGHT));
    pieces.put(new Location(File.E, 8), new King(PieceColor.DARK));

    // Pawns

    for(File file : File.values()) {
      pieces.put(new Location(file, 2), new Pawn(PieceColor.LIGHT));
      pieces.put(new Location(file, 7), new Pawn(PieceColor.DARK));
    }

    return pieces;

  }

}
