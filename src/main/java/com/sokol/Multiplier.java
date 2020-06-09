package com.sokol;

public class Multiplier implements Runnable {

  private NumbersSupplier numbersSupplier;
  private NumbersWriter numbersWriter;

  public Multiplier(NumbersSupplier numbersSupplier, NumbersWriter numbersWriter) {
    this.numbersSupplier = numbersSupplier;
    this.numbersWriter = numbersWriter;
  }

  @Override
  public void run() {
    while (true) {
      PriorityNumber number = numbersSupplier.get();
      Integer value = number.getValue();
      number.setValue(value * value);
      numbersWriter.put(number);
    }
  }
}
