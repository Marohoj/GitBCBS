package gui;

import gui.AdminMenu;
import gui.LoginScreen;
import gui.UserMenu;

import java.awt.CardLayout;
import java.awt.Color;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.ImageIcon;

public class Screen extends JFrame {
	public static final String LOGIN = "login";
	public static final String USERMENU = "usermenu";
	public static final String ADMINMENU = "adminmenu";
	public static final String DEPOSIT = "deposit";
	public static final String WITHDRAW = "withdraw";
	public static final String TRANSFER = "transfer";
	public static final String VIEW = "view";
	public static final String CREATE = "create";
	public static final String DELETE = "delete";
		
	private LoginScreen login;
	private UserMenu usermenu;
	private AdminMenu adminmenu;
	private DepositScreen deposit;
	private WithdrawScreen withdraw;
	private TransferScreen transfer;
	private ViewScreen view;
	private CreateScreen create;
	private DeleteScreen delete;
	private JPanel contentPane;
	
	private CardLayout c;
	
	/**
	 * Create the frame.
	 */
	
	// Background
	//JPanel jp = new JPanel();
	//JLabel jl = new JLabel();
	
	
	
	
	public Screen(){
		
		
		
		
		setTitle("CBS Bitcoin ATM");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 800, 600);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new CardLayout(0, 0));
		setContentPane(contentPane);

		login = new LoginScreen();
		login.setBackground(new Color(255, 255, 255));
		login.setBounds(100, 100, 600, 500);
		login.setLayout(null);
		contentPane.add(login, LOGIN);
		
		usermenu = new UserMenu();
		usermenu.setBackground(new Color(255, 255, 255));
		usermenu.setBounds(100, 100, 600, 500);
		usermenu.setLayout(null);
		contentPane.add(usermenu, USERMENU);
		
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
		
		create = new CreateScreen();
		create.setBackground(new Color(255, 255, 255));
		create.setBounds(100, 100, 600, 500);
		create.setLayout(null);
		contentPane.add(create, CREATE);
		
		delete = new DeleteScreen();
		delete.setBackground(new Color(255, 255, 255));
		delete.setBounds(100, 100, 600, 500);
		delete.setLayout(null);
		contentPane.add(delete, DELETE);
		
		view = new ViewScreen();
		view.setBackground(new Color(255, 255, 255));
		view.setBounds(100, 100, 600, 500);
		view.setLayout(null);
		contentPane.add(view, VIEW);
				
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
	
	public ViewScreen getViewScreen(){
		return view;
	}
	
	public CreateScreen getCreateScreen(){
		return create;
	}
	
	public DeleteScreen getDeleteScreen(){
		return delete;
	}
	
	public void show(String card){
		c.show(this.getContentPane(), card);
	}
}
