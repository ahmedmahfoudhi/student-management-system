/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */

package com.mycompany.educationalmanagementsystem.UI;

import com.mycompany.educationalmanagementsystem.Scores.Score;
import com.mycompany.educationalmanagementsystem.Scores.ScoreService;
import com.mycompany.educationalmanagementsystem.Subjects.Subject;
import com.mycompany.educationalmanagementsystem.Subjects.SubjectService;
import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

/**
 *
 * @author mahfoudhi
 */
public class UpdateStudentSubjects extends javax.swing.JFrame {
    private final SubjectService subjectService;
    private final ScoreService scoreService;
    private List<SubjectPanel> subjectsPanels;

    /** Creates new form UpdateStudentSubjects */
    public UpdateStudentSubjects() {
        subjectService = SubjectService.getInstance();
        scoreService = ScoreService.getInstance();
        initComponents();
        addSubjects();
        addSubmitButton();
        
    }
    
    public final void addSubjects(){
        
        
        try{
            
            subjectsPanels = new ArrayList<>();
            List<Subject> subjects = subjectService.getAll();
            JPanel subjectsContainer = new JPanel(new GridLayout(subjects.size(),1,10,10));
            subjectsContainer.setBackground(new java.awt.Color(71, 71, 135));
            for(Subject s: subjects){
                
                SubjectPanel subjectPanel = new SubjectPanel(s);
                subjectsPanels.add(subjectPanel);
                subjectsContainer.add(subjectPanel);
            }
            getContentPane().add(subjectsContainer);
            repaint();
            
        }catch(Exception e){
            JOptionPane.showMessageDialog(this,e.getMessage());
        }
        
        
        
        
    }
    
    
    public final void addSubmitButton(){
        JButton submitBtn = new JButton("Submit");
        JPanel panel = new JPanel();
        panel.setBackground(new java.awt.Color(71, 71, 135));
        submitBtn.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e){
                int studentId;
                try{
                    studentId = Integer.parseInt(idField.getText());
                }catch(Exception err){
                    JOptionPane.showMessageDialog(null, "Invalid student id");
                    return;
                }
                List<Score> scores = new ArrayList<>();
                for(SubjectPanel subjectPanel: subjectsPanels){
                    boolean checked = subjectPanel.isSelected();
                    if(checked){
                        int subjectId = subjectPanel.getSubjectId();
                        int score;
                        try{
                            score = Integer.parseInt(subjectPanel.getScore());
                        }catch(Exception exception){
                            JOptionPane.showMessageDialog(null, "Invalid score");
                            return;
                        }
                        
                        if(score < 0 || score > 100){
                            JOptionPane.showMessageDialog(null, "Invalid score");
                            return;
                        }
                        scores.add(new Score(studentId,subjectId,score));
                    }
                }
                
                try{
                    for(Score s : scores){
                        scoreService.addScore(s);
                    }
                }catch(Exception ee){
                    JOptionPane.showMessageDialog(null, ee.getMessage());
                    return;
                }
                JOptionPane.showMessageDialog(null, "Scores updated successfully");
                
            }
        });
        panel.add(submitBtn);
        add(panel);
        revalidate();
        repaint();
    }
    

    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        mainPanel = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        idField = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new java.awt.GridLayout(3, 1));

        mainPanel.setBackground(new java.awt.Color(71, 71, 135));

        jLabel1.setFont(new java.awt.Font("Liberation Sans", 1, 24)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(242, 242, 242));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Update Student Subjects");

        jLabel2.setFont(new java.awt.Font("Liberation Sans", 1, 18)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(242, 242, 242));
        jLabel2.setText("Student ID");

        idField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                idFieldActionPerformed(evt);
            }
        });

        jLabel3.setFont(new java.awt.Font("Liberation Sans", 1, 18)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(242, 242, 242));
        jLabel3.setText("Back");
        jLabel3.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel3MouseClicked(evt);
            }
        });

        javax.swing.GroupLayout mainPanelLayout = new javax.swing.GroupLayout(mainPanel);
        mainPanel.setLayout(mainPanelLayout);
        mainPanelLayout.setHorizontalGroup(
            mainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(mainPanelLayout.createSequentialGroup()
                .addGroup(mainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(mainPanelLayout.createSequentialGroup()
                        .addGap(96, 96, 96)
                        .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 111, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(idField, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(mainPanelLayout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 111, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(34, Short.MAX_VALUE))
        );
        mainPanelLayout.setVerticalGroup(
            mainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(mainPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(9, 9, 9)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(mainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, 48, Short.MAX_VALUE)
                    .addComponent(idField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(34, 34, 34))
        );

        getContentPane().add(mainPanel);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void idFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_idFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_idFieldActionPerformed

    private void jLabel3MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel3MouseClicked
        // TODO add your handling code here:
        new HomePage().setVisible(true);
        dispose();
    }//GEN-LAST:event_jLabel3MouseClicked

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(UpdateStudentSubjects.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(UpdateStudentSubjects.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(UpdateStudentSubjects.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(UpdateStudentSubjects.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new UpdateStudentSubjects().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField idField;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel mainPanel;
    // End of variables declaration//GEN-END:variables

}


class SubjectPanel extends JPanel{
    private int subjectId;
    private boolean selected;
    JTextField scoreField;
    public SubjectPanel(Subject subject){
        setBackground(new java.awt.Color(71, 71, 135));
        JPanel container = new JPanel(new FlowLayout(FlowLayout.LEFT));
        container.setBackground(new java.awt.Color(71, 71, 135));
        JCheckBox subjectCheckBox = new JCheckBox(subject.getTitle());
        subjectCheckBox.setForeground(new java.awt.Color(255,255 , 255));
        subjectId = subject.getId();
        selected = false;
        container.add(subjectCheckBox);
        scoreField = new JTextField(20);
        subjectCheckBox.addActionListener(new ActionListener() {
            
            @Override
            public void actionPerformed(ActionEvent e){
                selected = subjectCheckBox.isSelected();
                if(selected){
                    container.add(scoreField);
                    
                }else{
                    container.remove(scoreField);
                }
                container.revalidate();
                container.repaint();
            }
        });
        add(container);
        revalidate();
        repaint();
    }

    public boolean isSelected() {
        return selected;
    }
    
    public int getSubjectId(){
        return subjectId;
    }
    
    public String getScore(){
        return scoreField.getText();
            
    }
    
    
}
