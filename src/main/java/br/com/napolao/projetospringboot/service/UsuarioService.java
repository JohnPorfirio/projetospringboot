package br.com.napolao.projetospringboot.service;

import br.com.napolao.projetospringboot.dto.UsuarioDTO;
import br.com.napolao.projetospringboot.entity.UsuarioEntity;
import br.com.napolao.projetospringboot.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UsuarioService {

    @Autowired
    private UsuarioRepository usuarioRepository;

    public List<UsuarioDTO> listarTodos(){
        List< UsuarioEntity> usuarioEntities = usuarioRepository.findAll();
        return usuarioEntities.stream().map(UsuarioDTO::new).toList();
    }

    public void inserir(UsuarioDTO usuarioDTO){
        UsuarioEntity usuarioEntity = new UsuarioEntity(usuarioDTO);
        usuarioRepository.save(usuarioEntity);
    }

    public UsuarioDTO alterar(UsuarioDTO usuarioDTO){
        UsuarioEntity usuarioEntity = new UsuarioEntity(usuarioDTO);
        return new UsuarioDTO(usuarioRepository.save(usuarioEntity));
    }

    public void excluir(Long id){
        UsuarioEntity usuarioEntity = usuarioRepository.findById(id).get();
        usuarioRepository.delete(usuarioEntity);
    }

    public UsuarioDTO buscarPorID(Long id){
        return new UsuarioDTO(usuarioRepository.findById(id).get());
    }
}
