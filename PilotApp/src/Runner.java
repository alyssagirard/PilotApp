import java.io.IOException;
import java.net.URISyntaxException;

import javax.swing.UIManager;

public class Runner
{
 /**
  * Main runner for the Pilot app.
  * @param args The arguments for the desired calculator.
  * @throws IOException Thrown if there is an issue with the input and/or output.
  * @throws URISyntaxException Thrown if there is an issue with the syntax of the URI.
  */
  public static void main(final String[] args) throws IOException, URISyntaxException
  {
    try
    {
      UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
    }
    catch (Exception e)
    {
      // Use the default
    }
    new PilotPal();
  }
}
