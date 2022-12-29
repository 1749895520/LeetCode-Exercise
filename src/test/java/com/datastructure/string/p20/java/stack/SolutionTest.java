package com.datastructure.string.p20.java.stack;

import org.junit.Test;

public class SolutionTest {
    @Test
    public void test() {
        Solution solution = new Solution();
        boolean valid = solution.isValid("()[]{}");
        System.out.println(valid);
    }
}
