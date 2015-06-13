package org.gochev;

import javax.validation.Valid;
import javax.websocket.server.PathParam;

import org.gochev.model.SessionLevel;
import org.gochev.model.Submission;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
public class SampleController {

	@RequestMapping("/")
	@ResponseBody
	String home() {
		return "Hello World!";
	}

	//
	// @ModelAttribute("submission")
	// public Submission getModel(){
	// return new Submission();
	// }

	@Autowired
	private SubmissionRepository submissionRepository;

	@RequestMapping(value = "/view", method = RequestMethod.GET)
	public String view(Model model) {
		model.addAttribute("submission", new Submission());
		model.addAttribute("levels", SessionLevel.values());
		return "register.jsp";
	}

	@RequestMapping(value = "/submit", method = RequestMethod.POST)
	public String submit(@Valid Submission submission,
			BindingResult bindingResult, Model model, RedirectAttributes redirectAttributes) {
		if (bindingResult.hasErrors()) {
			return "register.jsp";
		}
		submissionRepository.save(submission);
		redirectAttributes.addFlashAttribute("submissionTitle", submission.getTitle());
		return "redirect:/done";
	}

	@RequestMapping(value = "/done", method = RequestMethod.GET)
	public String done() {
		return "done.jsp";
	}
	
	@ResponseBody
	@RequestMapping(value = "/getSubmission", method = RequestMethod.GET)
	public Submission getSubmission(@RequestParam Long id){
		return submissionRepository.findOne(id);
	}
	
	@ResponseBody
	@RequestMapping(value = "/getSubmissionPath/{id}", method = RequestMethod.GET)
	public Submission getSubmissionPath(@PathVariable Long id){
		return submissionRepository.findOne(id);
	}
}