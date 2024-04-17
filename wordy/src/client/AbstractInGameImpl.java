package client;

import server.GameServer;
import wordy_idl.*;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class AbstractInGameImpl extends AbstractInGameFrame {
    protected GameServant inGameServant;

    public AbstractInGameImpl(String title, GameServant inGameServant) {
        this.inGameServant = inGameServant;
        inGameFrame = new JFrame(title);
        inGameFrame.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                super.windowClosing(e);
                System.exit(0);
            }
        });
    }


    public void implementButtons() {
        String generatedLetters = inGameServant.generateRandomLetters();
        givenLetters.setText(generatedLetters);

        SUBMITButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String inputWord = inputWordTextField.getText().toLowerCase();

                boolean isValid;

                try {
                    isValid = inGameServant.checkWord(inputWord, generatedLetters);
                    if (isValid) {
                        JOptionPane.showMessageDialog(null, inputWord + " is a valid word!\n");
                    } else {
                        JOptionPane.showMessageDialog(null, "The word " + inputWord + " does not exist.\n");
                    }
                } catch (InvalidWordException ex) {
                    JOptionPane.showMessageDialog(
                            null,
                            "Your word is invalid.",
                            "Invalid word",
                            JOptionPane.ERROR_MESSAGE
                    );
                } catch (WordLengthException ex) {
                    JOptionPane.showMessageDialog(
                            null,
                            "Word must be at least 5 characters long.",
                            "Invalid word",
                            JOptionPane.ERROR_MESSAGE
                    );
                } catch (WrongLetterException ex) {
                    JOptionPane.showMessageDialog(
                            null,
                            "The/Some letters are not included in the random letters",
                            "Invalid Word",
                            JOptionPane.ERROR_MESSAGE
                    );
                }
            }
        });
    }

    protected void launchFrame() {

        implementButtons();

        inGameFrame.setContentPane(inGameMenuPanel);
        inGameFrame.setLocationRelativeTo(null);
        inGameFrame.setSize(1000, 600);
        inGameFrame.setResizable(false);
        inGameFrame.setVisible(true);
    }
}
