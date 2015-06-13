package org.gochev;

import java.util.List;

import org.gochev.model.Submission;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

@Repository(value = SubmissionRepository.NAME)
public interface SubmissionRepository extends PagingAndSortingRepository<Submission, Long> {

	String NAME = "submissionRepository";

	List<Submission> findByTitleLike(String title);
}
