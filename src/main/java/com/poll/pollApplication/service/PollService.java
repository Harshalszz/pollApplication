package com.poll.pollApplication.service;

import com.poll.pollApplication.model.Poll;
import com.poll.pollApplication.repository.PollRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PollService {

    private final PollRepository pollRepository;

    public PollService(PollRepository pollRepository) {
        this.pollRepository = pollRepository;
    }

    public Poll createPoll(Poll poll){
        return pollRepository.save(poll);
    }

    public List<Poll> getPolls() {
        return pollRepository.findAll();
    }

    public Optional<Poll> getPollByID(Long id) {
        return pollRepository.findById(id);
    }
}
