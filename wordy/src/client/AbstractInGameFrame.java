package client;

import javax.swing.*;


abstract class AbstractInGameFrame {

    protected JFrame inGameFrame;
    protected JPanel inGameMenuPanel;

    protected JList playersInGame;
    protected JTextField inputWordTextField;
    protected JButton SUBMITButton;
    protected JTextArea givenLetters;


    protected abstract void implementButtons();
}
