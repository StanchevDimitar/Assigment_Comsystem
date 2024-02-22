package com.comsystem.homework.rest;

import com.comsystem.homework.model.RobotPlan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.ErrorResponseException;
import org.springframework.web.bind.annotation.*;
import com.comsystem.homework.robot.RobotOperations;

@RestController()
@RequestMapping("/api/v1/robot/operation")
public final class RobotRestController {

    private final RobotOperations robotOperations;

    @Autowired
    public RobotRestController(RobotOperations robotOperations) {
        this.robotOperations = robotOperations;
    }

    /**
     * This method exposes the functionality of {@link RobotOperations#excavateStonesForDays(int)} via HTTP
     */
    @PostMapping("/excavation")
    public ResponseEntity<RobotPlan> excavateStones(@RequestBody Integer numberOfDays) {
        RobotPlan robotPlan;
        try {
            robotPlan = robotOperations.excavateStonesForDays(numberOfDays);
        }catch (Exception e){
            return ResponseEntity.badRequest().build();
        }

        return ResponseEntity.ok(robotPlan);
    }

    /**
     * This method exposes the functionality of {@link RobotOperations#daysRequiredToCollectStones(int)} via HTTP
     */
    @PostMapping("/approximation")
    public ResponseEntity<RobotPlan> approximateDays(@RequestBody Integer numberOfStones) {
        RobotPlan robotPlan;
        try {
            robotPlan = robotOperations.daysRequiredToCollectStones(numberOfStones);
        }catch (Exception e){
            return ResponseEntity.badRequest().build();
        }

        return ResponseEntity.ok(robotPlan);
    }

}
