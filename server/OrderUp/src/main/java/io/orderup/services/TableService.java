package io.orderup.services;

import io.orderup.repositories.TableRepository;
import org.springframework.beans.factory.annotation.Autowired;

import javax.transaction.Transactional;

public class TableService {

    @Autowired
    private TableRepository tableRepository;
    private io.orderup.models.Table table;

    public static void save(String tableNumber) {
    }

    public static void deleteTable(String id) {
    }

    @Transactional
	public void searchById(Long id)  {
     tableRepository.getById(id);
	}
}
