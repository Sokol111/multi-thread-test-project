package com.sokol;

import java.util.concurrent.PriorityBlockingQueue;

public class NumbersWriter implements Runnable {

  private PriorityBlockingQueue<PriorityNumber> numbers;
  private int capacity;
  private PriorityNumber lastNumber;

  public NumbersWriter(int capacity) {
    this.capacity = capacity;
    this.numbers = new PriorityBlockingQueue<>(capacity);
  }

  @Override
  public void run() {
    while (true) {
      writeToFile();
    }
  }

  public void put(PriorityNumber number) {
    while (true) {
      for (int i = 0; i < 10; i++) {
        if (numbers.size() < capacity) {
          if (numbers.offer(number)) {
            return;
          }
        }
      }

      if (numbers.offer(number)) {
        return;
      }
    }
  }

  private void writeToFile() {
    PriorityNumber number = numbers.peek();
    if (number == null) {
      return;
    }

    if (lastNumber == null || number.getOrder().greaterThanOtherPerOne(lastNumber.getOrder())) {
      lastNumber = numbers.poll();
      System.out.println(lastNumber);
    }
  }
}
