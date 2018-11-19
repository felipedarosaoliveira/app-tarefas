package br.com.cursojava.apptarefas.utils;

import java.util.List;
import java.util.Map;

import org.primefaces.model.menu.DefaultMenuItem;
import org.primefaces.model.menu.MenuItem;

public class BreadCrumbItem  implements MenuItem{
	
	private String label;
	private String url;
	private String id;
	private boolean rendered;
	private MenuItem item = new DefaultMenuItem();
	
	public BreadCrumbItem() {
		super();
		// TODO Auto-generated constructor stub
	}

	public BreadCrumbItem(String id, String label, String url) {
	this(id,label,url,true);
	}
	public BreadCrumbItem(String id, String label, String url,boolean isRendered) {
		super();
		this.id = id;
		this.label = label;
		this.url = url;
		this.rendered = isRendered;
		}

	public boolean requiresConfirmation() {
		return item.requiresConfirmation();
	}

	public void setConfirmationScript(String script) {
		item.setConfirmationScript(script);
	}

	public String getConfirmationScript() {
		return item.getConfirmationScript();
	}

	public String getIcon() {
		return item.getIcon();
	}

	public String getIconPos() {
		return item.getIconPos();
	}

	public String getTitle() {
		return item.getTitle();
	}

	public boolean shouldRenderChildren() {
		return item.shouldRenderChildren();
	}

	public boolean isDisabled() {
		return item.isDisabled();
	}

	public String getOnclick() {
		return item.getOnclick();
	}

	public String getStyle() {
		return item.getStyle();
	}

	public String getStyleClass() {
		return item.getStyleClass();
	}

	public String getTarget() {
		return item.getTarget();
	}

	public String getOutcome() {
		return item.getOutcome();
	}

	public String getFragment() {
		return item.getFragment();
	}

	public boolean isIncludeViewParams() {
		return item.isIncludeViewParams();
	}

	public boolean isAjax() {
		return item.isAjax();
	}

	public Object getValue() {
		return item.getValue();
	}

	public void setStyleClass(String styleClass) {
		item.setStyleClass(styleClass);
	}

	public Map<String, List<String>> getParams() {
		return item.getParams();
	}

	public void setParam(String key, Object value) {
		item.setParam(key, value);
	}

	public boolean isDynamic() {
		return item.isDynamic();
	}

	public String getCommand() {
		return item.getCommand();
	}

	public boolean isImmediate() {
		return item.isImmediate();
	}

	public String getClientId() {
		return item.getClientId();
	}

	public String getContainerStyle() {
		return item.getContainerStyle();
	}

	public String getContainerStyleClass() {
		return item.getContainerStyleClass();
	}

	public boolean isEscape() {
		return item.isEscape();
	}

	public String getRel() {
		return item.getRel();
	}

	public String getLabel() {
		return label;
	}

	public void setLabel(String label) {
		this.label = label;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	@Override
	public String getId() {
		return id;
	}

	@Override
	public void setId(String id) {
		this.id = id;
	}

	@Override
	public boolean isRendered() {
		return rendered;
	}
	public void setRendered(boolean isRendered) {
		this.rendered = isRendered;
	}

	
	
	
	
}
