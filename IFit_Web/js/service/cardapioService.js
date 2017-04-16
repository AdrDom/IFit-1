angulaAppModulo.factory("CardapioService", function($http) {

    var urlBase = "http://localhost:8080/RestEasyApp";
    
    var _listarRefeicao = function() {
        return $http.get(urlBase + "/refeicao/listar/")
    };
    
    var _cadastrarRefeicao = function(refeicao){
		return $http.post(urlBase + "/refeicao/inserir", refeicao)
	};
    
    var _consultarAlunoByNome = function(nome){
		return $http.get(urlBase + "/aluno/listar/nome/" + encodeURI(nome))
	};

    return {
        listarRefeicoes: _listarRefeicao,
        cadastrarRefeicao: _cadastrarRefeicao,
        consultarAlunoByNome: _consultarAlunoByNome
    };
});