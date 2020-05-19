package com.zhbit.findwork.convertor;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Map;
import org.apache.struts2.util.StrutsTypeConverter;

import com.opensymphony.xwork2.conversion.TypeConversionException;
/**
 * ʱ������ת����
 * @author ������
 *
 */
public class DateConverter extends StrutsTypeConverter {

	@Override
	public Object convertFromString(Map arg0, String[] arg1, Class arg2) {
		System.out.println("ʱ������ת����");
		//���ʱ�䲻����Ҫ��
		String time = arg1[0];
		if (!time.matches("\\d{4}+[-]\\d{1,2}+[-]\\d{1,2}+")) {
			   throw new TypeConversionException();
			  }
		SimpleDateFormat sdf = null;
			sdf = new SimpleDateFormat("yyyy-MM-dd");
		try {
			Date str = sdf.parse(time);
			return new java.sql.Date(str.getTime());
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public String convertToString(Map arg0, Object arg1) {
		System.out.println("ʱ������ת����");
		Date date = (Date) arg1;
		return new SimpleDateFormat("yyyy-MM-dd").format(date);
	}

}
