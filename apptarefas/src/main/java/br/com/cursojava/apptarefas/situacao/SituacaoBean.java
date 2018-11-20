package br.com.cursojava.apptarefas.situacao;
import java.util.Date;
import java.util.List;
import javax.faces.application.FacesMessage;
import javax.faces.application.FacesMessage.Severity;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;

import br.com.cursojava.apptarefas.utils.AbstractBean;

@ManagedBean
@ViewScoped
public class SituacaoBean extends AbstractBean {
	
	private SituacaoFacade facade = new SituacaoFacade();
	private Situacao situacaoAtual = facade.novaSituacao();
	private List<Situacao> situacoes;
	private String oid;
	private boolean novo = true;
	private boolean podeEditar = true;
	
	public String getOid() {
		return oid;
	}
	
	public void setOid(String oid) {
		this.oid = oid;
		if("novo".equals(oid)){
			setSituacaoAtual(facade.novaSituacao());
			novo();
		}else{
			try{
				Integer id = Integer.parseInt(oid);
				setSituacaoAtual(facade.carregarSituacao(id));
				novo = false;
			}catch(NumberFormatException ex){
				FacesContext context= FacesContext.getCurrentInstance();
				FacesMessage message = new FacesMessage("Id inválido");
				message.setSeverity(FacesMessage.SEVERITY_ERROR);
				context.addMessage(null, message);
			}
		}
	}
	
	public Integer getId() {
		return  getSituacaoAtual() != null ? getSituacaoAtual().getId() : null;
	}

	public void setId(Integer id) {
		if ( getSituacaoAtual() != null) {
			 getSituacaoAtual().setId(id);
		}
	}
	
	public String getNome() {
		return  getSituacaoAtual() != null ?  getSituacaoAtual().getNome() : "";
	}

	public void setNome(String nome) {
		if ( getSituacaoAtual()!= null) {
			 getSituacaoAtual().setNome(nome);
		}
	}
	public TipoSituacao getTipo() {
		return  getSituacaoAtual() != null ?  getSituacaoAtual().getTipo() : null;
	}

	public void setTipo(TipoSituacao tipo) {
		if ( getSituacaoAtual()!= null) {
			 getSituacaoAtual().setTipo(tipo);
		}
	}
	public Date getDataHoraCriacao() {
		return  getSituacaoAtual() != null ?  getSituacaoAtual().getDataHoraCriacao() : null;
		
	}
	public void setDataHoraCriacao(Date dataHoraCriacao) {
		if ( getSituacaoAtual()!= null) {
			 getSituacaoAtual().setDataHoraCriacao(dataHoraCriacao);
		}
	}
	public Date getDataHoraAtualizacao() {
		return  getSituacaoAtual() != null ?  getSituacaoAtual().getDataHoraAtualizacao() : null;
	}
	public void setDataHoraAtualizacao(Date dataHoraAtualizacao) {
		if ( getSituacaoAtual()!= null) {
			 getSituacaoAtual().setDataHoraAtualizacao(dataHoraAtualizacao);
		}
	}
	public Date getDataHoraRemocao() {
		return  getSituacaoAtual() != null ?  getSituacaoAtual().getDataHoraRemocao() : null;
	}
	public void setDataHoraRemocao(Date dataHoraRemocao) {
		if ( getSituacaoAtual()!= null) {
			 getSituacaoAtual().setDataHoraRemocao(dataHoraRemocao);
		}
	}
	public StatusSituacao getStatus() {
		return  getSituacaoAtual() != null ?  getSituacaoAtual().getStatus() : null;
	}
	public void setStatus(StatusSituacao status) {
		if ( getSituacaoAtual()!= null) {
			 getSituacaoAtual().setStatus(status);
		}
	}
	public TipoSituacao[] getTipos(){
		return TipoSituacao.values();
	}

	public void salvar(){
		boolean ok = false;
		if (getSituacaoAtual() != null) {
			if(getSituacaoAtual().getDataHoraCriacao()==null) {
				getSituacaoAtual().setDataHoraCriacao(new Date());
			}
			getSituacaoAtual().setDataHoraAtualizacao(new Date());
			ok = facade.salvar(getSituacaoAtual());
		}
		if (ok) {
			addMensagem("Situação salva com sucesso", FacesMessage.SEVERITY_INFO);
			novo = false;
			podeEditar = false;
		} else {
			addMensagem("Não foi possível salvar a Situação", FacesMessage.SEVERITY_ERROR);
		}
	}
	
	public void remover(){
		boolean ok = false;
		if(getSituacaoAtual() != null && !novo) {
			getSituacaoAtual().setDataHoraRemocao(new Date());
			ok = facade.removerSituacao(getSituacaoAtual());
			if(ok) {
				addMensagem("Contato removido com sucesso", FacesMessage.SEVERITY_INFO);
				novo();
			}else {
				addMensagem("Não foi possível remover o contato", FacesMessage.SEVERITY_ERROR);
			}
			
		}
	}
	public void editar(){
        this.setPodeEditar(true);
		
	}
	public String listar() {
		novo();
		return "./lista.jsf";
	}
	public void novo() {
		this.setSituacaoAtual(facade.novaSituacao());
		novo = true;
		editar();
	}
	public void novoHandler(ActionEvent event){
		this.situacaoAtual = facade.novaSituacao();
		novo = true;
		editar();
	}
		
	public List<Situacao> getSituacoes(){
		if(situacoes == null || situacoes.isEmpty()){
			situacoes = facade.carregarSituacoes();
		}
		return situacoes;
	}
	
	private void addMensagem(String mensagem, Severity severidade){
		FacesContext context= FacesContext.getCurrentInstance();
		FacesMessage message = new FacesMessage(mensagem);
		message.setSeverity(severidade);
		context.addMessage(null, message);
	}

	public boolean isPodeEditar() {
		return podeEditar;
	}

	public void setPodeEditar(boolean podeEditar) {
		this.podeEditar = podeEditar;
	}

	public Situacao getSituacaoAtual() {
		return situacaoAtual;
	}

	public void setSituacaoAtual(Situacao situacaoAtual) {
		this.situacaoAtual = situacaoAtual;
	}

	

	
	
























}