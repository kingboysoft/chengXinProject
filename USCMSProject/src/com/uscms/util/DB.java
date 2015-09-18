package com.uscms.util;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;


/************************************************
 * ����ƣ���ݿ����Java������
 * ���ܣ�ʵ����ݿ�ĳ������
 ************************************************/
public abstract class DB {
	private String classDriverName="";//ע����
	private String connectionString="";//��ݿ������ַ�
	private String userId="";//�����û���
	private String password="";//����
	/**************************
	 * ��ȡע�������
	 **************************/
	public String getClassDriverName() {
		return classDriverName;
	}
	/**************************
	 * ����ע�������
	 **************************/
	protected void setClassName(String className) {
		this.classDriverName = className;
	}
	/**************************
	 * ��ȡ��ݿ�����·��
	 **************************/
	public String getConnectionString() {
		return connectionString;
	}
	/**************************
	 * ������ݿ�����·��
	 **************************/
	public void setConnectionString(String connectionString) {
		this.connectionString = connectionString;
	}
	/**************************
	 * ������getConnection;
	 * ���ܣ�����ṩ�������������ַ��ṩ��ݿ�������Ӷ���
	 * ���أ������ڷ���������������Ӷ��󣬷��򷵻ؿա�
	 ***************************/
	public Connection getConnection() 
	{
		try
		{
			Class.forName(classDriverName);
			Connection con=DriverManager.getConnection(connectionString,
					userId,password);
			return con;
		}catch(ClassNotFoundException e)
		{
			e.printStackTrace();
			return null;
		}
		catch(SQLException e)
		{
			e.printStackTrace();
			return null;
		}

	}

