package com.poll.pollApplication.controller;

import com.poll.pollApplication.model.Poll;
import com.poll.pollApplication.service.PollService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/polls")
public class PollController {

    private final PollService pollService;

    public PollController(PollService pollService) {
        this.pollService = pollService;
    }

    @PostMapping
    public Poll createPoll(@RequestBody Poll poll){
        return pollService.createPoll(poll);
    }

    @GetMapping("/getAllPolls")
    public List<Poll> getPolls(){
        return pollService.getPolls();
    }

    @GetMapping("/{id}/getPoll")
    public ResponseEntity<Poll> getPollByID(@PathVariable Long id){
        return pollService.getPollByID(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }
}
