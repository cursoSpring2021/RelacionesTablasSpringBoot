package com.sistemainventario;

import com.sistemainventario.usuario.Rol;
import com.sistemainventario.usuario.Usuario;
import com.sistemainventario.usuario.UsuarioRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.annotation.Rollback;

@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
@Rollback(value = false)
public class testCrearNuevoUsuarioConUnRol {
    @Autowired
    private UsuarioRepository usuarioRepository;
    @Autowired
    private TestEntityManager entityManager;

    @Test
    public void testCrearNuevoUsuarioUnRol() {
        Rol rolAdmin = entityManager.find(Rol.class, 1);
        Usuario usuario = new Usuario("davisguera@gmail.com", "2021");
        usuario.añadirRol(rolAdmin);
        usuarioRepository.save(usuario);
    }
}
