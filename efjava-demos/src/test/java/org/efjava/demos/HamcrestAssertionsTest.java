package org.efjava.demos;

import org.junit.Before;
import org.junit.Test;

import java.util.Arrays;

import static org.hamcrest.CoreMatchers.both;
import static org.hamcrest.CoreMatchers.containsString;
import static org.hamcrest.CoreMatchers.everyItem;
import static org.hamcrest.CoreMatchers.hasItems;
import static org.hamcrest.CoreMatchers.startsWith;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.junit.Assert.assertTrue;

public class HamcrestAssertionsTest {
  String word1, contains1, word2, contains2;

  @Before
  public void setUp() {
    word1 = "super";
    contains1 = "u";
    word2 = "Sunnyvale";
    contains2 = "nyv";
  }

  @Test
  public void standardAssertions() {
    // Does "super" contain the letter "u"?
    // Does "Sunnyvale" contain the String "nyv"?

    assertTrue(word1.contains(contains1));
  }

  @Test
  public void hamcrestAssertions() {
    assertThat(word1, containsString(contains1));
    assertThat(word1, both(containsString(contains1)).and(containsString("p")));
    assertThat(Arrays.asList("John", "Dan", "Tim"), hasItems("Dan", "Tim"));
    assertThat(Arrays.asList("aardvark", "apple", "alpha"),
               everyItem(startsWith("a")));
  }
}
