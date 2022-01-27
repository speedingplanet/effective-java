package org.efjava.demos;

import org.junit.Ignore;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

public class EvenMoreTest {
  @Test
  public void passingTest() {
    assertEquals(1, 1);
  }

  @Ignore
  @Test
  public void failingTest() {
    fail();
  }
}
