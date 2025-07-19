package com.poll.pollApplication.controller;

import com.poll.pollApplication.model.Poll;
import com.poll.pollApplication.service.PollService;
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
}
