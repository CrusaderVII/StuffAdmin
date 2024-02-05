package com.egor.stuff_admin.recruiting.repository.service;

import com.egor.stuff_admin.recruiting.model.Candidate;
import com.egor.stuff_admin.recruiting.repository.CandidateRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CandidateService {

    @Autowired
    CandidateRepository candidateRepository;

    public Candidate getCandidateById(Long id) {
        return candidateRepository.getReferenceById(id);
    }

    public Candidate saveCandidate (Candidate candidate) {
        return candidateRepository.save(candidate);
    }

    public void deleteCandidate (Candidate candidate) {
        candidateRepository.delete(candidate);
    }
}
