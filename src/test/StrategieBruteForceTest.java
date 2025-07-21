package com.cracker.strategie;

import com.cracker.cible.CibleLocale;
import org.junit.Test;
import static org.junit.Assert.*;

public class StrategieBruteForceTest {
    @Test
    public void testTrouveMotDePasse() {
        // Arrange
        StrategieBruteForce brute = new StrategieBruteForce();
        Cible cible = new CibleLocale(); 

        // Act
        // admin/azerty sont définis dans CibleLocale
        String motDePasseTrouve = brute.lancer("admin", cible);

        assertNotNull("Le mot de passe aurait dû être trouvé.", motDePasseTrouve);
        assertEquals("azerty", motDePasseTrouve);
    }
}
