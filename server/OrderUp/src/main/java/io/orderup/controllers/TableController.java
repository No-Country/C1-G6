package io.orderup.controllers;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

public class TableController {

    @PostMapping("/guardar")
	public String guardar(RedirectAttributes redirectAt, @RequestParam String tableNumber){
		try{
			TableService.save(tableNumber);
			return "redirect:/";
		}catch(Error e) {
			redirectAt.addFlashAttribute("error", e.getMessage());
			return "redirect:/user/registroTable";
		}
	}
	
	@GetMapping("/delete")
	public String delete(@RequestParam String id) {
		TableService.deleteTable(id);
		return "redirect:/table/listTable";
	}
    
}
