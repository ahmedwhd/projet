package com.Ensim.tp5.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class FormController {

	@GetMapping("/formulaire")
	public String formulaire(@RequestParam(name = "adresse", defaultValue = "World") String adresseform, Model model) {
		model.addAttribute("adresse", adresseform);
		// return "Un exemple de produit";
		return "formulaire";
	}

}
