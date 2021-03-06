package com.eauto100.app.server.framework.database.impl;


import org.springframework.jdbc.core.ColumnMapRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import com.eauto100.app.server.framework.context.EopSetting;


/**
 * 覆写jdbctemlate ，使用LowerCaseColumnMapRowMapper
 * @author kingapex
 * 2010-6-13上午11:05:32
 */
public class LowerCaseJdbcTemplate extends JdbcTemplate {
	@Override
	protected RowMapper getColumnMapRowMapper() {
		if("2".equals(EopSetting.DBTYPE)){
			return new OracleColumnMapRowMapper();
		}else if("1".equals(EopSetting.DBTYPE)){
			return new MySqlColumnMapRowMapper();
		}else{
			return new ColumnMapRowMapper();
		}
	}

}
