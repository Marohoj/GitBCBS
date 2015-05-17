package gui;

import gui.AdminMenu;
import gui.LoginScreen;
import gui.UserMenu;

import java.awt.CardLayout;
import java.awt.Color;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import logic.UserMethod;

public class Screen extends JFrame {
	public static final String LOGIN = "login";
	public static final String USERMENU = "usermenu";
	public static final String ADMINMENU = "adminmenu";
	public static final String DEPOSIT = "deposit";
	public static final String WITHDRAW = "withdraw";
	public static final String TRANSFER = "transfer";
	public static final String VIS = "vis";
	public static final String OPRET = "opret";
	public static final String SLET = "slet";
		
	private LoginScreen login;
	private UserMenu usermenu;
	private UserMethod usermethod;
	private AdminMenu adminmenu;
	private DepositScreen deposit;
	private WithdrawScreen withdraw;
	private TransferScreen transfer;
	private VisBruger vis;
	private NyBruger opret;
	private SletBruger slet;
	private JPanel contentPane;
	
	private CardLayout c;
	
	/**
	 * Create the frame.
	 */
	public Screen(){
		
		setTitle("CBS Bitcoin ATM");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 800, 600);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new CardLayout(0, 0));
		setContentPane(contentPane);

		login = new LoginScreen();
		login.getLblPing().setBounds(10, 10, 218, 23);
		login.setBackground(new Color(255, 255, 255));
		login.setBounds(100, 100, 600, 500);
		login.setLayout(null);
		contentPane.add(login, LOGIN);
		
		usermenu = new UserMenu();
		usermenu.setBackground(new Color(255, 255, 255));
		usermenu.setBounds(100, 100, 600, 500);
		usermenu.setLayout(null);
		contentPane.add(usermenu, USERMENU);
		
		usermethod = new UserMethod();
		
		adminmenu = new AdminMenu();
		adminmenu.setBackground(new Color(255, 255, 255));
		adminmenu.setBounds(100, 100, 600, 500);
		adminmenu.setLayout(null);
		contentPane.add(adminmenu, ADMINMENU);
		
		deposit = new DepositScreen();
		deposit.setBackground(new Color(255, 255, 255));
		deposit.setBounds(100, 100, 600, 500);
		deposit.setLayout(null);
		contentPane.add(deposit, DEPOSIT);
		
		withdraw = new WithdrawScreen();
		withdraw.setBackground(new Color(255, 255, 255));
		withdraw.setBounds(100, 100, 600, 500);
		withdraw.setLayout(null);
		contentPane.add(withdraw, WITHDRAW);
		
		transfer = new TransferScreen();
		transfer.setBackground(new Color(255, 255, 255));
		transfer.setBounds(100, 100, 600, 500);
		transfer.setLayout(null);
		contentPane.add(transfer, TRANSFER);
		
		opret = new NyBruger();
		opret.setBackground(new Color(255, 255, 255));
		opret.setBounds(100, 100, 600, 500);
		opret.setLayout(null);
		contentPane.add(opret, OPRET);
		
		slet = new SletBruger();
		slet.setBackground(new Color(255, 255, 255));
		slet.setBounds(100, 100, 600, 500);
		slet.setLayout(null);
		contentPane.add(slet, SLET);
		
		vis = new VisBruger();
		vis.setBackground(new Color(255, 255, 255));
		vis.setBounds(100, 100, 600, 500);
		vis.setLayout(null);
		contentPane.add(vis, VIS);
				
		c = (CardLayout) getContentPane().getLayout();
	}
		
	public LoginScreen getLogin(){
		return login;
	}

	public UserMenu getUserMenu(){
		return usermenu;
	}

	public AdminMenu getAdminMenu(){
		return adminmenu;
	}
	
	public DepositScreen getDepositScreen(){
		return deposit;
	}
	
	public WithdrawScreen getWithdrawScreen(){
		return withdraw;
	}
	
	public TransferScreen getTransferScreen(){
		return transfer;
	}
	
	public VisBruger getVisBruger(){
		return vis;
	}
	
	public NyBruger getNyBruger(){
		return opret;
	}
	
	public SletBruger getSletBruger(){
		return slet;
	}
	
	public void show(String card){
		c.show(this.getContentPane(), card);
	}
}
