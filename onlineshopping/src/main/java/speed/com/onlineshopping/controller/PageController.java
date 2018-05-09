package speed.com.onlineshopping.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class PageController {
	static {
		System.out.println("Hello");
	}

	@RequestMapping(value = { "/", "/home", "/index" })
	public ModelAndView index() {

		ModelAndView mv = new ModelAndView("page");
		mv.addObject("greeting", "welcome to spring web mvc");
		return mv;

	}
/*using @RequestParam
	@RequestMapping(value="/test")
	public ModelAndView test(@RequestParam("greeting")String greeting) { //pass the key and value by url

	public ModelAndView test(@RequestParam(value="greeting",required=false)String greeting) {//pass the default value 
	
		if(greeting == null) {
			
			greeting ="hello there";
	}
		
		ModelAndView mv = new ModelAndView("page");
		mv.addObject("greeting", greeting);
		return mv;

	}
	*/
	
	/*using @PathVariable*/
	@RequestMapping(value="/test/{greeting}")
	public ModelAndView test(@PathVariable("greeting")String greeting) { //access the only value by url/path

	
	
		if(greeting == null) {
			
			greeting ="hello there";
	}
		
		ModelAndView mv = new ModelAndView("page");
		mv.addObject("greeting", greeting);
		return mv;

	}
}