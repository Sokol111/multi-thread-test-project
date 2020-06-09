package com.sokol;

import java.util.Objects;

public class Order implements Comparable<Order> {

  private static Integer lastOrder = 0;
  private static Integer lastIteration = 1;

  private final Integer order;
  private final Integer iteration;

  private Order(Integer order, Integer iteration) {
    this.order = order;
    this.iteration = iteration;
  }

  public static Order next() {
    if (lastOrder == Integer.MAX_VALUE) {
      lastOrder = 1;
      lastIteration++;
    } else {
      lastOrder++;
    }

    return new Order(lastOrder, lastIteration);
  }

  public boolean greaterThanOtherPerOne(Order o) {
    if ((order - o.getOrder()) == 1 && iteration.equals(o.getIteration())) {
      return true;
    } else if (order.equals(1) && ((iteration - o.getIteration()) == 1)) {
      return true;
    }
    return false;
  }

  public Integer getOrder() {
    return order;
  }

  public Integer getIteration() {
    return iteration;
  }

  @Override
  public int compareTo(Order o) {
    if (iteration > o.getIteration()) {
      return 1;
    } else if (iteration < o.getIteration()) {
      return -1;
    } else if (order > o.getOrder()) {
      return 1;
    } else if (order < o.getOrder()) {
      return -1;
    } else {
      throw new RuntimeException("Priority values can't be the same");
    }
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    Order order1 = (Order) o;
    return order.equals(order1.order) &&
        iteration.equals(order1.iteration);
  }

  @Override
  public int hashCode() {
    return Objects.hash(order, iteration);
  }

  @Override
  public String toString() {
    return "Order{" +
        "order=" + order +
        ", iteration=" + iteration +
        '}';
  }
}
