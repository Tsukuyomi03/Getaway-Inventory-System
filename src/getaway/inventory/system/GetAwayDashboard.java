
package getaway.inventory.system;

import static getaway.inventory.system.class_login.dbURL;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JOptionPane;
import static javax.swing.JOptionPane.showMessageDialog;
import javax.swing.RowFilter;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableRowSorter;


public class GetAwayDashboard extends javax.swing.JFrame {
    
    static String dbURL = "jdbc:mysql://localhost:3306/getaway?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC";
    static String username = "root";
    static String password = "";
    
    public GetAwayDashboard() {
        initComponents();
        
        refresh();
        refresh_tables();
    }
    private void refresh()
    {
        
        lbl_pid.setText("");
        lbl_pn.setText("");
        lbl_pt.setText("");
        lbl_price.setText("");
        lbl_spid.setText("");
        lbl_spname.setText("");
        lbl_srem.setText("");
        lbl_sin.setText("");
        lbl_sout.setText("");
        
  
    }
    private void refresh_tables()
    {
        
        table_prod();
        table_stocks();
        table_logs();
    }
    private void table_logs()
    {
        try(Connection cn = DriverManager.getConnection(dbURL, username, password))
        {
            String query = "SELECT * from logging";
            Statement sp = cn.createStatement();
            ResultSet rs = sp.executeQuery(query); 
            DefaultTableModel tm = (DefaultTableModel)tbl_logs.getModel();
            tm.setRowCount(0);
            while(rs.next())
            {
                Object o[] = {rs.getString("Stamp") + " : " +  rs.getString("Logs")};
                tm.addRow(o);   
            }
        } 
        catch (SQLException e) 
        {
            JOptionPane.showMessageDialog(this, e);
        }   
    }
    private void table_stocks()
    {
        try
        {
            Connection cn = DriverManager.getConnection(dbURL, username, password);
            PreparedStatement ps = cn.prepareStatement("SELECT * FROM products");
            ResultSet rs = ps.executeQuery();
            DefaultTableModel tm = (DefaultTableModel)tbl_stocks.getModel();
            tm.setRowCount(0);
            while(rs.next())
            {
                Object o[] = {rs.getString("Product_ID"),rs.getString("Product_Name"),rs.getString("Remaining"),rs.getString("Incoming"),rs.getString("Outgoing")};
                tm.addRow(o);
            }
        } 
        catch (SQLException e) 
        {
            JOptionPane.showMessageDialog(this, e);
        }   
    }
    
    private void table_prod()
    {
        try
        {
            Connection cn = DriverManager.getConnection(dbURL, username, password);
            PreparedStatement ps = cn.prepareStatement("SELECT * FROM products");
            ResultSet rs = ps.executeQuery();
            DefaultTableModel tm = (DefaultTableModel)tbl_prod.getModel();
            tm.setRowCount(0);
            while(rs.next())
            {
                Object o[] = {rs.getString("Product_ID"),rs.getString("Product_Name"),rs.getString("Product_Type"),rs.getString("Product_Price")};
                tm.addRow(o);
            }
        } 
        catch (SQLException e) 
        {
            JOptionPane.showMessageDialog(this, e);
        }   
    }
    private void filterproducts(String query)
    {
        TableRowSorter<DefaultTableModel> tm2 = new TableRowSorter<>((DefaultTableModel)tbl_prod.getModel());   
        tbl_prod.setRowSorter(tm2);   
        tm2.setRowFilter(RowFilter.regexFilter("(?i)" + query));
    }
    
