'use strict';

module client {

  interface ILayoutScope extends ng.IScope {
    date: Date
  }

  export class LayoutCtrl {
    /* @ngInject */
    constructor ($scope: ILayoutScope) {
      $scope.date = new Date();
    }
  }

}
