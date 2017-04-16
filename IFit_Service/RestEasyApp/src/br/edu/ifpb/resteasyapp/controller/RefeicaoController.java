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

import br.edu.ifpb.resteasyapp.dao.RefeicaoDAO;
import br.edu.ifpb.resteasyapp.entidade.Refeicao;

@Path("refeicao")
public class RefeicaoController {
	
	@PermitAll
	@POST
	@Path("/inserir")
	@Consumes("application/json")
	@Produces("application/json")
	public Response insert(Refeicao refeicao) {

		// Preparando a resposta. Provisoriamente o sistema preparará a resposta
		// como requisição incorreta.
		ResponseBuilder builder = Response.status(Response.Status.BAD_REQUEST);
		builder.expires(new Date());

		// TODO: Regra de negócio e manipulação de dados nesse ponto. As
		// informaçãos devem ser associadas
		// nesse ponto ao biuld (response).

		try {

			int id = RefeicaoDAO.getInstance().insert(refeicao);

			refeicao.setId(id);

			builder.status(Response.Status.CREATED).entity(refeicao);

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
	public List<Refeicao> getAll() {

		// Retorno em formato de lista.
		// Desse modo o response sempre conterá o código de resposta OK.
		List<Refeicao> refeicoes = new ArrayList<Refeicao>();

		try {

			// TODO: Regra de negócio e manipulação de dados nesse ponto.
			refeicoes = RefeicaoDAO.getInstance().getAll();

		} catch (SQLException e) {

			// TODO: Tratar a exceção.
		}

		// Será retornado ao cliente um conjunto de alunos no formato de Json.
		return refeicoes;
	}

	/**
	 * Recupera o professor cadastrado no sistema através do seu id.
	 * 
	 * @param id
	 * @return Response
	 */
	@PermitAll
	@GET
	@Path("/id/{id}")
	@Produces("application/json")
	public Response getRefeicaoById(@PathParam("id") int id) {

		// Preparando a resposta. Provisoriamente o sistema preparará a resposta
		// como requisição incorreta.
		ResponseBuilder builder = Response.status(Response.Status.BAD_REQUEST);
		builder.expires(new Date());

		try {

			// Regra de negócio e manipulação de dados nesse ponto.
			Refeicao refeicao = RefeicaoDAO.getInstance().getById(id);

			if (refeicao != null) {

				// As informaçãos associadas ao build para o response.
				builder.status(Response.Status.OK);
				builder.entity(refeicao);

			} else {

				// Conteúdo não encontrado.
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
	public Response delete(Refeicao refeicao) {
		// Preparando a resposta. Provisoriamente o sistema preparará a resposta
		// como requisição incorreta.
		ResponseBuilder builder = Response.status(Response.Status.BAD_REQUEST);
		builder.expires(new Date());

		try {

			if (refeicao != null) {
				// Regra de negócio e manipulação de dados nesse ponto.
				RefeicaoDAO.getInstance().delete(refeicao);
				Refeicao refeicaoTeste = RefeicaoDAO.getInstance().getById(refeicao.getId());

				if (refeicaoTeste == null) {

					// As informaçãos associadas ao build para o response.
					builder.status(Response.Status.NO_CONTENT);

				} else {

					// Conteúdo não deletado
					builder.status(Response.Status.NOT_IMPLEMENTED).entity(refeicaoTeste);
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
	public Response update(Refeicao refeicao) {

		ResponseBuilder builder = Response.status(Response.Status.BAD_REQUEST);
		builder.expires(new Date());

		try {

			RefeicaoDAO.getInstance().updateByEntity(refeicao);
			builder.status(Response.Status.OK).entity(refeicao);

		} catch (SQLException exception) {
			builder.status(Response.Status.INTERNAL_SERVER_ERROR);
		}
		return builder.build();

	}

}
