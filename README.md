# greendot-db

A sample database access project setup and configuration using: 

  Hibernate as a persistence provider,
  Spring for declarative transaction handling,
  Spring Data for one alternative data access mechanism.
  Foundation DAO classes as a basis for a pure JPA repository access mechanism,
  Criteria API queries in the foundation DAO JPA classes.
  
# greendot-db-deps

  All Maven dependencies expressed in a single dependency jar and supplied by Maven Central.
  
  The JPA provider specified is Hibernate v5.2.3, JPA API is v2.1, Spring Framework 4.3.3-Release

# greendot-db-domain

  A set of standard domain objects - useful across a number of distinct verticals. All of the entities are loaded by the JPA provider based on the package name. Currently, this is configured in the greendot-db-jpa-core package but needs to move.

# greendot-db-jpa-core

  A set of classes that provide default simple access mechanisms for search and mutation across the set of configured entities. The access mechanism used is pure JPA for those consumers that require it. The JPA provider configured is Hibernate, the deps module dictates which provider version is supported.
  
# greendot-db-dao

  A set of repository interfaces and implementations for pure JPA, Spring Data and JDBC DAO repositories. Each repository will manage an entity type as specified by standard domain objects located in greendot-db-domain
