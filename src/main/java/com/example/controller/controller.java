package com.example.controller;
import com.example.Voting.*;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import com.example.Repository.*;

@Controller
public class controller {
	
	
	@Autowired
	private Repository repo;
	
	@Autowired
	private VRepository reppo;
	
	@GetMapping("/home")
	public String home()
	{
		return "home";
	}
	
	@GetMapping("/register")
	public String save()
	{
		
		return"register";
	}
	
	@GetMapping("/login")
	public String login()
	{
		
		return"login";
	}
	@GetMapping("/govern")
	public String govern()
	{
		
		return"govern";
	}
	@GetMapping("/voting")
	public String voting()
	{
		
		return"voting";
	}
	@GetMapping("/about")
	public String about()
	{
		
		return"about";
	}
	
	@PostMapping("/register")
	public String regi(@RequestParam("name") String name,@RequestParam("email") String email,@RequestParam("pass") String pass,Model model)
	{
		if(repo.findByName("name")!=null)
		{
			model.addAttribute("message","User Already Exists");
		}
		
			Vote user=new Vote();
			user.setName(name);
			user.setEmail(email);
			user.setPass(pass);
			repo.save(user);
     		return"redirect:/login";
		
	}
	
	@PostMapping("/login")
	public String logi(@RequestParam("name")String name,@RequestParam("pass")String pass,Model model)
	{
		Vote user=(Vote) repo.findByName(name);
		 if (user != null && user.getPass().equals(pass)) 
		{
			return "home";
		}
		model.addAttribute("message","User Not Found");
		return "login";
	}
	
	
	@PostMapping("/vote")
	public String vote(@RequestParam("name") String name, RedirectAttributes redirectAttributes) {
	    Optional<Voting> optionalUser = reppo.findByName(name);
	    
	    if (optionalUser.isPresent()) {
	        redirectAttributes.addFlashAttribute("message", "You  have already Voted.");
	    } else {
	        
	        Voting entity = new Voting();
	        entity.setName(name);
	        entity.setVote(1); 
	        reppo.save(entity);
	        
	        redirectAttributes.addFlashAttribute("message", "Your vote was successful.");
	    }

	    return "redirect:/voting";
	}


	@PostMapping("/vott")
	public String vott(@RequestParam("name") String name, RedirectAttributes redirectAttributes) {
	    
	    Optional<Voting> optionalUser = reppo.findByName(name);
	    
	    if (optionalUser.isPresent()) {
	   
	        redirectAttributes.addFlashAttribute("message", "You  have already Voted.");
	    } else {
	        Voting entity = new Voting();
	        entity.setName(name);
	        entity.setVott(1);
	     
	        reppo.save(entity);
	        redirectAttributes.addFlashAttribute("message", "Your vote was successful.");
	    }

	    return "redirect:/voting";
	}
	 @GetMapping("/result")
	    public String getVoteSummary(Model model) {
		 int totalVotes = reppo.countAllVotes();
		 int totalVote = reppo.countAllVoting(1);
	     model.addAttribute("totalVotes", totalVotes);
	     model.addAttribute("totalVote", totalVote);
	        return "result"; 
	    }

}
