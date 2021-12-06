package io.orderup.controllers;

import io.orderup.services.TableService;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

public class TableController {

    @PostMapping("/saveTable")
	public String saveTable(RedirectAttributes redirectAt, @RequestParam String tableNumber){
		try{
			TableService.save(tableNumber);
			return "redirect:/";
		}catch(Error e) {
			redirectAt.addFlashAttribute("error", e.getMessage());
			return "redirect:/user/registerTable";
		}
	}
	
	@GetMapping("/delete")
	public String delete(@RequestParam String id) {
		TableService.deleteTable(id);
		return "redirect:/table/listTable";
	}
    
}
