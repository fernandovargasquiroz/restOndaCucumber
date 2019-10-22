Feature: Get cotizacion
  Scenario: cotizacion del euro
	Given cotizacion del dia
	When hay cotizacion
	Then the status code is 200
	And response includes the following
	| quotes.base_currency	        | [EUR]                         |
	| quotes.ask			| [7.91092]			|

Scenario: cotizacion del dolar
	Given cotizacion del dia
	When hay cotizacion
	Then the status code is 200
	And response includes the following
	| quotes.base_currency	        | [USD]                           |
	| quotes.ask			| [7.08693]			|

