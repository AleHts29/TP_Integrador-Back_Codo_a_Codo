package com.tpi.Controllers;

import com.tpi.Exceptions.BadRequestException;
import com.tpi.Model.Speaker;
import com.tpi.Service.SpeakerService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
@CrossOrigin(origins = "*")
@RequestMapping("/speaker")
public class SpeakerController {
    private SpeakerService speakerService;

    @GetMapping("/listall")
    public ResponseEntity<List<Speaker>> listAll(){
        return ResponseEntity.status(HttpStatus.FOUND).body(speakerService.ListAllSpeaker());
    }
    @PostMapping("/save")
    public ResponseEntity<Speaker> saveSpeaker(@RequestBody Speaker speaker){
        return ResponseEntity.status(HttpStatus.CREATED).body(speakerService.SaveSpeaker(speaker));
    }
    @GetMapping("/id/{id}")
    public ResponseEntity<Speaker> getSpeakerById(@PathVariable Long id) throws BadRequestException {
        return ResponseEntity.status(HttpStatus.FOUND).body(speakerService.FindUserByID(id));
    }
    @DeleteMapping("/id/{id}")
    public ResponseEntity<HttpStatus> deleteSpeaker(@PathVariable Long id) throws BadRequestException {
        speakerService.DeleteByID(id);
        return ResponseEntity.ok(HttpStatus.NO_CONTENT);
    }
}
