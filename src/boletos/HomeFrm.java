/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package boletos;

import java.awt.Color;
import java.awt.Component;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.text.DecimalFormat;
import java.util.Arrays;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableCellRenderer;

/**
 *
 * @author USER
 */
public class HomeFrm extends javax.swing.JFrame {

    public static double costoViaje = 140;
    public static String priceTxt = "" + 140;
    private JComboBox[] cmbAsientosType;
    private JTextField[] txtAsiento;
    private JLabel[] lblAsientos;
    private JButton[] btnAsientosRemove;
    private int count = -1;
    private final int max_row = 5;
    private int empty_count = 0;
    private String[] typeList;
    Data _data_Boletos;
    String[] horarios = new String[2];
    Object typePassanger;
    String[] boletosList;
    int selectedRowToEdit = -1;

    /**
     * Creates new form HomeFrm
     */
    public HomeFrm() {
        this.typeList = new String[2];
        this.typeList[0] = "Pasillo";
        this.typeList[1] = "Ventana";
        horarios[0] = "05h45";
        horarios[1] = "15h00";
        initComponents();
        txtCosto.setText(priceTxt);
        txtEdad.setText("18");
        tblAsientos.getTableHeader().setUI(null);
        change_color(tblAsientos);
        _data_Boletos = new Data();
        combo1_combo2_text1_array();
        cmbRutas.setSelectedIndex(0);
        IniBoletosList();
        btnUpdate.setVisible(false);
        btnNuevo.setVisible(false);
    }

    private void IniBoletosList() {
        try {
            FileInputStream fin = new FileInputStream("boletos.txt");
            ObjectInputStream ois = new ObjectInputStream(fin);
            _data_Boletos = (Data) ois.readObject();
            ois.close();
        } catch (Exception eBoletos) {
            try {
                FileOutputStream fout = new FileOutputStream("boletos.txt");
                ObjectOutputStream oos = new ObjectOutputStream(fout);
                oos.writeObject(_data_Boletos);
                oos.close();
            } catch (IOException eU) {
                eU.printStackTrace();
            }
        }
        String string;
        string = _data_Boletos.toString().replace("[", "");
        string = string.replace(string.substring(string.length() - 1), "");
        boletosList = string.split(",");
    }

    private void combo1_combo2_text1_array() {
        cmbAsientosType = new JComboBox[5];
        txtAsiento = new JTextField[5];
        lblAsientos = new JLabel[5];
        btnAsientosRemove = new JButton[5];
    }

    private void removeAsiento(int index) {
        if (count > -1) {
            panelAsientosList.remove(cmbAsientosType[index]);
            panelAsientosList.remove(txtAsiento[index]);
            panelAsientosList.remove(btnAsientosRemove[index]);
            panelAsientosList.remove(lblAsientos[index]);
            count--;
            panelAsientosList.revalidate();
            panelAsientosList.repaint();
        }
        DecimalFormat decim = new DecimalFormat("0.00");
        txtCosto.setText("" + decim.format(calculatePrice(count + 1)));
    }

    private double calculatePrice(int numasientos) {
        typePassanger = cmbType.getSelectedItem();
        int edadP = Integer.parseInt(txtEdad.getText());
        costoViaje = 140 * numasientos;
        if (typePassanger.toString().equals("VIP")) {
            costoViaje = costoViaje - (double) (costoViaje * 0.04);
        }
        if (typePassanger.toString().equals("Normal")) {
            if (edadP <= 5) {
                costoViaje = costoViaje - (double) (costoViaje * 0.05);
            }
            costoViaje = costoViaje - (double) (costoViaje * 0.02);
        }
        if (edadP >= 70) {
            costoViaje = costoViaje - (double) (costoViaje * 0.10);
        }
        return costoViaje;
    }

