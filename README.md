<!-- START doctoc generated TOC please keep comment here to allow auto update -->
<!-- DON'T EDIT THIS SECTION, INSTEAD RE-RUN doctoc TO UPDATE -->
**Table of Contents**  *generated with [DocToc](http://doctoc.herokuapp.com/)*

- [Battle of the JVM frameworks](#battle-of-the-jvm-frameworks)
  - [The application](#the-application)
    - [Features:](#features)
  - [The competition](#the-competition)
  - [Journal](#journal)
    - [Vaadin](#vaadin)
      - [Installation](#installation)
      - [Documentation](#documentation)
      - [Learning resources](#learning-resources)
      - [Tooling](#tooling)
      - [Productivity](#productivity)
      - [Templating/Styling](#templatingstyling)
      - [Performance](#performance)
    - [ZK](#zk)
    - [Jhipster (Spring + Angular)](#jhipster-spring--angular)
    - [Grails](#grails)
    - [Play! 2.0](#play!-20)
      - [Java](#java)
      - [Scala](#scala)
    - [Dropwizard](#dropwizard)
    - [Jersey + ??](#jersey--)

<!-- END doctoc generated TOC please keep comment here to allow auto update -->

# Battle of the JVM frameworks

I've singled out a few web development stacks that I want to test out.

My primary requirement for now is that it should run on the JVM, but I may decide later on to expand and include frameworks like RoR, Django, Node.js, ASP.NET, Clojure/Luminus and possibly others.

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

- [ ] [Vaadin](https://vaadin.com/home)
- [ ] [Jhipster (Spring + Angular)](https://jhipster.github.io/)
- [ ] [Grails](https://grails.org/)
- [ ] [Play!2 (Java)](https://www.playframework.com/)
- [ ] [Play!2 (Scala)](https://www.playframework.com/)
- [ ] [ZK](http://www.zkoss.org/)
- [ ] [Dropwizard](https://dropwizard.github.io/dropwizard/)
- [ ] [Jersey + ??](https://jersey.java.net/)


## Journal

Comment on the following for each framework.

- Ease of installation/setup?
- Quality of documentation?
- Availability of learning resources?
- Tooling? Database migrations, IDE support, etc.
- Productivity? Amount of boilerplate, configuration, etc.
- Templating/styling? How easy is it to work with the UI?
- Performance? req/s benchmark, resource usage

### Vaadin

#### Installation

- Install Tomcat (extract zip, run startup.bat)
- Install Eclipse
- Install Eclipse plugins: Vaadin + Tomcat
- Install Eclipse E4 RCP patch
- [Configure Eclipse to open *.scss files properly](http://stackoverflow.com/questions/7614612/is-there-an-eclipse-editor-for-sasss-scss-files-or-syntax-coloring-plugin)
- Install Eclipse IvyDE plugin (for resolving dependencies added to ivy.xml)

No major roadblocks so far.

#### Development

##### Step 1: Basic persistence

For persistence I was following the steps described in the [Vaadin book](https://vaadin.com/book/-/page/jpacontainer.installation.html)

Installed JPAContainer extension by adding a line to ivy.xml.
Eclipse automatically downloaded the extension as soon as I saved the file :).
Installed eclipselink and H2 via Ivy.
Configured persistence.xml.

*ISSUE*: When code is reloaded without restarting tomcat, I get a database exception because H2 is not running in TCP mode and can only accept one connect, which is not properly closed when code is reloaded.

##### Step 2: Create member

#### Thoughts

- Documentation: 
  - The _Vaadin Book_:
    - Has lots of code examples, but seems to gloss over topics common to JVM web development in general. 
    - Shows a bunch of different ways to do something, but assumes the reader is experienced enough to know when each technique is relevant without much explanation.
    - Code examples use deprecated classes... (e.g. Form instead of FieldGroup)

### Jhipster (Spring + Angular)

### Grails

### Play! 2.0

#### Java

#### Scala

### ZK

### Dropwizard

### Jersey + ??
