package org.efjava;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.FixMethodOrder;
import org.junit.runner.OrderWith;
import org.junit.runner.manipulation.Alphanumeric;
import org.junit.runners.MethodSorters;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;

// @FixMethodOrder(MethodSorters.NAME_ASCENDING)
@OrderWith(Alphanumeric.class)
public class SharingResourcesTest {
  List<String> names;

  @BeforeClass
  static public void oneTimeSetup() {
    System.out.println("@BeforeClass: Runs only once for the class, before anything else");
  }

  @AfterClass
  static public void oneTimeTeardown() {
    System.out.println("@AfterClass: Runs only once for the class, after everything else");
  }

  @Before
  public void setUp() {
    names = new ArrayList<>();
    System.out.println("@Before: Runs before each test");
  }

  @After
  public void tearDown() {
    System.out.println("@After: Runs after a test has completed");
  }

  @Test
  public void testGamma() {
    System.out.println("testGamma");
    assertEquals(1, 1);
  }

  @Test
  public void testBeta() {
    System.out.println("testBeta");
    names.add("John");
    names.add("Dan");
    names.add("Tim");

  }

  @Test
  public void testAlpha() {
    System.out.println("testAlpha");
    assertEquals(1, 1);
  }

  @Test
  public void testDelta() {
    System.out.println("testDelta");
    assertEquals(1, 1);
  }

}
