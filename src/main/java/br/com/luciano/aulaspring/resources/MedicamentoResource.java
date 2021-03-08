package br.com.luciano.aulaspring.resources;


import br.com.luciano.aulaspring.domain.Medicamento;
import br.com.luciano.aulaspring.service.MedicamentoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;
import java.util.UUID;

@RestController
@RequestMapping(value = "/medicamento")
public class MedicamentoResource {

    @Autowired
    private MedicamentoService medicamentoService;

    @PostMapping
    public ResponseEntity saveMedicamento(@RequestBody Medicamento medicamento){
        Medicamento med = medicamentoService.save(medicamento);
        return ResponseEntity.ok().body(med);
    }

    @PostMapping("/find/{uuid}")
    public ResponseEntity findMedicamentoById(@PathVariable("uuid")UUID uuid){
       try{
           return ResponseEntity.ok().body(medicamentoService.findById(uuid));
       }catch(Exception ex){
           return ResponseEntity.badRequest().body(ex.getMessage());
       }
    }

    @GetMapping("/all")
    public ResponseEntity getAll(){
        return ResponseEntity.ok().body(medicamentoService.getAll());
    }
}
