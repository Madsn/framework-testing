<!-- START doctoc generated TOC please keep comment here to allow auto update -->
<!-- DON'T EDIT THIS SECTION, INSTEAD RE-RUN doctoc TO UPDATE -->
**Table of Contents**  *generated with [DocToc](http://doctoc.herokuapp.com/)*

- [Battle of the web frameworks](#battle-of-the-web-frameworks)
  - [The application](#the-application)
    - [Features:](#features)
    - [Implementation order](#implementation-order)
  - [The competition](#the-competition)
  - [Journal](#journal)
    - [Vaadin](#vaadin)
      - [Installation](#installation)
      - [Thoughts](#thoughts)
    - [Jhipster (Spring + Angular)](#jhipster-spring--angular)
    - [Grails](#grails)
    - [Play](#play)
      - [Java](#java)
      - [Scala](#scala)
    - [ZK](#zk)
    - [Dropwizard](#dropwizard)
    - [Ruby on Rails](#ruby-on-rails)
    - [Wicket](#wicket)
    - [Python](#python)
      - [Django](#django)
      - [Flask](#flask)

<!-- END doctoc generated TOC please keep comment here to allow auto update -->

# Battle of the web frameworks

I've singled out 'a few' web development stacks that I want to test out.

## The application

For use in Scrum on my team for various occasions when it is necessary to cycle through team members, or choose a single member at random.

There are many other features that would be useful, but in order to avoid having to do a ton of duplicate work the baseline for doing comparisons is very minimal.

### Features:

- Setup of team (CRUD member)
- Ability to cycle through team members with long-term persistence (for our daily Battleships game vs the other team). It should be possible to postpone the "turn" of the team member in case that person is not available
- Ability to draw a name at random from the team without influencing the regular cycle

### Implementation order

To the extent that it makes sense, I will attempt to implement the functionality in the following order.

1. Setup basic persistence (Sqlite or similar preferably, if not then MySQL or Postgres)
2. Create member via form
3. List members
4. Edit/Delete members
5. Random button
6. Cycle button
7. Postpone when cycling

## The competition

I won't be able to get around all of them, but I have at least a little interest in checking out each of these:

- [ ] [Vaadin](https://vaadin.com/home)
  - Progress: Finished first 3 steps, i.e. create new member + list existing members
- [ ] [Jhipster (Spring + Angular)](https://jhipster.github.io/)
  - Progress: Finished steps 1-4 in next to no time at all, thanks to the yeoman generator. 5 is also complete and 6+7 almost there.
- [ ] [Grails](https://grails.org/)
- [ ] [Play (Java)](https://www.playframework.com/)
- [ ] [Play (Scala)](https://www.playframework.com/)
  - Progress: Finished steps 1-3
- [ ] [ZK](http://www.zkoss.org/)
- [ ] [Dropwizard](https://dropwizard.github.io/dropwizard/)
- [ ] [Ruby on Rails](https://rubyonrails.org/)
- [ ] [Wicket](https://wicket.apache.org/)
- [ ] [Django](https://www.djangoproject.com/)
- [ ] [Flask](http://flask.pocoo.org/)
- [ ] [Pyramid](http://www.pylonsproject.org/)
- [ ] [Zotonic](http://zotonic.com/)
- [ ] [Node.js](http://nodejs.org) - with [Loopback](http://strongloop.com/node-js/loopback-framework/), [AngularJS](https://angularjs.org/) and [Typescript](http://www.typescriptlang.org/)

## Journal

Possible topics to comment on for each framework.

- Ease of installation/setup? This is somewhat important to me, since ideally I would like to work with a stack that I can also recommend to friends who are fairly new to programming
- Quality of documentation?
- Availability of learning resources?
- Tooling? Database migrations, IDE support, etc.
- Productivity? Amount of boilerplate, configuration, etc.
- Templating/styling? How easy is it to work with the UI?
- Performance/scalability? req/s benchmark, resource usage, scaling options

### Vaadin

#### Installation

- Install Tomcat (extract zip, run startup.bat)
- Install Eclipse
- Install Eclipse plugins: Vaadin + Tomcat
- Install Eclipse E4 RCP patch
- [Configure Eclipse to open *.scss files properly](http://stackoverflow.com/questions/7614612/is-there-an-eclipse-editor-for-sasss-scss-files-or-syntax-coloring-plugin)
- Install Eclipse IvyDE plugin (for resolving dependencies added to ivy.xml)

No major roadblocks so far.

#### Thoughts

- Documentation: 
  - The _Vaadin Book_:
    - Has lots of code examples, but seems to gloss over topics common to JVM web development in general. 
    - Shows a bunch of different ways to do something, but assumes the reader is experienced enough to know when each technique is relevant without much explanation.
    - Code examples use deprecated classes... (e.g. Form instead of FieldGroup)
  - Hard to find code examples (full, working projects), although I did find one pretty nice github repo [here](https://github.com/rolandkrueger/vaadin-by-example)

In summary - documentation is somewhat spotty and outdated. 
Possibly suitable for experienced java devs, but definitely unfriendly toward beginners to Swing and web dev on JVM in general.
I'm sure I would be having less issues if I took the time to read through the entire Vaadin book, but if I am going to be that thorough with all the frameworks this project would just take too long.

Doesn't seem to have autoreloading setup out of the box.


### Jhipster (Spring + Angular)

- Installation: 
  - Setup was very easy with yeoman - with one minor exception: the installation guide forgets to mention that ruby is required for SASS.
  - The sample app is pretty nice, with authentication, i18n, swagger API + some other stuff
- Scaffolding for entity CRUD (both Spring AND Angular code)
- Really easy to work with (I do have some experience with Angular already though), but SO much boilerplate code!

Autoreloading of backend code doesn't seem to work out of the box - at least not for Java 8, but autoreload of angular is setup just fine with grunt.

### Grails

- Excellent autoreloading for changes on front end, backend is fine with small changes but seems to need a restart pretty often - the uncertainty of when this is needed being the biggest downside
- Decent scaffolding
- Seems like I am defaulting to performing a bunch of queries to fetch all the data needed to reload a page when I'm only interested in changing one element, where with a front-end framework like angular the default would be to use ajax
- IDE support for groovy is not excellent in GGTS
- Seems very flexible, but my approach so far feels hackish - likely since I, as per usual in this experiment, only skimmed parts of the documentation

### Play

#### Java

- "Ebean DDL generation" - automatically updates the initial db migration sql script. Pretty neat for some quick initial prototyping when combined with [play2-crud](https://github.com/hakandilek/play2-crud), which generates GUI and backend for CRUD on-the-fly
- It _should_ be straightforward to get eclipse to play nice with Play, but that's not exactly my experience. Apparently you have to manually add a folder containing compiled templates (target/scala-2.11/twirl) to the project build path - and even then eclipse is having trouble understanding what is being referenced (but it runs fine).
- Setting up routes and endpoints is simple
- Working with entities is straightforward and familiar (JPA)
- Templating language uses Scala syntax - a nice way for somebody comfortable with Java to slowly get used to Scala, but not great for beginners.
- Autoreloading of changes seems decent.

#### Scala

- IDE support is not great, I'm constantly seeing intellij complain about unused imports and missing imports, when the app is running just fine
- Different versions of different libraries require different versions of the Scala compiler = dependency hell
- I'm not particularly pleased with the documentation/tutorials, and samples seem to only work if I use the EXACT same setup wrt. libraries and their versions.

### ZK

### Dropwizard

### Ruby on Rails

Installed on windows with RailsInstaller. 
Ran into issues almost instantly when trying to create a new project, windows just doesn't play nice with ruby [(issue+fix)](https://gist.github.com/luislavena/f064211759ee0f806c88).

It's not the first time I play with Rails - and my general impression is somewhat unchanged: Convention over configuration is a nice concept, except with all the "magic" going on behind the scenes, it's hard to explain why things work (or why they don't) without having read the docs very thoroughly.

### Wicket


### Python

#### Django

#### Flask


### SPA stacks

#### Loopback, Angular, Typescript

##### Yeoman
I combined two different yeoman generators for this. 
[generator-loopback](https://github.com/strongloop/generator-loopback) for the overall project structure, and [generator-gulp-angular](https://github.com/Swiip/generator-gulp-angular) for the client directory. 
The gulp-angular generator is really nice, and offers a lot of options. 
I chose to use ui-router for routing, bootstrap for styling/layout, SASS as the CSS preprocessor and Typescript as the "Javascript flavor".
I initially experimented with Material Design for angular, but it seems to have a lot of sharp edges - or is at least not nearly as well integrated in the gulp-angular generator as bootstrap is.

##### Loopback
Loopback is an interesting nodejs framework for VERY easy creation of a RESTful backend - almost no coding, just configuration via json files.
_TODO: describe loopback angular sdk_

##### Angular
A general nice thing about angular, is the ability to quickly prototype a feature with no backend - by just storing data in the controller. Then once the workflow seems to be in place, it's just a matter of hooking the controller up to the backend.

##### Typescript
Using typescript does add more of a learning curve than I had expected, not with typescript in particular, but writing it such that the compiled javascript satisfies the expections angularjs has for the code. 
Typescript is probably a poor choice for prototyping small projects.