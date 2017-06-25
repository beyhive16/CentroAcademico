package br.com.cacomp.bean;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import javax.faces.model.ListDataModel;

import br.com.cacomp.DAO.AdministradoresDAO;
import br.com.cacomp.domain.Administradores;
import br.com.cacomp.util.Mensagens;
import org.primefaces.model.LazyDataModel;

@ManagedBean(name = "MBAdministradores")
@ViewScoped
public class AdministradoresBean {
	
	private Administradores adms;
	
	private List<Administradores> itens;
	
	public Administradores getAdms() {
		return adms;
	}

	public void setAdms(Administradores adms) {
		this.adms = adms;
	}

	public List<Administradores> getItens() {
		return itens;
	}

	public void setItens(List<Administradores> itens) {
		this.itens = itens;
	}
	
	@PostConstruct	
	public void prepararPesquisa(){
		try {
			AdministradoresDAO admDAO = new AdministradoresDAO();
			ArrayList<Administradores> lista = admDAO.listar();
			itens = lista;
			System.out.println("Tam: " + itens.size());
		} catch (SQLException e) {
			Mensagens.addMsgErro("ex.getMessage()");
			e.printStackTrace();
		}
	}
	
	public void prepararNovo(){
		adms = new Administradores();
	}
	
	public void novo(){
		try {
			AdministradoresDAO admDAO = new AdministradoresDAO();
			admDAO.salvar(adms);
			
			ArrayList<Administradores> lista = admDAO.listar();
			itens = lista;
			Mensagens.addMsgSucesso("Salvo com sucesso!");
		} catch (SQLException e) {
			Mensagens.addMsgErro("ex.getMessage()");
			e.printStackTrace();
		}
	}
	
	/*public void prepararExcluir(){
		adms = itens.getRowData();
	}*/
	
	public void excluir(Administradores admTEMP){
		try {
			System.out.println("codigo: "+admTEMP.getCodigo()+" nome: "+admTEMP.getNome());
			AdministradoresDAO admDAO = new AdministradoresDAO();
			admDAO.excluir(admTEMP);
			
			ArrayList<Administradores> lista = admDAO.listar();
			itens = lista;
			Mensagens.addMsgSucesso("Excluido com sucesso!");
		} catch (SQLException e) {
			Mensagens.addMsgErro("ex.getMessage()");
			e.printStackTrace();
		}
	}
}
