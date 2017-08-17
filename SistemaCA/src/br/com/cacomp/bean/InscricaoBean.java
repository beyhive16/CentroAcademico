package br.com.cacomp.bean;

import java.io.FileNotFoundException;
import java.io.Serializable;
import java.sql.SQLException;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.model.SelectItem;

import br.com.cacomp.DAO.InscricaoDAO;
import br.com.cacomp.domain.Alunos;
import br.com.cacomp.util.Mensagens;

@ManagedBean
@ViewScoped
public class InscricaoBean implements Serializable{
	
	private static final long serialVersionUID = 5577802532138082460L;
	private Alunos inscrito;
	private SelectItem item;
	
	public SelectItem getItem() {
		return item;
	}

	public void setItem(SelectItem item) {
		this.item = item;
	}

	public Alunos getinscrito() {
		return inscrito;
	}

	public void setinscrito(Alunos inscrito) {
		this.inscrito = inscrito;
	}
	
	public void prepararNovo(){
		inscrito = new Alunos();
	}
	
	public void novo() throws FileNotFoundException{
		prepararNovo();
		System.out.println("entrou no novo");
		try {
			InscricaoDAO inscritoDAO = new InscricaoDAO();
			/*if(x==1){
				inscritoDAO.salvarIdentidade(inscrito);
			}else if(x==2){
				inscritoDAO.salvarRequisicao(inscrito);
			}else{
				inscritoDAO.salvarComprovante(inscrito);
			}
			*/
			inscritoDAO.addInscricao(inscrito,getItem().getValue().toString());
			Mensagens.addMsgSucesso("Salvo com sucesso!");
		} catch (SQLException e) {
			Mensagens.addMsgErro("ex.getMessage()");
			e.printStackTrace();
		}
	}
	
}
