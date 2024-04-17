package client;

import jdk.nashorn.internal.scripts.JO;
import wordy_idl.*;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

abstract class AbstractLoginFrameImpl extends AbstractLoginFrame{

    public void implementButtonListeners() {

        exitButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                loginFrame.dispose();
                System.exit(0);
            }
        });

        loginButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    if (usernameField.getText().equals("") || passwordField.getText().equals(""))
                        throw new IncompleteCredentialsException();
                    String player_id = String.valueOf(gameMenuServant.logIn(usernameField.getText(), passwordField.getText()));
                    System.out.println(player_id);
                    JOptionPane.showMessageDialog(
                            null,
                            "Successfully logged in as " + usernameField.getText(),
                             "Logged in",
                            JOptionPane.INFORMATION_MESSAGE
                    );
                    loginFrame.dispose();

                    AbstractGameMenuFrameImpl menuFrame = new
                            AbstractGameMenuFrameImpl("Wordy Game - Main Menu", gameMenuServant);
                    menuFrame.launchFrame();


                } catch (InvalidPasswordException ex) {
                    JOptionPane.showMessageDialog(
                            null,
                            "Your password is incorrect.",
                            "Invalid password",
                            JOptionPane.ERROR_MESSAGE
                            );
                    //ex.printStackTrace();
                } catch (NoUserFoundException ex) {
                    JOptionPane.showMessageDialog(
                            null,
                            "No user of the given username exists.",
                            "No user found",
                            JOptionPane.ERROR_MESSAGE
                    );
                    //ex.printStackTrace();
                } catch (LoggedInException ex) {
                    JOptionPane.showMessageDialog(
                            null,
                            "You are already logged in from another machine.",
                            "Already logged in",
                            JOptionPane.ERROR_MESSAGE
                    );
                    //ex.printStackTrace();
                } catch (IncompleteCredentialsException incompleteCredentialsException) {
                    JOptionPane.showMessageDialog(
                            null,
                            "Please fill in the missing fields before you log in",
                            "Incomplete credentials",
                            JOptionPane.ERROR_MESSAGE
                    );
                    //incompleteCredentialsException.printStackTrace();
                }
            }
        });
    }

}
