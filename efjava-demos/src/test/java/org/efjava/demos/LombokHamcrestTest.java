package org.efjava.demos;

import org.efjava.demos.LombokHamcrest;
import org.junit.Test;

import java.time.LocalDate;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.isA;
import static org.hamcrest.CoreMatchers.not;
import static org.hamcrest.CoreMatchers.notNullValue;
import static org.hamcrest.CoreMatchers.sameInstance;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNotSame;
import static org.junit.Assert.assertTrue;

public class LombokHamcrestTest {
  @Test
  public void createInstance() {
    LombokHamcrest lh =
      new LombokHamcrest("John Paxton", LocalDate.of(1974, 1, 31), 4);
    assertTrue(lh instanceof LombokHamcrest);
    assertNotNull(lh);
    assertEquals(lh.getName(), "John Paxton");
  }

  @Test
  public void createInstanceHamcrest() {
    LombokHamcrest lh =
      new LombokHamcrest("John Paxton", LocalDate.of(1974, 1, 31), 4);
    assertThat(lh, isA(LombokHamcrest.class));
    assertThat(lh, notNullValue());
    assertThat(lh.getName(), is("John Paxton"));
  }

  @Test
  public void checkEquals() {
    LombokHamcrest lh1 =
      new LombokHamcrest("John Paxton", LocalDate.of(1974, 1, 31), 4);
    LombokHamcrest lh2 =
      new LombokHamcrest("John Paxton", LocalDate.of(1974, 1, 31), 4);
    assertNotSame(lh1, lh2);
    assertEquals(lh1, lh2);
  }

  @Test
  public void checkEqualsHamcrest() {
    LombokHamcrest lh1 =
      new LombokHamcrest("John Paxton", LocalDate.of(1974, 1, 31), 4);
    LombokHamcrest lh2 =
      new LombokHamcrest("John Paxton", LocalDate.of(1974, 1, 31), 4);
    assertThat(lh1, not(sameInstance(lh2)));
    assertThat(lh1, is(lh2));
  }
}
