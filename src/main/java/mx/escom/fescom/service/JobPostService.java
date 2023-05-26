package mx.escom.fescom.service;

import mx.escom.fescom.entities.JobPost;

public interface JobPostService {

    JobPost getJobPostByVacancyId(Long vacancyId);
}
