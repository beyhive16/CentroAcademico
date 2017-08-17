package br.com.cacomp.bean;

import java.io.IOException;
import java.util.Scanner;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.validator.ValidatorException;
import javax.servlet.http.Part;

@ManagedBean
public class ImportadorBean {

	private static final int MAX_SIZE = 2 * 1024 * 1024;
    private Part arquivo; 

    public Part getArquivo() {
		return arquivo;
	}

	public void setArquivo(Part arquivo) {
		this.arquivo = arquivo;
	}

	public void importa() {
        try {
            String conteudo = new Scanner(arquivo.getInputStream())
                .useDelimiter("\\A").next();
        } catch (IOException e) {
            System.out.println("erro na funcao importa");
        }
    }
	
	public void valida(FacesContext context, UIComponent component, Object value) {

        Part arquivo = (Part) value;

        if (arquivo.getSize() > MAX_SIZE) {
            FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_ERROR, 
                    "Arquivo muito grande", "O arquivo deve ter o tamanho máximo de 2mb.");
            throw new ValidatorException(msg);
        }

        else if (!"text/plain".equals(arquivo.getContentType())) {
            FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_ERROR, 
                    "Tipo de arquivo inválido", "O arquivo deve ser do tipo texto.");
            throw new ValidatorException(msg);
        }
        else{
        	System.out.println("tudo okay");
        }
    }
}