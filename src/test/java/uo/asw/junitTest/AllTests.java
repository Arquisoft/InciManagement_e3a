package uo.asw.junitTest;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

@RunWith(Suite.class)
@SuiteClasses({
	
	CategoriaTest.class,
	IncidenciaBDTest.class,
	PropiedadTest.class,
	UsuarioBDTest.class
})
public class AllTests { }