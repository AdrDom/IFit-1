package br.edu.ifpb.resteasyapp.controller;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.annotation.security.PermitAll;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.ResponseBuilder;

import br.edu.ifpb.resteasyapp.dao.AdministradorDAO;
import br.edu.ifpb.resteasyapp.entidade.Administrador;

@Path("administrador")
public class AdministradorController {
	
	@PermitAll
	@POST
	@Path("/inserir")
	@Consumes("application/json")
	@Produces("application/json")
	public Response insert(Administrador administrador) {

		// Preparando a resposta. Provisoriamente o sistema preparar� a resposta
		// como requisi��o incorreta.
		ResponseBuilder builder = Response.status(Response.Status.BAD_REQUEST);
		builder.expires(new Date());

		// TODO: Regra de neg�cio e manipula��o de dados nesse ponto. As
		// informa��os devem ser associadas
		// nesse ponto ao biuld (response).

		try {

			int id = AdministradorDAO.getInstance().insert(administrador);

			administrador.setId(id);

			builder.status(Response.Status.CREATED).entity(administrador);

		} catch (SQLException e) {

			builder.status(Response.Status.INTERNAL_SERVER_ERROR);
		}

		// Resposta.
		return builder.build();
	}

	/**
	 * Retorna todos os professores cadastrados.
	 * 
	 * @return Response
	 */
	@PermitAll
	@GET
	@Path("/listar")
	@Produces("application/json")
	public List<Administrador> getAll() {

		// Retorno em formato de lista.
		// Desse modo o response sempre conter� o c�digo de resposta OK.
		List<Administrador> administradores = new ArrayList<Administrador>();

		try {

			// TODO: Regra de neg�cio e manipula��o de dados nesse ponto.
			administradores = AdministradorDAO.getInstance().getAll();

		} catch (SQLException e) {

			// TODO: Tratar a exce��o.
		}

		// Ser� retornado ao cliente um conjunto de alunos no formato de Json.
		return administradores;
	}

	/**
	 * Recupera o professor cadastrado no sistema atrav�s do seu id.
	 * 
	 * @param id
	 * @return Response
	 */
	@PermitAll
	@GET
	@Path("/id/{id}")
	@Produces("application/json")
	public Response getAdministradorById(@PathParam("id") int id) {

		// Preparando a resposta. Provisoriamente o sistema preparar� a resposta
		// como requisi��o incorreta.
		ResponseBuilder builder = Response.status(Response.Status.BAD_REQUEST);
		builder.expires(new Date());

		try {

			// Regra de neg�cio e manipula��o de dados nesse ponto.
			Administrador administrador = AdministradorDAO.getInstance().getById(id);

			if (administrador != null) {

				// As informa��os associadas ao build para o response.
				builder.status(Response.Status.OK);
				builder.entity(administrador);

			} else {

				// Conte�do n�o encontrado.
				builder.status(Response.Status.NOT_FOUND);
			}

		} catch (SQLException exception) {

			builder.status(Response.Status.INTERNAL_SERVER_ERROR);
		}

		// Resposta
		return builder.build();
	}

	@PermitAll
	@POST
	@Path("/deletar")
	@Consumes("application/json")
	@Produces("application/json")
	public Response delete(Administrador administrador) {
		// Preparando a resposta. Provisoriamente o sistema preparar� a resposta
		// como requisi��o incorreta.
		ResponseBuilder builder = Response.status(Response.Status.BAD_REQUEST);
		builder.expires(new Date());

		try {

			if (administrador != null) {
				// Regra de neg�cio e manipula��o de dados nesse ponto.
				AdministradorDAO.getInstance().delete(administrador);
				Administrador administradorTeste = AdministradorDAO.getInstance().getById(administrador.getId());

				if (administradorTeste == null) {

					// As informa��os associadas ao build para o response.
					builder.status(Response.Status.NO_CONTENT);

				} else {

					// Conte�do n�o deletado
					builder.status(Response.Status.NOT_IMPLEMENTED).entity(administradorTeste);
				}
			}

		} catch (SQLException exception) {

			builder.status(Response.Status.INTERNAL_SERVER_ERROR);
		}

		// Resposta
		return builder.build();
	}

	@PermitAll
	@POST
	@Path("/alterar")
	@Produces("application/json")
	@Consumes("application/json")
	public Response update(Administrador administrador) {

		ResponseBuilder builder = Response.status(Response.Status.BAD_REQUEST);
		builder.expires(new Date());

		try {

			AdministradorDAO.getInstance().updateByEntity(administrador);
			builder.status(Response.Status.OK).entity(administrador);

		} catch (SQLException exception) {
			builder.status(Response.Status.INTERNAL_SERVER_ERROR);
		}
		return builder.build();

	}

	@PermitAll
	@POST
	@Path("/login")
	@Produces("application/json")
	@Consumes("application/json")
	public Response login(Administrador administrador) {

		ResponseBuilder builder = Response.status(Response.Status.BAD_REQUEST);
		builder.expires(new Date());

		try {

			Administrador administradorRecebido = AdministradorDAO.getInstance().findAdministradorByLogin(administrador.getLogin());

			if (administrador.getSenha().equals(administradorRecebido.getSenha())) {

				builder.status(Response.Status.OK);

			} else {

				if (administrador.getSenha() == null || administrador.getSenha().isEmpty()) {

					builder.status(Response.Status.EXPECTATION_FAILED);

				} else {

					builder.status(Response.Status.BAD_REQUEST);
				}
			}

		} catch (SQLException exception) {
			builder.status(Response.Status.INTERNAL_SERVER_ERROR);
		}

		return builder.build();
	}
}
