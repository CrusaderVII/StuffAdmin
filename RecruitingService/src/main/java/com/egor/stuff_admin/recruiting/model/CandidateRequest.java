package com.egor.stuff_admin.recruiting.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter @Setter @AllArgsConstructor
public class CandidateRequest implements Comparable<CandidateRequest> {
    public String department;
    public int priority;

    @Override
    public int compareTo(CandidateRequest o) {
        return Integer.compare(this.priority, o.getPriority());
    }
}
