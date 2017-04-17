angulaAppModulo.factory("AlunoService", function($http) {

    var urlBase = "http://localhost:8080/RestEasyApp";
    
    var _listarAlunos = function() {
        return $http.get(urlBase + "/aluno/listar/")
    };
    
    var _cadastrarRefeicao = function(refeicao){
		return $http.post(urlBase + "/refeicao/inserir", refeicao)
	};
    
    var _consultarAlunoByNome = function(nome){
		return $http.get(urlBase + "/aluno/listar/nome/" + encodeURI(nome))
	};

    return {
        listarAlunos: _listarAlunos,
        cadastrarRefeicao: _cadastrarRefeicao,
        consultarAlunoByNome: _consultarAlunoByNome
    };
});