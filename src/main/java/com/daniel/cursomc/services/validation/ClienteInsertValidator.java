package com.daniel.cursomc.services.validation;

import java.util.ArrayList;
import java.util.List;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import com.daniel.cursomc.domain.enums.TipoCliente;
import com.daniel.cursomc.dto.ClienteNewDTO;
import com.daniel.cursomc.resources.exception.FieldMessage;
import com.daniel.cursomc.services.validation.utils.BR; 
 
public class ClienteInsertValidator implements ConstraintValidator < ClienteInsert , ClienteNewDTO> { 
 
    @Override 
    public void initialize(ClienteInsert ann) {
    	}
    @Override
    public boolean isValid(ClienteNewDTO objDto, ConstraintValidatorContext context) { 
    
 
        List<FieldMessage> list = new ArrayList<>(); 
        
        if (objDto.getTipo().equals(TipoCliente.PESSOAFISICA.getCod()) && ! BR.isValidCPF(objDto.getCpfOUcnpj())) {
        	list.add(new FieldMessage("cpfOUcnpj ","CPF invalido"));
        }
        
        if (objDto.getTipo().equals(TipoCliente.PESSOAJURIDICA.getCod()) && ! BR.isValidCNPJ(objDto.getCpfOUcnpj())) {
        	list.add(new FieldMessage("cpfOUcnpj ","CNPJ invalido"));
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
