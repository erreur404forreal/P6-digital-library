package org.cereme.webapp.controller;
import org.cereme.digital.library.clientws.WorkWeb;
import org.cereme.digital.library.clientws.WorkWs;

import org.cereme.business.services.contracts.WorkService;
import org.cereme.model.Work;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.DispatcherServlet;
import org.springframework.web.servlet.ModelAndView;

import java.io.IOException;
import java.util.List;



@Controller
public class WorkController {

	@Autowired
	WorkService workService;

	@RequestMapping(value = "/searchwork", method = RequestMethod.GET)
	public ModelAndView View(DispatcherServlet request) throws IOException {

		ModelAndView modelAndView = new ModelAndView("work/searchworks");

		return modelAndView;
	}

	@RequestMapping(value = "/work/workinformations/{worksId}", method = RequestMethod.GET)
	public ModelAndView ViewworkInfo(@PathVariable Integer worksId) {

		WorkWeb workWeb = new WorkWeb();
		WorkWs workWs = workWeb.getWorkWsPort();
		workWs.init();

		ModelAndView modelAndView = new ModelAndView("work/workinformations");
		org.cereme.digital.library.clientws.Work work = workWs.findWorksById(worksId);
		modelAndView.addObject("work", work);

		return modelAndView;
	}


	@RequestMapping(value = "/library/author/{author}", method = RequestMethod.GET)
	public @ResponseBody
    List<org.cereme.digital.library.clientws.Work> getWorkByAuthor(@PathVariable String author) {

		WorkWeb workWeb = new WorkWeb();
		WorkWs workWs = workWeb.getWorkWsPort();
		workWs.init();

		List<org.cereme.digital.library.clientws.Work> workList = workWs.findWorkByAuthor(author);
		for(org.cereme.digital.library.clientws.Work work : workList)
		{
			System.out.println("Titre : " + work.getTitle());
			System.out.println("Auteur : " + work.getAuthor());
			System.out.println("Description du livre : " + work.getBookDescription());
		}
		return workList;

	}


	@RequestMapping(value = "/work/search", method = RequestMethod.GET)
	public ModelAndView searchbyauthorlikeafter(@RequestParam("author") String author, @RequestParam("title") String title) {
		System.out.println("searching by author");

		WorkWeb workWeb = new WorkWeb();
		WorkWs workWs = workWeb.getWorkWsPort();
		workWs.init();
		List<org.cereme.digital.library.clientws.Work> workList = workWs.findWorkByAuthorContainsAndTitleContains(author,title);

			ModelAndView modelAndView = new ModelAndView("work/searchedwork");
				modelAndView.addObject("workList", workList);

		return modelAndView;
	}


}
