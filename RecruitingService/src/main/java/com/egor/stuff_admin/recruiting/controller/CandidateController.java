package com.egor.stuff_admin.recruiting.controller;

import com.egor.stuff_admin.recruiting.model.Candidate;
import com.egor.stuff_admin.recruiting.repository.service.CandidateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("stuff-admin/api/v1/recruit")
public class CandidateController {

    @Autowired
    CandidateService candidateService;

    @GetMapping("/candidate/get/{candidateId}")
    public Candidate getCandidateById (@PathVariable long candidateId) {
        Candidate candidate = candidateService.getCandidateById(candidateId);
        return candidate;
    }

    @PostMapping("/candidate/save")
    public Candidate saveCandidate(@RequestBody Candidate candidate) {
        return candidateService.saveCandidate(candidate);
    }

    @DeleteMapping("/candidate/delete/{candidateId}")
    public void deleteCandidate(@PathVariable long candidateId) {
        Candidate candidate = candidateService.getCandidateById(candidateId);
        candidateService.deleteCandidate(candidate);
    }

    @GetMapping("/requirement")
    public List<Candidate> getEmployeeRequirement(@RequestParam String department) {
        List<Candidate> candidates = candidateService.getCandidateByDepartment(department);
        if (candidates==null) {
            //TODO: implement priority queue of the employee requirements
        } else {
            //TODO: implement email notification for each candidate about free position
        }
        return candidates;
    }
}
