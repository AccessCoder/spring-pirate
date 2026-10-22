package org.example.springpirate.controller;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/hello")
public class HelloController {

    @GetMapping
    public String sayHello(){
        return "Hello World";
    }

    @GetMapping("/{name}")
    public String sayHello2(@PathVariable String name,
                            @RequestParam String greeting){
        return greeting + " " + name;
    }



    /**
     * GET -> Erhebt Daten
     * POST -> Erstellt neue Datensätze
     * PUT -> Updaten vorhandene Datensätze (mehrere Datenfelder)
     * DELETE -> Löscht Daten
     *
     * C -> Create
     * R -> Read
     * U -> Update
     * D -> Delete
     */
}
