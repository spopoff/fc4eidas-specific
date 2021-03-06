/*
 * This work is Open Source and licensed by the European Commission under the
 * conditions of the European Public License v1.1 
 *  
 * (http://www.osor.eu/eupl/european-union-public-licence-eupl-v.1.1); 
 * 
 * any use of this file implies acceptance of the conditions of this license. 
 * Unless required by applicable law or agreed to in writing, software distributed 
 * under the License is distributed on an "AS IS" BASIS,  WITHOUT WARRANTIES OR
 * CONDITIONS OF ANY KIND, either express or implied. See the License for the 
 * specific language governing permissions and    limitations under the License.
 */
package eu.eidas.node.specific.validation;

import java.util.Arrays;
import java.util.List;
import java.util.Locale;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import eu.eidas.auth.commons.CountryCodes;
import eu.eidas.auth.specific.ICheckAttributeValue;
import eu.eidas.node.auth.specific.SpecificEidasNode;

/**
 * Class that implements the validation of the Country Code of Birth attribute.
 * 
 * @author ricardo.ferreira@multicert.com, renato.portela@multicert.com,
 *         luis.felix@multicert.com, hugo.magalhaes@multicert.com
 * 
 */
public final class ValidateCountryCodeOfBirth implements ICheckAttributeValue {
   
   /**
    * Logger object.
    */
   private static final Logger LOG = LoggerFactory.getLogger(SpecificEidasNode.class
      .getName());
   
   /**
    * {@inheritDoc} Checks if the value provided is in the range of
    * {@link Locale#getISOCountries}.
    */
   public boolean checkValue(final List<String> values,
      final String expectedValue) {

      boolean retVal = false;
      
      final String value = values.get(0);
      if (value != null) {
         final List<String> expectedValues =
            Arrays.asList(Locale.getISOCountries());
         retVal =
            expectedValues.contains(value)
               || CountryCodes.hasCountryCodeAlpha3(value);
      }
      
      LOG.trace("[checkValue] " + retVal);
      return retVal;
   }
   
}
