// Listing 4.9  Using Spring expressions to define authorization rules

@Override
protected void configure(HttpSecurity http) throws Exception {
    http
	.authorizeRequests()
	.antMatchers("/design", "/orders")
	    .access("hasRole('ROLE_USER')")
	.antMatchers("/", "/**").access("permitAll")
	;
}
