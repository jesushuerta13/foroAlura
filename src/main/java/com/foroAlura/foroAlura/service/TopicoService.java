package com.foroAlura.foroAlura.service;


import com.foroAlura.foroAlura.dto.TopicoRequest;
import com.foroAlura.foroAlura.dto.TopicoResponse;
import com.foroAlura.foroAlura.dto.TopicoUpdateRequest;
import com.foroAlura.foroAlura.entity.Topico;
import com.foroAlura.foroAlura.repository.TopicoRepository;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class TopicoService {
    public final TopicoRepository topicoRepository;

    @Transactional()
    public List<TopicoResponse> listar(){
        return topicoRepository.findAll().stream()
                .map(this::toResponse)
                .toList();
    }

    @Transactional
    public TopicoResponse crear(TopicoRequest request){
        Topico topico=Topico.builder()
                .titulo(request.titulo())
                .mensaje(request.mensaje())
                .build();
        return toResponse(topicoRepository.save(topico));
    }


    @Transactional
    public  TopicoResponse actualizar (TopicoUpdateRequest request) {
        Topico topico =topicoRepository.findById(request.id())
                .orElseThrow(()->new EntityNotFoundException("Topico no disponiblr"));
        if (request.titulo() != null && !request.titulo().isBlank()) {
            topico.setTitulo(request.titulo());


        }
        if (request.mensaje() != null && request.mensaje().isBlank()) {
            topico.setMensaje(request.mensaje());
        }
            return toResponse(topicoRepository.save(topico));
        }

    @Transactional
    public void eliminar (Long id) {
        topicoRepository.deleteById(id);
    }


    private TopicoResponse toResponse(Topico topico){
        return  new TopicoResponse(
                topico.getId(),
                topico.getTitulo(),
                topico.getMensaje(),
                topico.getFechaCreacion());

    }

}
