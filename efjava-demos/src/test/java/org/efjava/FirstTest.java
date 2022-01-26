package org.efjava;

import io.reactivex.rxjava3.core.Observable;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class FirstTest {
  @Test
  public void equalsTest() {
    assertEquals(1, 1);
  }

  @Test
  public void falseTest() {
    assertFalse(1 == 2);
  }

  @Test
  public void reactiveExperiment() {
    Observable<String> names = Observable.just("John", "Dan", "Tim");
    names.subscribe(name -> {
      System.out.println("The name is: " + name);
    });
  }
}
