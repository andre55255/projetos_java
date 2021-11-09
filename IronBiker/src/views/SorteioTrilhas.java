package views;

import classes.Trilha;
import classes.Piloto;
import java.awt.Color;
import java.util.Random;
import javax.swing.JOptionPane;

public class SorteioTrilhas extends javax.swing.JFrame {

    private int contagemSorteioSabado = 0;
    private int contagemSorteioDomingo = 0;

    public SorteioTrilhas() {
        initComponents();
    }

    private void marcaTrilhaSorteada(javax.swing.JTextField jtf) {
        jtf.setForeground(new Color(50, 205, 50));
    }

    private void trilhaMarcada(int t) {
        if (jrbSabado.isSelected()) {
            if (t == 1) {
                this.marcaTrilhaSorteada(ts1);
            } else if (t == 2) {
                this.marcaTrilhaSorteada(ts2);
            } else if (t == 3) {
                this.marcaTrilhaSorteada(ts3);
            } else if (t == 4) {
                this.marcaTrilhaSorteada(ts4);
            } else if (t == 5) {
                this.marcaTrilhaSorteada(ts5);
            } else if (t == 6) {
                this.marcaTrilhaSorteada(ts6);
            } else if (t == 7) {
                this.marcaTrilhaSorteada(ts7);
            }
        } else {
            if (t == 1) {
                this.marcaTrilhaSorteada(td1);
            } else if (t == 2) {
                this.marcaTrilhaSorteada(td2);
            } else if (t == 3) {
                this.marcaTrilhaSorteada(td3);
            } else if (t == 4) {
                this.marcaTrilhaSorteada(td4);
            } else if (t == 5) {
                this.marcaTrilhaSorteada(td5);
            } else if (t == 6) {
                this.marcaTrilhaSorteada(td6);
            } else if (t == 7) {
                this.marcaTrilhaSorteada(td7);
            }
        }
    }

    private void preencheListaTrilhas() {
        listas.TrilhasSabado.trilhasSabado.add(new Trilha(ts1.getText(), 1));
        listas.TrilhasSabado.trilhasSabado.add(new Trilha(ts2.getText(), 2));
        listas.TrilhasSabado.trilhasSabado.add(new Trilha(ts3.getText(), 3));
        listas.TrilhasSabado.trilhasSabado.add(new Trilha(ts4.getText(), 4));
        listas.TrilhasSabado.trilhasSabado.add(new Trilha(ts5.getText(), 5));
        listas.TrilhasSabado.trilhasSabado.add(new Trilha(ts6.getText(), 6));
        listas.TrilhasSabado.trilhasSabado.add(new Trilha(ts7.getText(), 7));

        listas.TrilhasDomingo.trilhasDomingo.add(new Trilha(td1.getText(), 1));
        listas.TrilhasDomingo.trilhasDomingo.add(new Trilha(td2.getText(), 2));
        listas.TrilhasDomingo.trilhasDomingo.add(new Trilha(td3.getText(), 3));
        listas.TrilhasDomingo.trilhasDomingo.add(new Trilha(td4.getText(), 4));
        listas.TrilhasDomingo.trilhasDomingo.add(new Trilha(td5.getText(), 5));
        listas.TrilhasDomingo.trilhasDomingo.add(new Trilha(td6.getText(), 6));
        listas.TrilhasDomingo.trilhasDomingo.add(new Trilha(td7.getText(), 7));

    }

    private void sorteioRotasSabado() {
        Random random = new Random();

        int tentativas = 0;

        while (tentativas <= 7) {
            int valor = random.nextInt(7 + 1) + 1;

            for (Trilha t : listas.TrilhasSabado.trilhasSabado) {

                if (t.getCodigo() == valor) {

                    if (!t.isSorteado()) {

                        String nomePiloto = comboBoxPiloto.getSelectedItem().toString();
                        int numeroPiloto;

                        try {
                            numeroPiloto = Integer.parseInt(campoNumero.getText());
                        } catch (NumberFormatException e) {
                            System.out.println(e.getMessage());
                            jlErro.setText("*Selecione novamente um piloto");
                            return;
                        }

                        t.setIsSorteado(true);

                        this.trilhaMarcada(t.getCodigo());

                        listas.Pilotos.alterarPilotosSabado(
                                nomePiloto,
                                numeroPiloto,
                                t
                        );

                        campoTrilha.setText(t.getNome());

                        botaoSorteio.setEnabled(false);

                        this.contagemSorteioSabado++;

                        tentativas = 8;
                        break;
                    }

                    break;
                }
            }

            tentativas++;
        }
    }

