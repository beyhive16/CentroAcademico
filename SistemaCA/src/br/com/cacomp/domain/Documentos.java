package br.com.cacomp.domain;

import java.io.File;

import org.primefaces.model.UploadedFile;
public class Documentos {
	
	private UploadedFile identidade;
	private UploadedFile requisicao;
	private UploadedFile comprovante;
	private int idDocumentos;
	
	public UploadedFile getIdentidade() {
		return identidade;
	}

	public void setIdentidade(UploadedFile identidade) {
		this.identidade = identidade;
	}

	public UploadedFile getRequisicao() {
		return requisicao;
	}

	public void setRequisicao(UploadedFile requisicao) {
		this.requisicao = requisicao;
	}

	public UploadedFile getComprovante() {
		return comprovante;
	}

	public void setComprovante(UploadedFile comprovante) {
		this.comprovante = comprovante;
	}


	public int getIdDocumentos() {
		return idDocumentos;
	}

	public void setIdDocumentos(int idDocumentos) {
		this.idDocumentos = idDocumentos;
	}

	
}
