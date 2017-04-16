package br.edu.ifpb.resteasyapp.servico;

import java.util.HashSet;
import java.util.Set;

import javax.ws.rs.core.Application;

import org.jboss.resteasy.plugins.interceptors.CorsFilter;

import br.edu.ifpb.resteasyapp.controller.AdministradorController;
import br.edu.ifpb.resteasyapp.controller.AlimentoController;
import br.edu.ifpb.resteasyapp.controller.RefeicaoController;

public class RestEasyApplication extends Application {

	private Set<Object> singletons = new HashSet<Object>();
	private Set<Class<?>> empty = new HashSet<Class<?>>();

	public RestEasyApplication() {

		// Multiple client-request: Cross-Filter
		CorsFilter filter = new CorsFilter();
		filter.getAllowedOrigins().add("*");
		filter.setAllowedMethods("POST, GET, DELETE, PUT, OPTIONS");
		filter.setAllowedHeaders("Content-Type, Authorization");

		this.singletons.add(filter);

		// Controllers disponíveis no serviço.
		this.singletons.add(new AdministradorController());
		this.singletons.add(new RefeicaoController());
		this.singletons.add(new AlimentoController());
	}

	public Set<Class<?>> getClasses() {
		return this.empty;
	}

	public Set<Object> getSingletons() {
		return this.singletons;
	}
}