package views;

import classes.Trilha;
import classes.Piloto;
import java.util.Random;

public class SorteioTrilhas extends javax.swing.JFrame {

    public SorteioTrilhas() {
        initComponents();
    }

    private void preencheListaTrilhas() {
        if (jrbSabado.isSelected()) {
            listas.TrilhasSabado.trilhasSabado.add(new Trilha(ts1.getText(), 1));
            listas.TrilhasSabado.trilhasSabado.add(new Trilha(ts2.getText(), 2));
            listas.TrilhasSabado.trilhasSabado.add(new Trilha(ts3.getText(), 3));
            listas.TrilhasSabado.trilhasSabado.add(new Trilha(ts4.getText(), 4));
            listas.TrilhasSabado.trilhasSabado.add(new Trilha(ts5.getText(), 5));
            listas.TrilhasSabado.trilhasSabado.add(new Trilha(ts6.getText(), 6));
            listas.TrilhasSabado.trilhasSabado.add(new Trilha(ts7.getText(), 7));
        } else {
            listas.TrilhasDomingo.trilhasDomingo.add(new Trilha(td1.getText(), 1));
            listas.TrilhasDomingo.trilhasDomingo.add(new Trilha(td2.getText(), 2));
            listas.TrilhasDomingo.trilhasDomingo.add(new Trilha(td3.getText(), 3));
            listas.TrilhasDomingo.trilhasDomingo.add(new Trilha(td4.getText(), 4));
            listas.TrilhasDomingo.trilhasDomingo.add(new Trilha(td5.getText(), 5));
            listas.TrilhasDomingo.trilhasDomingo.add(new Trilha(td6.getText(), 6));
            listas.TrilhasDomingo.trilhasDomingo.add(new Trilha(td7.getText(), 7));
        }
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
                        
                        listas.Pilotos.alterarPilotosSabado(
                                nomePiloto,
                                numeroPiloto,
                                t
                        );

                        campoTrilha.setText(t.getNome());

                        botaoSorteio.setEnabled(false);

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

                        listas.Pilotos.alterarPilotosDomingo(
                                nomePiloto,
                                numeroPiloto,
                                t
                        );

                        campoTrilha.setText(t.getNome());
                        botaoSorteio.setEnabled(false);

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
        ts1 = new javax.swing.JLabel();
        ts3 = new javax.swing.JLabel();
        ts4 = new javax.swing.JLabel();
        ts5 = new javax.swing.JLabel();
        ts6 = new javax.swing.JLabel();
        ts2 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        ts7 = new javax.swing.JLabel();
        td1 = new javax.swing.JLabel();
        td2 = new javax.swing.JLabel();
        td3 = new javax.swing.JLabel();
        td4 = new javax.swing.JLabel();
        td5 = new javax.swing.JLabel();
        td6 = new javax.swing.JLabel();
        td7 = new javax.swing.JLabel();
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

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setResizable(false);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowActivated(java.awt.event.WindowEvent evt) {
                formWindowActivated(evt);
            }
        });

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/assets/Logo.jpg"))); // NOI18N

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setText("Sábado");

        ts1.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        ts1.setForeground(new java.awt.Color(255, 0, 51));
        ts1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        ts1.setText("Fazenda da palha / Entrada da trilha do dinossauro");
        ts1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        ts3.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        ts3.setForeground(new java.awt.Color(255, 0, 51));
        ts3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        ts3.setText("Ponte do gama / Trilha do Waguinho");
        ts3.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        ts4.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        ts4.setForeground(new java.awt.Color(255, 0, 51));
        ts4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        ts4.setText("Aguas Claras / Asfalto ");
        ts4.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        ts5.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        ts5.setForeground(new java.awt.Color(255, 0, 51));
        ts5.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        ts5.setText("Fazenda Celso / Monsenhor Horta");
        ts5.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        ts6.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        ts6.setForeground(new java.awt.Color(255, 0, 51));
        ts6.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        ts6.setText("Linha de Monsenhor Horta / Ribeirão");
        ts6.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        ts2.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        ts2.setForeground(new java.awt.Color(255, 0, 51));
        ts2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        ts2.setText("Fazenda dos Rola / Ponte das Criolas");
        ts2.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel4.setText("Domingo");

        ts7.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        ts7.setForeground(new java.awt.Color(255, 0, 51));
        ts7.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        ts7.setText("Rota a ser definida");
        ts7.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        td1.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        td1.setForeground(new java.awt.Color(255, 0, 51));
        td1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        td1.setText("TPM / Ponto de água Lau");
        td1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        td2.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        td2.setForeground(new java.awt.Color(255, 0, 51));
        td2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        td2.setText("Trilha das cangas / Igreja de Camargos");
        td2.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        td3.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        td3.setForeground(new java.awt.Color(255, 0, 51));
        td3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        td3.setText("Fazenda da Palha / Fred Kruger");
        td3.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        td4.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        td4.setForeground(new java.awt.Color(255, 0, 51));
        td4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        td4.setText("Estrada de Bicas / Ponte das Criolas");
        td4.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        td5.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        td5.setForeground(new java.awt.Color(255, 0, 51));
        td5.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        td5.setText("Trilha da onça / Fazenda dos Rola");
        td5.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        td6.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        td6.setForeground(new java.awt.Color(255, 0, 51));
        td6.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        td6.setText("Fazenda dos Rola / Garganta do diabo");
        td6.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        td7.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        td7.setForeground(new java.awt.Color(255, 0, 51));
        td7.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        td7.setText("Senhor Cornélio / Ribeirão");
        td7.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel3.setText("Piloto:");

        jLabel20.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel20.setText("Número:");

        campoNumero.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        campoNumero.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true));

        campoTrilha.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        campoTrilha.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true));

        botaoSorteio.setText("Sortear");
        botaoSorteio.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        botaoSorteio.setFocusable(false);
        botaoSorteio.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botaoSorteioActionPerformed(evt);
            }
        });

        jLabel23.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel23.setText("Trilha:");

        comboBoxPiloto.setMaximumRowCount(7);
        comboBoxPiloto.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                comboBoxPilotoItemStateChanged(evt);
            }
        });

        jLabel5.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel5.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel5.setText("Sistema de sorteio de trilhas aos Pilotos");

        jrbSabado.setBackground(new java.awt.Color(255, 255, 255));
        btnGroupDia.add(jrbSabado);
        jrbSabado.setSelected(true);
        jrbSabado.setText("Sábado");
        jrbSabado.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jrbSabadoActionPerformed(evt);
            }
        });

        jrbDomingo.setBackground(new java.awt.Color(255, 255, 255));
        btnGroupDia.add(jrbDomingo);
        jrbDomingo.setText("Domingo");
        jrbDomingo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jrbDomingoActionPerformed(evt);
            }
        });

        jlErro.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jlErro.setForeground(new java.awt.Color(255, 51, 0));

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 258, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(54, 54, 54)
                                .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 369, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                .addGap(84, 84, 84)
                                .addComponent(jlErro, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
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
                                        .addGap(0, 0, Short.MAX_VALUE)
                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(botaoSorteio, javax.swing.GroupLayout.PREFERRED_SIZE, 146, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addGroup(jPanel1Layout.createSequentialGroup()
                                                .addComponent(jrbSabado)
                                                .addGap(18, 18, 18)
                                                .addComponent(jrbDomingo))))))))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                        .addGap(24, 24, 24)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(ts2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(ts3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(ts4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(ts5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(ts6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(ts7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(ts1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(89, 89, 89)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 288, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(td1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(td2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(td3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(td4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(td5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(td6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(td7, javax.swing.GroupLayout.PREFERRED_SIZE, 288, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addGap(30, 30, 30))
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
                            .addComponent(jrbSabado))
                        .addGap(18, 18, 18)
                        .addComponent(botaoSorteio)
                        .addGap(36, 36, 36))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 214, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(28, 28, 28)))
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel4)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(td1, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(td2, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(td3, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(td4, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(td5, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(td6, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(td7, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addGap(4, 4, 4)
                        .addComponent(ts1, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(ts2, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(ts3, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(ts4, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(ts5, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(ts6, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(ts7, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)))
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
        this.preencheListaTrilhas();

        if (jrbSabado.isSelected()) {
            this.sorteioRotasSabado();
        } else {
            this.sorteioRotasDomingo();
        }
    }//GEN-LAST:event_botaoSorteioActionPerformed

    private void jrbSabadoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jrbSabadoActionPerformed
        campoTrilha.setText("");
        campoNumero.setText("");
        comboBoxPiloto.setSelectedIndex(-1);
    }//GEN-LAST:event_jrbSabadoActionPerformed

    private void jrbDomingoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jrbDomingoActionPerformed
        campoTrilha.setText("");
        campoNumero.setText("");
        comboBoxPiloto.setSelectedIndex(-1);
    }//GEN-LAST:event_jrbDomingoActionPerformed

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
            java.util.logging.Logger.getLogger(SorteioTrilhas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(SorteioTrilhas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(SorteioTrilhas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(SorteioTrilhas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(() -> {
            new SorteioTrilhas().setVisible(true);
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton botaoSorteio;
    private javax.swing.ButtonGroup btnGroupDia;
    private javax.swing.JLabel campoNumero;
    private javax.swing.JLabel campoTrilha;
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
    private javax.swing.JLabel td1;
    private javax.swing.JLabel td2;
    private javax.swing.JLabel td3;
    private javax.swing.JLabel td4;
    private javax.swing.JLabel td5;
    private javax.swing.JLabel td6;
    private javax.swing.JLabel td7;
    private javax.swing.JLabel ts1;
    private javax.swing.JLabel ts2;
    private javax.swing.JLabel ts3;
    private javax.swing.JLabel ts4;
    private javax.swing.JLabel ts5;
    private javax.swing.JLabel ts6;
    private javax.swing.JLabel ts7;
    // End of variables declaration//GEN-END:variables
}
