package DisplayServer;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.io.File;
import Radio.Radio;
import RadioProtocol.RadioOutput;

public class Display extends JFrame {
    private final DisplayController controller;
    private JLabel RadioName;
    private JLabel Speed;
    private JLabel StreamSize;
    private JLabel Url;
    private Button addSong;
    private Button deleteSong;
    private JLabel info;
    private JScrollPane jScrollPane1;
    private JSeparator jSeparator2;
    private JSeparator jSeparator3;
    private JSeparator jSeparator4;
    private JPanel listPanel;
    private Button upMoveSongs;
    private JTable songsList;
    private Button startServer;
    private Button stopServer;
    private static javax.swing.JLabel ListenersNumber;
    private javax.swing.JLabel serverState;
    private DefaultTableModel tableModel;

    public Display(DisplayController controller) {
        this.controller = controller;
        setTitle("Radio Internet");
        initComponents();
        setLocationRelativeTo(null);
        setVisible(true);
    }
    private void initComponents() {
        JPanel mainPanel = new JPanel();
        listPanel = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        songsList = new javax.swing.JTable();
        upMoveSongs = new java.awt.Button();
        addSong = new java.awt.Button();
        deleteSong = new java.awt.Button();
        JLabel title = new JLabel();
        jSeparator2 = new javax.swing.JSeparator();
        jSeparator3 = new javax.swing.JSeparator();
        ListenersNumber = new javax.swing.JLabel();
        jSeparator4 = new javax.swing.JSeparator();
        stopServer = new java.awt.Button();
        startServer = new java.awt.Button();
        RadioName = new javax.swing.JLabel();
        Url = new javax.swing.JLabel();
        StreamSize = new javax.swing.JLabel();
        Speed = new javax.swing.JLabel();
        info = new javax.swing.JLabel();
        serverState = new javax.swing.JLabel();
        tableModel = new javax.swing.table.DefaultTableModel(
                new Object [][] {},
                new String [] {"Liste des musiques"}
        ) {
            final boolean[] canEdit = new boolean [] {false};
            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        };

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(255, 255, 255));
        setResizable(false);

        mainPanel.setBackground(new java.awt.Color(255, 255, 255));

        listPanel.setBackground(new java.awt.Color(255, 255, 255));

