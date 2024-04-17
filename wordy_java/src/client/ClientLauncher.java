package client;

import org.omg.CORBA.ORBPackage.InvalidName;
import org.omg.CosNaming.*;
import org.omg.CosNaming.NamingContextPackage.*;
import org.omg.CORBA.*;
import wordy_idl.*;

import java.util.Properties;

public class ClientLauncher {

    public static void main(String[] args) {
        try {
            Properties props = new Properties();
            props.put("org.omg.CORBA.ORBInitialPort", "1050");
            props.put("org.omg.CORBA.ORBInitialHost", "192.168.1.17");
            ORB orb = ORB.init(args, props);
            org.omg.CORBA.Object objRef = orb.resolve_initial_references("NameService");
            NamingContextExt ncRef = NamingContextExtHelper.narrow(objRef);
            String name = "Game Menu";
            GameMenuServant gameMenuServant = GameMenuServantHelper.narrow(ncRef.resolve_str(name));

            System.out.println("Successfully initiated connection with ORB.");

            LoginFrame loginFrame = new LoginFrame("Wordy Login", gameMenuServant);
            loginFrame.launchFrame();


        } catch (InvalidName e) {
            e.printStackTrace();
        } catch (org.omg.CosNaming.NamingContextPackage.InvalidName invalidName) {
            invalidName.printStackTrace();
        } catch (CannotProceed cannotProceed) {
            cannotProceed.printStackTrace();
        } catch (NotFound notFound) {
            //notFound.printStackTrace();
        } catch (Exception e) {
            System.out.println("A connection cannot be established; please try again later");
        }


    }
}
