package com.poll.pollApplication.service;

import com.poll.pollApplication.model.OptionVote;
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

    public void vote(Long pollId, int optionIndex) {
        //Get poll from DB
        Poll poll = pollRepository.findById(pollId)
                .orElseThrow(() -> new RuntimeException("Poll not found"));

        // Get All options
        List<OptionVote> options = poll.getOptions();

        // If index for vote is not valid throw exception
        if(optionIndex <0 || optionIndex >= options.size()){
            throw new IllegalArgumentException("Invalid option Index");
        }


        // Get the selected option
        OptionVote selectedOption =  options.get(optionIndex);

        // increment vote for selected option
        selectedOption.setVoteCount(selectedOption.getVoteCount() +1);

        //save the incremented option into DB

        pollRepository.save(poll);
    }

    public void deletePoll(long pollId) {

        pollRepository.deleteById(pollId);
    }
}