        songsList.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        songsList.setFont(new java.awt.Font("Segoe UI Light", 1, 12)); // NOI18N
        songsList.setForeground(new java.awt.Color(51, 51, 255));
        songsList.setModel(tableModel);
        songsList.setColumnSelectionAllowed(true);
        songsList.setDebugGraphicsOptions(javax.swing.DebugGraphics.NONE_OPTION);
        songsList.setDropMode(javax.swing.DropMode.ON);
        songsList.setGridColor(new java.awt.Color(102, 102, 102));
        songsList.setSelectionBackground(new java.awt.Color(50, 86, 190));
        songsList.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        songsList.setShowHorizontalLines(false);
        songsList.setShowVerticalLines(false);
        songsList.getTableHeader().setResizingAllowed(false);
        songsList.getTableHeader().setReorderingAllowed(false);
        jScrollPane1.setViewportView(songsList);
        songsList.getColumnModel().getSelectionModel().setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);

        javax.swing.GroupLayout listPanelLayout = new javax.swing.GroupLayout(listPanel);
        listPanel.setLayout(listPanelLayout);
        listPanelLayout.setHorizontalGroup(
                listPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(listPanelLayout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                                .addContainerGap())
        );
        listPanelLayout.setVerticalGroup(
                listPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, listPanelLayout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 181, Short.MAX_VALUE)
                                .addContainerGap())
        );

        upMoveSongs.setBackground(new java.awt.Color(50, 86, 190));
        upMoveSongs.setFont(new java.awt.Font("Gadugi", 1, 12)); // NOI18N
        upMoveSongs.setForeground(new java.awt.Color(255, 255, 255));
        upMoveSongs.setLabel("Déplacer en bas");
        upMoveSongs.setPreferredSize(new java.awt.Dimension(591, 299));

        addSong.setBackground(new java.awt.Color(50, 86, 190));
        addSong.setFont(new java.awt.Font("Gadugi", 1, 12)); // NOI18N
        addSong.setForeground(new java.awt.Color(255, 255, 255));
        addSong.setLabel("Ajouter");

        deleteSong.setBackground(new java.awt.Color(50, 86, 190));
        deleteSong.setFont(new java.awt.Font("Gadugi", 1, 12)); // NOI18N
        deleteSong.setForeground(new java.awt.Color(255, 255, 255));
        deleteSong.setLabel("Supprimer");
        deleteSong.setPreferredSize(new java.awt.Dimension(591, 299));

        title.setFont(new java.awt.Font("Yu Gothic UI", 1, 18)); // NOI18N
        title.setText("Internet Radio Planificateur");

        ListenersNumber.setFont(new java.awt.Font("Yu Gothic UI", 0, 12)); // NOI18N
        ListenersNumber.setForeground(new java.awt.Color(51, 51, 51));

        stopServer.setBackground(new java.awt.Color(204, 0, 0));
        stopServer.setFont(new java.awt.Font("Gadugi", 1, 12)); // NOI18N
        stopServer.setForeground(new java.awt.Color(255, 255, 255));
        stopServer.setLabel("Stop");
        stopServer.setPreferredSize(new java.awt.Dimension(591, 299));

        startServer.setBackground(new java.awt.Color(0, 153, 51));
        startServer.setFont(new java.awt.Font("Gadugi", 1, 12)); // NOI18N
        startServer.setForeground(new java.awt.Color(255, 255, 255));
        startServer.setLabel("Start");
        startServer.setPreferredSize(new java.awt.Dimension(591, 299));

        RadioName.setFont(new java.awt.Font("Yu Gothic UI", 0, 12)); // NOI18N
        RadioName.setForeground(new java.awt.Color(51, 51, 51));

        Url.setFont(new java.awt.Font("Yu Gothic UI", 0, 12)); // NOI18N
        Url.setForeground(new java.awt.Color(51, 51, 51));
        Url.setToolTipText("");

        StreamSize.setFont(new java.awt.Font("Yu Gothic UI", 0, 12)); // NOI18N
        StreamSize.setForeground(new java.awt.Color(51, 51, 51));
        StreamSize.setToolTipText("");

        Speed.setFont(new java.awt.Font("Yu Gothic UI", 0, 12)); // NOI18N
        Speed.setForeground(new java.awt.Color(51, 51, 51));
        Speed.setToolTipText("");

        info.setFont(new java.awt.Font("Yu Gothic UI", 1, 12)); // NOI18N
        info.setForeground(new java.awt.Color(51, 51, 51));
        info.setText("Information Radio :");

        serverState.setFont(new java.awt.Font("Yu Gothic UI", 0, 12)); // NOI18N
        serverState.setToolTipText("");

        textSetter();

        javax.swing.GroupLayout MainPanelLayout = new javax.swing.GroupLayout(mainPanel);
        mainPanel.setLayout(MainPanelLayout);
        MainPanelLayout.setHorizontalGroup(
                MainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jSeparator2, javax.swing.GroupLayout.Alignment.TRAILING)
                        .addComponent(jSeparator3, javax.swing.GroupLayout.Alignment.TRAILING)
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, MainPanelLayout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(info)
                                .addGroup(MainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(MainPanelLayout.createSequentialGroup()
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 94, Short.MAX_VALUE)
                                                .addComponent(title)
                                                .addGap(163, 163, 163))
                                        .addGroup(MainPanelLayout.createSequentialGroup()
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(jSeparator4))))
                        .addGroup(MainPanelLayout.createSequentialGroup()
                                .addGroup(MainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(MainPanelLayout.createSequentialGroup()
                                                .addComponent(listPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addGroup(MainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                        .addGroup(MainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                                .addComponent(upMoveSongs, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 143, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                .addComponent(deleteSong, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 143, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                        .addComponent(addSong, javax.swing.GroupLayout.PREFERRED_SIZE, 143, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                        .addGroup(MainPanelLayout.createSequentialGroup()
                                                                .addComponent(startServer, javax.swing.GroupLayout.PREFERRED_SIZE, 68, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                                .addComponent(stopServer, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE))))
                                        .addGroup(MainPanelLayout.createSequentialGroup()
                                                .addContainerGap()
                                                .addGroup(MainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                        .addGroup(MainPanelLayout.createSequentialGroup()
                                                                .addComponent(ListenersNumber, javax.swing.GroupLayout.PREFERRED_SIZE, 321, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                                .addComponent(Speed, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                                .addComponent(serverState, javax.swing.GroupLayout.PREFERRED_SIZE, 98, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                        .addGroup(MainPanelLayout.createSequentialGroup()
                                                                .addComponent(RadioName, javax.swing.GroupLayout.PREFERRED_SIZE, 201, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                                .addComponent(Url, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                                .addComponent(StreamSize, javax.swing.GroupLayout.PREFERRED_SIZE, 172, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                .addGap(8, 8, 8)))))
                                .addContainerGap())
        );
        MainPanelLayout.setVerticalGroup(
                MainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(MainPanelLayout.createSequentialGroup()
                                .addComponent(jSeparator3, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(title, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(16, 16, 16)
                                .addComponent(jSeparator2, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGroup(MainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(MainPanelLayout.createSequentialGroup()
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(addSong, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(deleteSong, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(upMoveSongs, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                .addGroup(MainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                        .addComponent(startServer, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                        .addComponent(stopServer, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                .addGap(30, 30, 30)
                                                .addComponent(jSeparator4, javax.swing.GroupLayout.PREFERRED_SIZE, 11, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, MainPanelLayout.createSequentialGroup()
                                                .addGap(2, 2, 2)
                                                .addComponent(listPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 7, Short.MAX_VALUE)
                                                .addComponent(info)
                                                .addGap(2, 2, 2)))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(MainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(RadioName, javax.swing.GroupLayout.PREFERRED_SIZE, 18, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(Url, javax.swing.GroupLayout.PREFERRED_SIZE, 18, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(StreamSize, javax.swing.GroupLayout.PREFERRED_SIZE, 18, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(MainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(ListenersNumber, javax.swing.GroupLayout.PREFERRED_SIZE, 18, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(Speed, javax.swing.GroupLayout.PREFERRED_SIZE, 18, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(serverState, javax.swing.GroupLayout.PREFERRED_SIZE, 18, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addContainerGap())
        );

        ListenersNumber.getAccessibleContext().setAccessibleName("Nombre des personnes qui écoutent ce stream:");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(mainPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(mainPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        //Buttons Actions Listeners
        addSong.addActionListener(e -> {
            JFileChooser fileChooser = new JFileChooser();
            int result = fileChooser.showOpenDialog(this);
            if (result == JFileChooser.APPROVE_OPTION) {
                File selectedFile = fileChooser.getSelectedFile();
                controller.addSong(selectedFile.getAbsolutePath());
                Object[] obj = {selectedFile.getAbsolutePath()};
                tableModel.addRow(obj);
            }

        });
        deleteSong.addActionListener(e -> {
            int index = songsList.getSelectedRow();
            if(!(index >= 0)) JOptionPane.showMessageDialog(null,"Aucune musique n'a était selectionnée!");
            else{
                int res = JOptionPane.showConfirmDialog(this, "Êtes vous sûr de vouloir supprimer cette musique?","Supprimer Musique",JOptionPane.YES_NO_CANCEL_OPTION,JOptionPane.ERROR_MESSAGE);
                if(res == JOptionPane.OK_OPTION){
                    controller.deleteSong(index);
                    tableModel.removeRow(index);
                }
            }
        });
        upMoveSongs.addActionListener(e -> {
            int index = songsList.getSelectedRow();
            try{
                tableModel.moveRow(index,index,index+1);
                controller.upMoveSong(index);
            }catch (Exception ee){}
        });
        startServer.addActionListener(e->{
            if(tableModel.getRowCount() <= 0){
                JOptionPane.showMessageDialog(null, "Aucune musique n'a été séléctionnée!");
            }else{
                String name = JOptionPane.showInputDialog(this,"Nom de la Radio : ");
                controller.runServer(name);
                startServer.setEnabled(false);
                textSetter();
            }

        });
        stopServer.addActionListener(e ->{
            controller.stopServer();
            startServer.setEnabled(true);
            textSetter();
        });
        //End Listeners
        pack();
    }

    //Texts Setter Method
    private void textSetter(){
        RadioName.setText("Radio : "+Radio.getNomRadio());
        Url.setText("Url : "+Radio.getUrl());
        ListenersNumber.setText("Nombre des personnes qui écoutent ce stream : "+Radio.getListeners());
        serverState.setText("State : "+Radio.getRadioState());
        if(Radio.getRadioState() == Radio.state.Stopped){
            serverState.setForeground(new java.awt.Color(204, 0, 0));
        }else{
            serverState.setForeground(new java.awt.Color(0, 153, 51));
        }
        Speed.setText("Vitesse : "+"0"+" Kb/s");
        StreamSize.setText("Stream Size : 64192");
    }

    public static void main(String[] args) {
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Windows".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException | UnsupportedLookAndFeelException | IllegalAccessException | InstantiationException ex) {
            java.util.logging.Logger.getLogger(Display.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        /* Create and display the form */
        java.awt.EventQueue.invokeLater(() -> new Display(new DisplayController()));

    }

    public static void updateVisitors(){
        ListenersNumber.setText("Nombre des personnes qui écoutent ce stream : "+Radio.getListeners());
    }
}
