package io.orderup.services;

import io.orderup.models.Table;
import io.orderup.repositories.TableRepository;

import javax.transaction.Transactional;

public class TableService {

    public static void save(String tableNumber) {
    }

    public static void deleteTable(String id) {
    }

    @Transactional
	public Table searchById(Long id)  {
     TableRepository.getById(id);
	} 
}
