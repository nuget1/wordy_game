package client;
import wordy_idl.GameMenuServant;
import wordy_idl.NoPlayersJoinedException;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.Timer;
import java.util.TimerTask;

class AbstractGameMenuFrameImpl extends AbstractGameMenuFrame{

    private GameMenuServant gameMenuServant;


    @Override
    public void implementButtons() {

        playGameButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println("Start/Play button Pressed.");

                try {
                    // synchronize with server countdown
                    gameMenuServant.startGame();
                    int countdown = gameMenuServant.inQueue();
                    Timer timer = new Timer();
                    timer.scheduleAtFixedRate(new TimerTask() {
                        int remainingTime = countdown;
                        @Override
                        public void run() {
                            if (remainingTime <= 0) {
                                timer.cancel();
                                // TODO: show in-game frame
                            } else {
                                System.out.println("Remaining time: " + remainingTime);
                                remainingTime--;
                            }
                        }
                    }, 0, 1000);

                    //AbstractInGameImpl inGameFrame = new
                    //        AbstractInGameImpl("Wordy Game - In Game", inGameServant);
                    //inGameFrame.launchFrame();
                } catch (NoPlayersJoinedException ex) {
                    throw new RuntimeException(ex);
                }
            }
        });

        showBestPlayersButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println("Show Best Players button Pressed.");
                gameMenuServant.getBestPlayers();
            }
        });


        showLongestWordsButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println("Show Best Players button Pressed.");
                gameMenuServant.getLongestWords();
            }
        });

        exitButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                loginFrame.setVisible(true);
                gameMenuFrame.setVisible(false);
            }
        });
    }
    protected AbstractGameMenuFrameImpl(String title, GameMenuServant gameMenuServant) {
        this.gameMenuServant = gameMenuServant;
        gameMenuFrame = new JFrame(title);
        gameMenuFrame.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                super.windowClosing(e);
                System.exit(0);
            }
        });
    }

    protected void launchFrame() {

        implementButtons();
        gameMenuFrame.setContentPane(gameMenuPanel);
        gameMenuFrame.setLocationRelativeTo(null);
        gameMenuFrame.setSize(500, 300);
        gameMenuFrame.setResizable(false);
        gameMenuFrame.setVisible(true);
    }


}
