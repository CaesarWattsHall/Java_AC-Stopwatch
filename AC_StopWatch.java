//Caesar Watts & Anthony J.
//Group Project
package stop;
import java.sql.*;

public class Stop extends javax.swing.JFrame implements Runnable {

    Connection conn = null;
    static final String MY_DRIVER = "net.ucanaccess.jdbc.UcanaccessDriver";
    static final String DB_USERNAME = "";
    static final String DB_PASSWORD = "";
    static String tableName = "ACRecords";

    Thread ACThread;
    int ACHcnt = 0,
        ACMcnt = 0,
        ACScnt = 0,
        ACMScnt = 0;

    String acStr = "",
           acNstr = "",
           acMstr = "",
           acDstr = "";

    int ACCnt = 0,
        ACCnt2 = 0;

    public Stop() {
        this.setTitle("|BETA Run| AC_STOPWATCH Vr0.1");
        initComponents();
        ACThread = new Thread(this);
        reset();
    }

    public void reset() {
        ACHcnt = 0;
        ACMcnt = 0;
        ACScnt = 0;
        ACMScnt = 0;
        ACCnt2 = 0;
        acNstr = "00:00:00";
        acMstr = "000";
        acDstr = "";
        display();
    }

    public void display() {
        ACLabel.setText(acNstr);
        ACLabel2.setText(acMstr);
    }

    public void acSetTimeCounter() {
        acNstr = "";
        if (ACHcnt < 10) {
            acNstr = "0" + ACHcnt;

        } else {
            acNstr = "" + ACHcnt;
        }

        if (ACMcnt < 10) {
            acNstr += ":0" + ACMcnt;

        } else {
            acNstr += ":" + ACMcnt;
        }

        if (ACScnt < 10) {
            acNstr += ":0" + ACScnt;

        } else {
            acNstr += ":" + ACScnt;
        }
    }

    public void acSetTimeCounter2() {
        acMstr = "";
        if (ACMScnt < 10) {
            acMstr = "00" + ACMScnt;

        } else if (ACMScnt >= 10 && ACMScnt < 100) {
            acMstr = "0" + ACMScnt;

        } else {
            acMstr = "" + ACMScnt;
        }
    }

    public void run() {
        try {
            while (true) {
                ACMScnt++;
                if (ACMScnt > 999) {
                    ACMScnt = 00;
                    ACScnt++;
                }

                if (ACScnt > 59) {
                    ACScnt = 00;
                    ACMcnt++;
                }

                if (ACMcnt > 59) {
                    ACMcnt = 00;
                    ACHcnt++;
                }

                if (ACHcnt > 99) {
                    reset();
                }

                acSetTimeCounter();
                acSetTimeCounter2();
                display();
                Thread.sleep(1);
            }
        } catch (Exception e) {
        }
    }

    public void acPrintToList() {
        ACCnt2++;
        acDstr += "\n" + " TIME: " + ACLabel.getText() + " " + ACLabel2.getText() + "\n";
        AC_TextArea.setText(acDstr);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        AC_Panel = new javax.swing.JPanel();
        ACLabel = new javax.swing.JLabel();
        ACLabel2 = new javax.swing.JLabel();
        AC_StartBtn = new javax.swing.JButton();
        AC_ResetBtn = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        AC_TextArea = new javax.swing.JTextArea();
        AC_SaveBtn = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        ACLabel.setFont(new java.awt.Font("Dialog", 1, 50)); // NOI18N
        ACLabel.setText("00 : 00 : 00");

        ACLabel2.setFont(new java.awt.Font("Dialog", 1, 25)); // NOI18N
        ACLabel2.setText("000");

        AC_StartBtn.setText("START");
        AC_StartBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                AC_StartBtnActionPerformed(evt);
            }
        });

        AC_ResetBtn.setText("RESET");
        AC_ResetBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                AC_ResetBtnActionPerformed(evt);
            }
        });

        AC_TextArea.setColumns(20);
        AC_TextArea.setRows(5);
        jScrollPane1.setViewportView(AC_TextArea);

        AC_SaveBtn.setText("SAVE");
        AC_SaveBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                AC_SaveBtnActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout AC_PanelLayout = new javax.swing.GroupLayout(AC_Panel);
        AC_Panel.setLayout(AC_PanelLayout);
        AC_PanelLayout.setHorizontalGroup(
            AC_PanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(AC_PanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(AC_PanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(AC_SaveBtn, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jScrollPane1)
                    .addGroup(AC_PanelLayout.createSequentialGroup()
                        .addComponent(AC_StartBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(AC_ResetBtn, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(AC_PanelLayout.createSequentialGroup()
                        .addGap(12, 12, 12)
                        .addComponent(ACLabel)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(ACLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        AC_PanelLayout.setVerticalGroup(
            AC_PanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(AC_PanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(AC_PanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(ACLabel)
                    .addComponent(ACLabel2))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(AC_PanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(AC_StartBtn)
                    .addComponent(AC_ResetBtn))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(AC_SaveBtn)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 8, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 280, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(AC_Panel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(AC_Panel, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void AC_StartBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_AC_StartBtnActionPerformed
        if (AC_StartBtn.getText().equals("START")) {
            AC_StartBtn.setText("STOP");
            ACCnt++;
            if (ACCnt == 1) {
                ACThread.start();
            } else {
                ACThread.resume();
            }
        } else {
            AC_StartBtn.setText("START");
            ACThread.suspend();
            acPrintToList();
        }
    }//GEN-LAST:event_AC_StartBtnActionPerformed

    private void AC_ResetBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_AC_ResetBtnActionPerformed
        reset();
        ACThread.suspend();
        AC_StartBtn.setText("START");
        AC_TextArea.setText("");
    }//GEN-LAST:event_AC_ResetBtnActionPerformed

    private void AC_SaveBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_AC_SaveBtnActionPerformed
        AC_SaveBtn.setText("SAVE");
        conn = SqlConnect.ConnectDB();

        try {
            Class.forName(MY_DRIVER);
            String database = "jdbc:ucanaccess://C:\\Users\\TEMP\\Desktop\\ACStopWatchDB (3).accdb";
            Connection con = DriverManager.getConnection(database, DB_USERNAME, DB_PASSWORD);
            Statement s = con.createStatement();

            String selectStatementSQL = "SELECT * FROM " + tableName;
            s.execute(selectStatementSQL);
            ResultSet rs = s.getResultSet();
            while ((rs != null) && (rs.next())) {
                System.out.println(rs.getString(1) + " : " + rs.getString(2));
            }
            
            String insertStatementSQL = " INSERT INTO " + tableName + " VALUES ( 'Number of Stops','RecordTime'";
            s.execute(insertStatementSQL);
            System.out.println("Next Execute!");
            s.close();
            con.close();
        } catch (Exception e) {
        } finally {
        }
    }//GEN-LAST:event_AC_SaveBtnActionPerformed

    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Stop().setVisible(true);
            }
        });
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel ACLabel;
    private javax.swing.JLabel ACLabel2;
    private javax.swing.JPanel AC_Panel;
    private javax.swing.JButton AC_ResetBtn;
    private javax.swing.JButton AC_SaveBtn;
    private javax.swing.JButton AC_StartBtn;
    private javax.swing.JTextArea AC_TextArea;
    private javax.swing.JScrollPane jScrollPane1;
    // End of variables declaration//GEN-END:variables
}
