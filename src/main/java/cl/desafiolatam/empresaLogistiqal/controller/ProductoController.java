package cl.desafiolatam.empresaLogistiqal.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import cl.desafiolatam.empresaLogistiqal.model.Producto;
import cl.desafiolatam.empresaLogistiqal.service.ProductoService;
import cl.desafiolatam.empresaLogistiqal.util.Util;
import cl.desafiolatam.empresaLogistiqal.vo.ProductoVO;

@Controller
public class ProductoController {

	private static final Logger log = LoggerFactory.getLogger(ProductoController.class);
	@Autowired
	private ProductoService service;
	Util util;
	
	@GetMapping({ "/", "/home" })
	public String home(Model model, @RequestParam(defaultValue = "1") Integer
			p) {
	//	model.addAttribute("VO", service.getAllProductos());
		Integer totalPaginas = (int) service.getPageCount(6).getValor();
		model.addAttribute("paginas", Util.getArregloPaginas(p, totalPaginas));
		model.addAttribute("paginaActual", p);
		model.addAttribute("VO", service.getPage(p-1, 6));
		return "home";
	}

	@GetMapping("/editarForm")
	public ModelAndView editarForm(Model model, @RequestParam Integer codigo, RedirectAttributes ra) {
		ProductoVO respuestaServicio = new ProductoVO();
		respuestaServicio.setMensaje("No se pudo cargar la vista de edición, intente nuevamente.");
		try {
			respuestaServicio = service.findByCodigo(codigo);
			model.addAttribute("mensaje", respuestaServicio.getMensaje());
			model.addAttribute("VO", respuestaServicio.getProductos().get(0));
			return new ModelAndView("editar");
		} catch (Exception e) {
			log.error("Error en ProductoController editar", e);
		}
		ra.addFlashAttribute("mensaje", respuestaServicio.getMensaje());
		respuestaServicio = service.getAllProductos();
		return new ModelAndView("redirect:/home");
	}
	
	@PostMapping("/editar")
	public ModelAndView editar(@ModelAttribute Producto producto, RedirectAttributes ra) {
		ProductoVO respuestaServicio = service.update(producto);
		ra.addFlashAttribute("mensaje", respuestaServicio.getMensaje());
		if (respuestaServicio.getCodigo().equals("0")) {
			return new ModelAndView("redirect:/home");
		} else {
			return new ModelAndView("redirect:/editarForm");
		}
	}

	@GetMapping("/agregarForm")
	public String agregarForm(Model model) {
		return "agregar";
	}

	@PostMapping("/agregar")
	public ModelAndView agregarSubmit(@ModelAttribute Producto producto, RedirectAttributes ra) {
		ProductoVO respuestaServicio = service.add(producto);
		ra.addFlashAttribute("mensaje", respuestaServicio.getMensaje());
		if (respuestaServicio.getCodigo().equals("0")) {
			return new ModelAndView("redirect:/home");
		} else {
			return new ModelAndView("redirect:/agregarForm");
		}
	}
	
	@GetMapping("/eliminar")
	public ModelAndView eliminar(Model model, @RequestParam Integer codigo, RedirectAttributes ra) {
		ProductoVO respuestaServicio = new ProductoVO();
		respuestaServicio.setMensaje("No se pudo eliminar al producto, intente nuevamente.");
		try {
			Producto eliminado = new Producto();
			eliminado.setCodigo(codigo);
			respuestaServicio = service.delete(eliminado);
			ra.addFlashAttribute("mensaje", respuestaServicio.getMensaje());
			return new ModelAndView("redirect:/home");
		} catch (Exception e) {
			log.error("Error en ProductoController eliminar", e);
		}
		ra.addFlashAttribute("mensaje", respuestaServicio.getMensaje());
		respuestaServicio = service.getAllProductos();
		ra.addAttribute("VO", respuestaServicio);
		return new ModelAndView("redirect:/home");
	}


}
