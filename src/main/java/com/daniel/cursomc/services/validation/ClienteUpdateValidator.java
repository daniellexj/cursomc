package com.daniel.cursomc.services.validation;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.reactive.HandlerMapping;

import com.daniel.cursomc.domain.Cliente;
import com.daniel.cursomc.dto.ClienteDTO;
import com.daniel.cursomc.repositories.ClienteRepository;
import com.daniel.cursomc.resources.exception.FieldMessage; 
 
public class ClienteUpdateValidator implements ConstraintValidator < ClienteUpdate , ClienteDTO> { 
 
	@Autowired
	private HttpServletRequest request;


	
	@Autowired
	private ClienteRepository repo;
	
    @Override 
    public void initialize(ClienteUpdate ann) {
    	}
    
    @Override
    public boolean isValid(ClienteDTO objDto, ConstraintValidatorContext context) { 
    
 
    	@SuppressWarnings("unchecked")
		Map<String,String> map = (Map<String,String>) request.getAttribute(HandlerMapping.URI_TEMPLATE_VARIABLES_ATTRIBUTE);
    	
    	Integer uriId = Integer.parseInt(map.get("id"));
    	
        List<FieldMessage> list = new ArrayList<>(); 
        
        Cliente aux = repo.findByEmail(objDto.getEmail());
        
    	if (aux != null && !aux.getId().equals(uriId)) {
			list.add(new FieldMessage("email", "Email já existente"));
		}
        // inclua os testes aqui, inserindo erros na lista
        for (FieldMessage e : list) { 
        	context.disableDefaultConstraintViolation(); 
        	context.buildConstraintViolationWithTemplate(e.getMessage())
        	.addPropertyNode(e.getFieldName()).addConstraintViolation();
        	}         
        return list.isEmpty();
        }
} 
