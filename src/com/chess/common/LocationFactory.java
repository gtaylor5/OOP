package com.chess.common;

public class LocationFactory {
  private static final File[] files = File.values();
  public static Location build(Location current, Integer fileOffset, Integer rankOffset) {
    Integer currentFile = current.getFile().ordinal();
    if (currentFile + fileOffset >= files.length || currentFile + fileOffset < 0) {
      return new Location(files[currentFile], current.getRank() + rankOffset);
    }
    return new Location(files[currentFile + fileOffset], current.getRank() + rankOffset);
  }
}
