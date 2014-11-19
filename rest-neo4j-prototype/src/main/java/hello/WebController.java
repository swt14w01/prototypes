package hello;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.neo4j.core.GraphDatabase;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.neo4j.graphdb.Transaction;

@Controller
public class WebController extends WebMvcConfigurerAdapter {
	
	@Autowired
	public PersonRepository perrepo;
	
	@Autowired
    public GraphDatabase graphDatabase;
	

    @Override
    public void addViewControllers(ViewControllerRegistry registry) {
        registry.addViewController("/results").setViewName("results");
    }

    @RequestMapping(value="/", method=RequestMethod.GET)
    public String showForm(Person person) {
        return "form";
    }
    
    @RequestMapping(value="/content", method=RequestMethod.GET)
    public String showAll() {
    	String str = "";
    	for(Person pers : perrepo.findAll())
    	{str = str + pers.getName();}
        return "content";
    }

    @RequestMapping(value="/", method=RequestMethod.POST)
    public String checkPersonInfo(@Valid Person person, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return "form";
        }
        Transaction tx = graphDatabase.beginTx();
        try {
        perrepo.save(person);
        tx.success();
        } finally {
            tx.close();
        }
        
        return "redirect:/results";
      
    }

}