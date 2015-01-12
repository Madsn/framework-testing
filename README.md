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

- Authentication (Login at least, signup not a requirement)
- Setup of team (CRUD member)
- Ability to cycle through team members with long-term persistence (for our daily Battleships game vs the other team). It should be possible to postpone the "turn" of the team member in case that person is not available
- Ability to draw a name at random from the team without influencing the regular cycle

## The competition

- [ ] [Vaadin](https://vaadin.com/home)
- [ ] [ZK](http://www.zkoss.org/)
- [ ] [Jhipster (Spring + Angular)](https://jhipster.github.io/)
- [ ] [Grails](https://grails.org/)
- [ ] [Play!2 (Java)](https://www.playframework.com/)
- [ ] [Play!2 (Scala)](https://www.playframework.com/)
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


#### Documentation

#### Learning resources

#### Tooling

#### Productivity

#### Templating/Styling

#### Performance

### ZK

### Jhipster (Spring + Angular)

### Grails

### Play! 2.0

#### Java

#### Scala

### Dropwizard

### Jersey + ??
