package br.com.cacomp.bean;

import java.sql.SQLException;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import br.com.cacomp.DAO.AdministradoresDAO;
import br.com.cacomp.domain.Administradores;
import br.com.cacomp.util.Mensagens;

@ManagedBean(name = "MBAdministradores")
@ViewScoped
public class AdministradoresBean {
	
	private Administradores adms;
	
	private List<Administradores> itens;
	
	private List<Administradores> itensFiltrados;
	
	public List<Administradores> getItensFiltrados() {
		return itensFiltrados;
	}

	public void setItensFiltrados(List<Administradores> itensFiltrados) {
		this.itensFiltrados = itensFiltrados;
	}

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
			itens = admDAO.listar();
			
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
			
			itens = admDAO.listar();
			
			Mensagens.addMsgSucesso("Salvo com sucesso!");
		} catch (SQLException e) {
			Mensagens.addMsgErro("ex.getMessage()");
			e.printStackTrace();
		}
	}
	
	public void excluir(Administradores admTEMP){
		try {
			System.out.println("codigo: "+admTEMP.getCodigo()+" nome: "+admTEMP.getNome());
			AdministradoresDAO admDAO = new AdministradoresDAO();
			admDAO.excluir(admTEMP);
			
			itens = admDAO.listar();
			Mensagens.addMsgSucesso("Excluido com sucesso!");
		} catch (SQLException e) {
			Mensagens.addMsgErro("ex.getMessage()");
			e.printStackTrace();
		}
	}
	
	public void preparaEditar(Administradores admTEMP){
		adms = admTEMP;
	}
	public void editar(){
		try {
			AdministradoresDAO admDAO = new AdministradoresDAO();
			admDAO.editar(adms);
			
			itens = admDAO.listar();
			
			Mensagens.addMsgSucesso("Editado com sucesso!");
		} catch (SQLException e) {
			Mensagens.addMsgErro("ex.getMessage()");
			e.printStackTrace();
		}
	}
}
