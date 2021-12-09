package io.orderup.services;

import io.orderup.models.Table;
import io.orderup.repositories.TableRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TableService {

    @Autowired
    private TableRepository tableRepository;

    public void save(Table table) {
        tableRepository.save(table);
    }

    public void deleteTable(long id) {
        tableRepository.deleteById(id);
    }

    public Table searchById(long id)  {
        return tableRepository.getById(id);
    }
}
