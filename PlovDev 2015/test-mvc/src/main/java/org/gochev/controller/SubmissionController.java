package org.gochev.controller;

import org.gochev.entity.Submission;
import org.gochev.repository.SubmissionRepository;

import javax.inject.Inject;
import javax.mvc.Models;
import javax.mvc.annotation.Controller;
import javax.ws.rs.BeanParam;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;

/**
 * Created by gochev on 10/6/15.
 */

@Controller
@Path("submission")
public class SubmissionController {

    @Inject
    private SubmissionRepository submissionRepository;

    @Inject
    Models models;

    @GET
    public String viewSubmission() {
        return "/submission.jsp";
    }

    @POST
    public String saveSubmission( @BeanParam Submission submission) {
        Submission saved = submissionRepository.save(submission);
        models.put("savedSubmission", saved);
        return "/done.jsp";
    }

}
