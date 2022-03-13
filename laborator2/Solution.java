package com.company;

import java.util.Arrays;

/**
 * We consider the problem of assigning a room to each event such that the constraints are satisfied and the number of used rooms is as small as possible (if possible).
 */

public class Solution {

    private Room[] assignment;

    public Solution(Room[] assignment) {
        this.assignment = assignment;
    }

    public Room[] getAssignment() {
        return assignment;
    }

    @Override
    public String toString() {
        return "Solution{" +
                "assignment=" + Arrays.toString(assignment) +
                '}';
    }
}
