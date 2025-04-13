package net.codejava;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class AppController {

	@Autowired
	private UserRepository userRepo;
	
	@GetMapping("")
	public String viewHomePage() {
		return "index";
	}
	
	 @GetMapping("/Home")
	    public String page2() {
	        return "Home";
	    }
	 @GetMapping("/dance")
	    public String page20() {
	        return "dance";
	    }
	 @GetMapping("/About_Me")
	    public String page3() {
	        return "About_Me";
	    }
	 @GetMapping("/Famous_Dancers")
	    public String page4() {
	        return "Famous_Dancers";
	    }
	 @GetMapping("/Famous_Choregraphers")
	    public String page5() {
	        return "Famous_Choregraphers";
	    }
	 @GetMapping("/Types of Dances")
	    public String page6() {
	        return "Types of Dances";
	    }
	 @GetMapping("/Bharatanatyam")
	    public String page7() {
	        return "Bharatanatyam";
	    } @GetMapping("/Kathak")
	    public String page8() {
	        return "Kathak";
	    } @GetMapping("/Kuchipudi")
	    public String page9() {
	        return "Kuchipudi";
	    } @GetMapping("/Odissi")
	    public String page10() {
	        return "Odissi";
	    } @GetMapping("/Manipuri")
	    public String page11() {
	        return "Manipuri";
	    } @GetMapping("/Kathakali")
	    public String page12() {
	        return "Kathakali";
	    } @GetMapping("/Mohiniyattam")
	    public String page13() {
	        return "Mohiniyattam";
	    }
	    @GetMapping("/Sattriya")
	    public String page14() {
	        return "Sattriya";
	    }@GetMapping("/Lavani")
	    public String page15() {
	        return "Lavani";
	    }@GetMapping("/Bihu")
	    public String page16() {
	        return "Bihu";
	    }@GetMapping("/Giddha")
	    public String page17() {
	        return "Giddha";
	    }@GetMapping("/Garba")
	    public String page18() {
	        return "Garba";
	    }
	@GetMapping("/register")
	public String showRegistrationForm(Model model) {
		model.addAttribute("user", new User());
		
		return "signup_form";
	}
	
	@PostMapping("/process_register")
	public String processRegister(User user) {
		BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
		String encodedPassword = passwordEncoder.encode(user.getPassword());
		user.setPassword(encodedPassword);
		
		userRepo.save(user);
		
		return "register_success";
	}
	
	@GetMapping("/users")
	public String listUsers(Model model) {
		List<User> listUsers = userRepo.findAll();
		model.addAttribute("listUsers", listUsers);
		
		return "users";
	}
}
