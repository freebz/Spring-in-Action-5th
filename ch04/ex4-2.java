// Listing 4.2  Defining users in an in-memory user store

@Override
protected void configure(AuthenticationManagerBuilder auth)
    throws Exception {

  auth
    .inMemoryAuthentication()
      .withUser("buzz")
	.password("infinity")
	.authorities("ROLE_USER")
      .and()
      .withUser("woody")
	.password("bullseye")
	.authorities("ROLE_USER");
}
