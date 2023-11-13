package net.weg.apigestaoprodutos.service;

import lombok.AllArgsConstructor;
import net.weg.apigestaoprodutos.model.Fabricante;
import net.weg.apigestaoprodutos.model.dto.FabricanteDTO;
import net.weg.apigestaoprodutos.model.dto.IDTO;
import net.weg.apigestaoprodutos.repository.FabricanteRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import java.util.Collection;

@Service
@AllArgsConstructor
public class FabricanteService implements IService<Fabricante, Integer>{

    private FabricanteRepository fabricanteRepository;

    @Override
    public Fabricante cadastrar(IDTO dto) {
        Fabricante fabricante = new Fabricante();
        BeanUtils.copyProperties(dto, fabricante);
        return fabricanteRepository.save(fabricante);
    }

    @Override
    public Fabricante editar(IDTO dto) {
        Fabricante fabricante = new Fabricante();
        BeanUtils.copyProperties(fabricante, dto);
        return fabricanteRepository.save(fabricante);
    }

    @Override
    public void deletar(Integer id) {
        fabricanteRepository.deleteById(id);
    }

    @Override
    public Collection<Fabricante> buscarTodos() {
        return fabricanteRepository.findAll();
    }

    @Override
    public Fabricante buscarUm(Integer id) {
        return fabricanteRepository.findById(id).get();
    }
}
