package com.egor.stuff_admin.recruiting.controller;

import com.egor.stuff_admin.recruiting.model.Candidate;
import com.egor.stuff_admin.recruiting.model.CandidateRequest;
import com.egor.stuff_admin.recruiting.repository.service.CandidateService;
import com.egor.stuff_admin.recruiting.repository.service.MailService;
import com.egor.stuff_admin.recruiting.repository.service.RequestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.sql.Timestamp;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;

@RestController
@RequestMapping("stuff-admin/api/v1/recruit")
public class CandidateController {

    @Autowired
    CandidateService candidateService;
    @Autowired
    RequestService requestService;
    @Autowired
    MailService mailService;

    @GetMapping("/candidate/get/{candidateId}")
    public Candidate getCandidateById (@PathVariable long candidateId) {
        Candidate candidate = candidateService.getCandidateById(candidateId);
        return candidate;
    }

    @PostMapping("/candidate/save")
    public Candidate saveCandidate(@RequestBody Candidate candidate) {
        List<CandidateRequest> requests = requestService.getRequestsInOrder(candidate.getDepartment());

        if (requests.size() != 0) {
            //because in database there are non-existed emails, I don't want to send email notification
            //mailService.sendMessage(candidate, requests.size());
        }

        return candidateService.saveCandidate(candidate);
    }

    @DeleteMapping("/candidate/delete/{candidateId}")
    public void deleteCandidate(@PathVariable long candidateId) {
        Candidate candidate = candidateService.getCandidateById(candidateId);
        candidateService.deleteCandidate(candidate);
    }

    @PostMapping("/requirement/save")
    public List<Candidate> getEmployeeRequirement(@RequestParam String department, @RequestParam int priority) {
        List<Candidate> candidates = candidateService.getCandidateByDepartment(department);
        if (candidates.size()==0) {
            Date date = new Date();
            CandidateRequest request = new CandidateRequest(department,
                    priority,
                    new Timestamp(date.getTime()));

            requestService.saveRequest(request);
        } else {
            //because in database there are non-existed emails, I don't want to send email notification
            //mailService.sendMessage(candidates);
        }
        return candidates;
    }
}
