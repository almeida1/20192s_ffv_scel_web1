package com.fatec.scel;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.result.ModelResultMatchers;
import org.springframework.test.web.servlet.result.ViewResultMatchers;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fatec.scel.model.Livro;

@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
public class REQ01CadastrarLivroMVC {
	@Autowired
	private MockMvc mockMvc;

	@Test
	public void status0() throws Exception {
		ResultActions resultActions = mockMvc.perform(MockMvcRequestBuilders.get("/livros/cadastrar"));
		resultActions.andExpect(MockMvcResultMatchers.status().isOk());
		resultActions.andExpect(MockMvcResultMatchers.status().is(200));
	}

	@Test
	public void verificaView0() throws Exception {
		ResultActions resultActions = mockMvc.perform(MockMvcRequestBuilders.get("/livros/cadastrar"));
		ViewResultMatchers view = MockMvcResultMatchers.view();
		resultActions.andExpect(view.name("CadastrarLivro"));
	}

	@Test // verifica o model
	public void verificaModel0() throws Exception {
		ResultActions resultActions = mockMvc.perform(MockMvcRequestBuilders.get("/livros/cadastrar"));
		ModelResultMatchers model = MockMvcResultMatchers.model();
		resultActions.andExpect(model.attributeExists("livro"));
	}
	@Test
	public void createEmployeeAPI() throws Exception {
//	  mockMvc.perform( MockMvcRequestBuilders
//	      .post("/livros/cadastrar")
//	      .content(asJsonString(new Livro("1111", "Teste de Software", "Delamaro"))
//	      .contentType(MediaType.APPLICATION_JSON)
//	      .accept(MediaType.APPLICATION_JSON)));
	      
	}
	public static String asJsonString(final Object obj) {
	    try {
	        final ObjectMapper mapper = new ObjectMapper();
	        final String jsonContent = mapper.writeValueAsString(obj);
	        return jsonContent;
	    } catch (Exception e) {
	        throw new RuntimeException(e);
	    }
	}  
}