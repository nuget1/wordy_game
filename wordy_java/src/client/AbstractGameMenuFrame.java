package client;

import wordy_idl.GameMenuServant;
import wordy_idl.GameServant;

import javax.swing.*;

abstract class AbstractGameMenuFrame {
    protected JFrame gameMenuFrame;
    protected JFrame loginFrame;
    protected JButton playGameButton;
    protected JPanel gameMenuPanel;
    protected JButton showBestPlayersButton;
    protected JButton showLongestWordsButton;
    protected JButton exitButton;
    protected GameMenuServant gameMenuServant;
    protected GameServant inGameServant;

    protected abstract void implementButtons();
}
