tasks = new SQL.Collection('tasks');

Schema = {};
Schema.taskFormSchema = new SimpleSchema({
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
  var taskTable = {
    id: ['$number'],
    text: ['$string'],
    checked: ['$bool', {$default: false}]};
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
    taskFormSchema: function() {
      return Schema.taskFormSchema;
    }
  });
  Template.editTaskForm.helpers({
    taskFormSchema: function() {
      return Schema.taskFormSchema;
    }
  });
}

if (Meteor.isServer) {
  var taskTable = {
    id: ['$seq', '$primary', '$notnull'],
    text: ['$string'],
    checked: ['$bool', {$default: false}]};
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
    check(doc, Schema.taskFormSchema);
    tasks.insert(doc).save();
  },
  editTask: function(doc_raw, documentId) {
    var doc = doc_raw.$set;
    console.log(doc_raw);
    console.log(documentId);
    check(doc, Schema.taskFormSchema);
    tasks.update(doc).where('id = ?', documentId).save();
  }
});
