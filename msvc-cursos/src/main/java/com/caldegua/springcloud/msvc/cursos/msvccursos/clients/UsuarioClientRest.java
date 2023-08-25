package com.caldegua.springcloud.msvc.cursos.msvccursos.clients;

import com.caldegua.springcloud.msvc.cursos.msvccursos.models.Usuario;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@FeignClient(name="msvc-usuarios", url="msvc-usuarios:8001")
public interface UsuarioClientRest {


    @GetMapping("/{id}")
    Usuario detalle(@PathVariable Long id);

    @PostMapping("/")
    Usuario crear(@RequestBody Usuario usuario);

    @GetMapping("/usuarios-por-curso")
    List<Usuario> obtenerAlumnosPorCurso(@RequestParam List<Long> ids);

}
