package junitTests;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;

@Suite.SuiteClasses({JunitTests.class, Junit5Tests.class})
@RunWith(Suite.class)
public class SuiteClasses {
}
