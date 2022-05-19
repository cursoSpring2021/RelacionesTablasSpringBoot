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
public class testEliminarRolUsuarioExistente {
    @Autowired
    private UsuarioRepository usuarioRepository;
    @Autowired
    private TestEntityManager entityManager;

    @Test
    public void testEliminarUsuarioExistentes() {
        Usuario usuario = usuarioRepository.findById(1).get();
        Rol rol = new Rol(2);
        usuarioRepository.deleteById(rol.getId());

    }
}
