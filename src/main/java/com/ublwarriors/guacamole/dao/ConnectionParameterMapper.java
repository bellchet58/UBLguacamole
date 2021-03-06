package com.ublwarriors.guacamole.dao;

import com.ublwarriors.guacamole.model.ConnectionParameter;
import com.ublwarriors.guacamole.model.ConnectionParameterExample;
import com.ublwarriors.guacamole.model.ConnectionParameterKey;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface ConnectionParameterMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table guacamole_connection_parameter
     *
     * @mbggenerated Wed Jul 13 15:15:04 CST 2016
     */
    int countByExample(ConnectionParameterExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table guacamole_connection_parameter
     *
     * @mbggenerated Wed Jul 13 15:15:04 CST 2016
     */
    int deleteByExample(ConnectionParameterExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table guacamole_connection_parameter
     *
     * @mbggenerated Wed Jul 13 15:15:04 CST 2016
     */
    int deleteByPrimaryKey(ConnectionParameterKey key);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table guacamole_connection_parameter
     *
     * @mbggenerated Wed Jul 13 15:15:04 CST 2016
     */
    int insert(ConnectionParameter record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table guacamole_connection_parameter
     *
     * @mbggenerated Wed Jul 13 15:15:04 CST 2016
     */
    int insertSelective(ConnectionParameter record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table guacamole_connection_parameter
     *
     * @mbggenerated Wed Jul 13 15:15:04 CST 2016
     */
    List<ConnectionParameter> selectByExample(ConnectionParameterExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table guacamole_connection_parameter
     *
     * @mbggenerated Wed Jul 13 15:15:04 CST 2016
     */
    ConnectionParameter selectByPrimaryKey(ConnectionParameterKey key);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table guacamole_connection_parameter
     *
     * @mbggenerated Wed Jul 13 15:15:04 CST 2016
     */
    int updateByExampleSelective(@Param("record") ConnectionParameter record, @Param("example") ConnectionParameterExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table guacamole_connection_parameter
     *
     * @mbggenerated Wed Jul 13 15:15:04 CST 2016
     */
    int updateByExample(@Param("record") ConnectionParameter record, @Param("example") ConnectionParameterExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table guacamole_connection_parameter
     *
     * @mbggenerated Wed Jul 13 15:15:04 CST 2016
     */
    int updateByPrimaryKeySelective(ConnectionParameter record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table guacamole_connection_parameter
     *
     * @mbggenerated Wed Jul 13 15:15:04 CST 2016
     */
    int updateByPrimaryKey(ConnectionParameter record);
}