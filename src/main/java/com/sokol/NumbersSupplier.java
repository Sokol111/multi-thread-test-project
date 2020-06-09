package com.sokol;

import java.util.Random;
import java.util.concurrent.PriorityBlockingQueue;

public class NumbersSupplier implements Runnable {

  private PriorityBlockingQueue<PriorityNumber> numbers;
  private int capacity;

  public NumbersSupplier(int capacity) {
    this.capacity = capacity;
    this.numbers = new PriorityBlockingQueue<>(capacity);
  }

  @Override
  public void run() {
    Random random = new Random();
    while (true) {
      if (numbers.size() < capacity) {
        PriorityNumber number = PriorityNumber.next(random.nextInt(1000));
        addNumberToQueue(number);
      }
    }
  }

  public PriorityNumber get() {
    while (true) {
      PriorityNumber number = numbers.poll();
      if (number != null) {
        return number;
      }
    }
  }

  private void addNumberToQueue(PriorityNumber number) {
    while (true) {
      if (numbers.offer(number)) {
        return;
      }
    }
  }
}
