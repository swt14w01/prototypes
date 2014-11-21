package jrmds;

import javax.validation.Valid;

import org.neo4j.graphdb.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

@Controller
public class WebController extends WebMvcConfigurerAdapter {
	
	@Autowired
	public PersonRepository perrepo;

    @Override
    public void addViewControllers(ViewControllerRegistry registry) {
        registry.addViewController("/results").setViewName("results");
    }

    

    
    @RequestMapping(value="/hello", method=RequestMethod.GET)
    public String showForm(Person person) {
        return "index2";
    }
    
    
   
    /*@RequestMapping(value = "/guests", method = RequestMethod.GET)
    public String showGuestList(Model model) {
    	List<Person> personsList = new ArrayList<Person>();
    	for(Person pers: perrepo.findAll()){
    		personsList.add(pers);
    	}
    model.addAttribute("guests", personsList);
    return "content :: resultsList";
    }*/
    
    /*
    @RequestMapping(value = "/content", method = RequestMethod.GET)
    public ModelAndView persons() {
        ModelAndView mav = new ModelAndView("personlist");
        List<Person> personsList = new ArrayList<Person>();
    	for(Person person: perrepo.findAll()){
    		personsList.add(person);
    	}
        mav.addObject("personslist", personsList);
        return mav;
    }*/

    @RequestMapping(value="/hello", method=RequestMethod.POST)
    public String checkPersonInfo(@Valid Person person, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return "form";
        }
        Transaction tx = Application.repo.beginTx();
        try {
        perrepo.save(person);
        System.out.println(person.getName());
        tx.success();
        } finally {
            tx.close();
        }
        
        return "redirect:/results";
      
    }

}