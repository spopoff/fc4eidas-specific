/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package eu.eidas.node.auth.specific;

import eu.eidas.auth.engine.EIDASSAMLEngine;
import eu.eidas.auth.engine.core.SAMLEngineEncryptionI;
import eu.eidas.auth.engine.core.eidas.EidasExtensionProcessor;
import eu.eidas.engine.exceptions.EIDASSAMLEngineException;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author SPOPOFF
 */
public class normalizeTest {
    private SpecificEidasNode nodeSpec;
    private static final String TEST_KEYSTORE_LOCATION="src/test/resources/keyStoreCountry1.jks";
    private static final String TEST_KEYSTORE_PASSWORD="local-demo";
    private static final String TEST_KEYSTORE_SERIALNUMBER="54D8A000";
    private static final String TEST_KEYSTORE_ISSUER="CN=local-demo-cert, OU=DIGIT, O=European Comission, L=Brussels, ST=Belgium, C=BE";
    private static final String TEST_SIGNATURE_ALGORITHM="http://www.w3.org/2001/04/xmldsig-more#rsa-sha512";
    private static final String TEST_COUNTRY_NAME="Belgium";
    private static EIDASSAMLEngine engine = null;
//    private static EIDASSAMLEngine engineO =null;
    static {
        try {
            engine = EIDASSAMLEngine.createSAMLEngine("METADATATEST");
            engine.setExtensionProcessor(new EidasExtensionProcessor());
            engine.setEncrypterProperty(SAMLEngineEncryptionI.SELF_SIGNED_PROPERTY, "true");
        }catch (EIDASSAMLEngineException exc){
            assertTrue(false);
        }
    }
    public normalizeTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
        nodeSpec = new SpecificEidasNode();
        nodeSpec.setSamlEngine("Specific");
    }
    
    @After
    public void tearDown() {
    }

    // TODO add test methods here.
    // The methods must be annotated with annotation @Test. For example:
    //
    //@Test
     public void changeAttrName() {
     }
}
