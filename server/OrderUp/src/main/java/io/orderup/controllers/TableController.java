package io.orderup.controllers;

import io.orderup.models.Table;
import io.orderup.services.TableService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/api")
public class TableController {

	@Autowired
	private TableService tableService;

    @PostMapping("/saveTable")
	public String saveTable(@RequestParam Table table){
			tableService.save(table);
			return "redirect:/";
		}
	
	@GetMapping("/delete")
	public String delete(@RequestParam long id) {
		tableService.deleteTable(id);
		return "redirect:/table/listTable";
	}
    
}
