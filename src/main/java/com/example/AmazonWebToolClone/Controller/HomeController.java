package com.example.AmazonWebToolClone.Controller;


import java.util.List;
import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.MailSender;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.example.AmazonWebToolClone.entities.UserAccounts;
import com.example.AmazonWebToolClone.service.NewAccountService;

import jakarta.servlet.http.HttpSession;
import org.springframework.ui.Model;



@Controller
public class HomeController {
	   @Autowired
       public NewAccountService ns;
	   
	   @Autowired
	   public JavaMailSender mailSender;
	   
	   String code;
	   
	   @Autowired
	   public HttpSession session;
	   
	@GetMapping("/")
	public String homepage() {
		return "signinpage";
	}
	
	@GetMapping("/createaccount")
	public String newaccount() {
		return "createaccount";
	}
	
	@GetMapping("/verifyredirect")
	public String Verificationpageredirect() {
		return "Verificationpage";
	}
	
	@PostMapping("/doverification")
	public String saveaccount(@ModelAttribute UserAccounts saveacc,Model model,RedirectAttributes redirectattributes) {
		
		String returnwhat = "createaccount" ;
		try {
		String receivedemail = saveacc.getEmail();
		System.out.println("Email received from frontend "+saveacc.getEmail());
		String sendingemailindb = ns.findByEmail(saveacc.getEmail());
		System.out.println("Sending email : "+ sendingemailindb);
		if(saveacc.getEmail().isEmpty() || saveacc.getMobile().isEmpty() || saveacc.getPassword().isEmpty()) {
			redirectattributes.addFlashAttribute("addalldetailsmessage", "Please enter all the details");
			returnwhat="redirect:/createaccount";
		}
		else if(saveacc.getEmail()!=null && !saveacc.getEmail().isEmpty() && sendingemailindb==null ) {
		Random random = new Random();
		code = Integer.toString(10000+ random.nextInt(900000));
		SimpleMailMessage message = new SimpleMailMessage();
		message.setTo(saveacc.getEmail());
		message.setSubject("Your Verification code");
		message.setText("Your verification code is: "+code);
		mailSender.send(message);
		
		session.setAttribute("newaccount", saveacc);
		returnwhat= "Verificationpage";
		}
		else if(sendingemailindb!=null){
			//model.addAttribute("addnewemailmessage", "Email already exists, use another email");
			redirectattributes.addFlashAttribute("addnewemailmessage", "Email already exists, use another email");
			returnwhat="redirect:/createaccount";
			
		}
		else if(receivedemail.isEmpty()){
			//model.addAttribute("addnewemailmessage", "Please enter email");
			redirectattributes.addFlashAttribute("addnewemailmessage", "Please enter email");
			returnwhat="redirect:/createaccount";
			
		}
		}
		catch(Exception e) {
			System.out.println(e);
			redirectattributes.addFlashAttribute("addnewemailmessage", "Please enter valid email");
			returnwhat="redirect:/createaccount";
			
		}
		return returnwhat;
	}
	
	@PostMapping("/authenticate")
	public String authenticateuser(@RequestParam("enter_code") String enteredcode,Model model,RedirectAttributes redirectattributes) {
		String returnwhat;
		if(enteredcode.equals(code)) {
			ns.saveaccount((UserAccounts)session.getAttribute("newaccount"));
			redirectattributes.addFlashAttribute("success","Your verification is successful!!Now login with your credentials");
			
			returnwhat = "redirect:/";
		}
		else {
			redirectattributes.addFlashAttribute("error","Incorrect Verification code");
			returnwhat ="redirect:/verifyredirect";
		}
		return returnwhat;
		
	}
	
	@PostMapping("/shoppingpage")
	public String doshopping(@RequestParam("email_mobile") String emailormobile,@RequestParam("password")String entered_password) {
		String password_fromdb= null;
		String email = "";
		String mobile="";
		String returnwhat ="";
		if(emailormobile.contains("@")) {
			 email = ns.findByEmail(emailormobile);
			 if(email!=null) {
				password_fromdb= ns.findPasswordByEmail(email);
			 }
			 else {
				 returnwhat = "signinpage";
			 }
		}
		else {
			mobile =ns.findByMobile(emailormobile);
			if(mobile!=null) {
				password_fromdb= ns.findPasswordByMobile(mobile);
			}
			else {
				 returnwhat = "signinpage";
			 }
		}
		if(password_fromdb!=null && password_fromdb.equals(entered_password)) {
			
			returnwhat = "Shoppingpage";
		}
		
		return returnwhat;
	}
	
}
