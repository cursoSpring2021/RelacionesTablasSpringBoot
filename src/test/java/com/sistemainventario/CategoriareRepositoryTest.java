package com.sistemainventario;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase.Replace;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.annotation.Rollback;

import com.sistemainventario.categoria.Categoria;
import com.sistemainventario.categoria.CategoriaRepository;
@DataJpaTest
@AutoConfigureTestDatabase(replace =Replace.NONE)
@Rollback(false)
public class CategoriareRepositoryTest {
	@Autowired
	private CategoriaRepository repository;
	@Test
	public void testCrearCategoria() {
		//Categoria categoriaGuardada = repository.save(new Categoria("Electronicos"));
		//assertThat(categoriaGuardada.getId()).isGreaterThan(0);
	}
	

}
