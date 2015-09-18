package com.uscms.util;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.security.interfaces.DSAKey;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.Vector;

import org.apache.struts2.views.jsp.DateTag;
import org.json.JSONException;
import org.json.JSONObject;

import com.sun.org.apache.bcel.internal.generic.NEW;

public class Tool {
	public static final String SUCCESS="0";//��ʾ�ϴ��ɹ����������������ʧ��
	public static final String SAVE="1";//��ʾ�ϴ��ɹ�������������Ҳ�ɹ�
	public static final String FAIL="-1";//��ʾ�ļ��ϴ�ʧ�ܣ�
	/**************************************
	 * ����ת���ַ��ʽ
	 *************************************/
	public static String DateLongString(Date d) {
		SimpleDateFormat sd = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
		return sd.format(d);
	}

	/**************************************
	 * ����ת���ַ��ʽ
	 *************************************/
	public static String DateShortString(Date d) {
		return DateFormat.getDateInstance(DateFormat.DEFAULT).format(d);
	}
     
	/**************************************
	 * ���ַ�����ת������
	 *************************************/
	public static java.util.Date GetDate(String value)
	{
		DateFormat df=new SimpleDateFormat("yyyy-MM-dd");
		try {
			return df.parse(value);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return new Date();
		}
		
	}
	public static java.util.Date GetNowLongDate()
	{
		SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");//�������ڸ�ʽ
	    try {
			return df.parse(df.format(new Date()));
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			return new Date();
		}
	}
	/*��������ַ�*/
	public static String CreateID()
	{
		String id=java.util.UUID.randomUUID().toString().replace("-", "");
		return id.length()>40?id.substring(0,39):id;
	}
	/**************************************
	 * ��ȡ�����IP��ַ
	 *************************************/
	public static String GetIpAddress() {
		try {
			InetAddress address = InetAddress.getLocalHost();
			return address.getHostAddress();
		} catch (UnknownHostException e) {
			return "��ַ����";
		}
	}

	/**************************************
	 * ��ȡ�����Mac��ַ
	 *************************************/
	public static String GetMACAddress() {

		String address = "";
		String os = System.getProperty("os.name");
		if (os != null && os.startsWith("Windows")) {

			try {
				String command = "cmd.exe /c ipconfig /all";
				Process p = Runtime.getRuntime().exec(command);
				BufferedReader br = new BufferedReader(new InputStreamReader(
						p.getInputStream()));

				String line;

				while ((line = br.readLine()) != null) {
					if (line.indexOf("Physical Address") > 0) {
						int index = line.indexOf(":");
						index += 2;
						address = line.substring(index);
						break;
					}
				}

				br.close();
				return address.trim();
			} catch (IOException e) {
			}

		}
		return address;
	}

	/***************************************************
	 * ����ݼ�ת��Ϊ��ά����
	 ***************************************************/
	public static Object[][] ResultSetToObjectArray(ResultSet rs) {
		List<Object[]> data = new ArrayList<Object[]>();
		try {
			ResultSetMetaData md = rs.getMetaData();// ��ȡ��¼����Ԫ���
			int columnCount = md.getColumnCount();// ����
			while (rs.next()) {

				Object[] row = new Object[columnCount];
				for (int i = 0; i < columnCount; i++) {
					if (rs.getObject(i + 1) != null)
						row[i] = rs.getObject(i + 1).toString();
					else
						row[i] = null;
				}

				data.add(row);
			}
		} catch (Exception e) {
			return null;
		}
		Object[][] source = new Object[data.size()][];
		int i = 0;
		for (Object[] x : data) {
			source[i] = new Object[x.length];
			source[i++] = x;
		}
		return source;

	}

	/*******************************************************************
	 * ��������ת���ɶ�άVector
	 * ����rsΪ���ϣ�columnIndexes��Ҫ����������,�������0�п�ʼ,isCheckBox�Ƿ���ҪcheckBox�������ҪΪtrue,����Ϊfalse
	 *******************************************************************/
	public static Vector<Vector<Object>> ResultSetToVector(ResultSet rs,
			int[] columnIndexes, boolean isCheckBox,String[] extendCols) {
		Vector<Vector<Object>> data = new Vector<Vector<Object>>();
		try {
			ResultSetMetaData md = rs.getMetaData();// ��ȡ��¼����Ԫ���
			int columnCount = md.getColumnCount();// ����
			if (columnIndexes == null || columnIndexes.length > columnCount)
				return null;

			int order = 1;// ���
			while (rs.next()) {
				Vector<Object> v = new Vector<Object>();
				if (isCheckBox)
					v.add(false);
				v.add(order++);
				for (int i = 0; i < columnIndexes.length; i++) {
					{						
						if (rs.getObject(columnIndexes[i] + 1) != null)
							v.add(rs.getObject(columnIndexes[i] + 1));
						else
							v.add(null); 
					}
				}
				if (extendCols!=null && extendCols.length>0)
					for(int j=0;j<extendCols.length;j++)
						v.add(extendCols[j]);
				data.add(v);
			}
			return data;
		} catch (Exception e) {
			return null;
		}
	}
	/*��ȡ������ʼѧ��*/
	public static int GetStartYear()
	{ 	 
		Calendar a=Calendar.getInstance(); 
		if (a.get(Calendar.MONTH)>=1 && a.get(Calendar.MONTH)<=6)
			return a.get(Calendar.YEAR)-1;
		else {
			return a.get(Calendar.YEAR);
		}
	}
	/*��ȡ������ֹѧ��*/
	public static int GetEndYear()
	{
		Calendar a=Calendar.getInstance(); 
		if (a.get(Calendar.MONTH)>=1 && a.get(Calendar.MONTH)<=6)
			return a.get(Calendar.YEAR);
		else {
			return a.get(Calendar.YEAR)+1;
		}
	}
	/*��ȡ����ѧ�ڣ�1��ʾ��һѧ�ڣ�2��ʾ�ڶ�ѧ��*/
	public static int GetTerm()
	{
		Calendar a=Calendar.getInstance();
		if (a.get(Calendar.MONTH)>=1 && a.get(Calendar.MONTH)<=6)
			return 2;
		else {
			return 1;
		}
	}
	
	/*������ʼѧ��*/
	public static int GetStartYear(Date date)
	{ 	 
		Calendar a=Calendar.getInstance(); 
		a.setTime(date);
		if (a.get(Calendar.MONTH)>=1 && a.get(Calendar.MONTH)<=6)
			return a.get(Calendar.YEAR)-1;
		else {
			return a.get(Calendar.YEAR);
		}
	}
	/*��ȡ��ֹѧ��*/
	public static int GetEndYear(Date date)
	{
		Calendar a=Calendar.getInstance();
		a.setTime(date);
		if (a.get(Calendar.MONTH)>=1 && a.get(Calendar.MONTH)<=6)
			return a.get(Calendar.YEAR);
		else {
			return a.get(Calendar.YEAR)+1;
		}
	}
	/*��ȡѧ�ڣ�1��ʾ��һѧ�ڣ�2��ʾ�ڶ�ѧ��*/
	public static int GetTerm(Date date)
	{
		Calendar a=Calendar.getInstance();
		a.setTime(date);
		if (a.get(Calendar.MONTH)>=1 && a.get(Calendar.MONTH)<=6)
			return 2;
		else {
			return 1;
		}
	}
	
}
