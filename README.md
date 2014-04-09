name-gen, a version name generator
==================================

**Version 0.3.1 (rela ilves)**
* Ability to limit the length of the generated name via the route /:max-len 
 * e.g. localhost:3000/9 will yield names no longer than nine characters 
 * The parameter must be larger than 6 since there are no shorter names at the moment (parameters less than 7 are ignored)


**Version 0.3.0 (nelikymppinen mustajättiläisorava)**

* A lot more animals (in Finnish), mostly mammals
* Adjectives link to Wiktionary, nouns to Wikipedia (Finnish ones)

**Version 0.2.0 (ahdasmielinen lammas)**

* Internal tools for scraping words off lists on web pages
* A bit larger Finnish vocabulary

**Version 0.1.0 (raunchy tiger)**

initial version

usage
=====

`lein ring server`

todo
====
* feedback link or something
* ~~show current version, revision history somewhere~~
* keep a count of generated names
* larger vocabulary
* RESTful API
* ~~link the adjective to wiktionary?~~
* ...
* selectable language / word sets


