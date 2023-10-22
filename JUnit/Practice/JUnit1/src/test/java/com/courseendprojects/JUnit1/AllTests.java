package com.courseendprojects.JUnit1;

import org.junit.platform.suite.api.SelectClasses;
import org.junit.platform.suite.api.Suite;

@Suite
@SelectClasses({ AppTest.class, CalculateTest.class, CheckerTest.class, SpeedTest.class })
public class AllTests {

}