    private void filterstocks(String query)
    {
        TableRowSorter<DefaultTableModel> tm2 = new TableRowSorter<>((DefaultTableModel)tbl_stocks.getModel());   
        tbl_stocks.setRowSorter(tm2);   
        tm2.setRowFilter(RowFilter.regexFilter("(?i)" + query));
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        pnl_back = new javax.swing.JPanel();
        lbl_logo = new javax.swing.JLabel();
        lbl_name = new javax.swing.JLabel();
        pnl_buttons = new javax.swing.JPanel();
        pnl_products = new javax.swing.JPanel();
        jLabel19 = new javax.swing.JLabel();
        jLabel22 = new javax.swing.JLabel();
        pnl_logout = new javax.swing.JPanel();
        jLabel20 = new javax.swing.JLabel();
        jLabel23 = new javax.swing.JLabel();
        btn_stocks = new javax.swing.JPanel();
        jLabel24 = new javax.swing.JLabel();
        jLabel25 = new javax.swing.JLabel();
        btn_stocks1 = new javax.swing.JPanel();
        jLabel30 = new javax.swing.JLabel();
        jLabel31 = new javax.swing.JLabel();
        pnl_main = new javax.swing.JPanel();
        card_product = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        tbl_prod = new javax.swing.JTable();
        jLabel10 = new javax.swing.JLabel();
        txt_prodsearch = new javax.swing.JTextField();
        jPanel1 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        lbl_pid = new javax.swing.JLabel();
        lbl_pn = new javax.swing.JLabel();
        lbl_pt = new javax.swing.JLabel();
        lbl_price = new javax.swing.JLabel();
        jPanel4 = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        card_stocks = new javax.swing.JPanel();
        jScrollPane3 = new javax.swing.JScrollPane();
        tbl_stocks = new javax.swing.JTable();
        lbl_search5 = new javax.swing.JLabel();
        txt_searchstocks = new javax.swing.JTextField();
        btn_order = new javax.swing.JPanel();
        jLabel8 = new javax.swing.JLabel();
        btn_prodsold = new javax.swing.JPanel();
        jLabel44 = new javax.swing.JLabel();
        btn_remove = new javax.swing.JPanel();
        jLabel45 = new javax.swing.JLabel();
        btn_srefresh1 = new javax.swing.JPanel();
        jLabel46 = new javax.swing.JLabel();
        jLabel26 = new javax.swing.JLabel();
        jLabel27 = new javax.swing.JLabel();
        jLabel28 = new javax.swing.JLabel();
        jLabel29 = new javax.swing.JLabel();
        jLabel17 = new javax.swing.JLabel();
        lbl_spid = new javax.swing.JLabel();
        lbl_spname = new javax.swing.JLabel();
        lbl_srem = new javax.swing.JLabel();
        lbl_sin = new javax.swing.JLabel();
        lbl_sout = new javax.swing.JLabel();
        card_logs = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tbl_logs = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);

        pnl_back.setBackground(new java.awt.Color(255, 204, 204));

        lbl_logo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/getaway/inventory/system/logo.png"))); // NOI18N

