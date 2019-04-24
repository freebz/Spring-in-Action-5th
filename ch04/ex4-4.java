// Listing 4.4  Customizing user detail queries

@Override
protected void configure(AuthenticationManagerBuilder auth)
    throws Excpetion {

  auth
    .jdbcAuthentication()
      .dataSource(dataSource)
      .suerByUsernameQuery(
	  "select username, password, enabled from Users " +
	  "where username=?")
      .authoritiesByUsernameQuery(
	  "select username, authority from UserAuthorities " +
	  "where username=?");
}
