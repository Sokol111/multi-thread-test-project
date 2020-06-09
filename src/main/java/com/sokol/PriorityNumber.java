package com.sokol;

import java.util.Objects;

public class PriorityNumber implements Comparable<PriorityNumber> {

  private Integer value;
  private Order order;

  private PriorityNumber(Integer value, Order order) {
    this.value = value;
    this.order = order;
  }

  public static PriorityNumber next(Integer value) {
    return new PriorityNumber(value, Order.next());
  }

  public Integer getValue() {
    return value;
  }

  public Order getOrder() {
    return order;
  }

  public void setValue(Integer value) {
    this.value = value;
  }

  @Override
  public int compareTo(PriorityNumber o) {
    return order.compareTo(o.getOrder());
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    PriorityNumber number = (PriorityNumber) o;
    return value.equals(number.value) &&
        order.equals(number.order);
  }

  @Override
  public int hashCode() {
    return Objects.hash(value, order);
  }

  @Override
  public String toString() {
    return "PriorityNumber{" +
        "value=" + value +
        ", order=" + order +
        '}';
  }
}
