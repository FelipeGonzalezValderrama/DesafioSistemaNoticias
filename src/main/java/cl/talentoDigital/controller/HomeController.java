package cl.talentoDigital.controller;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HomeController {
	private final static Logger logger = LoggerFactory.getLogger(HomeController.class);

	@RequestMapping("/")
	public String Main(Model modelo) {
		String nombre = "src/main/resources/static/noticias.txt";
		ArrayList<String> n = new ArrayList<String>();
		try {
			FileReader fr = new FileReader(nombre);
			BufferedReader br = new BufferedReader(fr);
			String data = br.readLine();
			while (data != null) {
			n.add(data);
			data = br.readLine();
			}
			br.close();
			fr.close();
			} catch (Exception e) {
			logger.error("Error leyendo el fichero "+ nombre + ": " + e);
			}
			modelo.addAttribute("noticia1",n.get(0));
			modelo.addAttribute("noticia2",n.get(1));
			modelo.addAttribute("noticia3",n.get(2));
			modelo.addAttribute("noticia4",n.get(3));
			modelo.addAttribute("noticia5",n.get(4));
			return "noticias";
		

	}
}
