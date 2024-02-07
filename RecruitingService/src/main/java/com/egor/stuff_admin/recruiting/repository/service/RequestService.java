package com.egor.stuff_admin.recruiting.repository.service;

import com.egor.stuff_admin.recruiting.model.Candidate;
import com.egor.stuff_admin.recruiting.model.CandidateRequest;
import com.egor.stuff_admin.recruiting.repository.RequestRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RequestService {

    @Autowired
    RequestRepository requestRepository;

    public CandidateRequest getRequest(long id) {
        return requestRepository.getReferenceById(id);
    }

    public CandidateRequest saveRequest(CandidateRequest request) {
        return requestRepository.save(request);
    }

    public void deleteRequest (long id) {
        requestRepository.deleteById(id);
    }

    public List<CandidateRequest> getRequestsInOrder (String department) {
        return requestRepository.findRequests(department);
    }
}
