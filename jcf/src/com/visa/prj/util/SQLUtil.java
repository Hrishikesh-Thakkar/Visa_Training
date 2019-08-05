package com.visa.prj.util;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

import com.visa.prj.annotations.Column;
import com.visa.prj.annotations.Table;

public class SQLUtil {

	public static String generateCreateSQL(Class<?> clazz) {
		StringBuilder builder = new StringBuilder();
		Table t=clazz.getAnnotation(Table.class);
		if(t!=null) {
			builder.append("create table");
			builder.append(" ");
			builder.append(t.name());
			builder.append("(");
			Method[] methods = clazz.getDeclaredMethods();
			for (Method method : methods) {
				if(method.getName().startsWith("get")) {
					Column c = method.getAnnotation(Column.class);
					if(c!=null) {
						builder.append(c.name());
						builder.append(" ");
						builder.append(c.type());
						builder.append(",");
					}
				}
			}
		}
		builder.setCharAt(builder.lastIndexOf(","), (')'));
		return builder.toString();
	}
	public static String generateInsertSQL(Object obj) {
		StringBuilder builder= new StringBuilder();
		//String t=obj.getClass().toString();
		StringBuilder builder1= new StringBuilder();
		StringBuilder builder2 = new StringBuilder();
		builder2.append("(");
		Table t=obj.getClass().getAnnotation(Table.class);
		if(t!=null) {
			builder.append("insert into ");
			builder.append(" ");
			builder.append(t.name());
			builder.append(" values (");
			Method[] methods = obj.getClass().getDeclaredMethods();
			for (Method method : methods) {
				if(method.getName().startsWith("get")) {
					Column c = method.getAnnotation(Column.class);
					if(c!=null) {
						try {
							builder1.append(method.getName().toLowerCase());
							builder1.replace(0,3,"");
							builder2.append(builder1);
							builder2.append(", ");
							builder1.setLength(0);
							
							builder.append(method.invoke(obj));
							//builder.append(c.type());
							builder.append(",");
						} catch (IllegalAccessException | IllegalArgumentException | InvocationTargetException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
						
					}
				}
			}
		}
		builder2.setCharAt(builder2.lastIndexOf(","), (')'));
		System.out.println(builder2);
		builder.setCharAt(builder.lastIndexOf(","), (')'));
		builder.insert(builder.lastIndexOf("values"), builder2);
		return builder.toString();
	}
}
