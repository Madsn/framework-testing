'use strict';

module client {
  class Member {

    constructor(public name:string,
                public initials:string) {
    }
  }

  interface IMembersScope extends ng.IScope {
    members: Member[];
    selected: string;
    select(member: Member);
  }

  export class MembersCtrl {
    /* @ngInject */
    constructor($scope:IMembersScope) {
      var members = [{
        'name': 'Mikkel Madsen',
        'initials': 'MIKMA'
      }, {
        'name': 'Superman',
        'initials': 'SPMN'
      }, {
        'name': 'Batman',
        'initials': 'BAT'
      }];

      $scope.members = new Array<Member>();

      members.forEach(function (member) {
        $scope.members.push(new Member(
          member.name,
          member.initials
        ));
      });

      $scope.select = function(member){
        $scope.selected = member.initials;
      }
    }
  }

}
