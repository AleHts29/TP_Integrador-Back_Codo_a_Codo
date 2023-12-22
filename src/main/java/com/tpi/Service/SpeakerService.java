package com.tpi.Service;

import com.tpi.Exceptions.BadRequestException;
import com.tpi.Model.Speaker;
import com.tpi.Repository.SpeakerRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class SpeakerService {
    private final SpeakerRepository speakerRepository;

    public Speaker SaveSpeaker(Speaker speaker){
        return speakerRepository.save(speaker);
    }

    public List<Speaker> ListAllSpeaker(){
        return speakerRepository.findAll();
    }


    public Speaker FindUserByID(Long id) throws BadRequestException {
        Optional<Speaker> speaker = speakerRepository.findById(id);
        if (speaker.isPresent()){
            return speakerRepository.findById(id).get();
        }else{
            throw new BadRequestException("This speaker doesn't exist");
        }
    }

    public void DeleteByID(Long id) throws BadRequestException {
        Optional<Speaker> speaker = speakerRepository.findById(id);
        if (speaker.isPresent()) {
            speakerRepository.delete(speaker.get());
        } else {
            throw new BadRequestException("This speaker can't be deleted since it doesn't exist");
        }
    }
}
