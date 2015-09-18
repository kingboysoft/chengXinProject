package com.uscms.util;
/**************************************
 * ������ݿ������
 * ����������ʵ�ָ��ֲ�ͬ��ݿ�֧�֣���ݿ����������Ҫ��ȡ
 *        �������ļ���resources�е�init.xml����
 *        �ļ�,��ʽ���£�
 *        <db>
 *          <ipAddress>��ݿ��������IP��ַ</ipAddress>
 *          <port>��ݿ�Ķ˿ں�</port>
 *          <dbName>��ݿ����</dbName>
 *          <name>�����û���</name>
 *          <password>��������</password>
 *        </db>
 * ���ߣ�kesun
 * ���ڣ�2014-11-12
 * �汾��1.0.0.0
 **************************************/
public final class DBHelper extends DB{
   private static DBHelper sql=null;
   private DBHelper()
   {
	   
   } 
   /**************************
    * ��ȡ��ݿ���ʶ���
    **************************/
   public static DBHelper getInstance()
   {   
 	  return getMySQLInstance();
   }
   /********************************************
    * ������Microsoft SQL Server��ݿ����ʵ�������*
    * ���ܣ�����SQL Server��ݿ���ʶ���                                              *
    ********************************************/
   public static DBHelper getSQLServerInstance()
   {
	     if (sql==null)
	    	 sql= new DBHelper();
	     sql.setClassName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
	 	  sql.setConnectionString("jdbc:sqlserver://127.0.0.1:1433;databaseName=Test");
	 	  sql.setUserId("sa");
	 	  sql.setPassword("111111");
	 	 return sql; 
   }
   /********************************************
    * ������MySQL��ݿ����ʵ�������                                            *
    * ���ܣ�����MySQL��ݿ���ʶ���                                                           *
    ********************************************/
   public static DBHelper getMySQLInstance()
   {
	     if (sql==null)
	    	 sql= new DBHelper();
	     sql.setClassName("com.mysql.jdbc.Driver");
	 	 sql.setConnectionString("jdbc:mysql://127.0.0.1:3306/uscmsdb");
	 	 sql.setUserId("root");
	 	 sql.setPassword("root");
	 	 return sql; 
   }
   /********************************************
    * ������Oracle��ݿ����ʵ�������                                         *
    * ���ܣ�����Oracle��ݿ���ʶ���                                                         *
    ********************************************/
   public static DBHelper getOracleInstance()
   {
	     if (sql==null)
	    	 sql= new DBHelper();
	     sql.setClassName("oracle.jdbc.driver.OracleDriver");
	 	 sql.setConnectionString("jdbc:oracle:thin:WIN-PLHV5DMKZHS:1521:orcl");
	 	 sql.setUserId("scott");
	 	 sql.setPassword("tiger");
	 	 return sql; 
   }
}
