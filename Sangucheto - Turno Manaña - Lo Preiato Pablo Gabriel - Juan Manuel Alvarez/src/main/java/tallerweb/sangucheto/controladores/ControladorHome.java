package tallerweb.sangucheto.controladores;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class ControladorHome {

	@RequestMapping(path = "/")
	public ModelAndView irAHome() {
		return new ModelAndView("home");
	}
}