        lbl_name.setBackground(new java.awt.Color(255, 153, 102));
        lbl_name.setFont(new java.awt.Font("Segoe Script", 1, 48)); // NOI18N
        lbl_name.setForeground(new java.awt.Color(153, 0, 0));
        lbl_name.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbl_name.setText("GetAway Inventory System");
        lbl_name.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        lbl_name.setDebugGraphicsOptions(javax.swing.DebugGraphics.FLASH_OPTION);
        lbl_name.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);

        pnl_buttons.setBackground(new java.awt.Color(255, 204, 204));

        pnl_products.setBackground(new java.awt.Color(255, 153, 153));
        pnl_products.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                pnl_productsMouseClicked(evt);
            }
        });

        jLabel19.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel19.setText("Products");

        jLabel22.setIcon(new javax.swing.ImageIcon(getClass().getResource("/getaway/inventory/system/product.png"))); // NOI18N

        javax.swing.GroupLayout pnl_productsLayout = new javax.swing.GroupLayout(pnl_products);
        pnl_products.setLayout(pnl_productsLayout);
        pnl_productsLayout.setHorizontalGroup(
            pnl_productsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnl_productsLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel22)
                .addGap(18, 18, 18)
                .addComponent(jLabel19, javax.swing.GroupLayout.PREFERRED_SIZE, 93, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(37, 37, 37))
        );
        pnl_productsLayout.setVerticalGroup(
            pnl_productsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnl_productsLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(pnl_productsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel22)
                    .addComponent(jLabel19, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(33, 33, 33))
        );

        pnl_logout.setBackground(new java.awt.Color(255, 153, 153));
        pnl_logout.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                pnl_logoutMouseClicked(evt);
            }
        });

        jLabel20.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel20.setText("Logout");

        jLabel23.setIcon(new javax.swing.ImageIcon(getClass().getResource("/getaway/inventory/system/logout.png"))); // NOI18N
        jLabel23.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel23MouseClicked(evt);
            }
        });

        javax.swing.GroupLayout pnl_logoutLayout = new javax.swing.GroupLayout(pnl_logout);
        pnl_logout.setLayout(pnl_logoutLayout);
        pnl_logoutLayout.setHorizontalGroup(
            pnl_logoutLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnl_logoutLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel23)
                .addGap(18, 18, 18)
                .addComponent(jLabel20, javax.swing.GroupLayout.PREFERRED_SIZE, 98, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(28, 28, 28))
        );
        pnl_logoutLayout.setVerticalGroup(
            pnl_logoutLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnl_logoutLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnl_logoutLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel23)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnl_logoutLayout.createSequentialGroup()
                        .addComponent(jLabel20, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addContainerGap())))
        );

        btn_stocks.setBackground(new java.awt.Color(255, 153, 153));
        btn_stocks.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btn_stocksMouseClicked(evt);
            }
        });

        jLabel24.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel24.setText("Stocks");

        jLabel25.setIcon(new javax.swing.ImageIcon(getClass().getResource("/getaway/inventory/system/product.png"))); // NOI18N

        javax.swing.GroupLayout btn_stocksLayout = new javax.swing.GroupLayout(btn_stocks);
        btn_stocks.setLayout(btn_stocksLayout);
        btn_stocksLayout.setHorizontalGroup(
            btn_stocksLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, btn_stocksLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel25)
                .addGap(18, 18, 18)
                .addComponent(jLabel24, javax.swing.GroupLayout.PREFERRED_SIZE, 93, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(37, 37, 37))
        );
        btn_stocksLayout.setVerticalGroup(
            btn_stocksLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, btn_stocksLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(btn_stocksLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel25)
                    .addComponent(jLabel24, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(33, 33, 33))
        );

        btn_stocks1.setBackground(new java.awt.Color(255, 153, 153));
        btn_stocks1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btn_stocks1MouseClicked(evt);
            }
        });

        jLabel30.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel30.setText("Logs");

        jLabel31.setIcon(new javax.swing.ImageIcon(getClass().getResource("/getaway/inventory/system/product.png"))); // NOI18N

        javax.swing.GroupLayout btn_stocks1Layout = new javax.swing.GroupLayout(btn_stocks1);
        btn_stocks1.setLayout(btn_stocks1Layout);
        btn_stocks1Layout.setHorizontalGroup(
            btn_stocks1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, btn_stocks1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel31)
                .addGap(18, 18, 18)
                .addComponent(jLabel30, javax.swing.GroupLayout.PREFERRED_SIZE, 93, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(37, 37, 37))
        );
        btn_stocks1Layout.setVerticalGroup(
            btn_stocks1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, btn_stocks1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(btn_stocks1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel31)
                    .addComponent(jLabel30, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(33, 33, 33))
        );

        javax.swing.GroupLayout pnl_buttonsLayout = new javax.swing.GroupLayout(pnl_buttons);
        pnl_buttons.setLayout(pnl_buttonsLayout);
        pnl_buttonsLayout.setHorizontalGroup(
            pnl_buttonsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnl_buttonsLayout.createSequentialGroup()
                .addGroup(pnl_buttonsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(pnl_logout, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 190, Short.MAX_VALUE)
                    .addComponent(pnl_products, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 190, Short.MAX_VALUE)
                    .addComponent(btn_stocks, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 190, Short.MAX_VALUE)
                    .addComponent(btn_stocks1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 190, Short.MAX_VALUE))
                .addGap(0, 0, Short.MAX_VALUE))
        );
        pnl_buttonsLayout.setVerticalGroup(
            pnl_buttonsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnl_buttonsLayout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addComponent(pnl_products, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btn_stocks, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btn_stocks1, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(pnl_logout, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        pnl_main.setBackground(new java.awt.Color(204, 255, 204));
        pnl_main.setLayout(new java.awt.CardLayout());

        card_product.setBackground(new java.awt.Color(255, 204, 255));

        tbl_prod.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Product ID", "Product Name", "Type", "Price"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tbl_prod.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tbl_prodMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(tbl_prod);

        jLabel10.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel10.setText("SEARCH");

        txt_prodsearch.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txt_prodsearchKeyReleased(evt);
            }
        });

        jPanel1.setBackground(new java.awt.Color(204, 204, 255));
        jPanel1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jPanel1MouseClicked(evt);
            }
        });

        jLabel2.setText("UPDATE PRODUCT");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 114, Short.MAX_VALUE)
            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel1Layout.createSequentialGroup()
                    .addGap(14, 14, 14)
                    .addComponent(jLabel2)
                    .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 45, Short.MAX_VALUE)
            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel1Layout.createSequentialGroup()
                    .addGap(15, 15, 15)
                    .addComponent(jLabel2)
                    .addContainerGap(16, Short.MAX_VALUE)))
        );

        jPanel2.setBackground(new java.awt.Color(204, 204, 255));
        jPanel2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jPanel2MouseClicked(evt);
            }
        });

        jLabel3.setText("REMOVE  PRODUCT");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 119, Short.MAX_VALUE)
            .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel2Layout.createSequentialGroup()
                    .addGap(14, 14, 14)
                    .addComponent(jLabel3)
                    .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 45, Short.MAX_VALUE)
            .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel2Layout.createSequentialGroup()
                    .addGap(15, 15, 15)
                    .addComponent(jLabel3)
                    .addContainerGap(16, Short.MAX_VALUE)))
        );

        jPanel3.setBackground(new java.awt.Color(204, 204, 255));
        jPanel3.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jPanel3MouseClicked(evt);
            }
        });

        jLabel1.setText("ADD PRODUCT");

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addContainerGap(39, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addContainerGap(20, Short.MAX_VALUE)
                .addComponent(jLabel1)
                .addContainerGap())
        );

        jLabel11.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel11.setText("Product ID");

        jLabel12.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel12.setText("Product Name");

        jLabel13.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel13.setText("Product Type");

        jLabel14.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel14.setText("Price");

        lbl_pid.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        lbl_pid.setText(" ");

        lbl_pn.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        lbl_pn.setText(" ");

        lbl_pt.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        lbl_pt.setText(" ");

        lbl_price.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        lbl_price.setText(" ");

        jPanel4.setBackground(new java.awt.Color(204, 204, 255));
        jPanel4.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jPanel4MouseClicked(evt);
            }
        });

        jLabel4.setText("REFRESH");

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 119, Short.MAX_VALUE)
            .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel4Layout.createSequentialGroup()
                    .addGap(14, 14, 14)
                    .addComponent(jLabel4)
                    .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 45, Short.MAX_VALUE)
            .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel4Layout.createSequentialGroup()
                    .addGap(15, 15, 15)
                    .addComponent(jLabel4)
                    .addContainerGap(16, Short.MAX_VALUE)))
        );

        javax.swing.GroupLayout card_productLayout = new javax.swing.GroupLayout(card_product);
        card_product.setLayout(card_productLayout);
        card_productLayout.setHorizontalGroup(
            card_productLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(card_productLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(card_productLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, card_productLayout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(jLabel10)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txt_prodsearch, javax.swing.GroupLayout.PREFERRED_SIZE, 240, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(card_productLayout.createSequentialGroup()
                        .addGroup(card_productLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(card_productLayout.createSequentialGroup()
                                .addGroup(card_productLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel11)
                                    .addComponent(jLabel12)
                                    .addComponent(jLabel13)
                                    .addComponent(jLabel14))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(card_productLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(lbl_pid)
                                    .addComponent(lbl_pn)
                                    .addComponent(lbl_pt)
                                    .addComponent(lbl_price)))
                            .addGroup(card_productLayout.createSequentialGroup()
                                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(0, 324, Short.MAX_VALUE)))
                .addContainerGap())
            .addComponent(jScrollPane2, javax.swing.GroupLayout.Alignment.TRAILING)
        );
        card_productLayout.setVerticalGroup(
            card_productLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, card_productLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(card_productLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel10)
                    .addComponent(txt_prodsearch, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 243, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(card_productLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(card_productLayout.createSequentialGroup()
                        .addComponent(jLabel11)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel12)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel13)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel14)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(card_productLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(card_productLayout.createSequentialGroup()
                                .addGap(0, 5, Short.MAX_VALUE)
                                .addGroup(card_productLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(card_productLayout.createSequentialGroup()
                                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 0, Short.MAX_VALUE))))
                    .addGroup(card_productLayout.createSequentialGroup()
                        .addComponent(lbl_pid)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lbl_pn)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lbl_pt)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lbl_price)))
                .addGap(18, 18, 18))
        );

        pnl_main.add(card_product, "card3");

        tbl_stocks.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null}
            },
            new String [] {
                "PRODUCT ID", "PRODUCT NAME", "REMAINING", "INCOMING", "OUTGOING"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tbl_stocks.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tbl_stocksMouseClicked(evt);
            }
        });
        jScrollPane3.setViewportView(tbl_stocks);

        lbl_search5.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        lbl_search5.setText("SEARCH");

        txt_searchstocks.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_searchstocksActionPerformed(evt);
            }
        });
        txt_searchstocks.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txt_searchstocksKeyReleased(evt);
            }
        });

        btn_order.setBackground(new java.awt.Color(204, 204, 255));
        btn_order.setForeground(new java.awt.Color(0, 255, 0));
        btn_order.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btn_orderMouseClicked(evt);
            }
        });

        jLabel8.setText("Order Stocks");

        javax.swing.GroupLayout btn_orderLayout = new javax.swing.GroupLayout(btn_order);
        btn_order.setLayout(btn_orderLayout);
        btn_orderLayout.setHorizontalGroup(
            btn_orderLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(btn_orderLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel8)
                .addContainerGap(43, Short.MAX_VALUE))
        );
        btn_orderLayout.setVerticalGroup(
            btn_orderLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(btn_orderLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel8)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        btn_prodsold.setBackground(new java.awt.Color(204, 204, 255));
        btn_prodsold.setForeground(new java.awt.Color(0, 255, 0));
        btn_prodsold.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btn_prodsoldMouseClicked(evt);
            }
        });

        jLabel44.setText("Product Sold");

        javax.swing.GroupLayout btn_prodsoldLayout = new javax.swing.GroupLayout(btn_prodsold);
        btn_prodsold.setLayout(btn_prodsoldLayout);
        btn_prodsoldLayout.setHorizontalGroup(
            btn_prodsoldLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(btn_prodsoldLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel44)
                .addContainerGap(30, Short.MAX_VALUE))
        );
        btn_prodsoldLayout.setVerticalGroup(
            btn_prodsoldLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(btn_prodsoldLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel44)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        btn_remove.setBackground(new java.awt.Color(204, 204, 255));
        btn_remove.setForeground(new java.awt.Color(0, 255, 0));
        btn_remove.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btn_removeMouseClicked(evt);
            }
        });

        jLabel45.setText("Recieve Delivery");

        javax.swing.GroupLayout btn_removeLayout = new javax.swing.GroupLayout(btn_remove);
        btn_remove.setLayout(btn_removeLayout);
        btn_removeLayout.setHorizontalGroup(
            btn_removeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(btn_removeLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel45)
                .addContainerGap(19, Short.MAX_VALUE))
        );
        btn_removeLayout.setVerticalGroup(
            btn_removeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(btn_removeLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel45)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        btn_srefresh1.setBackground(new java.awt.Color(204, 204, 255));
        btn_srefresh1.setForeground(new java.awt.Color(0, 255, 0));
        btn_srefresh1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btn_srefresh1MouseClicked(evt);
            }
        });

        jLabel46.setText("Refresh");

        javax.swing.GroupLayout btn_srefresh1Layout = new javax.swing.GroupLayout(btn_srefresh1);
        btn_srefresh1.setLayout(btn_srefresh1Layout);
        btn_srefresh1Layout.setHorizontalGroup(
            btn_srefresh1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(btn_srefresh1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel46)
                .addContainerGap(76, Short.MAX_VALUE))
        );
        btn_srefresh1Layout.setVerticalGroup(
            btn_srefresh1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(btn_srefresh1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel46)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jLabel26.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel26.setForeground(new java.awt.Color(0, 102, 102));
        jLabel26.setText("Remaining :");

        jLabel27.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel27.setForeground(new java.awt.Color(0, 102, 102));
        jLabel27.setText("Incoming : ");

        jLabel28.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel28.setForeground(new java.awt.Color(0, 102, 102));
        jLabel28.setText("Outgoing : ");

        jLabel29.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel29.setForeground(new java.awt.Color(0, 102, 102));
        jLabel29.setText("Product Name :");

        jLabel17.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel17.setForeground(new java.awt.Color(0, 102, 102));
        jLabel17.setText("Product ID :");

        lbl_spid.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        lbl_spid.setForeground(new java.awt.Color(0, 102, 102));
        lbl_spid.setText(" ");

        lbl_spname.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        lbl_spname.setForeground(new java.awt.Color(0, 102, 102));
        lbl_spname.setText(" ");

        lbl_srem.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        lbl_srem.setForeground(new java.awt.Color(0, 102, 102));
        lbl_srem.setText(" ");

        lbl_sin.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        lbl_sin.setForeground(new java.awt.Color(0, 102, 102));
        lbl_sin.setText(" ");

        lbl_sout.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        lbl_sout.setForeground(new java.awt.Color(0, 102, 102));
        lbl_sout.setText(" ");

        javax.swing.GroupLayout card_stocksLayout = new javax.swing.GroupLayout(card_stocks);
        card_stocks.setLayout(card_stocksLayout);
        card_stocksLayout.setHorizontalGroup(
            card_stocksLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane3)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, card_stocksLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(lbl_search5)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txt_searchstocks, javax.swing.GroupLayout.PREFERRED_SIZE, 282, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
            .addGroup(card_stocksLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(card_stocksLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(card_stocksLayout.createSequentialGroup()
                        .addComponent(btn_order, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btn_prodsold, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btn_remove, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btn_srefresh1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(card_stocksLayout.createSequentialGroup()
                        .addGroup(card_stocksLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel28)
                            .addComponent(jLabel29)
                            .addComponent(jLabel17)
                            .addComponent(jLabel26)
                            .addComponent(jLabel27))
                        .addGap(18, 18, 18)
                        .addGroup(card_stocksLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lbl_spid, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(lbl_spname, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(lbl_srem, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(lbl_sin, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(lbl_sout, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                .addContainerGap(367, Short.MAX_VALUE))
        );
        card_stocksLayout.setVerticalGroup(
            card_stocksLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, card_stocksLayout.createSequentialGroup()
                .addGap(0, 11, Short.MAX_VALUE)
                .addGroup(card_stocksLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lbl_search5)
                    .addComponent(txt_searchstocks, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 241, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(4, 4, 4)
                .addGroup(card_stocksLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(card_stocksLayout.createSequentialGroup()
                        .addComponent(jLabel17)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel29))
                    .addGroup(card_stocksLayout.createSequentialGroup()
                        .addComponent(lbl_spid)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lbl_spname)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(card_stocksLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(card_stocksLayout.createSequentialGroup()
                        .addComponent(jLabel26, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel27)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel28))
                    .addGroup(card_stocksLayout.createSequentialGroup()
                        .addComponent(lbl_srem, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lbl_sin)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lbl_sout)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(card_stocksLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btn_order, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btn_prodsold, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btn_remove, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btn_srefresh1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        pnl_main.add(card_stocks, "card4");

        tbl_logs.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null},
                {null},
                {null},
                {null}
            },
            new String [] {
                "Logs"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tbl_logs.getTableHeader().setReorderingAllowed(false);
        jScrollPane1.setViewportView(tbl_logs);
        if (tbl_logs.getColumnModel().getColumnCount() > 0) {
            tbl_logs.getColumnModel().getColumn(0).setResizable(false);
        }

        javax.swing.GroupLayout card_logsLayout = new javax.swing.GroupLayout(card_logs);
        card_logs.setLayout(card_logsLayout);
        card_logsLayout.setHorizontalGroup(
            card_logsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 843, Short.MAX_VALUE)
        );
        card_logsLayout.setVerticalGroup(
            card_logsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 471, Short.MAX_VALUE)
        );

        pnl_main.add(card_logs, "card4");

        javax.swing.GroupLayout pnl_backLayout = new javax.swing.GroupLayout(pnl_back);
        pnl_back.setLayout(pnl_backLayout);
        pnl_backLayout.setHorizontalGroup(
            pnl_backLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnl_backLayout.createSequentialGroup()
                .addComponent(pnl_buttons, javax.swing.GroupLayout.PREFERRED_SIZE, 188, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(pnl_main, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(pnl_backLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lbl_logo)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lbl_name, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        pnl_backLayout.setVerticalGroup(
            pnl_backLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnl_backLayout.createSequentialGroup()
                .addGroup(pnl_backLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(lbl_name, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(lbl_logo, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(0, 0, 0)
                .addGroup(pnl_backLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(pnl_buttons, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(pnl_main, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(pnl_back, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(pnl_back, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jLabel23MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel23MouseClicked
        this.dispose();
    }//GEN-LAST:event_jLabel23MouseClicked

    private void pnl_logoutMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_pnl_logoutMouseClicked
        try
        {
        
        Connection cn = DriverManager.getConnection(dbURL, username, password);
        PreparedStatement ps = cn.prepareStatement("SELECT * FROM users WHERE Pincode=?");
        ps.setString(1, GetAwayLogIn.pin);
        ResultSet rs = ps.executeQuery();
        while(rs.next())
        {
            
                     Connection cnc = DriverManager.getConnection(dbURL, username, password);
                     rs.getString(4);
                     String logger = rs.getString(4) + " has logged out.";
                     PreparedStatement sps = cnc.prepareStatement("INSERT INTO logging (Logs) Value (?)");
                     sps.setString(1, logger);
                     
                        int rowsInserted = sps.executeUpdate();
			if (rowsInserted > 0)
                        {
			       
			} 
                        this.dispose();
                        
                     break;
       }
        
        
        
        cn.close();
        
    }
    catch (SQLException e) {
      System.out.println(e);
    }
    }//GEN-LAST:event_pnl_logoutMouseClicked

    private void tbl_prodMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbl_prodMouseClicked
            DefaultTableModel tm = (DefaultTableModel)tbl_prod.getModel();
            int selectedRowIndex = tbl_prod.getSelectedRow();            
            lbl_pid.setText(tm.getValueAt(selectedRowIndex, 0).toString()); 
            lbl_pn.setText(tm.getValueAt(selectedRowIndex, 1).toString());
            lbl_pt.setText(tm.getValueAt(selectedRowIndex, 2).toString());
            lbl_price.setText(tm.getValueAt(selectedRowIndex, 3).toString());
    }//GEN-LAST:event_tbl_prodMouseClicked

    private void txt_prodsearchKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_prodsearchKeyReleased
        filterproducts(txt_prodsearch.getText().toLowerCase());
    }//GEN-LAST:event_txt_prodsearchKeyReleased

    private void pnl_productsMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_pnl_productsMouseClicked
        pnl_main.removeAll();
        pnl_main.add(card_product);
        pnl_main.repaint();
        pnl_main.revalidate();
        refresh();
        refresh_tables();
    }//GEN-LAST:event_pnl_productsMouseClicked

    private void jPanel3MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel3MouseClicked
        String wew = "ADD PRODUCT";
        new GetAwayProducts(wew).setVisible(true);
        refresh();
        refresh_tables();
    }//GEN-LAST:event_jPanel3MouseClicked

    private void jPanel1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel1MouseClicked
        if(lbl_pid.getText().equals(""))
        {
            JOptionPane.showMessageDialog(null, "Select a Product First!");
        }
        else
        {
            String wew="UPDATE PRODUCT";
            new GetAwayProducts2(lbl_pn.getText(),lbl_pt.getText(), lbl_price.getText(),wew).setVisible(true);
            refresh();
            refresh_tables();
        }
    }//GEN-LAST:event_jPanel1MouseClicked

    private void jPanel2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel2MouseClicked
        if(lbl_pid.getText().equals(""))
        {
            JOptionPane.showMessageDialog(null, "Select a Product First!");
        }
        else
        {
            int response = JOptionPane.showConfirmDialog(null, "Are you sure you want to Delete this Product?" , "Alert", JOptionPane.YES_NO_OPTION, JOptionPane.WARNING_MESSAGE);
            if(response == JOptionPane.NO_OPTION)
            {
                
            }
            else
            {
                       class_product.Delete_Product(lbl_pid.getText(), lbl_pn.getText());
                       refresh();
                       refresh_tables();
            }
           
        }
        
    }//GEN-LAST:event_jPanel2MouseClicked

    private void btn_stocksMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_stocksMouseClicked
        pnl_main.removeAll();
        pnl_main.add(card_stocks);
        pnl_main.repaint();
        pnl_main.revalidate();
        refresh();
        refresh_tables();
    }//GEN-LAST:event_btn_stocksMouseClicked

    private void txt_searchstocksActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_searchstocksActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_searchstocksActionPerformed

    private void txt_searchstocksKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_searchstocksKeyReleased
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_searchstocksKeyReleased

    private void tbl_stocksMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbl_stocksMouseClicked
        DefaultTableModel tm = (DefaultTableModel)tbl_stocks.getModel();
            int selectedRowIndex = tbl_stocks.getSelectedRow();            
            lbl_spid.setText(tm.getValueAt(selectedRowIndex, 0).toString()); 
            lbl_spname.setText(tm.getValueAt(selectedRowIndex, 1).toString());
            lbl_srem.setText(tm.getValueAt(selectedRowIndex, 2).toString());
            lbl_sin.setText(tm.getValueAt(selectedRowIndex, 3).toString());
            lbl_sout.setText(tm.getValueAt(selectedRowIndex, 4).toString());
    }//GEN-LAST:event_tbl_stocksMouseClicked

    private void jPanel4MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel4MouseClicked
        refresh();
        refresh_tables();
    }//GEN-LAST:event_jPanel4MouseClicked

    private void btn_orderMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_orderMouseClicked
        if(lbl_spname.getText().equals(""))
        {
            JOptionPane.showMessageDialog(null, "Select a Product First!");
        }
        else
        {
           new GetAwayStocksOrder(lbl_spid.getText(),lbl_spname.getText()).setVisible(true);
           refresh();
           refresh_tables();
        }
        
    }//GEN-LAST:event_btn_orderMouseClicked

    private void btn_srefresh1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_srefresh1MouseClicked
        refresh();
        refresh_tables();
    }//GEN-LAST:event_btn_srefresh1MouseClicked

    private void btn_prodsoldMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_prodsoldMouseClicked
        new GetAwayStocksSold(lbl_spid.getText(), lbl_spname.getText()).setVisible(true);
    }//GEN-LAST:event_btn_prodsoldMouseClicked

    private void btn_removeMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_removeMouseClicked
        class_product.Recieve_Product(lbl_spid.getText(), lbl_spname.getText());
    }//GEN-LAST:event_btn_removeMouseClicked

    private void btn_stocks1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_stocks1MouseClicked
        pnl_main.removeAll();
        pnl_main.add(card_logs);
        pnl_main.repaint();
        pnl_main.revalidate();
        refresh();
        refresh_tables();
    }//GEN-LAST:event_btn_stocks1MouseClicked

  
    public static void main(String args[]) {
        
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new GetAwayDashboard().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel btn_order;
    private javax.swing.JPanel btn_prodsold;
    private javax.swing.JPanel btn_remove;
    private javax.swing.JPanel btn_srefresh1;
    private javax.swing.JPanel btn_stocks;
    private javax.swing.JPanel btn_stocks1;
    private javax.swing.JPanel card_logs;
    private javax.swing.JPanel card_product;
    private javax.swing.JPanel card_stocks;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel23;
    private javax.swing.JLabel jLabel24;
    private javax.swing.JLabel jLabel25;
    private javax.swing.JLabel jLabel26;
    private javax.swing.JLabel jLabel27;
    private javax.swing.JLabel jLabel28;
    private javax.swing.JLabel jLabel29;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel30;
    private javax.swing.JLabel jLabel31;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel44;
    private javax.swing.JLabel jLabel45;
    private javax.swing.JLabel jLabel46;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JLabel lbl_logo;
    private javax.swing.JLabel lbl_name;
    private javax.swing.JLabel lbl_pid;
    private javax.swing.JLabel lbl_pn;
    private javax.swing.JLabel lbl_price;
    private javax.swing.JLabel lbl_pt;
    private javax.swing.JLabel lbl_search5;
    private javax.swing.JLabel lbl_sin;
    private javax.swing.JLabel lbl_sout;
    private javax.swing.JLabel lbl_spid;
    private javax.swing.JLabel lbl_spname;
    private javax.swing.JLabel lbl_srem;
    private javax.swing.JPanel pnl_back;
    private javax.swing.JPanel pnl_buttons;
    private javax.swing.JPanel pnl_logout;
    private javax.swing.JPanel pnl_main;
    private javax.swing.JPanel pnl_products;
    private javax.swing.JTable tbl_logs;
    private javax.swing.JTable tbl_prod;
    private javax.swing.JTable tbl_stocks;
    private javax.swing.JTextField txt_prodsearch;
    private javax.swing.JTextField txt_searchstocks;
    // End of variables declaration//GEN-END:variables

}
