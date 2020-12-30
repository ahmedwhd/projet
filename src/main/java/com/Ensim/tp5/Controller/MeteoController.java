package com.Ensim.tp5.Controller;

import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.client.RestTemplate;

import com.Ensim.tp5.Model.AddressData;
import com.Ensim.tp5.Model.MeteoModel;
import com.Ensim.tp5.Model.Welcome;

@Controller
public class MeteoController {

	@GetMapping("/meteo")
	public String meteo(@RequestParam(name = "adresse", defaultValue = "57 boulevard demorieux") String adresse,
			Model model) {
		model.addAttribute("adresserecup", adresse);
		RestTemplate restTemplate = new RestTemplate();
		String fooResourceUrl = String.format("%s?q=%s", "https://api-adresse.data.gouv.fr/search/", adresse);
		ResponseEntity<Welcome> response = restTemplate.getForEntity(fooResourceUrl, Welcome.class);

		return "meteo";
	}

	@PostMapping("/meteo")
	public String getAdress(@RequestParam(name = "adresse", defaultValue = "57 boulevard demorieux") String adresse,
			Model model) {
		model.addAttribute("adresserecup", adresse);

		String urlCoord = "https://api-adresse.data.gouv.fr/search/?q=" + adresse;
		RestTemplate restTemplate = new RestTemplateBuilder().build();
		AddressData answerUrl = restTemplate.getForObject(urlCoord, AddressData.class);

		if (answerUrl.getFeatures().size() > 0) { // i.e. Address found

			Double lon = answerUrl.getLon();
			Double lat = answerUrl.getLat();
			model.addAttribute("longitude", lon);
			model.addAttribute("latitude", lat);
			String adresseAPI = answerUrl.getAddress();

			// Get weather from coordinates
			String apiKey = "09e9d9c9da2b3a148b78afe80d9fc47d";
			String urlmeteo = "https://api.openweathermap.org/data/2.5/weather?lat=" + lat + "&lon=" + lon + "&appid="
					+ apiKey + "&units=metric";
			MeteoModel answermeteo = restTemplate.getForObject(urlmeteo, MeteoModel.class);
			String Temperature = answermeteo.getActualTemperature();

			String forecast = answermeteo.getForecast();

			model.addAttribute("Temp", Temperature);
			model.addAttribute("address", adresseAPI);
			model.addAttribute("forecast", forecast);
		} else {
			model.addAttribute("error", "Address not found");
		}

		return "meteo";

	}

}
