package org.gochev;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;


@Controller
public class HomeController {
    
   @RequestMapping(value = "/home2", method = RequestMethod.GET)
   public String index(ModelMap map) {
       map.put("msg", "Hello Spring 4 Web MVC!");
       map.put("test","test 1-2-3");
       return "index";
   }
   
   @ResponseBody
   @RequestMapping(value = "/get2", method = RequestMethod.GET)
   public String whatever(){
	   return "Wohoo hello string";
   }
   
}