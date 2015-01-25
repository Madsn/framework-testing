'use strict';
class SampleDirective
{
  //public link: (scope: ng.IScope, element: ng.IAugmentedJQuery, attrs: ng.IAttributes) => void;
  public template = '<p>Test Directive</p>';
  //public scope = {};

  constructor(/*list of dependencies*/)
  {
    /*
    this.link = (scope: ng.IScope, element: ng.IAugmentedJQuery, attrs: ng.IAttributes) =>
    {
      // handle all your linking requirements here
    };
    */
  }

  public static Factory()
  {
    var directive = (/*list of dependencies*/) =>
    {
      return new SampleDirective(/*list of dependencies*/);
    };
    //directive['$inject'] = [];
    return directive;
  }
}
