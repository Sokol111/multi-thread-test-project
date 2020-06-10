package com.sokol;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Starter {

  public static void main(String[] args) {
    new Starter().start();
  }

  public void start() {
    NumbersSupplier numbersSupplier = new NumbersSupplier(1000);
    NumbersWriter numbersWriter = new NumbersWriter(1000);

    Multiplier multiplierOne = new Multiplier(numbersSupplier, numbersWriter);
    Multiplier multiplierTwo = new Multiplier(numbersSupplier, numbersWriter);

    ExecutorService service = Executors.newFixedThreadPool(4);

    service.execute(numbersSupplier);
    service.execute(numbersWriter);
    service.execute(multiplierOne);
    service.execute(multiplierTwo);
  }
}
