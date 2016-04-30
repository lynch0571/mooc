package com.suime.admin.tools;

import com.confucian.framework.support.Constants;
import com.confucian.tools.MybatisCodeTools;


/**
 * 
 * @author Lynch
 * Created date: 2016年4月6日 
 * Created time: 下午9:38:59
 */
public class CodeTools {

    /**
     * generateJavaFile
     */
    public static void main(String[] args) {
        try {
			MybatisCodeTools mybatisCodeTools = new MybatisCodeTools();
			//mybatisCodeTools.setClassNamePrefix("wenji_,wenku_doc_,wenku_,tb_");
			mybatisCodeTools.setClassNamePrefix("");
			mybatisCodeTools.setPackageName("com.suime.context.model");
			mybatisCodeTools.setBasePackage("com.suime.admin");
			mybatisCodeTools.setDriverName("com.mysql.jdbc.Driver");
			mybatisCodeTools.setDsPassword("root");
			mybatisCodeTools.setDsUserName("root");
			mybatisCodeTools.setDsUrl("jdbc:mysql://127.0.0.1:3306/mooc?useUnicode=true&characterEncoding=utf8");

			mybatisCodeTools.setAuthorName("Lynch");

//			String tableNames = "student";
			String tableNames = "course";
			String[] array = tableNames.split(Constants.VALUE_SIMPLE_SPLIT_CHAR);
			for (String tableName : array) {
			    mybatisCodeTools.setTableName(tableName);
			    mybatisCodeTools.generateJavaFile();
			}
			System.out.println("代码生成完毕，请刷新后查看！");
		} catch (Exception e) {
			System.out.println("代码生成错误，请检查！");
		}
        
    }
}
