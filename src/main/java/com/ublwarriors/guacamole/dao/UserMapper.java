package com.ublwarriors.guacamole.dao;

import com.ublwarriors.guacamole.model.User;
import com.ublwarriors.guacamole.model.UserExample;
import com.ublwarriors.guacamole.model.UserWithBLOBs;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface UserMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table guacamole_user
     *
     * @mbggenerated Wed Jul 13 15:15:04 CST 2016
     */
    int countByExample(UserExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table guacamole_user
     *
     * @mbggenerated Wed Jul 13 15:15:04 CST 2016
     */
    int deleteByExample(UserExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table guacamole_user
     *
     * @mbggenerated Wed Jul 13 15:15:04 CST 2016
     */
    int deleteByPrimaryKey(Integer userId);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table guacamole_user
     *
     * @mbggenerated Wed Jul 13 15:15:04 CST 2016
     */
    int insert(UserWithBLOBs record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table guacamole_user
     *
     * @mbggenerated Wed Jul 13 15:15:04 CST 2016
     */
    int insertSelective(UserWithBLOBs record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table guacamole_user
     *
     * @mbggenerated Wed Jul 13 15:15:04 CST 2016
     */
    List<UserWithBLOBs> selectByExampleWithBLOBs(UserExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table guacamole_user
     *
     * @mbggenerated Wed Jul 13 15:15:04 CST 2016
     */
    List<User> selectByExample(UserExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table guacamole_user
     *
     * @mbggenerated Wed Jul 13 15:15:04 CST 2016
     */
    UserWithBLOBs selectByPrimaryKey(Integer userId);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table guacamole_user
     *
     * @mbggenerated Wed Jul 13 15:15:04 CST 2016
     */
    int updateByExampleSelective(@Param("record") UserWithBLOBs record, @Param("example") UserExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table guacamole_user
     *
     * @mbggenerated Wed Jul 13 15:15:04 CST 2016
     */
    int updateByExampleWithBLOBs(@Param("record") UserWithBLOBs record, @Param("example") UserExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table guacamole_user
     *
     * @mbggenerated Wed Jul 13 15:15:04 CST 2016
     */
    int updateByExample(@Param("record") User record, @Param("example") UserExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table guacamole_user
     *
     * @mbggenerated Wed Jul 13 15:15:04 CST 2016
     */
    int updateByPrimaryKeySelective(UserWithBLOBs record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table guacamole_user
     *
     * @mbggenerated Wed Jul 13 15:15:04 CST 2016
     */
    int updateByPrimaryKeyWithBLOBs(UserWithBLOBs record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table guacamole_user
     *
     * @mbggenerated Wed Jul 13 15:15:04 CST 2016
     */
    int updateByPrimaryKey(User record);
}