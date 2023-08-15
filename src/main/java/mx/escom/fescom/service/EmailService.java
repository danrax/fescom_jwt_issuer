package mx.escom.fescom.service;

import mx.escom.fescom.entities.Candidate;
import mx.escom.fescom.entities.JobApplication;

public interface EmailService {

    void sendJobApplicationEmail(JobApplication jobApplication);
}
