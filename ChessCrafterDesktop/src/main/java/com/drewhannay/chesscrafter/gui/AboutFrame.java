package com.drewhannay.chesscrafter.gui;

import com.drewhannay.chesscrafter.utility.AppConstants;
import com.drewhannay.chesscrafter.utility.GuiUtility;
import com.drewhannay.chesscrafter.utility.Messages;

import javax.swing.*;
import java.awt.*;
import java.io.IOException;
import java.net.URI;

public class AboutFrame extends JFrame {
    public AboutFrame(JPanel mainPanel) {
        initGUIComponents(mainPanel);
    }

    private void initGUIComponents(JPanel mainPanel) {
        setTitle(Messages.getString("AboutFrame.about") + AppConstants.APP_NAME); //$NON-NLS-1$
        setSize(350, 450);
        setResizable(false);
        setLocationRelativeTo(this);
        setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
        GridBagConstraints constraints = new GridBagConstraints();

        mAboutPanel = new ChessPanel();
        mAboutPanel.setLayout(new GridBagLayout());

        JLabel frontPageImage = null;
        JLabel piecePicture = null;
        try {
            frontPageImage = new JLabel(GuiUtility.createImageIcon(250, 250, "/chess_logo.png")); //$NON-NLS-1$
            piecePicture = new JLabel(GuiUtility.createImageIcon(48, 48, "/d_King.png")); //$NON-NLS-1$
        } catch (IOException e1) {
            e1.printStackTrace();
        }

        Font font = new Font(Messages.getString("AboutFrame.verdana"), Font.BOLD, 18); //$NON-NLS-1$
        JLabel title = GuiUtility.createJLabel(AppConstants.APP_NAME + Messages.getString("AboutFrame.newline")); //$NON-NLS-1$
        title.setFont(font);

        JLabel versionLabel = GuiUtility.createJLabel(Messages.getString("AboutFrame.version")); //$NON-NLS-1$
        JLabel visitSiteLabel = GuiUtility.createJLabel(Messages.getString("AboutFrame.visitOurSite")); //$NON-NLS-1$

        JButton siteButton = new JButton();
        siteButton.setIcon(piecePicture.getIcon());
        siteButton.addActionListener(event -> {
            if (Desktop.isDesktopSupported()) {
                try {
                    Desktop.getDesktop().browse(new URI(AppConstants.PROJECT_URL));
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });

        constraints.gridy = 0;
        constraints.insets = new Insets(10, 5, 10, 5);
        mAboutPanel.add(title, constraints);
        constraints.gridy = 1;
        constraints.insets = new Insets(0, 0, 0, 0);
        mAboutPanel.add(frontPageImage, constraints);
        constraints.gridy = 2;
        constraints.insets = new Insets(10, 5, 5, 5);
        mAboutPanel.add(versionLabel, constraints);
        constraints.gridy = 3;
        constraints.insets = new Insets(10, 5, 5, 5);
        mAboutPanel.add(visitSiteLabel, constraints);
        constraints.gridy = 4;
        mAboutPanel.add(siteButton, constraints);

        add(mAboutPanel);

        setVisible(true);
    }

    private static final long serialVersionUID = 7316549497827793096L;
    private ChessPanel mAboutPanel;
}
