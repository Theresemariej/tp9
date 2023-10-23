package champollion;

import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;


public class ChampollionJUnitTest {
	Enseignant untel;
	UE uml, java;


	@BeforeEach
	public void setUp() {
		untel = new Enseignant("untel", "untel@gmail.com");
		uml = new UE("UML");
		java = new UE("Programmation en java");		
		

	}

        @Test
        public void testHeuresPrevues(){
            untel.ajouteEnseignement(uml, 0, 1, 0);
            untel.ajouteEnseignement(java, 0, 1, 0);
            assertEquals(2, untel.heuresPrevues(),"L'enseignant doit réaliser 2h" );
        }
        
          @Test
        public void testHeuresPrevuesPourUE(){
          
            untel.ajouteEnseignement(java, 0, 5, 0);
            assertEquals(5, untel.heuresPrevuesPourUE(java),"L'enseignant doit réaliser 5h" );
        }
       

        @Test 
        public void testEnSousService(){
            untel.ajouteEnseignement(uml, 1, 1, 1);
            assertTrue (untel.sousService(), "L'enseignant doit être en sous service");

            untel.ajouteEnseignement(uml, 100, 50, 50);
            assertFalse (untel.sousService(), "L'enseignant ne doit pas être en sous service");

        }

}
