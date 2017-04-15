angulaAppModulo.controller('cardapioController', function ($scope, $state) {
    $scope.redirecionar = function () {        
        $state.transitionTo('diaCardapio');
    };
});