    private void sorteioRotasDomingo() {
        Random random = new Random();

        int tentativas = 0;

        while (tentativas <= 7) {
            int valor = random.nextInt(7 + 1) + 1;

            for (Trilha t : listas.TrilhasDomingo.trilhasDomingo) {

                if (t.getCodigo() == valor) {

                    if (!t.isSorteado()) {

                        String nomePiloto = comboBoxPiloto.getSelectedItem().toString();
                        int numeroPiloto;

                        try {
                            numeroPiloto = Integer.parseInt(campoNumero.getText());
                        } catch (NumberFormatException e) {
                            System.out.println(e.getMessage());
                            jlErro.setText("*Selecione novamente um piloto");
                            return;
                        }

                        t.setIsSorteado(true);

                        this.trilhaMarcada(t.getCodigo());

                        listas.Pilotos.alterarPilotosDomingo(
                                nomePiloto,
                                numeroPiloto,
                                t
                        );

                        campoTrilha.setText(t.getNome());
                        botaoSorteio.setEnabled(false);

                        this.contagemSorteioDomingo++;

                        tentativas = 8;
                        break;
                    }

                    break;
                }
            }

            tentativas++;
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        btnGroupDia = new javax.swing.ButtonGroup();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel20 = new javax.swing.JLabel();
        campoNumero = new javax.swing.JLabel();
        campoTrilha = new javax.swing.JLabel();
        botaoSorteio = new javax.swing.JButton();
        jLabel23 = new javax.swing.JLabel();
        comboBoxPiloto = new javax.swing.JComboBox<>();
        jLabel5 = new javax.swing.JLabel();
        jrbSabado = new javax.swing.JRadioButton();
        jrbDomingo = new javax.swing.JRadioButton();
        jlErro = new javax.swing.JLabel();
        botaoResultado = new javax.swing.JButton();
        ts1 = new javax.swing.JTextField();
        ts2 = new javax.swing.JTextField();
        ts3 = new javax.swing.JTextField();
        ts4 = new javax.swing.JTextField();
        ts5 = new javax.swing.JTextField();
        ts6 = new javax.swing.JTextField();
        ts7 = new javax.swing.JTextField();
        td6 = new javax.swing.JTextField();
        td7 = new javax.swing.JTextField();
        td5 = new javax.swing.JTextField();
        td4 = new javax.swing.JTextField();
        td3 = new javax.swing.JTextField();
        td2 = new javax.swing.JTextField();
        td1 = new javax.swing.JTextField();
        checkBoxAlteraTrilhas = new javax.swing.JCheckBox();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Iron Biker");
        setIconImage(new javax.swing.ImageIcon(getClass().getResource("/assets/Logo_menor.jpg")).getImage());
        setResizable(false);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowActivated(java.awt.event.WindowEvent evt) {
                formWindowActivated(evt);
            }
        });

        jPanel1.setBackground(new java.awt.Color(0, 0, 0));
        jPanel1.setForeground(new java.awt.Color(255, 255, 255));

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/assets/LogoAtual.jpg"))); // NOI18N

        jLabel2.setBackground(new java.awt.Color(255, 255, 255));
        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setText("Sábado");

        jLabel4.setBackground(new java.awt.Color(255, 255, 255));
        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel4.setText("Domingo");

