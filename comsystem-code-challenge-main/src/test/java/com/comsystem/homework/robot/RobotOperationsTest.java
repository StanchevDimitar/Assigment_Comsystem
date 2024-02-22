package com.comsystem.homework.robot;

import com.comsystem.homework.model.RobotPlan;
import org.junit.jupiter.api.Test;

import java.security.InvalidParameterException;

import static org.junit.jupiter.api.Assertions.*;

public class RobotOperationsTest {

    @Test
    public void excavateStonesForDays_ValidInput_CorrectPlanReturned() {
        RobotOperations robotOperations = new RobotOperations();
        int days = 5;
        int expectedNumberOfStones = 16;
        RobotPlan plan = robotOperations.excavateStonesForDays(days);

        assertEquals(days, plan.numberOfDays());
        assertEquals(plan.numberOfStones(), expectedNumberOfStones);
        assertNotNull(plan.robotActions());
        assertFalse(plan.robotActions().isEmpty());
        assertEquals(plan.robotActions().size(), days);
    }

    @Test
    public void excavateStonesForDays_InvalidInput_ExceptionThrown() {
        RobotOperations robotOperations = new RobotOperations();
        int invalidDays = 0;

        assertThrows(InvalidParameterException.class, () -> {
            robotOperations.excavateStonesForDays(invalidDays);
        });
    }


    @Test
    public void daysRequiredToCollectStones_receive_Valid_Input() {
        int numberOfStones = 5;
        int expectedNumberOfDays = 4;
        RobotOperations robotOperations = new RobotOperations();
        RobotPlan plan = robotOperations.daysRequiredToCollectStones(numberOfStones);

        assertTrue(plan.numberOfDays() > 0);
        assertEquals(plan.numberOfDays(), expectedNumberOfDays);
        assertNotNull(plan.robotActions());
        assertFalse(plan.robotActions().isEmpty());
        assertEquals(plan.robotActions().size(), plan.numberOfDays());
    }

    @Test
    public void daysRequiredToCollectStones_InvalidInput_ExceptionThrown() {
        RobotOperations robotOperations = new RobotOperations();
        int invalidStones = 0;

        assertThrows(InvalidParameterException.class, () -> {
            robotOperations.daysRequiredToCollectStones(invalidStones);
        });
    }
}
