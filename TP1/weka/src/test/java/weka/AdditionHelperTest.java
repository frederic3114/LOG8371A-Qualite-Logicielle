package weka;

import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;


/**
 * Tests MultiFilter. Run from the command line with: <p/>
 * java weka.filters.MultiFilterTest
 *
 * @author FracPete (fracpete at waikato dot ac dot nz)
 * @version $Revision$
 */
public class AdditionHelperTest extends TestCase {

  public AdditionHelperTest(String name) {
    super(name);  
  }

  public void testPositiveAddition() {
    assertEquals(AdditionHelper.Add(1, 1), 2);
  }

  public void testNegativeAddition() {
    assertEquals(AdditionHelper.Add(-1, -1), -2);
  }

  public static Test suite() {
    return new TestSuite(AdditionHelperTest.class);
  }

  public static void main(String[] args){
    junit.textui.TestRunner.run(suite());
  }

}
