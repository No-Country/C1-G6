package io.orderup.services;


import io.OrderUp.models.Table;

import javax.transaction.Transactional;

public class TableService {

    public static void save(String tableNumber) {
    }

    public static void deleteTable(String id) {
    }

    @Transactional
	public Table buscarPorId(String id)  {
        return TableRepository.getById(id);
	} 
}