	/******************************************
	 * ������getStatement;
	 * ���ܣ��ṩ�������������
	 * ���أ������ڷ�����������ض��󣬷��򷵻ؿա�
	 ******************************************/
	public PreparedStatement getStatement(String cmd)
	{
		Connection con=getConnection();//��ȡ���Ӷ���
		try
		{
			return con.prepareStatement(cmd); 
		}catch(SQLException e)
		{
			return null;
		}

	}
	/**************************
	 * ������command;
	 * ���ܣ����ṩ��SQL����ָ��cmdִ�в���
	 * ���أ�����0��ʾ�ɹ��������ʾʧ�ܡ�
	 ***************************/
	public int command(String cmd)
	{
		Connection con=getConnection();//��ȡ���Ӷ���
		if (con==null) return 0;
		try
		{
			PreparedStatement smt=con.prepareStatement(cmd);//����������
			return smt.executeUpdate();  
		}catch(SQLException ex)
		{
			return 0;
		}finally
		{
			try
			{
				con.close();  
			}catch(SQLException e)
			{}

		}
	}
	/**************************
	 * ������command;
	 * ���ܣ����ṩ��SQL����ָ��cmd��������ִ�в���
	 * ���أ�����0��ʾ�ɹ��������ʾʧ�ܡ�
	 ***************************/
	public int command(String[] cmd)
	{
		Connection con=getConnection();//��ȡ���Ӷ���	  
		if (con==null || cmd==null || cmd.length==0) return 0;
		try
		{
			con.setAutoCommit(false);   
			Statement smt=con.createStatement();//����������
			for(int i=0;i<cmd.length;i++)
				smt.addBatch(cmd[i]);
			 smt.executeBatch();
			 con.commit();
			return smt.getUpdateCount(); 
		}catch(SQLException ex)
		{
			try
			{
				if (!con.isClosed()) {   
					con.rollback(); 
					con.setAutoCommit(true);   
				}    
			}catch(SQLException e)
			{
              e.printStackTrace();
			}

			return 0;
		}
	}
	/**************************
	 * ������command;
	 * ���ܣ����ṩ��SQL����ָ��cmdִ�в���
	 * ���أ�����0��ʾ�ɹ��������ʾʧ�ܡ�
	 ***************************/
	public int command(PreparedStatement cmd)
	{
		if (cmd==null) return 0;
		try
		{		 
			return cmd.executeUpdate();  
		}catch(SQLException ex)
		{
			return 0;
		}finally
		{
			try
			{
				cmd.getConnection().close();  
			}catch(SQLException e)
			{}

		}
	}
	/**************************
	 * ������find;
	 * ���ܣ����ṩ��SQL����ָ��cmdִ�в���
	 * ���أ������ڣ����ز�ѯ�����򷵻�null��
	 ***************************/
	public ResultSet find(String cmd)
	{
		Connection con=getConnection();//��ȡ���Ӷ���
		if (con==null) return null;
		try
		{
			PreparedStatement smt=con.prepareStatement(cmd,ResultSet.TYPE_SCROLL_SENSITIVE,ResultSet.CONCUR_READ_ONLY);//����������
			return smt.executeQuery();		  
		}catch(SQLException ex)
		{
			return null;
		} 
	}
	/**********************************
	 * ������find;
	 * ���ܣ����ṩ��SQL����ָ��cmdִ�в���
	 * ���أ������ڣ����ز�ѯ�����򷵻�null��
	 ***********************************/
	public ResultSet find(PreparedStatement cmd)
	{ 
		try
		{	
			if (cmd==null) return null;//ָ�����Ϊ�գ�����null
			return cmd.executeQuery();		  
		}catch(SQLException ex)
		{
			return null;
		}finally
		{
			try
			{
				cmd.getConnection().close();  
			}catch(SQLException e)
			{}

		} 
	}
	/************************************
	 * ������commandByPRC;
	 * ���ܣ��ṩ�洢�����name������Ϊparam�Ĳ���
	 * ���أ��������ɹ�����true,���򷵻�false;
	 ***********************************/
	public int commandByPRC(String name,String param)
	{
		Connection con=getConnection();//��ȡ���Ӷ���

		if (con==null) return 0;

		CallableStatement smt=null;
		try
		{
			smt=con.prepareCall("{? =call "+name+"(?)}");
			smt.setString(2, param); 
			smt.registerOutParameter(1, java.sql.Types.INTEGER); 
			smt.execute(); 
			return smt.getInt(1);

		}catch(SQLException ex)
		{  
			System.out.println(ex.toString());
			return -1;
		} 
	}
	
	public int commandByPRC(String name,String[] param)
	{
		Connection con=getConnection();//��ȡ���Ӷ���

		if (con==null) return 0;

		CallableStatement smt=null;
		try
		{
			/*�����ʺŴ���*/
			String strTemp="";
			if (param!=null && param.length>0)
			{
				for(int i=0;i<param.length;i++)
				{
					if (strTemp=="")
						strTemp="?";
					else {
						strTemp+=",?";
					}
				}
			}
			
			smt=con.prepareCall("{? =call "+name+"("+strTemp+")}");
			if (param!=null && param.length>0)
			{
				for(int i=1;i<param.length;i++)
					smt.setString(i+1, param[i-1]); 	
				
			}
			
			smt.registerOutParameter(1, java.sql.Types.INTEGER); 
			smt.execute(); 
			return smt.getInt(1);

		}catch(SQLException ex)
		{  
			System.out.println(ex.toString());
			return -1;
		} 
	}
	
	/****************************************************
	 * ������findByPRC;
	 * ���ܣ��ṩ�洢�����name������Ϊparam�Ĳ���
	 * ���أ��������ɹ�������ݼ�,���򷵻�null;
	 ***************************************************/
	public ResultSet findByPRC(String name,String param)
	{
		Connection con=getConnection();//��ȡ���Ӷ���
		if (con==null) return null;
		try
		{
			CallableStatement smt=con.prepareCall("{call "+name+"(?)}");
			smt.setString(1, param);		  
			return smt.executeQuery();

		}catch(SQLException ex)
		{
			return null;
		} 
		 
	}
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
}
