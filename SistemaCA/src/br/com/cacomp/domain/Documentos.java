package br.com.cacomp.domain;

import java.io.File;

public class Documentos {
	private File identidade;
	private File requisicao;
	private File comprovante;

	public File getIdentidade() {
		return identidade;
	}

	public void setIdentidade(File identidade) {
		this.identidade = identidade;
	}

	public File getRequisicao() {
		return requisicao;
	}

	public void setRequisicao(File requisicao) {
		this.requisicao = requisicao;
	}

	public File getComprovante() {
		return comprovante;
	}

	public void setComprovante(File comprovante) {
		this.comprovante = comprovante;
	}
}
