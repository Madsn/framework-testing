tasks = new SQL.Collection('tasks');

Schema = {};
Schema.addTaskFormSchema = new SimpleSchema({
  text: {
    type: String,
    label: 'Task text',
    optional: false,
    max: 50
  },
  checked: {
    type: Boolean,
    label: 'Done?'
  }
});

if (Meteor.isClient) {
  var taskTable = {id: ['$number'], text: ['$string'], checked: ["$bool", {$default: false}]};
  tasks.createTable(taskTable);
  Template.hello.helpers({
    tasks: function() {
      return tasks.select().fetch();
    },
    getCssClass: function(task) {
      return task.checked ? 'checked': '';
    }
  });
  Template.hello.events({
    'click #deleteAll': function(event) {
      tasks.remove().save();
    },
    'click .toggleDone': function(event) {
      tasks.update({
        checked: event.target.checked
      })
      .where('id = ?', event.target.id).save();
    }
  });
  Template.addTaskForm.helpers({
    addTaskFormSchema: function() {
      return Schema.addTaskFormSchema;
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

Meteor.methods({
  addTask: function(doc) {
    check(doc, Schema.addTaskFormSchema);
    tasks.insert(doc).save();
  }
});