    public void clearAll() {
        int aucCoutn = count;
        btnNuevo.setVisible(false);
        btnSave.setVisible(true);
        btnUpdate.setVisible(false);
        for (int i = 0; i <= aucCoutn; i++) {
            removeAsiento(i);
        }
        count = -1;
        txtCosto.setText("0.00");
        txtEdad.setText("18");
        txtNombres.setText("");
        txtIdentificacion.setText("");
        cmbRutas.setSelectedIndex(0);
        cmbType.setSelectedIndex(0);
        IniBoletosList();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jMenuItem1 = new javax.swing.JMenuItem();
        btnGTipo = new javax.swing.ButtonGroup();
        PaneReporte = new javax.swing.JTabbedPane();
        jPanel2 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        txtNombres = new javax.swing.JTextField();
        txtIdentificacion = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        cmbType = new javax.swing.JComboBox<>();
        jLabel5 = new javax.swing.JLabel();
        txtEdad = new javax.swing.JTextField();
        jLabel11 = new javax.swing.JLabel();
        panelViaje = new javax.swing.JPanel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        cmbHorario = new javax.swing.JComboBox<>();
        jLabel10 = new javax.swing.JLabel();
        txtCosto = new javax.swing.JTextField();
        jLabel12 = new javax.swing.JLabel();
        btnAddAsientos = new javax.swing.JButton();
        panelAsientosList = new javax.swing.JPanel();
        btnSave = new javax.swing.JButton();
        cmbRutas = new javax.swing.JComboBox<>();
        jLabel13 = new javax.swing.JLabel();
        cmbDia = new javax.swing.JComboBox<>();
        cmbMes = new javax.swing.JComboBox<>();
        cmbAnio = new javax.swing.JComboBox<>();
        btnUpdate = new javax.swing.JButton();
        btnNuevo = new javax.swing.JButton();
        panelReporte = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        panelAvion = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblAsientos = new javax.swing.JTable();
        jPanel3 = new javax.swing.JPanel();
        panelVendidos = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        tblVendidos = new javax.swing.JTable();
        btnSaveUpdate = new javax.swing.JButton();
        btnSaveUpdate1 = new javax.swing.JButton();
        jLabel7 = new javax.swing.JLabel();

        jMenuItem1.setText("jMenuItem1");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setName("homeFrm"); // NOI18N

        PaneReporte.setBackground(new java.awt.Color(102, 102, 255));
        PaneReporte.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                loadTableVendidos(evt);
            }
        });

        jPanel2.setBackground(new java.awt.Color(102, 102, 255));

        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("VENTA DE BOLETOS");

        jPanel1.setBackground(new java.awt.Color(102, 102, 255));
        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Datos del pasajero", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 0, 11), new java.awt.Color(255, 255, 255))); // NOI18N

        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("C.I.");

        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("Nombres / Apellidos");

        cmbType.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Normal", "VIP" }));
        cmbType.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                updatePrice(evt);
            }
        });

        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setText("Tipo de pasajero");

        jLabel11.setForeground(new java.awt.Color(255, 255, 255));
        jLabel11.setText("Edad");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(txtNombres, javax.swing.GroupLayout.DEFAULT_SIZE, 285, Short.MAX_VALUE)
                    .addComponent(jLabel3, javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtIdentificacion)
                    .addComponent(jLabel4, javax.swing.GroupLayout.Alignment.LEADING))
                .addGap(54, 54, 54)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(cmbType, 0, 237, Short.MAX_VALUE)
                    .addComponent(jLabel5)
                    .addComponent(jLabel11)
                    .addComponent(txtEdad))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(jLabel5))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(cmbType, javax.swing.GroupLayout.DEFAULT_SIZE, 31, Short.MAX_VALUE)
                    .addComponent(txtIdentificacion))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel4)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtNombres, javax.swing.GroupLayout.DEFAULT_SIZE, 31, Short.MAX_VALUE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel11)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtEdad)))
                .addGap(24, 24, 24))
        );

        panelViaje.setBackground(new java.awt.Color(102, 102, 255));
        panelViaje.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Viaje", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 0, 11), new java.awt.Color(255, 255, 255))); // NOI18N

        jLabel8.setForeground(new java.awt.Color(255, 255, 255));
        jLabel8.setText("Fecha del viaje");

        jLabel9.setForeground(new java.awt.Color(255, 255, 255));
        jLabel9.setText("Horario del viaje");

        jLabel10.setForeground(new java.awt.Color(255, 255, 255));
        jLabel10.setText("Costo");

        txtCosto.setEditable(false);

        jLabel12.setForeground(new java.awt.Color(255, 255, 255));
        jLabel12.setText("Numero de asientos");

        btnAddAsientos.setText("Añadir asiento");
        btnAddAsientos.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                addrowActionPerformed(evt);
            }
        });

        panelAsientosList.setBackground(new java.awt.Color(102, 102, 255));

        javax.swing.GroupLayout panelAsientosListLayout = new javax.swing.GroupLayout(panelAsientosList);
        panelAsientosList.setLayout(panelAsientosListLayout);
        panelAsientosListLayout.setHorizontalGroup(
            panelAsientosListLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        panelAsientosListLayout.setVerticalGroup(
            panelAsientosListLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 27, Short.MAX_VALUE)
        );

        btnSave.setBackground(new java.awt.Color(51, 255, 51));
        btnSave.setText("Guardar");
        btnSave.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnSaveMouseClicked(evt);
            }
        });

        cmbRutas.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "UIO – LOJA", "LOJA – UIO" }));
        cmbRutas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                loadHorarios(evt);
            }
        });

        jLabel13.setForeground(new java.awt.Color(255, 255, 255));
        jLabel13.setText("Ruta");

        cmbDia.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12", "13", "14", "15", "16", "17", "18", "19", "20", "21", "22", "23", "24", "25", "26", "27", "28", "29", "30", "31" }));

        cmbMes.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12" }));

        cmbAnio.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "2018", "2019" }));

        btnUpdate.setBackground(new java.awt.Color(51, 255, 51));
        btnUpdate.setText("Actualizar");
        btnUpdate.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnUpdateMouseClicked(evt);
            }
        });

        btnNuevo.setBackground(new java.awt.Color(51, 255, 51));
        btnNuevo.setText("Cancelar");
        btnNuevo.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnNuevoMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout panelViajeLayout = new javax.swing.GroupLayout(panelViaje);
        panelViaje.setLayout(panelViajeLayout);
        panelViajeLayout.setHorizontalGroup(
            panelViajeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelViajeLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panelViajeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelViajeLayout.createSequentialGroup()
                        .addComponent(panelAsientosList, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGap(181, 181, 181))
                    .addGroup(panelViajeLayout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(jLabel10)
                        .addGap(18, 18, 18)
                        .addComponent(txtCosto, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btnSave, javax.swing.GroupLayout.PREFERRED_SIZE, 165, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnUpdate)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnNuevo))
                    .addGroup(panelViajeLayout.createSequentialGroup()
                        .addGroup(panelViajeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(btnAddAsientos, javax.swing.GroupLayout.PREFERRED_SIZE, 153, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel12)
                            .addGroup(panelViajeLayout.createSequentialGroup()
                                .addGroup(panelViajeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel8)
                                    .addGroup(panelViajeLayout.createSequentialGroup()
                                        .addComponent(cmbDia, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(cmbMes, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(cmbAnio, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addGap(18, 18, 18)
                                .addGroup(panelViajeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel13)
                                    .addComponent(cmbRutas, javax.swing.GroupLayout.PREFERRED_SIZE, 177, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(18, 18, 18)
                                .addGroup(panelViajeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel9)
                                    .addComponent(cmbHorario, javax.swing.GroupLayout.PREFERRED_SIZE, 177, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addContainerGap(125, Short.MAX_VALUE))))
        );
        panelViajeLayout.setVerticalGroup(
            panelViajeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelViajeLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panelViajeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelViajeLayout.createSequentialGroup()
                        .addComponent(jLabel9)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(cmbHorario, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(panelViajeLayout.createSequentialGroup()
                        .addComponent(jLabel8)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(panelViajeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(cmbDia, javax.swing.GroupLayout.DEFAULT_SIZE, 33, Short.MAX_VALUE)
                            .addComponent(cmbAnio, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(cmbMes, javax.swing.GroupLayout.Alignment.TRAILING)))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelViajeLayout.createSequentialGroup()
                        .addComponent(jLabel13)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(cmbRutas, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(3, 3, 3)))
                .addGap(18, 18, 18)
                .addComponent(jLabel12)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnAddAsientos, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(panelAsientosList, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(30, 30, 30)
                .addGroup(panelViajeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel10)
                    .addComponent(txtCosto)
                    .addComponent(btnSave)
                    .addComponent(btnUpdate)
                    .addComponent(btnNuevo))
                .addGap(24, 24, 24))
        );

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(273, 273, 273)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 206, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(panelViaje, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(panelViaje, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(101, Short.MAX_VALUE))
        );

        PaneReporte.addTab("Venta de boletos", jPanel2);

        panelReporte.setBackground(new java.awt.Color(102, 102, 255));

        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setText("REPORTE DE VENTA");

        panelAvion.setBackground(new java.awt.Color(102, 102, 255));
        panelAvion.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "AIRBUS 433", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 0, 11), new java.awt.Color(255, 255, 255))); // NOI18N

        tblAsientos.setAutoCreateRowSorter(true);
        tblAsientos.setBackground(new java.awt.Color(204, 204, 204));
        tblAsientos.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {"1", "2"},
                {"3", "4"},
                {"5", "6"},
                {"7", "8"},
                {"9", "10"},
                {"11", "12"},
                {"13", "14"},
                {"15", "16"},
                {"17", "18"},
                {"19", "20"},
                {"21", "22"},
                {"23", "24"},
                {"25", "26"},
                {"27", "28"},
                {"29", "30"},
                {"31", "32"},
                {"33", "34"},
                {"35", "36"},
                {"37", "38"},
                {"39", "40"}
            },
            new String [] {
                "Title 1", "Title 2"
            }
        ));
        tblAsientos.setEnabled(false);
        tblAsientos.setRowHeight(50);
        jScrollPane1.setViewportView(tblAsientos);

        javax.swing.GroupLayout panelAvionLayout = new javax.swing.GroupLayout(panelAvion);
        panelAvion.setLayout(panelAvionLayout);
        panelAvionLayout.setHorizontalGroup(
            panelAvionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelAvionLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 660, Short.MAX_VALUE)
                .addContainerGap())
        );
        panelAvionLayout.setVerticalGroup(
            panelAvionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelAvionLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 475, Short.MAX_VALUE)
                .addContainerGap())
        );

        javax.swing.GroupLayout panelReporteLayout = new javax.swing.GroupLayout(panelReporte);
        panelReporte.setLayout(panelReporteLayout);
        panelReporteLayout.setHorizontalGroup(
            panelReporteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelReporteLayout.createSequentialGroup()
                .addGap(186, 186, 186)
                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 206, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(panelReporteLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(panelAvion, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        panelReporteLayout.setVerticalGroup(
            panelReporteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelReporteLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(panelAvion, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        PaneReporte.addTab("Reportes de venta", panelReporte);

        panelVendidos.setBackground(new java.awt.Color(102, 102, 255));

        tblVendidos.setAutoCreateRowSorter(true);
        tblVendidos.setBackground(new java.awt.Color(204, 204, 204));
        tblVendidos.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Title 1", "Title 2"
            }
        ));
        tblVendidos.setRowHeight(20);
        jScrollPane2.setViewportView(tblVendidos);

        btnSaveUpdate.setText("Editar");
        btnSaveUpdate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                updateSave(evt);
            }
        });

        btnSaveUpdate1.setText("Eliminar");
        btnSaveUpdate1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                deleteBoleto(evt);
            }
        });

        jLabel7.setForeground(new java.awt.Color(255, 255, 255));
        jLabel7.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel7.setText("BOLETOS VENDIDOS");

        javax.swing.GroupLayout panelVendidosLayout = new javax.swing.GroupLayout(panelVendidos);
        panelVendidos.setLayout(panelVendidosLayout);
        panelVendidosLayout.setHorizontalGroup(
            panelVendidosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelVendidosLayout.createSequentialGroup()
                .addGroup(panelVendidosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelVendidosLayout.createSequentialGroup()
                        .addGap(250, 250, 250)
                        .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 206, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(panelVendidosLayout.createSequentialGroup()
                        .addGap(28, 28, 28)
                        .addGroup(panelVendidosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 660, Short.MAX_VALUE)
                            .addGroup(panelVendidosLayout.createSequentialGroup()
                                .addComponent(btnSaveUpdate)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(btnSaveUpdate1)))))
                .addGap(24, 24, 24))
        );
        panelVendidosLayout.setVerticalGroup(
            panelVendidosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelVendidosLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(panelVendidosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnSaveUpdate)
                    .addComponent(btnSaveUpdate1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 437, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(60, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panelVendidos, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panelVendidos, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        PaneReporte.addTab("Boletos Vendidos", jPanel3);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(PaneReporte)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(PaneReporte)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void updatePrice(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_updatePrice
        DecimalFormat decim = new DecimalFormat("0.00");
        txtCosto.setText("" + decim.format(calculatePrice(1)));
    }//GEN-LAST:event_updatePrice

    public void change_color(JTable tableName) {
        tableName.setDefaultRenderer(Object.class, new TableCellRenderer() {
            private DefaultTableCellRenderer DEFAULT_RENDERER = new DefaultTableCellRenderer();

            @Override
            public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
                Component c = DEFAULT_RENDERER.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);
                Boolean paint = false;
                String[] dataAsiento;
                String[] boletoData;
                for (int i = 0; i < boletosList.length; i++) {
                    boletoData = boletosList[i].split(":");
                    dataAsiento = boletoData[7].split("-");
                    System.out.println(Arrays.toString(dataAsiento));
                    for (int j = 0; j < dataAsiento.length; j++) {
                        if (dataAsiento[j].equals(value)) {
                            paint = true;
                        }
                    }
                }
                if (paint) {
                    c.setBackground(Color.green);
                } else {
                    c.setBackground(Color.gray);
                }
                return c;
            }

        });
    }

    public boolean existAsiento(String numToVerify) {
        boolean assignedAsiento = false;
        if (boletosList.length > 0) {
            String fechaAsiento = cmbDia.getSelectedItem() + "-" + cmbMes.getSelectedItem() + "-" + cmbAnio.getSelectedItem();
            for (int count = 0; count < boletosList.length; count++) {
                String[] dataBoleto = boletosList[count].split(":");
                Boolean inList = false;
                if (dataBoleto.length > 5) {
                    String[] asientosInBoleto = dataBoleto[5].split("-");
                    for (int i = 0; i < asientosInBoleto.length; i++) {
                        if (asientosInBoleto[i].equals(numToVerify)) {
                            inList = true;
                        }
                    }
                    if (dataBoleto[7].equals(fechaAsiento) && dataBoleto[3].equals(cmbHorario.getSelectedItem()) && inList == true) {
                        assignedAsiento = true;
                        break;
                    }
                }
            }
        }
        return assignedAsiento;
    }
    private void loadTableVendidos(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_loadTableVendidos
        DefaultTableModel dtm = new DefaultTableModel(0, 0);
        // add header of the table
        String header[] = new String[]{"#", "Nombre", "Tipo", "Ruta", "Hora", "Costo", "Asiento", "Distribucion", "Fecha"};
        // add header in table model     
        dtm.setColumnIdentifiers(header);
        //set model into the table object
        tblVendidos.setModel(dtm);
        // add row dynamically into the table
        for (int count = 0; count < boletosList.length; count++) {
            String[] dataBoleto = boletosList[count].split(":");
            if (boletosList[count].length() > 5) {
                dtm.addRow(new Object[]{dataBoleto[0], dataBoleto[1], dataBoleto[2], dataBoleto[4], dataBoleto[5], dataBoleto[6], dataBoleto[7], dataBoleto[8], dataBoleto[9]});
            }
        }
    }//GEN-LAST:event_loadTableVendidos

    private void loadHorarios(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_loadHorarios
        if (cmbRutas.getSelectedItem().toString().equals("UIO – LOJA")) {
            horarios[0] = "05h45";
            horarios[1] = "15h00";
            DefaultComboBoxModel modelHorario = new javax.swing.DefaultComboBoxModel(horarios);
            cmbHorario.setModel(modelHorario);
        }
        if (cmbRutas.getSelectedItem().toString().equals("LOJA – UIO")) {
            horarios[0] = "07h00";
            horarios[1] = "15h00";
            DefaultComboBoxModel modelHorario = new javax.swing.DefaultComboBoxModel(horarios);
            cmbHorario.setModel(modelHorario);
        }
    }//GEN-LAST:event_loadHorarios

    private void btnSaveMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnSaveMouseClicked
        Boolean allOk = true;
        if (txtIdentificacion.getText().isEmpty() || txtNombres.getText().isEmpty() || txtEdad.getText().isEmpty()) {
            JOptionPane.showMessageDialog(null, "Algunos campos estan vacios");
            allOk = false;
            return;
        }
        if (count == -1) {
            JOptionPane.showMessageDialog(null, "Agregue por lo menos un asiento");
            allOk = false;
            return;
        }
        String asientos = "";
        String distribucion = "";
        for (int i = 0; i <= count; i++) {
            if (existAsiento(txtAsiento[i].getText())) {
                JOptionPane.showMessageDialog(null, "El numero de asiento " + txtAsiento[i].getText() + " ya esta assignado");
                allOk = false;
                break;
            }
            if (Integer.parseInt(txtAsiento[i].getText()) > 40) {
                JOptionPane.showMessageDialog(null, "El numero de asiento " + txtAsiento[i].getText() + " no existe");
                allOk = false;
                break;
            }
            if (txtAsiento[i].getText().isEmpty()) {
                JOptionPane.showMessageDialog(null, "Ingrese el numero de asiento");
                allOk = false;
                break;
            }
            int numIAsiento = Integer.parseInt(txtAsiento[i].getText());
            if (typePassanger.equals("Normal") && (numIAsiento >= 1 && numIAsiento <= 10)) {
                JOptionPane.showMessageDialog(null, "Los asientos del 1-10 unicamente pueden ser asignados a clientes VIP");
                allOk = false;
                break;
            }
            if (i < count) {
                distribucion = distribucion + txtAsiento[i].getText() + "->" + cmbAsientosType[i].getSelectedItem() + "|";
                asientos = asientos + txtAsiento[i].getText() + "-";
            } else {
                distribucion = distribucion + txtAsiento[i].getText() + "->" + cmbAsientosType[i].getSelectedItem();
                asientos = asientos + txtAsiento[i].getText();
            }

        }
        if (allOk) {
            Boleto _boleto = null;
            Pasajero pb;
            pb = new Pasajero(txtNombres.getText(), typePassanger.toString(), txtIdentificacion.getText(), txtEdad.getText());
            Ruta rt;
            rt = new Ruta(cmbRutas.getSelectedItem().toString(), cmbHorario.getSelectedItem().toString());
            String fechaB = cmbDia.getSelectedItem() + "-" + cmbMes.getSelectedItem() + "-" + cmbAnio.getSelectedItem();
            _boleto = new Boleto(pb.toString(), rt.toString(), txtCosto.getText().replace(",", "."), asientos, distribucion, fechaB);
            _data_Boletos.put(_boleto);
            try {
                FileOutputStream foutBoletos = new FileOutputStream("boletos.txt");
                ObjectOutputStream oosBoletos = new ObjectOutputStream(foutBoletos);
                oosBoletos.writeObject(_data_Boletos);
                oosBoletos.close();
            } catch (IOException eU) {
                eU.printStackTrace();
            }
            JOptionPane.showMessageDialog(null, "Asiento guardado correctamente");
            int aucCoutn = count;
            for (int i = 0; i <= aucCoutn; i++) {
                removeAsiento(i);
            }
            count = -1;
            txtCosto.setText("0.00");
            txtEdad.setText("18");
            txtNombres.setText("");
            txtIdentificacion.setText("");
            count = -1;
            change_color(tblAsientos);
            cmbRutas.setSelectedIndex(0);
            IniBoletosList();
        };
    }//GEN-LAST:event_btnSaveMouseClicked

    private void addrowActionPerformed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_addrowActionPerformed
        if (count == max_row - 1) {
            JOptionPane.showMessageDialog(null, "Unicamente puede añadir 5 asientos por usuario", "Error!!", JOptionPane.ERROR_MESSAGE);
            return;
        }
        count++;
        lblAsientos[count] = new JLabel("Numero de asiento ->");
        txtAsiento[count] = new JTextField();
        txtAsiento[count].addKeyListener(new KeyAdapter() {
            @Override
            public void keyReleased(KeyEvent e) {
                char c = e.getKeyChar();
                if (txtAsiento[count].getText().length() > 2) {
                    txtAsiento[count].setText("");
                }
                if (!((c >= '0') && (c <= '9')
                        || (c == KeyEvent.VK_BACK_SPACE)
                        || (c == KeyEvent.VK_DELETE))) {
                    txtAsiento[count].setText("");
                }
            }

            @Override
            public void keyTyped(KeyEvent e) {
            }

            @Override
            public void keyPressed(KeyEvent e) {
            }
        });
        btnAsientosRemove[count] = new JButton();
        btnAsientosRemove[count].setText("X");
        btnAsientosRemove[count].addActionListener((ActionEvent e) -> {
            removeAsiento(count);
        });
        cmbAsientosType[count] = new JComboBox(typeList);
        panelAsientosList.setLayout(new GridLayout(0, 4, 20, 20));
        panelAsientosList.add(cmbAsientosType[count]);
        panelAsientosList.add(lblAsientos[count]);
        panelAsientosList.add(txtAsiento[count]);
        panelAsientosList.add(btnAsientosRemove[count]);
        panelAsientosList.revalidate();
        panelAsientosList.repaint();
        DecimalFormat decim = new DecimalFormat("0.00");
        txtCosto.setText("" + decim.format(calculatePrice(count + 1)));
    }//GEN-LAST:event_addrowActionPerformed

    private void updateSave(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_updateSave
        clearAll();
        int row = tblVendidos.getSelectedRow();
        selectedRowToEdit = row;
        if (row == -1) {
            JOptionPane.showMessageDialog(null, "Selecione una fila para editar");
            return;
        }
        String[] dataBoletoupdate = boletosList[row].split(":");
        String[] dataUpdate = new String[tblVendidos.getColumnCount()];
        for (int i = 0; i < tblVendidos.getColumnCount(); i++) {
            String resul = tblVendidos.getValueAt(row, i).toString();
            dataUpdate[i] = resul;
        }
        txtIdentificacion.setText(dataBoletoupdate[0]);
        txtNombres.setText(dataUpdate[1]);
        txtEdad.setText(dataBoletoupdate[3]);
        txtCosto.setText(dataBoletoupdate[6].replace(".", ","));
        for (int i = 0; i < cmbType.getItemCount(); i++) {
            if (cmbType.getItemAt(i).toString().equals(dataUpdate[2])) {
                cmbType.setSelectedIndex(i);
                break;
            }
        }
        String[] dataFecha = dataBoletoupdate[9].split("-");
        for (int i = 0; i < cmbDia.getItemCount(); i++) {
            if (cmbDia.getItemAt(i).equals(dataFecha[0])) {
                cmbDia.setSelectedIndex(i);
                break;
            }
        }
        for (int i = 0; i < cmbMes.getItemCount(); i++) {
            if (cmbMes.getItemAt(i).equals(dataFecha[1])) {
                cmbMes.setSelectedIndex(i);
                break;
            }
        }
        for (int i = 0; i < cmbAnio.getItemCount(); i++) {
            if (cmbAnio.getItemAt(i).equals(dataFecha[2])) {
                cmbAnio.setSelectedIndex(i);
                break;
            }
        }
        for (int i = 0; i < cmbRutas.getItemCount(); i++) {
            if (cmbRutas.getItemAt(i).equals(dataBoletoupdate[4])) {
                cmbRutas.setSelectedIndex(i);
                break;
            }
        }
        for (int i = 0; i < cmbHorario.getItemCount(); i++) {
            if (cmbHorario.getItemAt(i).equals(dataBoletoupdate[5])) {
                cmbHorario.setSelectedIndex(i);
                break;
            }
        }
        String[] arrayAsientos = dataBoletoupdate[7].split("-");
        String[] arrayAsientosDetail = dataBoletoupdate[8].split("->");
        for (int i = 0; i < arrayAsientos.length; i++) {
            String asientoNum = arrayAsientos[i];
            String asientoPosition = arrayAsientosDetail[i + 1];
            asientoPosition = asientoPosition.substring(0, 7);
            count = i;
            lblAsientos[count] = new JLabel("Numero de asiento ->");
            txtAsiento[count] = new JTextField();
            txtAsiento[count].setText(asientoNum);
            txtAsiento[count].addKeyListener(new KeyAdapter() {
                @Override
                public void keyReleased(KeyEvent e) {
                    char c = e.getKeyChar();
                    if (txtAsiento[count].getText().length() > 2) {
                        txtAsiento[count].setText("");
                    }
                    if (!((c >= '0') && (c <= '9')
                            || (c == KeyEvent.VK_BACK_SPACE)
                            || (c == KeyEvent.VK_DELETE))) {
                        txtAsiento[count].setText("");
                    }
                }

                @Override
                public void keyTyped(KeyEvent e) {
                }

                @Override
                public void keyPressed(KeyEvent e) {
                }
            });
            btnAsientosRemove[count] = new JButton();
            btnAsientosRemove[count].setText("X");
            btnAsientosRemove[count].addActionListener((ActionEvent e) -> {
                removeAsiento(count);
            });
            cmbAsientosType[count] = new JComboBox(typeList);
            for (int j = 0; j < cmbAsientosType[count].getItemCount(); j++) {
                if (cmbAsientosType[count].getItemAt(j).equals(asientoPosition)) {
                    cmbAsientosType[count].setSelectedIndex(j);
                    break;
                }
            }
            panelAsientosList.setLayout(new GridLayout(0, 4, 20, 20));
            panelAsientosList.add(cmbAsientosType[count]);
            panelAsientosList.add(lblAsientos[count]);
            panelAsientosList.add(txtAsiento[count]);
            panelAsientosList.add(btnAsientosRemove[count]);
            panelAsientosList.revalidate();
            panelAsientosList.repaint();
        }
        btnNuevo.setVisible(true);
        btnSave.setVisible(false);
        btnUpdate.setVisible(true);
        PaneReporte.setSelectedIndex(0);
    }//GEN-LAST:event_updateSave
    public void updateTableVendidos() {
        IniBoletosList();
        DefaultTableModel dtm = new DefaultTableModel(0, 0);
        // add header of the table
        String header[] = new String[]{"#", "Nombre", "Tipo", "Ruta", "Hora", "Costo", "Asiento", "Distribucion", "Fecha"};
        // add header in table model     
        dtm.setColumnIdentifiers(header);
        //set model into the table object
        tblVendidos.setModel(dtm);
        // add row dynamically into the table
        for (int count = 0; count < boletosList.length; count++) {
            String[] dataBoleto = boletosList[count].split(":");
            if (boletosList[count].length() > 5) {
                dtm.addRow(new Object[]{dataBoleto[0], dataBoleto[1], dataBoleto[2], dataBoleto[4], dataBoleto[5], dataBoleto[6], dataBoleto[7], dataBoleto[8], dataBoleto[9]});
            }
        }
    }

    private void deleteBoleto(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_deleteBoleto
        int row = tblVendidos.getSelectedRow();
        boolean deleteRow = _data_Boletos.removeRowAt(_data_Boletos.getAt(row));
        if (deleteRow) {
            try {
                FileOutputStream fout = new FileOutputStream("boletos.txt");
                ObjectOutputStream oos = new ObjectOutputStream(fout);
                oos.writeObject(_data_Boletos);
                oos.close();
            } catch (IOException eU) {
                eU.printStackTrace();
            }
            updateTableVendidos();
            JOptionPane.showMessageDialog(null, "Boleto eliminado correctamente");
        }
    }//GEN-LAST:event_deleteBoleto

    private void btnNuevoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnNuevoMouseClicked
        clearAll();
    }//GEN-LAST:event_btnNuevoMouseClicked

    private void btnUpdateMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnUpdateMouseClicked
        Boolean allOk = true;
        if (txtIdentificacion.getText().isEmpty() || txtNombres.getText().isEmpty() || txtEdad.getText().isEmpty()) {
            JOptionPane.showMessageDialog(null, "Algunos campos estan vacios");
            allOk = false;
            return;
        }
        if (count == -1) {
            JOptionPane.showMessageDialog(null, "Agregue por lo menos un asiento");
            allOk = false;
            return;
        }
        String asientos = "";
        String distribucion = "";
        for (int i = 0; i <= count; i++) {
            if (existAsiento(txtAsiento[i].getText())) {
                JOptionPane.showMessageDialog(null, "El numero de asiento " + txtAsiento[i].getText() + " ya esta assignado");
                allOk = false;
                break;
            }
            if (Integer.parseInt(txtAsiento[i].getText()) > 40) {
                JOptionPane.showMessageDialog(null, "El numero de asiento " + txtAsiento[i].getText() + " no existe");
                allOk = false;
                break;
            }
            if (txtAsiento[i].getText().isEmpty()) {
                JOptionPane.showMessageDialog(null, "Ingrese el numero de asiento");
                allOk = false;
                break;
            }
            int numIAsiento = Integer.parseInt(txtAsiento[i].getText());
            if (typePassanger.equals("Normal") && (numIAsiento >= 1 && numIAsiento <= 10)) {
                JOptionPane.showMessageDialog(null, "Los asientos del 1-10 unicamente pueden ser asignados a clientes VIP");
                allOk = false;
                break;
            }
            if (i < count) {
                distribucion = distribucion + txtAsiento[i].getText() + "->" + cmbAsientosType[i].getSelectedItem() + "|";
                asientos = asientos + txtAsiento[i].getText() + "-";
            } else {
                distribucion = distribucion + txtAsiento[i].getText() + "->" + cmbAsientosType[i].getSelectedItem();
                asientos = asientos + txtAsiento[i].getText();
            }

        }
        if (allOk) {
            Boleto _boleto = null;
            Pasajero pb;
            pb = new Pasajero(txtNombres.getText(), typePassanger.toString(), txtIdentificacion.getText(), txtEdad.getText());
            Ruta rt;
            rt = new Ruta(cmbRutas.getSelectedItem().toString(), cmbHorario.getSelectedItem().toString());
            String fechaB = cmbDia.getSelectedItem() + "-" + cmbMes.getSelectedItem() + "-" + cmbAnio.getSelectedItem();
            _boleto = new Boleto(pb.toString(), rt.toString(), txtCosto.getText().replace(",", "."), asientos, distribucion, fechaB);
            _data_Boletos.updateRowAt(_boleto, selectedRowToEdit);
            try {
                FileOutputStream foutBoletos = new FileOutputStream("boletos.txt");
                ObjectOutputStream oosBoletos = new ObjectOutputStream(foutBoletos);
                oosBoletos.writeObject(_data_Boletos);
                oosBoletos.close();
            } catch (IOException eU) {
                eU.printStackTrace();
            }
            JOptionPane.showMessageDialog(null, "Asiento editado correctamente");
            clearAll();
            change_color(tblAsientos);
        };

    }//GEN-LAST:event_btnUpdateMouseClicked

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
            java.util.logging.Logger.getLogger(HomeFrm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(HomeFrm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(HomeFrm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(HomeFrm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new HomeFrm().setVisible(true);
            }
        });

    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTabbedPane PaneReporte;
    private javax.swing.JButton btnAddAsientos;
    private javax.swing.ButtonGroup btnGTipo;
    private javax.swing.JButton btnNuevo;
    private javax.swing.JButton btnSave;
    private javax.swing.JButton btnSaveUpdate;
    private javax.swing.JButton btnSaveUpdate1;
    private javax.swing.JButton btnUpdate;
    private javax.swing.JComboBox<String> cmbAnio;
    private javax.swing.JComboBox<String> cmbDia;
    private javax.swing.JComboBox<String> cmbHorario;
    private javax.swing.JComboBox<String> cmbMes;
    private javax.swing.JComboBox<String> cmbRutas;
    private javax.swing.JComboBox<String> cmbType;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JPanel panelAsientosList;
    private javax.swing.JPanel panelAvion;
    private javax.swing.JPanel panelReporte;
    private javax.swing.JPanel panelVendidos;
    private javax.swing.JPanel panelViaje;
    private javax.swing.JTable tblAsientos;
    private javax.swing.JTable tblVendidos;
    private javax.swing.JTextField txtCosto;
    private javax.swing.JTextField txtEdad;
    private javax.swing.JTextField txtIdentificacion;
    private javax.swing.JTextField txtNombres;
    // End of variables declaration//GEN-END:variables

}