        jLabel3.setBackground(new java.awt.Color(255, 0, 0));
        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 0, 0));
        jLabel3.setText("Piloto:");

        jLabel20.setBackground(new java.awt.Color(255, 0, 0));
        jLabel20.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel20.setForeground(new java.awt.Color(255, 0, 0));
        jLabel20.setText("Número:");

        campoNumero.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        campoNumero.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(255, 255, 255), 1, true));

        campoTrilha.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        campoTrilha.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(255, 255, 255), 1, true));

        botaoSorteio.setForeground(new java.awt.Color(255, 0, 0));
        botaoSorteio.setText("Sortear");
        botaoSorteio.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        botaoSorteio.setFocusable(false);
        botaoSorteio.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botaoSorteioActionPerformed(evt);
            }
        });

        jLabel23.setBackground(new java.awt.Color(255, 0, 0));
        jLabel23.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel23.setForeground(new java.awt.Color(255, 0, 0));
        jLabel23.setText("Trilha:");

        comboBoxPiloto.setMaximumRowCount(3);
        comboBoxPiloto.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                comboBoxPilotoItemStateChanged(evt);
            }
        });

        jLabel5.setBackground(new java.awt.Color(255, 255, 255));
        jLabel5.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel5.setText("Sistema de sorteio de trilhas aos Pilotos");

        jrbSabado.setBackground(new java.awt.Color(255, 255, 255));
        btnGroupDia.add(jrbSabado);
        jrbSabado.setForeground(new java.awt.Color(255, 0, 0));
        jrbSabado.setSelected(true);
        jrbSabado.setText("Sábado");
        jrbSabado.setBorder(null);
        jrbSabado.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jrbSabadoActionPerformed(evt);
            }
        });

        jrbDomingo.setBackground(new java.awt.Color(255, 255, 255));
        btnGroupDia.add(jrbDomingo);
        jrbDomingo.setForeground(new java.awt.Color(255, 0, 0));
        jrbDomingo.setText("Domingo");
        jrbDomingo.setBorder(null);
        jrbDomingo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jrbDomingoActionPerformed(evt);
            }
        });

        jlErro.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jlErro.setForeground(new java.awt.Color(255, 51, 0));

        botaoResultado.setBackground(new java.awt.Color(51, 51, 51));
        botaoResultado.setForeground(new java.awt.Color(255, 255, 255));
        botaoResultado.setText("Resultado");
        botaoResultado.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        botaoResultado.setEnabled(false);
        botaoResultado.setFocusable(false);
        botaoResultado.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botaoResultadoActionPerformed(evt);
            }
        });

        ts1.setEditable(false);
        ts1.setBackground(new java.awt.Color(0, 0, 0));
        ts1.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        ts1.setForeground(new java.awt.Color(255, 0, 51));
        ts1.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        ts1.setText("Fazenda da palha / Entrada da trilha do dinossauro");
        ts1.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(255, 255, 255), 1, true));

        ts2.setEditable(false);
        ts2.setBackground(new java.awt.Color(0, 0, 0));
        ts2.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        ts2.setForeground(new java.awt.Color(255, 0, 51));
        ts2.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        ts2.setText("Fazenda dos Rola / Ponte das Criolas");
        ts2.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(255, 255, 255), 1, true));

        ts3.setEditable(false);
        ts3.setBackground(new java.awt.Color(0, 0, 0));
        ts3.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        ts3.setForeground(new java.awt.Color(255, 0, 51));
        ts3.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        ts3.setText("Ponte do gama / Trilha do Waguinho");
        ts3.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(255, 255, 255), 1, true));

        ts4.setEditable(false);
        ts4.setBackground(new java.awt.Color(0, 0, 0));
        ts4.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        ts4.setForeground(new java.awt.Color(255, 0, 51));
        ts4.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        ts4.setText("Aguas Claras / Asfalto");
        ts4.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(255, 255, 255), 1, true));

        ts5.setEditable(false);
        ts5.setBackground(new java.awt.Color(0, 0, 0));
        ts5.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        ts5.setForeground(new java.awt.Color(255, 0, 51));
        ts5.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        ts5.setText("Fazenda Celso / Monsenhor Horta");
        ts5.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(255, 255, 255), 1, true));

        ts6.setEditable(false);
        ts6.setBackground(new java.awt.Color(0, 0, 0));
        ts6.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        ts6.setForeground(new java.awt.Color(255, 0, 51));
        ts6.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        ts6.setText("Linha de Monsenhor Horta / Ribeirão");
        ts6.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(255, 255, 255), 1, true));

        ts7.setEditable(false);
        ts7.setBackground(new java.awt.Color(0, 0, 0));
        ts7.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        ts7.setForeground(new java.awt.Color(255, 0, 51));
        ts7.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        ts7.setText("Rota a ser definida");
        ts7.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(255, 255, 255), 1, true));

        td6.setEditable(false);
        td6.setBackground(new java.awt.Color(0, 0, 0));
        td6.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        td6.setForeground(new java.awt.Color(255, 0, 51));
        td6.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        td6.setText("Fazenda dos Rola / Garganta do diabo");
        td6.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(255, 255, 255), 1, true));

        td7.setEditable(false);
        td7.setBackground(new java.awt.Color(0, 0, 0));
        td7.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        td7.setForeground(new java.awt.Color(255, 0, 51));
        td7.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        td7.setText("Senhor Cornélio / Ribeirão");
        td7.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(255, 255, 255), 1, true));

        td5.setEditable(false);
        td5.setBackground(new java.awt.Color(0, 0, 0));
        td5.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        td5.setForeground(new java.awt.Color(255, 0, 51));
        td5.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        td5.setText("Trilha da onça / Fazenda dos Rola");
        td5.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(255, 255, 255), 1, true));

        td4.setEditable(false);
        td4.setBackground(new java.awt.Color(0, 0, 0));
        td4.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        td4.setForeground(new java.awt.Color(255, 0, 51));
        td4.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        td4.setText(" Estrada de Bicas / Ponte das Criolas");
        td4.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(255, 255, 255), 1, true));

        td3.setEditable(false);
        td3.setBackground(new java.awt.Color(0, 0, 0));
        td3.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        td3.setForeground(new java.awt.Color(255, 0, 51));
        td3.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        td3.setText("Fazenda da Palha / Fred Kruger");
        td3.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(255, 255, 255), 1, true));

        td2.setEditable(false);
        td2.setBackground(new java.awt.Color(0, 0, 0));
        td2.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        td2.setForeground(new java.awt.Color(255, 0, 51));
        td2.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        td2.setText("Trilha das cangas / Igreja de Camargos");
        td2.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(255, 255, 255), 1, true));

        td1.setEditable(false);
        td1.setBackground(new java.awt.Color(0, 0, 0));
        td1.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        td1.setForeground(new java.awt.Color(255, 0, 51));
        td1.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        td1.setText("TPM / Ponto de água Lau");
        td1.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(255, 255, 255), 1, true));

        checkBoxAlteraTrilhas.setBackground(new java.awt.Color(255, 255, 255));
        checkBoxAlteraTrilhas.setForeground(new java.awt.Color(255, 0, 0));
        checkBoxAlteraTrilhas.setText("Alterar nomes de trilhas");
        checkBoxAlteraTrilhas.setBorder(null);
        checkBoxAlteraTrilhas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                checkBoxAlteraTrilhasActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(54, 54, 54)
                        .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 369, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 28, Short.MAX_VALUE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(84, 84, 84)
                        .addComponent(jlErro, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 72, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel20, javax.swing.GroupLayout.PREFERRED_SIZE, 72, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel23, javax.swing.GroupLayout.PREFERRED_SIZE, 72, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(comboBoxPiloto, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(campoNumero, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(campoTrilha, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                .addComponent(checkBoxAlteraTrilhas, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGap(31, 31, 31)
                                .addComponent(jrbSabado)
                                .addGap(18, 18, 18)
                                .addComponent(jrbDomingo))))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(botaoSorteio, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(botaoResultado, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(td6, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(td7, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(td5, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(td4, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(td3, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(td2, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel4, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(td1))
                        .addGap(1, 1, 1)))
                .addGap(30, 30, 30))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(ts1, javax.swing.GroupLayout.PREFERRED_SIZE, 346, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(ts2, javax.swing.GroupLayout.PREFERRED_SIZE, 346, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(ts3, javax.swing.GroupLayout.PREFERRED_SIZE, 346, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(ts4, javax.swing.GroupLayout.PREFERRED_SIZE, 346, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(ts5, javax.swing.GroupLayout.PREFERRED_SIZE, 346, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(ts6, javax.swing.GroupLayout.PREFERRED_SIZE, 346, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(ts7, javax.swing.GroupLayout.PREFERRED_SIZE, 346, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 346, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(6, 6, 6)
                        .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jlErro, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel3)
                            .addComponent(comboBoxPiloto))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel20)
                            .addComponent(campoNumero, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel23)
                            .addComponent(campoTrilha, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jrbDomingo)
                            .addComponent(jrbSabado)
                            .addComponent(checkBoxAlteraTrilhas))
                        .addGap(19, 19, 19)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(botaoSorteio)
                            .addComponent(botaoResultado)))
                    .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(35, 35, 35)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(jLabel4))
                .addGap(3, 3, 3)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(ts1, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(td1, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(5, 5, 5)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(ts2, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(td2, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(ts3, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(td3, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(ts4, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(td4, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(ts5, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(td5, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(ts6, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(td6, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(ts7, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(td7, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void formWindowActivated(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowActivated
        this.preencheListaTrilhas();
        for (Piloto p : listas.Pilotos.pilotosSabado) {
            comboBoxPiloto.addItem(p.getNome());
        }
    }//GEN-LAST:event_formWindowActivated

    private void comboBoxPilotoItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_comboBoxPilotoItemStateChanged
        try {
            botaoSorteio.setEnabled(true);
            jlErro.setText("");
            String numeroPiloto = listas.Pilotos.pilotosSabado.get(comboBoxPiloto.getSelectedIndex()).getNumero() + "";
            campoNumero.setText(numeroPiloto);

            Trilha trilhaPiloto;
            if (jrbSabado.isSelected()) {
                trilhaPiloto = listas.Pilotos.pilotosSabado.get(comboBoxPiloto.getSelectedIndex()).getTrilha();
            } else {
                trilhaPiloto = listas.Pilotos.pilotosDomingo.get(comboBoxPiloto.getSelectedIndex()).getTrilha();
            }

            if (trilhaPiloto != null) {
                campoTrilha.setText(trilhaPiloto.getNome());
                botaoSorteio.setEnabled(false);
            } else {
                campoTrilha.setText("");
            }
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println(e.getMessage());
            jlErro.setText("*Selecione um piloto");
        }
    }//GEN-LAST:event_comboBoxPilotoItemStateChanged

    private void botaoSorteioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botaoSorteioActionPerformed
        if (campoNumero.getText().length() == 0 || comboBoxPiloto.getSelectedItem().toString().length() == 0) {
            return;
        }

        if (jrbSabado.isSelected()) {
            this.sorteioRotasSabado();
        } else {
            this.sorteioRotasDomingo();
        }

        if (this.contagemSorteioSabado == listas.Pilotos.pilotosSabado.size() && this.contagemSorteioSabado != 10) {
            JOptionPane.showMessageDialog(this, "Sorteio de sabádo completo", "Sucesso", JOptionPane.DEFAULT_OPTION);
            this.contagemSorteioSabado = 10;
            botaoResultado.setEnabled(true);
        } else if (this.contagemSorteioDomingo == listas.Pilotos.pilotosSabado.size() && this.contagemSorteioDomingo != 10) {
            JOptionPane.showMessageDialog(this, "Sorteio de domingo completo", "Sucesso", JOptionPane.DEFAULT_OPTION);
            this.contagemSorteioDomingo = 10;
            botaoResultado.setEnabled(true);
        }

        if (this.contagemSorteioSabado == listas.Pilotos.pilotosSabado.size()
                && this.contagemSorteioDomingo == listas.Pilotos.pilotosSabado.size()) {
            botaoSorteio.setEnabled(false);
            checkBoxAlteraTrilhas.setEnabled(false);
            botaoResultado.setEnabled(true);
        }
    }//GEN-LAST:event_botaoSorteioActionPerformed

    private void jrbSabadoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jrbSabadoActionPerformed
        campoTrilha.setText("");
        campoNumero.setText("");
        comboBoxPiloto.setSelectedIndex(1);
    }//GEN-LAST:event_jrbSabadoActionPerformed

    private void jrbDomingoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jrbDomingoActionPerformed
        campoTrilha.setText("");
        campoNumero.setText("");
        comboBoxPiloto.setSelectedIndex(1);
    }//GEN-LAST:event_jrbDomingoActionPerformed

    private void checkBoxAlteraTrilhasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_checkBoxAlteraTrilhasActionPerformed
        if (checkBoxAlteraTrilhas.isSelected()) {
            botaoSorteio.setEnabled(false);
            jrbDomingo.setEnabled(false);
            jrbSabado.setEnabled(false);
            comboBoxPiloto.setEnabled(false);

            for (Trilha t : listas.TrilhasSabado.trilhasSabado) {
                if (!t.isSorteado()) {
                    if (t.getCodigo() == 1) {
                        ts1.setEditable(true);
                    } else if (t.getCodigo() == 2) {
                        ts2.setEditable(true);
                    } else if (t.getCodigo() == 3) {
                        ts3.setEditable(true);
                    } else if (t.getCodigo() == 4) {
                        ts4.setEditable(true);
                    } else if (t.getCodigo() == 5) {
                        ts5.setEditable(true);
                    } else if (t.getCodigo() == 6) {
                        ts6.setEditable(true);
                    } else if (t.getCodigo() == 7) {
                        ts7.setEditable(true);
                    }
                }
            }

            for (Trilha t : listas.TrilhasDomingo.trilhasDomingo) {
                if (!t.isSorteado()) {
                    if (t.getCodigo() == 1) {
                        td1.setEditable(true);
                    } else if (t.getCodigo() == 2) {
                        td2.setEditable(true);
                    } else if (t.getCodigo() == 3) {
                        td3.setEditable(true);
                    } else if (t.getCodigo() == 4) {
                        td4.setEditable(true);
                    } else if (t.getCodigo() == 5) {
                        td5.setEditable(true);
                    } else if (t.getCodigo() == 6) {
                        td6.setEditable(true);
                    } else if (t.getCodigo() == 7) {
                        td7.setEditable(true);
                    }
                }
            }

        } else {
            botaoSorteio.setEnabled(true);
            jrbDomingo.setEnabled(true);
            jrbSabado.setEnabled(true);
            comboBoxPiloto.setEnabled(true);
            ts1.setEditable(false);
            ts2.setEditable(false);
            ts3.setEditable(false);
            ts4.setEditable(false);
            ts5.setEditable(false);
            ts6.setEditable(false);
            ts7.setEditable(false);
            td1.setEditable(false);
            td2.setEditable(false);
            td3.setEditable(false);
            td4.setEditable(false);
            td5.setEditable(false);
            td6.setEditable(false);
            td7.setEditable(false);

            Trilha trilhaPiloto;
            if (jrbSabado.isSelected()) {
                trilhaPiloto = listas.Pilotos.pilotosSabado.get(comboBoxPiloto.getSelectedIndex()).getTrilha();
            } else {
                trilhaPiloto = listas.Pilotos.pilotosDomingo.get(comboBoxPiloto.getSelectedIndex()).getTrilha();
            }

            if (trilhaPiloto != null) {
                campoTrilha.setText(trilhaPiloto.getNome());
                botaoSorteio.setEnabled(false);
            } else {
                campoTrilha.setText("");
            }
        }
    }//GEN-LAST:event_checkBoxAlteraTrilhasActionPerformed

    private void botaoResultadoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botaoResultadoActionPerformed
        if (this.contagemSorteioSabado >= listas.Pilotos.pilotosSabado.size()
                && this.contagemSorteioDomingo >= listas.Pilotos.pilotosDomingo.size()) {
            new Resultado(true, true).setVisible(true);
        } else if (this.contagemSorteioSabado >= listas.Pilotos.pilotosSabado.size()) {
            new Resultado(true, false).setVisible(true);
        } else if (this.contagemSorteioDomingo >= listas.Pilotos.pilotosDomingo.size()) {
            new Resultado(false, true).setVisible(rootPaneCheckingEnabled);
        } else {
            JOptionPane.showMessageDialog(this, "Sorteios não concluídos", "Erro", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_botaoResultadoActionPerformed

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
            java.util.logging.Logger.getLogger(SorteioTrilhas.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);

        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(SorteioTrilhas.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);

        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(SorteioTrilhas.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);

        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(SorteioTrilhas.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(() -> {
            new SorteioTrilhas().setVisible(true);
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton botaoResultado;
    private javax.swing.JButton botaoSorteio;
    private javax.swing.ButtonGroup btnGroupDia;
    private javax.swing.JLabel campoNumero;
    private javax.swing.JLabel campoTrilha;
    private javax.swing.JCheckBox checkBoxAlteraTrilhas;
    private javax.swing.JComboBox<String> comboBoxPiloto;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel23;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JLabel jlErro;
    private javax.swing.JRadioButton jrbDomingo;
    private javax.swing.JRadioButton jrbSabado;
    private javax.swing.JTextField td1;
    private javax.swing.JTextField td2;
    private javax.swing.JTextField td3;
    private javax.swing.JTextField td4;
    private javax.swing.JTextField td5;
    private javax.swing.JTextField td6;
    private javax.swing.JTextField td7;
    private javax.swing.JTextField ts1;
    private javax.swing.JTextField ts2;
    private javax.swing.JTextField ts3;
    private javax.swing.JTextField ts4;
    private javax.swing.JTextField ts5;
    private javax.swing.JTextField ts6;
    private javax.swing.JTextField ts7;
    // End of variables declaration//GEN-END:variables
}
