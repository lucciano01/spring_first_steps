package br.com.luciano.aulaspring.service;

import br.com.luciano.aulaspring.domain.Medicamento;
import br.com.luciano.aulaspring.repository.MedicamentoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class MedicamentoService {

    private final MedicamentoRepository repository;

    @Autowired
    public MedicamentoService(MedicamentoRepository repository) {
        this.repository = repository;
    }

    public Medicamento save(Medicamento medicamento){
       return repository.save(medicamento);
    }

    public Medicamento findById(UUID uuid){
        Optional<Medicamento> medicamento = repository.findById(uuid);
        return medicamento.orElseThrow(()-> new RuntimeException("Medicamento não localizado na BD"));

    }

    public List<Medicamento> getAll(){
        return repository.findAll();
    }
}
