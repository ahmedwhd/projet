package com.Ensim.tp5.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.Ensim.tp5.Model.Address;
import com.Ensim.tp5.Model.AddressRepository;

@Controller
public class AddressController {

	@Autowired
	AddressRepository addressRepository;

	@GetMapping("/adresses")
	public String showAddresses(Model model) {
		model.addAttribute("allAddresses", addressRepository.findAll());
		return "addresses";
	}

	public List<Address> showAddresses1(Model model) {
		model.addAttribute("allAddresses", addressRepository.findAll());

		return (List<Address>) addressRepository.findAll();
	}
}
