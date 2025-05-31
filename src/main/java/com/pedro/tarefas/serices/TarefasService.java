package com.pedro.tarefas.serices;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Service;

@Service
public class TarefasService {

    public List<Map<String, Object>> listAll() {

        Map<String, Object> obj1 = new HashMap<>();
        obj1.put("id", 1);
        obj1.put("title", "Firs Year Task");
        obj1.put("content", "Test string for task");

        Map<String, Object> obj2 = new HashMap<>();
        obj2.put("id", 2);
        obj2.put("title", "Second Year Task");
        obj2.put("content", "Test string for task 2");

        return List.of(obj1, obj2);
    }

}
