package com.caldegua.springcloud.msvc.msvcusuarios.services.impl;

import com.caldegua.springcloud.msvc.msvcusuarios.clients.CursoClientRest;
import com.caldegua.springcloud.msvc.msvcusuarios.models.entity.Usuario;
import com.caldegua.springcloud.msvc.msvcusuarios.repositories.UsuarioRepository;
import com.caldegua.springcloud.msvc.msvcusuarios.services.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class UsuarioServiceImpl implements UsuarioService {

    @Autowired
    private UsuarioRepository repository;

    @Autowired
    public CursoClientRest client;


    @Override
    @Transactional(readOnly = true)
    public List<Usuario> listar() {
        return (List<Usuario>) repository.findAll();
    }

    @Transactional(readOnly = true)
    @Override
    public Optional<Usuario> porId(Long id) {
        return repository.findById(id);
    }

    @Override
    @Transactional
    public Usuario guardar(Usuario usuario) {
        return repository.save(usuario);
    }

    @Override
    @Transactional
    public void eliminar(Long id) {
        repository.deleteById(id);
        client.eliminarCursoUsuarioPorId(id);
    }


    @Override
    public Optional<Usuario> porEmail(String email) {
        return repository.porEmail(email);
    }

    @Override
    public boolean existePorEmail(String email) {
        return repository.existsByEmail(email);
    }


    @Override
    @Transactional(readOnly = true)
    public List<Usuario> listartPorIds(Iterable<Long> ids) {
        return (List<Usuario>) repository.findAllById(ids);
    }

}
