package com.twu.refactoring;

public class Time {
  private int startIndex;
  private int endIndex;
  private String name;
  private int characterCount;
  private int min;
  private int max;

  public Time(int startIndex, int endIndex, String name, int characterCount, int min, int max) {
    this.startIndex = startIndex;
    this.endIndex = endIndex;
    this.name = name;
    this.characterCount = characterCount;
    this.min = min;
    this.max = max;
  }

  public int getStartIndex() {
    return startIndex;
  }

  public int getEndIndex() {
    return endIndex;
  }

  public String getName() {
    return name;
  }

  public int getCharacterCount() {
    return characterCount;
  }

  public int getMin() {
    return min;
  }

  public int getMax() {
    return max;
  }
}
