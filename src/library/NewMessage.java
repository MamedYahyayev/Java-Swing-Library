package library;

import dao.DaoImpl;
import java.awt.Component;
import static java.awt.Component.CENTER_ALIGNMENT;
import java.io.File;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.TableCellRenderer;
import model.Item;
import model.OrderBook;
import model.Student;
import oracle.net.aso.f;
import org.jdesktop.swingx.autocomplete.AutoCompleteDecorator;
import util.Method;

public class NewMessage extends javax.swing.JFrame {

    private DaoImpl dao;
    private Long selectedRow;
    private String globCheckName;
    private String filename;

    public NewMessage() {
        initComponents();
    }

    NewMessage(DaoImpl dao) {
        try {
            initComponents();
            this.dao = dao;

            List<Student> studentList = dao.getStudentList();
            DefaultComboBoxModel model = (DefaultComboBoxModel) searchCombo.getModel();
            for (Student student : studentList) {
                model.addElement(new Item(student.getId(), student.getName() + " " + student.getSurname()));
            }
            model.setSelectedItem(new Item((long) 0, "Tələbəni Seç"));

            AutoCompleteDecorator.decorate(searchCombo);
        } catch (Exception ex) {
            Logger.getLogger(NewMessage.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    NewMessage(DaoImpl dao, Long selectedRow) {
        try {
            initComponents();
            this.dao = dao;
            this.selectedRow = selectedRow;

            searchCombo.setEnabled(false);
            Student student = dao.getStudentById(selectedRow);
            to.setText(student.getEmail());
        } catch (Exception ex) {
            Logger.getLogger(NewMessage.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    NewMessage(DaoImpl dao, Long selectedRow, String globCheckName) {
        try {
            initComponents();
            this.dao = dao;
            this.selectedRow = selectedRow;
            this.globCheckName = globCheckName;
            searchCombo.setEnabled(false);
            OrderBook orderBook = dao.getOrderBookById(selectedRow, (long) 2);
            to.setText(orderBook.getStudent().getEmail());
        } catch (Exception ex) {
            Logger.getLogger(NewMessage.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        bg = new javax.swing.JPanel();
        searchCombo = new javax.swing.JComboBox();
        jLabel1 = new javax.swing.JLabel();
        from = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        to = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        messageTxt = new javax.swing.JTextArea();
        jPanel2 = new javax.swing.JPanel();
        chooseFile = new javax.swing.JPanel();
        jLabel5 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        filePanel = new javax.swing.JPanel();
        icon = new javax.swing.JLabel();
        fileName = new javax.swing.JLabel();
        sendMessage = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        subject = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        bg.setBackground(new java.awt.Color(255, 255, 255));

        searchCombo.setFont(new java.awt.Font("Calibri", 0, 18)); // NOI18N
        searchCombo.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        searchCombo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                searchComboActionPerformed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Calibri", 0, 24)); // NOI18N
        jLabel1.setText("KİMDƏN");

        from.setFont(new java.awt.Font("Calibri", 0, 18)); // NOI18N

        jLabel2.setFont(new java.awt.Font("Calibri", 0, 24)); // NOI18N
        jLabel2.setText("KİMƏ");

        to.setFont(new java.awt.Font("Calibri", 0, 18)); // NOI18N

        jLabel3.setFont(new java.awt.Font("Calibri", 0, 24)); // NOI18N
        jLabel3.setText("MESAJ");

        messageTxt.setColumns(20);
        messageTxt.setFont(new java.awt.Font("Calibri", 0, 18)); // NOI18N
        messageTxt.setRows(5);
        jScrollPane1.setViewportView(messageTxt);

        chooseFile.setBackground(new java.awt.Color(102, 0, 255));
        chooseFile.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        chooseFile.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                chooseFileMouseClicked(evt);
            }
        });

        jLabel5.setIcon(new javax.swing.ImageIcon("C:\\Users\\Windows10\\Desktop\\JAVA\\DESKTOP\\DESKTOP_IMG\\File_25px.png")); // NOI18N

        jLabel4.setFont(new java.awt.Font("Calibri", 0, 18)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("FAYL YÜKLƏ");

        javax.swing.GroupLayout chooseFileLayout = new javax.swing.GroupLayout(chooseFile);
        chooseFile.setLayout(chooseFileLayout);
        chooseFileLayout.setHorizontalGroup(
            chooseFileLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(chooseFileLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel5)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel4)
                .addGap(12, 12, 12))
        );
        chooseFileLayout.setVerticalGroup(
            chooseFileLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, chooseFileLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel5)
                .addContainerGap())
            .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        filePanel.setBackground(new java.awt.Color(255, 255, 255));

        fileName.setFont(new java.awt.Font("Calibri", 0, 18)); // NOI18N

        javax.swing.GroupLayout filePanelLayout = new javax.swing.GroupLayout(filePanel);
        filePanel.setLayout(filePanelLayout);
        filePanelLayout.setHorizontalGroup(
            filePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(filePanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(icon, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(fileName, javax.swing.GroupLayout.DEFAULT_SIZE, 270, Short.MAX_VALUE)
                .addContainerGap())
        );
        filePanelLayout.setVerticalGroup(
            filePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(filePanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(filePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(filePanelLayout.createSequentialGroup()
                        .addGap(17, 17, 17)
                        .addComponent(fileName, javax.swing.GroupLayout.PREFERRED_SIZE, 15, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(filePanelLayout.createSequentialGroup()
                        .addComponent(icon, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addContainerGap())))
        );

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(chooseFile, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(filePanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(chooseFile, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(23, 23, 23))
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addComponent(filePanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        sendMessage.setIcon(new javax.swing.ImageIcon("C:\\Users\\Windows10\\Downloads\\button (7).png")); // NOI18N
        sendMessage.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        sendMessage.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                sendMessageMouseClicked(evt);
            }
        });

        jLabel6.setFont(new java.awt.Font("Calibri", 0, 24)); // NOI18N
        jLabel6.setText("MÖVZU");

        subject.setFont(new java.awt.Font("Calibri", 0, 18)); // NOI18N

        javax.swing.GroupLayout bgLayout = new javax.swing.GroupLayout(bg);
        bg.setLayout(bgLayout);
        bgLayout.setHorizontalGroup(
            bgLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(bgLayout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addGroup(bgLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, bgLayout.createSequentialGroup()
                        .addGroup(bgLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jScrollPane1)
                            .addGroup(bgLayout.createSequentialGroup()
                                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(sendMessage)))
                        .addGap(19, 19, 19))
                    .addGroup(bgLayout.createSequentialGroup()
                        .addGroup(bgLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel1)
                            .addComponent(jLabel2)
                            .addComponent(jLabel3)
                            .addComponent(jLabel6))
                        .addGap(83, 83, 83)
                        .addGroup(bgLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, bgLayout.createSequentialGroup()
                                .addComponent(from, javax.swing.GroupLayout.PREFERRED_SIZE, 289, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 242, Short.MAX_VALUE)
                                .addComponent(searchCombo, javax.swing.GroupLayout.PREFERRED_SIZE, 307, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(bgLayout.createSequentialGroup()
                                .addGroup(bgLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(to, javax.swing.GroupLayout.PREFERRED_SIZE, 289, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(subject, javax.swing.GroupLayout.PREFERRED_SIZE, 289, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(0, 0, Short.MAX_VALUE)))
                        .addContainerGap())))
        );
        bgLayout.setVerticalGroup(
            bgLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(bgLayout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(bgLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(from, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(bgLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(searchCombo, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel1)))
                .addGap(56, 56, 56)
                .addGroup(bgLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(to, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 60, Short.MAX_VALUE)
                .addGroup(bgLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(subject, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(64, 64, 64)
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 184, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(9, 9, 9)
                .addGroup(bgLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(sendMessage)
                    .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(bg, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(bg, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void chooseFileMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_chooseFileMouseClicked
        JFileChooser chooser = new JFileChooser();
        chooser.showOpenDialog(null);
        File f = chooser.getSelectedFile();
        filename = f.getAbsolutePath();
        int lastIndexOf = filename.lastIndexOf("\\");
        String substring = filename.substring(lastIndexOf + 1);
        fileName.setText(substring);
        if (filename.endsWith(".txt")) {
            ImageIcon iconImg = new ImageIcon("TXT_30px.png");
            icon.setIcon(iconImg);
        } else if (filename.endsWith(".png") || filename.endsWith(".jpg")) {
            ImageIcon iconImg = new ImageIcon("Image File_30px.png");
            icon.setIcon(iconImg);
        } else if (filename.endsWith(".pdf")) {
            ImageIcon iconImg = new ImageIcon("PDF_30px.png");
            icon.setIcon(iconImg);
        } else if (filename.endsWith(".pptx") || filename.endsWith(".ppsx")) {
            ImageIcon iconImg = new ImageIcon("Microsoft PowerPoint_30px.png");
            icon.setIcon(iconImg);
        } else if (filename.endsWith(".xlsx")) {
            ImageIcon iconImg = new ImageIcon("Microsoft Excel_30px.png");
            icon.setIcon(iconImg);
        } else if (filename.endsWith(".docx")) {
            ImageIcon iconImg = new ImageIcon("Microsoft Word_30px.png");
            icon.setIcon(iconImg);
        } else {
            ImageIcon iconImg = new ImageIcon("File_25px.png");
            icon.setIcon(iconImg);
        }

    }//GEN-LAST:event_chooseFileMouseClicked

    private void searchComboActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_searchComboActionPerformed
        try {
            Item searchItem = (Item) searchCombo.getSelectedItem();
            Student searchStudent = dao.getStudentById(searchItem.getId());
            to.setText(searchStudent.getEmail());
        } catch (Exception ex) {
            Logger.getLogger(NewMessage.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_searchComboActionPerformed

    private void sendMessageMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_sendMessageMouseClicked

        String message = messageTxt.getText();
        String gmail = to.getText();
        Method sendGmail = new Method();
        boolean isSended = sendGmail.sendMail(gmail, subject.getText(), message, filename);
        if (isSended) {
            JOptionPane.showMessageDialog(null, "Mesaj göndərildi...");
            this.dispose();
        } else {
            JOptionPane.showMessageDialog(null, "Mesaj göndərilmədi...");
        }


    }//GEN-LAST:event_sendMessageMouseClicked


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel bg;
    private javax.swing.JPanel chooseFile;
    private javax.swing.JLabel fileName;
    private javax.swing.JPanel filePanel;
    private javax.swing.JTextField from;
    private javax.swing.JLabel icon;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextArea messageTxt;
    private javax.swing.JComboBox searchCombo;
    private javax.swing.JLabel sendMessage;
    private javax.swing.JTextField subject;
    private javax.swing.JTextField to;
    // End of variables declaration//GEN-END:variables
}
