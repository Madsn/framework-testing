tasks = new SQL.Collection('tasks');

if (Meteor.isClient) {
  var taskTable = {id: ['$number'], text: ['$string'], checked: ["$bool", {$default: false}]};
  tasks.createTable(taskTable);
  Template.hello.helpers({
    tasks: function() {
      return tasks.select().fetch();
    }
  });
  Template.hello.events({
    'click #addTask': function(event) {
      var task = tasks.insert({
        text:'testing',
        checked:false
      })
      .save();
    }
  });
}

if (Meteor.isServer) {
  var taskTable = {text: ['$string'], checked: ["$bool", {$default: false}]};
  tasks.createTable(taskTable).save();
  tasks.publish('tasks', function(){
    return tasks.select();
  });
  Meteor.startup(function () {
    // code to run on server at startup
  });
}
